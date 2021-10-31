package com.example.myapplication.M.DataType;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Counter implements Serializable {


     int count_of_set_i_channel=0;
     int count_of_set_j_channel=0;


    public static float [][] channel=new float[32][800000];



    static int line_clecked=0;



    public int getLine_clecked() {
        return line_clecked;
    }

    public void setLine_clecked(int line_clecked) {
        this.line_clecked = line_clecked;
    }


    public int getCount_of_set_i_channel() {
        return count_of_set_i_channel;
    }

    public void setCount_of_set_i_channel(int count_of_set_i_channel) {
        this.count_of_set_i_channel = count_of_set_i_channel;
    }

    public int getCount_of_set_j_channel() {
        return count_of_set_j_channel;
    }

    public void setCount_of_set_j_channel(int count_of_set_j_channel) {
        this.count_of_set_j_channel = count_of_set_j_channel;
    }






    public float getChannel(int i,int j) {
        return channel[i][j];
    }

    public void setChannel(float f,int i,int j) {
        this.channel[i][j]=f;
    }







}
