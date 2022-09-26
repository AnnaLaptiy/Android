package com.example.myapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button button = findViewById(R.id.converter);
        Button zoo = findViewById(R.id.button10);
        Button paint = findViewById(R.id.paint);
        Button animation = findViewById(R.id.animation);
        Button browser = findViewById(R.id.MyBrowser);
        Button manual = findViewById(R.id.manual);
        Button map = findViewById(R.id.maptest);
        Button radio = findViewById(R.id.radio);
        Button pazzle = findViewById(R.id.pazzle);
        Button dialog = findViewById(R.id.dialogmenu);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String geoUriString = "geo:0,0?q=Georgia";                Uri geoUri = Uri.parse(geoUriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);

                startActivity(mapIntent);


            }
        });


        Button camera = findViewById(R.id.mycamera);
        Button text = findViewById(R.id.TextEditor);
        Button ravens = findViewById(R.id.counter);
        Intent dailogInt=new Intent(this,MyDialog.class);
        Intent pazzleInt=new Intent(this,myFragments.class);
        Intent radioInt=new Intent(this,Radio.class);
        Intent function = new Intent(this, FunctionActivity.class);
        Intent cameraInt = new Intent(this, MyPhoto.class);
        Intent zooInt = new Intent(this, Zoo.class);
        Intent paintInt = new Intent(this, paintMenu.class);
        Intent animInt = new Intent(this, myAnimation.class);
        Intent browserInt = new Intent(this, MyBrowser.class);
        Intent manualInt = new Intent(this, com.example.myapp.manual.class);
        Intent ravenInt=new Intent(this,counterRaven.class);
        Intent texInt=new Intent(this,textEditor.class);


        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dailogInt);
            }
        });
        pazzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(pazzleInt);
            }
        });
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(radioInt);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(texInt);
            }
        });
        ravens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ravenInt);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cameraInt);
            }
        });
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(manualInt);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(function);
            }
        });
        zoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(zooInt);
            }
        });
        paint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(paintInt);
            }
        });
        animation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(animInt);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(browserInt);
            }
        });
    }

}
