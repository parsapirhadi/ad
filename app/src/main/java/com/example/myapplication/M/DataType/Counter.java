package com.example.myapplication.M.DataType;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;

public class Counter {

static int exist_in_secound=0;

    public int getExist_in_secound() {
        return exist_in_secound;
    }

    public void setExist_in_secound(int exist_in_secound) {
        this.exist_in_secound = exist_in_secound;
    }

    int count_of_set_i_channel=0;
     int count_of_set_j_channel=0;

     static int surfaceviewheheight=0;
      static int surfaceviewhewidth=0;

     static int horizontal_scale=8;
static int startdraw=0;
    static int enddraw=8000;

static long anim_sleep=0;

    public long getAnim_sleep() {
        return anim_sleep;
    }

    public void setAnim_sleep(long anim_sleep) {
        this.anim_sleep = anim_sleep;
    }

    public int getSurfaceviewheheight() {
        return surfaceviewheheight;
    }

    public void setSurfaceviewheheight(int surfaceviewheheight) {
        this.surfaceviewheheight = surfaceviewheheight;
    }

    public int getSurfaceviewhewidth() {
        return surfaceviewhewidth;
    }

    public void setSurfaceviewhewidth(int surfaceviewhewidth) {
        this.surfaceviewhewidth = surfaceviewhewidth;
    }

    public int getStartdraw() {
        return startdraw;
    }

    public void setStartdraw(int startdraw) {
        Counter.startdraw = startdraw;
    }

    public int getEnddraw() {
        return enddraw;
    }

    public void setEnddraw(int enddraw) {
        Counter.enddraw = enddraw;
    }

    public int getHorizontal_scale() {
        return horizontal_scale;

    }
    public void setHorizontal_scale(int horizontal_scale) {
        Counter.horizontal_scale = horizontal_scale;

    }



       static float single_step_y =0;
         static float single_step_x =0;

    static float eight_step_y =0;
    static float eight_step_x =0;

    public  float getEight_step_y() {
        return eight_step_y;
    }

    public  void setEight_step_y(float eight_step_y) {
        Counter.eight_step_y = eight_step_y;
    }

    public  float getEight_step_x() {
        return eight_step_x;
    }

    public  void setEight_step_x(float eight_step_x) {
        Counter.eight_step_x = eight_step_x;
    }

    public float getSingle_step_y() {
       return single_step_y;
   }

    public void setSingle_step_y(float single_step_y) {
       Counter.single_step_y = single_step_y;
   }

    public float getSingle_step_x() {
        return single_step_x;
    }

    public  void setSingle_step_x(float single_step_x) {
        Counter.single_step_x = single_step_x;
    }

    static float surface_width =0;
   static float surface_height=0;

    static int x=1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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
