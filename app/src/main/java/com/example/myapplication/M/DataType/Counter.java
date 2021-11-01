package com.example.myapplication.M.DataType;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Counter implements Serializable {


     int count_of_set_i_channel=0;
     int count_of_set_j_channel=0;

static float screen_width =0;
   static float screen_height=0;

       static float step_y =0;
         static float step_x =0;

    public float getStep_y() {
        return step_y;
    }

   public void setStep_y(float step_y) {
        this.step_y = step_y;
    }

    public float getStep_x() {
        return step_x;
    }

    public void setStep_x(float step_x) {
        this.step_x = step_x;
   }

    static float surface_width =0;
   static float surface_height=0;

    public  float getScreen_width() {
        return screen_width;
    }

    public  void setScreen_width(float screen_width) {
        Counter.screen_width = screen_width;
    }

    public  float getScreen_height() {
        return screen_height;
    }

    public  void setScreen_height(float screen_height) {
        Counter.screen_height = screen_height;
    }

    public float getSurface_width() {
        return surface_width;
    }

    public void setSurface_width(float surface_width) {
        Counter.surface_width = surface_width;
    }

    public float getSurface_height() {
        return surface_height;
    }

    public  void setSurface_height(float surface_height) {
        Counter.surface_height = surface_height;
    }

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
