package com.compass.sample;

import android.app.Activity;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

// implement SensorListener
public class Compass extends Activity implements SensorListener {
  SensorManager sensorManager;
  static final int sensor = SensorManager.SENSOR_ORIENTATION;
  Rose rose;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set full screen view
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    rose = new Rose(this);

    setContentView(rose);

    // get sensor manager
    sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
  }

  // register to listen to sensors
  @Override
  public void onResume() {
    super.onResume();
    sensorManager.registerListener(this, sensor);
  }

  // unregister
  @Override
  public void onPause() {
    super.onPause();
    sensorManager.unregisterListener(this);
  }

  // Ignore for now
  public void onAccuracyChanged(int sensor, int accuracy) {
  }

  // Listen to sensor and provide output
  public void onSensorChanged(int sensor, float[] values) {
    if (sensor != Compass.sensor)
      return;
    float orientation = values[0];
    rose.setDirection(orientation);
  }
}