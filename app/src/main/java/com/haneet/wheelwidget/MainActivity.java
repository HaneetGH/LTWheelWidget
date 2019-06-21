package com.haneet.wheelwidget;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.haneet.wheelwidget.view.LTSpinningWheelView;
import com.haneet.wheelwidget.view.SpinningWheelView;

public class MainActivity extends AppCompatActivity implements LTSpinningWheelView.OnRotationListener<String> {
    private LTSpinningWheelView wheelView;
    private Double DIRECTION_START_OFFSET = 0.80;
    private Double DIRECTION_END_OFFSET = 0.32;

    private Double ASSIGNZONE_START_OFFSET = 0.29;
    private Double ASSIGNZONE_END_OFFSET = 0.0;

    private Double SHARELOCATION_START_OFFSET = 0.01;
    private Double SHARELOCATION_END_OFFSET = 1.45;

    private Double ENGINECUT_START_OFFSET = 1.55;
    private Double ENGINECUT_END_OFFSET = 1.46;

    private Double ANTITHEFT_START_OFFSET = 1.28;
    private Double ANTITHEFT_END_OFFSET = 0.84;

    private int DIRECTION_ANGLE = 75;
    private int ANTITHEFT_ANGLE = 3;
    private int ENGINECUR_ANGLE = -65;
    private int ASSIGNZONE_ANGLE = 145;
    private int SHARELOCATION_ANGLE = -140;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatebacm);
        wheelView = (LTSpinningWheelView) findViewById(R.id.wheel);


        wheelView.setItems(R.array.dummy);

        wheelView.setOnRotationListener(this);

        int[] images = new int[]{
                R.drawable.assign,
                R.drawable.antitheft,
                R.drawable.antitheft, R.drawable.antitheft, R.drawable.antitheft
        };

        wheelView.rotate(SHARELOCATION_ANGLE);
        //  wheelView.rotate(ENGINECUR_ANGLE,1000,0);
        clickvevenrt();
    }

    private void clickvevenrt() {

        findViewById(R.id.antitheft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.rotate(ANTITHEFT_ANGLE);
                wheelView.refreshDrawableState();
            }
        });
        findViewById(R.id.enginecut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.rotate(ENGINECUR_ANGLE);
            }
        });
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.rotate(SHARELOCATION_ANGLE);
            }
        });
        findViewById(R.id.zone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.rotate(ASSIGNZONE_ANGLE);
            }
        });
        findViewById(R.id.direction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.rotate(DIRECTION_ANGLE);
            }
        });


    }

    @Override
    public void onRotation(Point item) {
        // findAngle(item);
        //Log.d("ANGLE Rot", item + "");
    }

    private void findAngle(Point item) {
        int m;
        m = (10 - 20) / (0 - 10);
        Double offset = (Math.atan2(item.x, item.y));
        Log.d("TAN", item.x + "   " + item.y + "");


        if (offset < DIRECTION_START_OFFSET && offset > DIRECTION_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " DIRECTION");

            Toast.makeText(getApplicationContext(), "DIRECTION", Toast.LENGTH_SHORT).show();
        } else if (offset < ASSIGNZONE_START_OFFSET && offset > ASSIGNZONE_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ASSIGNZONE");
            Toast.makeText(getApplicationContext(), "ASSIGNZONE", Toast.LENGTH_SHORT).show();
        } else if (offset < ENGINECUT_START_OFFSET && offset > ENGINECUT_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ENGINECUT");
            Toast.makeText(getApplicationContext(), "ENGINECUT", Toast.LENGTH_SHORT).show();
        } else if (offset < ANTITHEFT_START_OFFSET && offset > ANTITHEFT_END_OFFSET) {
            Log.d("SELECTION", (Math.atan2(item.x, item.y)) + " ASSIGNZONE");
            Toast.makeText(getApplicationContext(), "ASSIGNZONE", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onStopRotation(String item) {

        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
        Log.d("ANGLE", item + "");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
