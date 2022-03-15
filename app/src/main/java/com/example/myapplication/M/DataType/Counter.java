package com.example.myapplication.M.DataType;

import android.graphics.Paint;

public class Counter {



    static float alpha=2048;


    static float beta= (float) 1.4;


    static int channel_load=0;


    static boolean b_touch =false;

    static int rate_in_secound =512;

   static boolean loadfor=true;

static int exist_in_secound=0;

static int row_montage[]=new int[64];

static int count_buffer=1;
static int show_record_ch=0;

    static int Surfaceview_height_singlerecord=0;

    static int Surfaceview_Width_singlerecord=0;



    static int Surfaceview_height_eightrecord=0;

    static int Surfaceview_Width_eightrecord=0;

    public static float [][] channel=new float[32][800000];

    static boolean activity_on_load=true;

    public static float [][] buffer=new float[16][16100];

    static boolean refresh=true;

    static final int part_data= 1000;

    static int surfaceviewheheight=0;
    static int surfaceviewhewidth=0;

    static float horizontal_scale=8;

    static  float horizontal_scale_clone=8;

    static int startdraw_record =1;
    static int enddraw_record =8192;

     static int startdraw_root =1;
    static int enddraw_root =8192;

    static int startdraw_root_clone =1;
    static int enddraw_root_clone =8192;

    static float Seconds_count0_root_clone =1;
    static float Seconds_count8000_root_clone=8192;




    static long anim_sleep=0;

    static boolean bluetooth_drawabe =false;


     static float Seconds_count0_record =0;
    static float Seconds_count1000_record;
    static float Seconds_count2000_record;
    static float Seconds_count3000_record;
    static float Seconds_count4000_record;
    static float Seconds_count5000_record;
    static float Seconds_count6000_record;
     static float Seconds_count7000_record;
    static float Seconds_count8000_record;



   static float Seconds_count0_root =0;
   static float Seconds_count1000_root;
    static float Seconds_count2000_root;
   static float Seconds_count3000_root;
   static float Seconds_count4000_root;
    static float Seconds_count5000_root;
    static float Seconds_count6000_root;
  static float Seconds_count7000_root;
    static float Seconds_count8000_root;


    static int Line_stop_counter=0;


    static int count_of_set_i_channel=0;
    static int count_of_set_j_channel=0;

    static float single_step_y =0;
    static float single_step_x =0;

    static float eight_step_y =0;
    static float eight_step_x =0;

    static float single_step_x_clone =0;

    static float eight_step_x_clone =0;

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


    static boolean record_activity= false;

    static boolean touchDraw=false;

    static float start_touch_draw=0;

    static float end_touch_draw=0;


    static long buffer_count=0;

    static boolean is_draw_activity_on =true;

    static boolean is_receive_activity_on =true;


    static float stop_line[]=new float[40];

     static Paint sp = new Paint();

    static boolean first_page=false;

    static boolean first_page1=false;

    static boolean signal_is_weak=false;

   static boolean eightRecord_ispause=false;

    static float min_receive_data;

    static int loop_counter=1;

    static float surface_width =0;
    static float surface_height=0;



    static int x=1;

   static int recordcount=1;


    static boolean on_pause=false;


    static float timer=0;

    public float getStart_touch_draw() {
        return start_touch_draw;
    }

    public void setStart_touch_draw(float start_touch_draw) {
        Counter.start_touch_draw = start_touch_draw;
    }

    public float getEnd_touch_draw() {
        return end_touch_draw;
    }

    public void setEnd_touch_draw(float end_touch_draw) {
        Counter.end_touch_draw = end_touch_draw;
    }

    public float getHorizontal_scale_clone() {
        return horizontal_scale_clone;
    }

    public void setHorizontal_scale_clone(float horizontal_scale_clone) {
        Counter.horizontal_scale_clone = horizontal_scale_clone;
    }

    public  float getSingle_step_x_clone() {
        return single_step_x_clone;
    }

    public  void setSingle_step_x_clone(float single_step_x_clone) {
        Counter.single_step_x_clone = single_step_x_clone;
    }

    public  float getEight_step_x_clone() {
        return eight_step_x_clone;
    }

    public  void setEight_step_x_clone(float eight_step_x_clone) {
        Counter.eight_step_x_clone = eight_step_x_clone;
    }

    public  int getStartdraw_root_clone() {
        return startdraw_root_clone;
    }

    public void setStartdraw_root_clone(int startdraw_root_clone) {
        Counter.startdraw_root_clone = startdraw_root_clone;
    }

    public int getEnddraw_root_clone() {
        return enddraw_root_clone;
    }

    public void setEnddraw_root_clone(int enddraw_root_clone) {
        Counter.enddraw_root_clone = enddraw_root_clone;
    }

    public  boolean isActivity_on_load() {
        return activity_on_load;
    }

    public  void setActivity_on_load(boolean activity_on_load) {
        Counter.activity_on_load = activity_on_load;
    }

    public float getSeconds_count0_root_clone() {
        return Seconds_count0_root_clone;
    }

    public  void setSeconds_count0_root_clone(float seconds_count0_root_clone) {
        Seconds_count0_root_clone = seconds_count0_root_clone;
    }

    public float getSeconds_count8000_root_clone() {
        return Seconds_count8000_root_clone;
    }

    public  void setSeconds_count8000_root_clone(int seconds_count8000_root_clone) {
        Seconds_count8000_root_clone = seconds_count8000_root_clone;
    }

    public boolean isLoadfor() {
        return loadfor;
    }

    public void setLoadfor(boolean loadfor) {
        Counter.loadfor = loadfor;
    }

    public int getChannel_load() {
        return channel_load;
    }



    public void setChannel_load(int channel_load) {
        Counter.channel_load = channel_load;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public boolean isOn_pause() {
        return on_pause;
    }

    public void setOn_pause(boolean on_pause) {
        this.on_pause = on_pause;
    }

    public boolean isRecord_activity() {
        return record_activity;
    }

    public void setRecord_activity(boolean record_activity) {
        this.record_activity = record_activity;
    }

    public float getStop_line(int i) {
        return stop_line[i];
    }

    public int getLoop_counter() {
        return loop_counter;
    }

    public void setLoop_counter(int loop_counter) {
        this.loop_counter = loop_counter;
    }

    public Paint getSp() {
        return sp;
    }

    public void setSp(Paint sp) {
        this.sp = sp;
    }

    public void setStop_line(float stop_line,int i) {
        this.stop_line[i] = stop_line;
    }

    public int getLine_stop_counter() {
        return Line_stop_counter;
    }

    public void setLine_stop_counter(int line_stop_counter) {
        Line_stop_counter = line_stop_counter;
    }

    public float getSeconds_count0_record() {
        return Seconds_count0_record;
    }

    public void setSeconds_count0_record(float seconds_count0) {
        Seconds_count0_record = seconds_count0;
    }

    public float getSeconds_count1000_record() {
        return Seconds_count1000_record;
    }

    public void setSeconds_count1000_record(float seconds_count1000) {
        Seconds_count1000_record = seconds_count1000;
    }

    public boolean isB_touch() {
        return b_touch;
    }

    public void setB_touch(boolean b_touch) {
        Counter.b_touch = b_touch;
    }

    public float getSeconds_count2000_record() {
        return Seconds_count2000_record;
    }

    public void setSeconds_count2000_record(float seconds_count2000) {
        Seconds_count2000_record = seconds_count2000;
    }

    public float getSeconds_count3000_record() {
        return Seconds_count3000_record;
    }

    public void setSeconds_count3000_record(float seconds_count3000) {
        Seconds_count3000_record = seconds_count3000;
    }

    public float getSeconds_count4000_record() {
        return Seconds_count4000_record;
    }

    public void setSeconds_count4000_record(float seconds_count4000) {
        Seconds_count4000_record = seconds_count4000;
    }

    public float getSeconds_count5000_record() {
        return Seconds_count5000_record;
    }

    public void setSeconds_count5000_record(float seconds_count5000) {
        Seconds_count5000_record = seconds_count5000;
    }

    public float getSeconds_count6000_record() {
        return Seconds_count6000_record;
    }

    public void setSeconds_count6000_record(float seconds_count6000) {
        Seconds_count6000_record = seconds_count6000;
    }

    public float getSeconds_count7000_record() {
        return Seconds_count7000_record;
    }

    public void setSeconds_count7000_record(float seconds_count7000) {
        Seconds_count7000_record = seconds_count7000;
    }

    public float getSeconds_count8000_record() {
        return Seconds_count8000_record;
    }

    public void setSeconds_count8000_record(float seconds_count8000) {
        Seconds_count8000_record = seconds_count8000;
    }


    public float getSeconds_count0_root() {
        return Seconds_count0_root;
    }

    public void setSeconds_count0_root(float seconds_count0_root) {
        Seconds_count0_root = seconds_count0_root;
    }

    public float getSeconds_count1000_root() {
        return Seconds_count1000_root;
    }

    public void setSeconds_count1000_root(float seconds_count1000_root) {
        Seconds_count1000_root = seconds_count1000_root;
    }

    public float getSeconds_count2000_root() {
        return Seconds_count2000_root;
    }

    public void setSeconds_count2000_root(float seconds_count2000_root) {
        Seconds_count2000_root = seconds_count2000_root;
    }

    public float getSeconds_count3000_root() {
        return Seconds_count3000_root;
    }

    public void setSeconds_count3000_root(float seconds_count3000_root) {
        Seconds_count3000_root = seconds_count3000_root;
    }

    public float getSeconds_count4000_root() {
        return Seconds_count4000_root;
    }

    public void setSeconds_count4000_root(float seconds_count4000_root) {
        Seconds_count4000_root = seconds_count4000_root;
    }

    public float getSeconds_count5000_root() {
        return Seconds_count5000_root;
    }

    public void setSeconds_count5000_root(float seconds_count5000_root) {
        Seconds_count5000_root = seconds_count5000_root;
    }

    public float getSeconds_count6000_root() {
        return Seconds_count6000_root;
    }

    public void setSeconds_count6000_root(float seconds_count6000_root) {
        Seconds_count6000_root = seconds_count6000_root;
    }

    public boolean isTouchDraw() {
        return touchDraw;
    }

    public void setTouchDraw(boolean touchDraw) {
        Counter.touchDraw = touchDraw;
    }

    public float getSeconds_count7000_root() {
        return Seconds_count7000_root;
    }

    public void setSeconds_count7000_root(float seconds_count7000_root) {
        Seconds_count7000_root = seconds_count7000_root;
    }

    public float getSeconds_count8000_root() {
        return Seconds_count8000_root;
    }

    public void setSeconds_count8000_root(float seconds_count8000_root) {
        Seconds_count8000_root = seconds_count8000_root;
    }

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

    public static boolean isIs_draw_activity_on() {
        return is_draw_activity_on;
    }

    public static boolean isIs_receive_activity_on() {
        return is_receive_activity_on;
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



    public long getBuffer_count() {
        return buffer_count;
    }

    public void setBuffer_count(long buffer_count) {
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

    public int getStartdraw_record() {
        return startdraw_record;
    }

    public void setStartdraw_record(int startdraw) {
        Counter.startdraw_record = startdraw;
    }

    public int getEnddraw_record() {
        return enddraw_record;
    }

    public void setEnddraw_record(int enddraw) {
        Counter.enddraw_record = enddraw;
    }


    public int getStartdraw_root() {
        return startdraw_root;
    }

    public void setStartdraw_root(int startdraw_root) {
        Counter.startdraw_root = startdraw_root;
    }

    public int getEnddraw_root() {
        return enddraw_root;
    }

    public void setEnddraw_root(int enddraw_root) {
        Counter.enddraw_root = enddraw_root;
    }

    public float getHorizontal_scale() {
        return horizontal_scale;

    }
    public void setHorizontal_scale(float horizontal_scale) {
        Counter.horizontal_scale = horizontal_scale;

    }



    public int getRate_in_s() {
        return rate_in_secound;
    }



    public static void setRate_in_s(int rate_in_secound) {
        Counter.rate_in_secound = rate_in_secound;
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


    public void setChannel(float f,int i,int j) {
        this.channel[i][j]=f;
    }







}
