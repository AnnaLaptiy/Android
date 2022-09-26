package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("get");
        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("broadcast.Message"),
                Toast.LENGTH_LONG).show();

    }
}