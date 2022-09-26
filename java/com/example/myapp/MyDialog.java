package com.example.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public class MyDialog extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button button=findViewById(R.id.firstdialog);
        Button button2=findViewById(R.id.seconddialog);
        Button button3=findViewById(R.id.thirdDialog);
        Button button4=findViewById(R.id.parentbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();

                MyFirstDialogFragment myFirstDialogFragment=new MyFirstDialogFragment();

                myFirstDialogFragment.show(manager,"MyDialog");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getSupportFragmentManager();

                MySecongDialogFragment myFirstDialogFragment=new MySecongDialogFragment();

                myFirstDialogFragment.show(manager,"MySecDialog");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRatingDialog();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();

                MyThirdDialogFragment myFirstDialogFragment=new MyThirdDialogFragment();

                myFirstDialogFragment.show(manager,"MyDialog3");
            }
        });


    }
    public void okClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку OK!",
                Toast.LENGTH_LONG).show();
    }

    public void cancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку отмены!",
                Toast.LENGTH_LONG).show();
    }
    public void showRatingDialog() {
        final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);
        final RatingBar rating = new RatingBar(this);

        ratingdialog.setIcon(android.R.drawable.btn_star_big_on);
        ratingdialog.setTitle("Голосуем за любимого кота!");
        ratingdialog.setView(rating);
        rating.setMax(5);
        rating.setNumStars(5);
        rating.setStepSize((float) 1.0);

        ratingdialog.setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                               // txtView.setText(String.valueOf(rating.getRating()));
                                Toast.makeText(getApplicationContext(),String.valueOf(rating.getRating()), Toast.LENGTH_LONG)
                                        .show();
                                dialog.dismiss();
                            }
                        })

                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        ratingdialog.create();
        ratingdialog.show();
    }
}
