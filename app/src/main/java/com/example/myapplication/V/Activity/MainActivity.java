 package com.example.myapplication.V.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
String1 string1;
SetPivotName namePivote;
SetPivotName pivotValue;
TextView name_version;
Counter counter;

    @SuppressLint("SetTextI18n")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);











        Locale locale_us = new Locale("en", "US");
        getResources().getConfiguration().setLocale(locale_us);
        string1=new String1();
        counter=new Counter();
        counter.setStartdraw_record(1);


        Intent intent=new Intent(this,MenuActivity.class);


try {


    counter.setHorizontal_scale(Integer.parseInt(getSharedPreferences("horizontal_scale", MODE_PRIVATE).getString("horizontal_scale", "")));
}
catch (Exception e){
    e.printStackTrace();
}





     
        for (int o=0;o<counter.getDefault_channel();o++){
        for (int p=0;p<1300000;p++) {
            counter.setChannel(1000, o, p);
        }}


        for (int p=0;p<40;p++){
            counter.setStop_line(10000,p);
        }

        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<16000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);

            }
        }

        startActivity(intent);


        finish();



    }
}














