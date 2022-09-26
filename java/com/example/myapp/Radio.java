package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Radio extends Activity {
    Button button;
    public static final String WHERE_MY_CAT_ACTION = "action.CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        button=findViewById(R.id.radiobutton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("!!");
                Intent intent = new Intent();
                intent.setAction(WHERE_MY_CAT_ACTION);
                intent.putExtra("broadcast.Message", ALARM_MESSAGE);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
                Toast.makeText(getApplicationContext(), "Обнаружено сообщение: " +
                                intent.getStringExtra("broadcast.Message"),
                        Toast.LENGTH_LONG).show();
            }
        });

    }



}
