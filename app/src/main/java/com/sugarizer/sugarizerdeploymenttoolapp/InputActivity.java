package com.sugarizer.sugarizerdeploymenttoolapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Log.d("TEST", "OnCreate ?");

        View root = findViewById(R.id.root);

        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //if (event.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("MotionEvent", "x:" + String.valueOf(event.getX()) + "y:" + String.valueOf(event.getY()));
                //}

                return true;
            }
        });
    }
}
