package com.example.myapplication.V.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
String1 string1;
SetPivotName namePivote;
SetPivotName pivotValue;
Counter counter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);



        Locale locale_us = new Locale("en", "US");
        getResources().getConfiguration().setLocale(locale_us);
        string1=new String1();
        counter=new Counter();
        Intent intent=new Intent(this,EightRootActivity.class);

        for (int o=0;o<counter.getDefault_channel();o++){
        for (int p=0;p<800000;p++) {
            counter.setChannel(1000, o, p);
        }}

        startActivity(intent);


        finish();



    }
}














