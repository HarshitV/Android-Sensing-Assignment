package com.example.harshitverma.wardi_sensing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.*;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView x,y,z;
    private SensorManager S;
    private TextView x1,y1,z1;
    private Button b1,b2;
    private SensorEventListener gyro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        x = (TextView) findViewById(R.id.textView);
        y = (TextView) findViewById(R.id.textView2);
        z = (TextView) findViewById(R.id.textView3);
        x1 = (TextView) findViewById(R.id.textView4);
        y1 = (TextView) findViewById(R.id.textView5);
        z1 = (TextView) findViewById(R.id.textView6);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button:
                S = (SensorManager) getSystemService(SENSOR_SERVICE);
                gyro= new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        Sensor t=sensorEvent.sensor;
                        if(t.getType()==Sensor.TYPE_ACCELEROMETER) {
                            x.setText("X "+sensorEvent.values[0]);
                            y.setText("Y "+sensorEvent.values[1]);
                            z.setText("Z "+sensorEvent.values[2]);
                        }
                        if(t.getType()==Sensor.TYPE_GYROSCOPE) {
                            x1.setText("X1 "+sensorEvent.values[0]);
                            y1.setText("Y1 "+sensorEvent.values[1]);
                            z1.setText("Z1 "+sensorEvent.values[2]);
                        }

                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int i) {

                    }
                };
                S.registerListener(gyro,S.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
                S.registerListener(gyro,S.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_NORMAL);
                //b2.setEnabled(false);
                break;
            case R.id.button2:
                //S.unregisterListener((SensorEventListener) this);
                x.setText("X ");
                y.setText("Y ");
                z.setText("Z ");
                x1.setText("X1 ");
                y1.setText("Y1 ");
                z1.setText("Z1 ");

                break;





        }

    }
}