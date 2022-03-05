package com.example.myapplication.M.DataType;

import android.graphics.Paint;
import android.net.Uri;

import java.io.Serializable;

public class String1 implements Serializable {
    static String montage="mono";

    static String nameVersion="NrSign1.0.0";

    static Uri filepatch=null;
    static int line_count=0;
    static String filename="";
    static int  channel_count=0;

   static String sview="eight";

   static String seight="eight";
   static String ssingle="single";


    public String getSview() {
        return sview;
    }

    public void setSview(String sview) {
        this.sview = sview;
    }

    public String getSeight() {
        return seight;
    }

    public void setSeight(String seight) {
        this.seight = seight;
    }

    public String getSsingle() {
        return ssingle;
    }

    public void setSsingle(String ssingle) {
        this.ssingle = ssingle;
    }

    public static String[] pivote_from =new String[64];
public static String[] pivote_to =new String[64];

    public String getPivote_from(int i) {
        return pivote_from[i];
    }

    public void setPivote_from(int i,String s) {
        pivote_from[i]=s;
    }

    public String getPivote_to(int i) {
        return pivote_to[i];
    }

    public void setPivote_to(int i,String s) {
        pivote_to[i]=s;
    }




    public static String[] pivote =new String[64];

public static Paint paint[]=new Paint[64];

    public  Paint getPaint(int t) {
        return paint[t];
    }

    public String getNameVersion() {
        return nameVersion;
    }

    public void setNameVersion(String nameVersion) {
        this.nameVersion = nameVersion;
    }

    public int getLine_count() {
        return line_count;
    }

    public void setLine_count(int line_count) {
        this.line_count = line_count;
    }





    public Uri getFilepatch() {
        return filepatch;
    }

    public void setFilepatch(Uri filepatch) {
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


