package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class counterRaven extends Activity {
    int count = 0;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        preferences =getSharedPreferences("settings", Context.MODE_PRIVATE);
        Button button1 = findViewById(R.id.button14);
        Button button2 = findViewById(R.id.button13);
        Button button3 = findViewById(R.id.button15);
        button1.setOnClickListener(radioButtonClickListener);
        button3.setOnClickListener(radioButtonClickListener);
        button2.setOnClickListener(radioButtonClickListener);
        Button clean = findViewById(R.id.clean);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putInt("RAVENS",0).apply();
                count=0;
                TextView textView = findViewById(R.id.textView6);
                textView.setText(String.valueOf(count));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("RAVENS",count).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(preferences.contains("RAVENS")){
            count=preferences.getInt("RAVENS",0);
            TextView textView = findViewById(R.id.textView6);
            textView.setText(String.valueOf(count));
        }
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView textView = findViewById(R.id.textView6);
            count++;
            textView.setText(String.valueOf(count));
        }
    };
}

