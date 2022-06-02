package com.example.spaceinvaders;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sensorManager;
    float sensorZ;
    EditText personaje;
    int valuePadding = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personaje = (EditText) findViewById(R.id.idPersonaje);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        sensorZ = sensorEvent.values[0];

        if(sensorZ > 0 && sensorZ <=0.77){
            valuePadding -= 10;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ > 0.77 && sensorZ <=1.53){
            valuePadding -= 15;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ > 1.53 && sensorZ <=3.75){
            valuePadding -= 25;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ > 3.75 ){
            valuePadding -= 35;
            personaje.setPadding(valuePadding,0,0,0);
        }


        if(sensorZ < 0 && sensorZ >=-0.77){
            valuePadding += 10;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ < -0.77 && sensorZ >=-1.53){
            valuePadding += 15;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ < -1.53 && sensorZ >=-3.75){
            valuePadding += 25;
            personaje.setPadding(valuePadding,0,0,0);
        }
        if (sensorZ < -3.75 ){
            valuePadding += 35;
            personaje.setPadding(valuePadding,0,0,0);
        }
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}