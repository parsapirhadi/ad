package com.example.myapplication.M.DataType;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;

public class Counter {


static int exist_in_secound=0;

static int row_montage[]=new int[64];

static int count_buffer=1;
static int show_record_ch=0;

    static int Surfaceview_height_singlerecord=0;

    static int Surfaceview_Width_singlerecord=0;


    static int Surfaceview_height_eightrecord=0;

    static int Surfaceview_Width_eightrecord=0;

    public static float [][] channel=new float[16][800000];

    public static float [][] buffer=new float[16][16100];

    static boolean refresh=true;

    static final int part_data= 1000;

    static int surfaceviewheheight=0;
    static int surfaceviewhewidth=0;

    static int horizontal_scale=8;
    static int startdraw=0;
    static int enddraw=8000;

    static long anim_sleep=0;

    static boolean bluetooth_drawabe =false;


    int count_of_set_i_channel=0;
    int count_of_set_j_channel=0;

    static float single_step_y =0;
    static float single_step_x =0;

    static float eight_step_y =0;
    static float eight_step_x =0;

    static int o=-1;

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    static final int default_channel=8;

    static int line_clecked=0;

    public static boolean changeScreen_eight=false;
    public static boolean changeScreen_single=false;


    static int counter_changescreeen=1;

    static int buffer_count=0;

    static boolean is_draw_activity_on =true;

    static boolean is_receive_activity_on =true;


    static boolean first_page=false;


    static boolean signal_is_weak=false;

   static boolean eightRecord_ispause=false;

    static float min_receive_data;



    static float surface_width =0;
    static float surface_height=0;

    static int x=1;

   static int recordcount=0;

    public int getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(int recordcount) {
        this.recordcount = recordcount;
    }

    public boolean isEightRecord_ispause() {
        return eightRecord_ispause;
    }

    public void setEightRecord_ispause(boolean eightRecord_ispause) {
        this.eightRecord_ispause = eightRecord_ispause;
    }

    public float getMin_receive_data() {
        return min_receive_data;
    }

    public void setMin_receive_data(float min_receive_data) {
        this.min_receive_data = min_receive_data;
    }

    public boolean isSignal_is_weak() {
        return signal_is_weak;
    }

    public void setSignal_is_weak(boolean signal_is_weak) {
        this.signal_is_weak = signal_is_weak;
    }

    public boolean is_draw_activity_on() {
        return is_draw_activity_on;
    }

    public void set_draw_activity_on(boolean is_draw_activity_on) {
        this.is_draw_activity_on = is_draw_activity_on;
    }
    public boolean is_receive_activity_on() {
        return is_receive_activity_on;
    }

    public void set_receive_activity_on(boolean is_receive_activity_on) {
        this.is_receive_activity_on = is_receive_activity_on;
    }
    public int getSurfaceview_Width_singlerecord() {
        return Surfaceview_Width_singlerecord;
    }

    public void setSurfaceview_Width_singlerecord(int Surfaceview_Width_singlerecord) {
        this.Surfaceview_Width_singlerecord = Surfaceview_Width_singlerecord;
    }

    public boolean isFrist_page() {
        return first_page;
    }

    public void setFrist_page(boolean frist_page) {
        this.first_page = frist_page;
    }

    public int getSurfaceview_height_singlerecord(){
       return Surfaceview_height_singlerecord;
   }
    public void setSurfaceview_height_singlerecord(int Surfaceview_height_singlerecord){
        this.Surfaceview_height_singlerecord =Surfaceview_height_singlerecord;
    }







    public int getSurfaceview_Width_eightrecord() {
        return Surfaceview_Width_eightrecord;
    }

    public void setSurfaceview_Width_eightrecord(int Surfaceview_Width_eightrecord) {
        this.Surfaceview_Width_eightrecord = Surfaceview_Width_eightrecord;
    }

    public int getSurfaceview_height_eightrecord(){
        return Surfaceview_height_eightrecord;
    }
    public void setSurfaceview_height_eightrecord(int Surfaceview_height_eightrecord){
        this.Surfaceview_height_eightrecord =Surfaceview_height_eightrecord;
    }







    public int getRow_montage(int i) {
        return row_montage[i];
    }

    public void setRow_montage(int row_montage,int i) {
        Counter.row_montage[i]= row_montage;
    }

    public int getShow_record_ch() {
        return show_record_ch;
    }

    public void setShow_record_ch(int show_record_ch) {
        this.show_record_ch = show_record_ch;
    }



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


    public int getPart_data() {
        return part_data;
    }



    public boolean isBluetooth_drawabe() {
        return bluetooth_drawabe;
    }

    public void setBluetooth_drawabe(boolean bluetooth_drawabe) {
        this.bluetooth_drawabe = bluetooth_drawabe;
    }



    public int getBuffer_count() {
        return buffer_count;
    }

    public void setBuffer_count(int buffer_count) {
        Counter.buffer_count = buffer_count;
    }



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




    public int getCounter_changescreeen() {
        return counter_changescreeen;
    }

    public void setCounter_changescreeen(int counter_changescreeen) {
        Counter.counter_changescreeen = counter_changescreeen;
    }



    public boolean isChangeScreen_eight() {
        return changeScreen_eight;
    }

    public void setChangeScreen_eight(boolean changeScreen_eight) {
        Counter.changeScreen_eight = changeScreen_eight;
    }

    public boolean isChangeScreen_single() {
        return changeScreen_single;
    }

    public void setChangeScreen_single(boolean changeScreen_single) {
        Counter.changeScreen_single = changeScreen_single;
    }

    public float getBuffere(int i, int j) {
        return buffer[i][j];
    }


    public void setBuffer(float f,int i,int j) {
        this.buffer[i][j]=f;
    }



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
