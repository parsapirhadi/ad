package com.example.myapplication.P;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class FileReader {
    BufferedReader myReader;
    String1 string1;
    Counter counter;
    int y1=0;
    String f1="";
    //SetPivotName namePivote;
    SetPivotValue pivotValue;
    String patch;
    Context context;
    Activity activity;

    public FileReader(Context context,Activity activity, String1 string1, Counter counter, SetPivotName namePivote, SetPivotValue pivotValue) {
        this.string1 = string1;
        this.counter = counter;
        //this.namePivote = namePivote;
        this.pivotValue = pivotValue;
        this.activity=activity;
        this.context=context;
    }

    public void read(){
        // Log.e("%%%%%%%%%%%","4444");
        for (int i=0;i<32;i++) {
            for (int j=0;j<800000;j++) {
                counter.setChannel((float) 1000.0,i,j);
            }
        }



        // String d=string1.getFilepatch().
        String fileName =  f1;
        Log.e("%%%%%%%%%%%",f1);
        String s = "";
        String fileContent = "";

        try {

            myReader = new BufferedReader(new InputStreamReader(context.getContentResolver().openInputStream(string1.getFilepatch())));

            if ((s = myReader.readLine()) != null) {
                fileContent = s ;

            }

            char[] charArray = fileContent.toCharArray();
            //   Log.e("aaaaaaaaaaaaaa",""+fileContent);



            for (int f=0;f<10;f++) {
                string1.setPivote(f, "ch"+(f+1));
            }
            string1.setChannel_count(8);
           // namePivote=new SetPivotName(fileContent,string1,counter);
           // namePivote.set();



            while ((s = myReader.readLine()) != null) {
                counter.setExist_in_secound(counter.getExist_in_secound()+1);
                fileContent = s ;
                string1.setLine_count(string1.getLine_count()+1);
                pivotValue=new SetPivotValue(fileContent,string1,counter);
                pivotValue.set();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            myReader.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }



        ///pivotValue.setvalueofeachchannel();
        pivotValue.y();

        //  Log.e("{{{{{{{{{{{",""+counter.getAll(5));


        counter.setEight_step_x((float) counter.getSurface_width()/(counter.getRate_in_s()*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/10000);
        counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);


    }
}