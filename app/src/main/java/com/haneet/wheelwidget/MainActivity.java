package com.haneet.wheelwidget;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.haneet.wheelwidget.view.LTSpinningWheelView;

public class MainActivity extends AppCompatActivity implements LTSpinningWheelView.OnRotationListener<String> {
    private LTSpinningWheelView wheelView;
    private Double DIRECTION_START_OFFSET = 0.80;
    private Double DIRECTION_END_OFFSET = 0.32;

    private Double ASSIGNZONE_START_OFFSET = 0.29;
    private Double ASSIGNZONE_END_OFFSET = 0.0;

    private Double SHARELOCATION_START_OFFSET = 0.01;
    private Double SHARELOCATION_END_OFFSET = 1.45;

    private Double ENGINECUT_START_OFFSET = 1.53;
    private Double ENGINECUT_END_OFFSET = 1.34;

    private Double ANTITHEFT_START_OFFSET = 1.32;
    private Double ANTITHEFT_END_OFFSET = 0.86;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelView = (LTSpinningWheelView) findViewById(R.id.wheel);


        wheelView.setItems(R.array.dummy);
        wheelView.setOnRotationListener(this);


        wheelView.rotate(50, 3000, 50);
    }

    @Override
    public void onRotation(Point item) {
        findAngle(item);
        Log.d("ANGLE Rot", item + "");
    }

    private void findAngle(Point item) {
        int m;
        m = (10 - 20) / (0 - 10);
        Double offset = (Math.atan2(item.x, item.y));
        Log.d("TAN", (Math.atan2(item.x, item.y)) + "");


        if (offset < DIRECTION_START_OFFSET && offset > DIRECTION_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " DIRECTION");

            Toast.makeText(getApplicationContext(),"DIRECTION",Toast.LENGTH_LONG).show();
        } else if (offset < ASSIGNZONE_START_OFFSET && offset > ASSIGNZONE_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ASSIGNZONE");
            Toast.makeText(getApplicationContext(),"ASSIGNZONE",Toast.LENGTH_LONG).show();
        } else if (offset > SHARELOCATION_START_OFFSET && offset < SHARELOCATION_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " SHARELOCATION");
            Toast.makeText(getApplicationContext(),"SHARELOCATION",Toast.LENGTH_LONG).show();
        } else if (offset < ENGINECUT_START_OFFSET && offset > ENGINECUT_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ENGINECUT");
            Toast.makeText(getApplicationContext(),"ENGINECUT",Toast.LENGTH_LONG).show();
        } else if (offset < ANTITHEFT_START_OFFSET && offset  > ANTITHEFT_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ASSIGNZONE");
            Toast.makeText(getApplicationContext(),"ASSIGNZONE",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onStopRotation(Point item) {
        Log.d("ANGLE", item + "");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
