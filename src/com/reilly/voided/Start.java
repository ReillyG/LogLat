package com.reilly.voided;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends Activity implements LocationListener {

	LocationManager mLocationManager;
	TextView Longitude;
	TextView Latitude;
	Button Accel;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		Longitude = (TextView)findViewById(R.id.textView4);
		Latitude = (TextView)findViewById(R.id.textView6);
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(location != null) {
			System.out.print(Longitude);
			Longitude.setText("" + location.getLongitude());
			Latitude.setText("" + location.getLatitude());
		}
		else {
			mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		}




		Accel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Start.this, Accel.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onLocationChanged(Location location) {
		if (location != null) {
			Longitude.setText("" + location.getLongitude());
			Latitude.setText("" + location.getLatitude());
		}
	}
	// etc..
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}


