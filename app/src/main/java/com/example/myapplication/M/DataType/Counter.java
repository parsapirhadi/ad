package com.example.myapplication.M.DataType;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;

public class Counter {

static int exist_in_secound=0;

static int count_buffer=1;
static int show_record_ch=0;

    public int getShow_record_ch() {
        return show_record_ch;
    }

    public void setShow_record_ch(int show_record_ch) {
        this.show_record_ch = show_record_ch;
    }

    static boolean refresh=true;

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        Counter.refresh = refresh;
    }

    public int getCount_buffer() {
        return count_buffer;
    }

    public void setCount_buffer(int count_buffer) {
        Counter.count_buffer = count_buffer;
    }

    public int getExist_in_secound() {
        return exist_in_secound;
    }

    public void setExist_in_secound(int exist_in_secound) {
        this.exist_in_secound = exist_in_secound;
    }
static final int part_data= 1000;

    public int getPart_data() {
        return part_data;
    }

    int count_of_set_i_channel=0;
     int count_of_set_j_channel=0;


     static boolean bluetooth_drawabe =false;

    public boolean isBluetooth_drawabe() {
        return bluetooth_drawabe;
    }

    public void setBluetooth_drawabe(boolean bluetooth_drawabe) {
        this.bluetooth_drawabe = bluetooth_drawabe;
    }

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

    final static int rate_in_secound =512;
    public int getRate_in_s() {
        return rate_in_secound;
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


     static final int default_channel=8;

    public  int getDefault_channel() {
        return default_channel;
    }

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

    public static float [][] buffer=new float[8][80000];

    public static float [][] buffer_clone=new float[8][80000];


    public float getBuffer_clone(int i,int j) {
        return buffer_clone[i][j];
    }


    public void setBuffer_clone(float f,int i,int j) {
        this.buffer_clone[i][j]=f;
    }
    public float getBuffere(int i,int j) {
        return buffer[i][j];
    }


    public void setBuffer(float f,int i,int j) {
        this.buffer[i][j]=f;
    }

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
    public float[] getChannel(int i){
        return channel[i];
    }

    public void setChannel(float f,int i,int j) {
        this.channel[i][j]=f;
    }







}
