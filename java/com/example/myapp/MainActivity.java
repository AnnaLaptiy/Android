package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final private int CHOOSE_THIEF = 0;
    private static final String KEY_COUNT = "COUNT";
    TextView textView; Button feed; Button set;
    private float mBackLightValue = 0.5f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);
        Button orient=findViewById(R.id.button3);
         feed=findViewById(R.id.button4);
         set=findViewById(R.id.action_settings);

         Button funcs=findViewById(R.id.button8);

        Intent intent=new Intent(this,AboutActivity.class);
        Intent function=new Intent(this, com.example.myapp.Menu.class);
        Intent intent2=new Intent(this,AddActivity.class);

        textView=findViewById(R.id.textView4);
        textView.setText("Click me!");
        if(savedInstanceState!=null) {
            if(savedInstanceState.getInt(KEY_COUNT,0)==0){
                orient.setText("toHor");
            }else{
                orient.setText("toVer");

            }
          //  orient.setText(String.valueOf(savedInstanceState.getInt(KEY_COUNT,0)));
        }else{
            orient.setText("def");
        }


        feed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                AlertDialog.Builder builder=new AlertDialog.Builder(feed.getContext(),R.style.MyDialogStyle);
                builder.setTitle("Dialog");
                builder.setMessage("Покормить котика?");
                builder.setPositiveButton("Ok",null);
                builder.setNegativeButton("No",null);
                builder.show();

            }
        });

        orient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rotate=getWindowManager().getDefaultDisplay().getRotation();

                if(rotate == Surface.ROTATION_0) {

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                else                 {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);}


            }
        });
        funcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(function);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra("gift"," cup of tea ");
                startActivityForResult(intent2,CHOOSE_THIEF);
                textView.setText("clicked: "+CHOOSE_THIEF);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(view);
            }
        });




    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, getWindowManager().getDefaultDisplay().getRotation());
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater=new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_ring:showSettingsRing(); return true;
            case R.id.ref:showSettings(); return true;
            case R.id.action_settings:

                AlertDialog.Builder builder=new AlertDialog.Builder(this, androidx.appcompat.R.style.Base_Theme_AppCompat_Light_DarkActionBar);
                builder.setTitle("Settings");

                // Теперь получим необходимую информацию
                Display display = getWindowManager().getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                int screenWidth = point.x;
                int screenHeight = point.y;

                String width = Integer.toString(screenWidth);
                String height = Integer.toString(screenHeight);
                String orientation = Integer.toString(display.getOrientation());
                String info = "Ширина: " + width + "; Высота: " + height + "; \n\nОриентация: " + orientation+" \n (0-вертикальная/1-горизонтальная)";

                //Получить DeviceDensity
                int dpiDensity = getResources().getDisplayMetrics().densityDpi;
                info+="\n\nDensity: ";
                switch(dpiDensity){
                    case DisplayMetrics.DENSITY_LOW:
                        info+=" DENSITY_LOW";
                        break;
                    case DisplayMetrics.DENSITY_MEDIUM:
                        info+=" DENSITY_MEDIUM";
                        break;
                    case DisplayMetrics.DENSITY_HIGH:
                        info+=" DENSITY_HIGH";
                        break;
                    case DisplayMetrics.DENSITY_XHIGH:
                        info+=" DENSITY_XHIGH";
                        break;
                    case DisplayMetrics.DENSITY_XXHIGH:
                        info+=" DENSITY_XXHIGH";
                        break;
                    case DisplayMetrics.DENSITY_XXXHIGH:
                        info+=" DENSITY_XXXHIGH";
                        break;
                }
                // ПОлучить яркость
                try {
                    int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                    info+="  \n\nТекущая яркость экрана: " + curBrightnessValue;
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }
                builder.setMessage(info);
                builder.setNegativeButton("Ok",null);
                builder.show();break;
            case R.id.action_cat1:textView.setText("Вы выбрали кота!"); break;
            case R.id.action_cat2:textView.setText("Вы выбрали кошку!");break;
            case R.id.action_cat3:textView.setText("Вы выбрали котёнка!");break;

        }

        return super.onOptionsItemSelected(item);

    }

    private void showPopMenu(View v){
        PopupMenu popupMenu=new PopupMenu(this,v);
        popupMenu.inflate(R.menu.menu_main);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_ring:showSettingsRing(); return true;
                    case R.id.ref:showSettings(); return true;
                    case R.id.action_settings:showSettings(); return true;
                    case R.id.action_cat1: Toast.makeText(getApplicationContext(),"Вы выбрали кота!",Toast.LENGTH_SHORT).show(); return true;
                    case R.id.action_cat2: Toast.makeText(getApplicationContext(),"Вы выбрали кошку!",Toast.LENGTH_SHORT).show(); return true;
                    case R.id.action_cat3: Toast.makeText(getApplicationContext(),"Вы выбрали котёнка!",Toast.LENGTH_SHORT).show(); return true;

                }
                return false;
            }

        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu popupMenu) {
                Toast.makeText(getApplicationContext(), "onDismiss",
                        Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }

    public void showSettings()
    {
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }
    public void showSettingsRing()
    {
        Intent intent = new Intent(this, RingtonePreferenceActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textView=findViewById(R.id.textView4);
        textView.setText("clicked: "+data.getExtras().getString("THIEF"));

    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }
    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("Таки да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            event.startTracking();
            Toast toast = Toast.makeText(getApplicationContext(), "Key Down", Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        SharedPreferences sharedPreferences = PreferenceManager
//                .getDefaultSharedPreferences(this);
//
//        int catHeight = sharedPreferences.getInt("height", 20);
//        // Добавим TextView, в котором будем выводить значение настройки
//        textView.setText("Высота кота = "
//                + catHeight);
//    }

}
