package com.example.myapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class Zoo extends Activity {
    SoundPool soundPool;
    AssetManager assetManager;
    int mCatSound,mCowSount,mChickenSound,mParrotSound;
    private int mStreamID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zookeper);



        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP) {
            createOldSoundPool();
        }else{
            createNewSoundPool();
        }

        Button catImageButton = findViewById(R.id.cat);
        catImageButton.setOnClickListener(onClickListener);
        catImageButton.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i) {
                    case KeyEvent.KEYCODE_W:
                        playSound(mCowSount);
                        break;
                    case KeyEvent.KEYCODE_E:
                        playSound(mChickenSound);
                        break;
                    case KeyEvent.KEYCODE_Q:
                        playSound(mCatSound);
                        break;
                    case KeyEvent.KEYCODE_R:
                        playSound(mParrotSound);
                        break;

                }

                return  true;
            }
        });

        Button cowImageButton = findViewById(R.id.cow);
        cowImageButton.setOnClickListener(onClickListener);


        Button chickenImageButton = findViewById(R.id.gees);
        chickenImageButton.setOnClickListener(onClickListener);


        Button parrotImageButton = findViewById(R.id.bird);
        parrotImageButton.setOnClickListener(onClickListener);


    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cow:
                    playSound(mCowSount);
                    break;
                case R.id.gees:
                    playSound(mChickenSound);
                    break;
                case R.id.cat:
                    playSound(mCatSound);
                    break;
                case R.id.bird:
                    playSound(mParrotSound);
                    break;

            }
        }
    };



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }
    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }
    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = soundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }
    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = assetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return soundPool.load(afd, 1);
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool();
        } else {
            // Для новых устройств
            createNewSoundPool();
        }

        assetManager = getAssets();

        // получим идентификаторы
        mCatSound = loadSound("Meow.ogg");
        mChickenSound = loadSound("duck-01.ogg");
        mCowSount = loadSound("cow.ogg");
        mParrotSound = loadSound("peacock.ogg");


    }
    @Override
    protected void onPause() {
        super.onPause();
        soundPool.release();
        soundPool = null;
    }


}
