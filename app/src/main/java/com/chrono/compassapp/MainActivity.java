package com.chrono.compassapp;

import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/*
* Compass application
* Deepak kumar
*
*/
public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private ImageView compassImage;
    private float currentDegree = 0f;
    private SensorManager mSensorManager;
    private TextView degreeTV;
    private TextView poleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassImage = (ImageView)findViewById(R.id.compassImageView);
        degreeTV = (TextView) findViewById(R.id.degree);
        poleTV = (TextView) findViewById(R.id.pole);

        // custom font using typeface class
        Typeface mCustomFont = Typeface.createFromAsset(getAssets(), "fonts/STENCIL.TTF");
        poleTV.setTypeface(mCustomFont);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        degreeTV.setText("" + Float.toString(degree) + "°");

        if(degree <= 30 || degree >=330)
        {
            poleTV.setText("N");
        }
        else if(degree > 30 && degree < 60)
        {
            poleTV.setText("NE");
        }
        else if(degree >= 60 && degree <= 120)
        {
            poleTV.setText("E");
        }
        else if(degree > 120 && degree < 150)
        {
            poleTV.setText("SE");
        }
        else if(degree >= 150 && degree <= 210)
        {
            poleTV.setText("S");
        }
        else if(degree > 210 && degree < 240)
        {
            poleTV.setText("SW");
        }
        else if(degree >= 240 && degree <= 300)
        {
            poleTV.setText("W");
        }
        else if(degree > 300 && degree < 330)
        {
            poleTV.setText("NW");
        }

        RotateAnimation rotation = new RotateAnimation(
                currentDegree, -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotation.setDuration(210);
        rotation.setFillAfter(true);

        compassImage.startAnimation(rotation);
        currentDegree = -degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
