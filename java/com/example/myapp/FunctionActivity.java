package com.example.myapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FunctionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);


        Button button=findViewById(R.id.b1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton meterRadioButton=findViewById(R.id.radioButton);
                EditText inputText = findViewById(R.id.MyPlain);
                if(inputText.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Введите длину кота", Toast.LENGTH_SHORT).show();
                return;
                }
                float inputValue=Float.parseFloat(inputText.getText().toString());
                if(meterRadioButton.isChecked()){
                    inputText.setText(String.valueOf(convertParrotToMeter(inputValue)));
                }else{
                    inputText.setText(String
                            .valueOf(convertMeterToParrot(inputValue)));
                }
            }
        });

    }
    private float convertParrotToMeter(float parrot) {
        return (float) (parrot / 7.6);
    }
    private float convertMeterToParrot(float meter){
        return (float)(meter*7.6);
    }

}
