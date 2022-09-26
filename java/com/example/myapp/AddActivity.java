package com.example.myapp;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AddActivity extends Activity {

    private static final int NOTIFY_ID=101;// Идентификатор уведомления
    private static final String CHANNEL_ID="Mychannel";// Идентификатор канала

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);



        RadioButton radioButton = findViewById(R.id.radio1);
        Button sendRes = findViewById(R.id.button5);
        Button toast = findViewById(R.id.button7);
        Button notify = findViewById(R.id.button6);
        RadioButton radioButton2 = findViewById(R.id.radio2);
        RadioButton radioButton3 = findViewById(R.id.radio3);

        TextView textView = findViewById(R.id.textView3);
        String name = "Animals";
        String gift = getIntent().getExtras().getString("gift");
        int token = getIntent().getExtras().getInt("CHOOSE_THIEF");

        textView.setText(name + " give you " + gift);

        radioButton.setOnClickListener(radioButtonClickListener);
        radioButton2.setOnClickListener(radioButtonClickListener);
        radioButton3.setOnClickListener(radioButtonClickListener);

        sendRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setImageResource(R.drawable.niceday);

                Toast toast=Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    toast.addCallback(new Toast.Callback() {
                        @Override
                        public void onToastHidden() {
                            super.onToastHidden();
                            Log.d("Toast","hidden");
                        }
                        @Override
                        public void onToastShown(){
                            super.onToastShown();
                            Log.d("Toast","shown");

                        }
                    });
                }
                toast.setView(imageView);
                toast.show();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder=
                        new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                                .setSmallIcon(R.drawable.niceday)
                                .setContentTitle("Напоминание")
                                .setContentText("Пора кормить кота")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat=
                        NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFY_ID,builder.build());
            }
        });
    }




    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent answerIntent = new Intent();

            TextView textView = findViewById(R.id.textView3);
            RadioButton rb = (RadioButton) view;
            switch (rb.getId()) {
                case R.id.radio1:
                    textView.setTextColor(Color.RED);
                    break;

                case R.id.radio2:
                    textView.setTextColor(Color.GREEN);
                    break;

                case R.id.radio3:
                    textView.setTextColor(Color.BLUE);
                    break;
                default:
                    break;


            }
            RadioGroup radioGroup=findViewById(R.id.radio_group);
            int buttomCurId=radioGroup.indexOfChild(rb);
            answerIntent.putExtra("THIEF",String.valueOf(buttomCurId+1));
            setResult(RESULT_OK, answerIntent);
            //  finish();

        }

    };
}
