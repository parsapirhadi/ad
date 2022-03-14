package com.example.myapplication.P;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

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
    SetPivotValue pivotValue;
    String patch;
    Context context;
    String s = "";
    String fileContent = "";
    Activity activity;

    public FileReader(Context context,Activity activity, String1 string1, Counter counter, SetPivotValue pivotValue) {
        this.string1 = string1;
        this.counter = counter;
       // this.namePivote = namePivote;
        this.pivotValue = pivotValue;
        this.activity=activity;
        this.context=context;
    }

    public void read(){
        counter.setCount_of_set_i_channel(0);
        counter.setCount_of_set_j_channel(0);


        // Log.e("%%%%%%%%%%%","4444");




        // String d=string1.getFilepatch().
        String fileName =  f1;



        try {

            myReader = new BufferedReader(new InputStreamReader(context.getContentResolver().openInputStream(string1.getFilepatch())));

           // if ((s = myReader.readLine()) != null) {
             //   fileContent = s ;

           // }

            char[] charArray = fileContent.toCharArray();
            //   Log.e("aaaaaaaaaaaaaa",""+fileContent);






         //   namePivote=new SetPivotName(fileContent,string1,counter);
          //  namePivote.set();
            counter.setCount_of_set_i_channel(0);
            counter.setCount_of_set_j_channel(0);


            if ((s = myReader.readLine()) != null && counter.isLoadfor()) {

                for (int e=0;e<s.length();e++){
                    if (s.charAt(e)==','){
                        counter.setChannel_load(counter.getChannel_load()+1);

                    }
                }



                counter.setExist_in_secound(counter.getExist_in_secound()+1);
                fileContent = s ;
                string1.setLine_count(string1.getLine_count()+1);
                pivotValue=new SetPivotValue(fileContent,string1,counter);
                pivotValue.set();

            }



            string1.setChannel_count((counter.getChannel_load()/8)*8);

            for (int f=0;f<string1.getChannel_count();f++) {
                string1.setPivote(f, "ch"+(f+1));
            }

             new Thread(new Runnable() {
                 @Override
                 public void run() {


                     try {



                         while ((s = myReader.readLine()) != null && counter.isLoadfor()) {
                             counter.setExist_in_secound(counter.getExist_in_secound() + 1);
                             fileContent = s;
                             string1.setLine_count(string1.getLine_count() + 1);
                             pivotValue = new SetPivotValue(fileContent, string1, counter);
                             pivotValue.set();


                         }
                         try {
                             myReader.close();
                         } catch (IOException | NullPointerException e) {
                             e.printStackTrace();
                         }

                     }
                     catch (IOException e){
                         e.printStackTrace();
                         Log.e("mmmmmmm",""+e.getMessage());
                     }

                 }
             }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }





        ///pivotValue.setvalueofeachchannel();
        pivotValue.y();



        counter.setEight_step_x((float) counter.getSurface_width()/(counter.getRate_in_s()*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/200);
        counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);


    }
}