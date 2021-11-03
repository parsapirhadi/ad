package com.example.myapplication.M.DataType;

import android.graphics.Paint;

import java.io.Serializable;

public class String1 implements Serializable {
     String montage="";
    static String filepatch="";
    static int line_count=0;
    static String filename="";
    static int  channel_count=0;
    public static String[] pivote =new String[64];

public static Paint paint[]=new Paint[64];

    public  Paint getPaint(int t) {
        return paint[t];
    }



    public int getLine_count() {
        return line_count;
    }

    public void setLine_count(int line_count) {
        this.line_count = line_count;
    }
    public String getFilepatch() {
        return filepatch;
    }

    public void setFilepatch(String filepatch) {
        this.filepatch = filepatch;
    }

    public String getPivote(int i) {
        return pivote[i];
    }

    public void setPivote(int i,String s) {
        pivote[i]=s;
    }



    public String getMontage() {
        return montage;
    }

    public void setMontage(String montage) {
        this.montage = montage;
    }

    public int getChannel_count() {
        return channel_count;
    }

    public void setChannel_count(int channel_count) {
        this.channel_count = channel_count;
    }





}


