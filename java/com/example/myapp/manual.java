package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class manual extends Activity {
    //Создаём массив разделов:


    private String titles[] = {
            "00. Начало",
            "01. Чем кормить кота",
            "02. Как гладить кота",
            "03. Как спит кот",
            "04. Как играть с котом",
            "05. Как разговаривать с котом",
            "06. Интересные факты из жизни котов",
            "07. Как назвать кота",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_manual);
        Intent intent2=new Intent(this,second_manual.class);
        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);
//        listView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //запускаем вторую активность
//                intent2.putExtra("gift"," cup of tea ");
//                startActivityForResult(intent2,0);
//            }
//        });
        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

//                intent.putExtra("title", position);
                //запускаем вторую активность
                intent2.putExtra("title", position);
                startActivityForResult(intent2,0);
            }
        });
    }




}
