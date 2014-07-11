package com.reilly.voided;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accel extends Activity implements SensorEventListener{
	private SensorManager sensorManager;

	TextView xAxis;
	TextView yAxis;
	TextView zAxis;	
	Button Accel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		xAxis = (TextView)findViewById(R.id.textView4);
		yAxis = (TextView)findViewById(R.id.textView5);
		zAxis = (TextView)findViewById(R.id.textView6);

		sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_NORMAL);
		Accel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Accel.this, Start.class);
				startActivity(intent);
			}
		});
	}
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];

			xAxis.setText("" + x);
			yAxis.setText("" + y);
			zAxis.setText("" + z);
		}
	}
}