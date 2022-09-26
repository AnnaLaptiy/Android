package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;

public class paintMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPaint draw2D = new myPaint(getApplicationContext());
        setContentView(draw2D);


    }
}
