package com.example.myapplication.V.Activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.V.BaseSurfaceEightRoot;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.P.SetPivotValue;
import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Set;

public class EightRootActivity extends AppCompatActivity {

    Button line, note, crop,bluetooth,montage,play,zoomout_eight,zoomin_eight,zoomout_single,zoomin_single;
    ImageView notch;
    TextView textplay;
    ListView listView;
    TextView pivote8000;
    Animation animation;
    Set<BluetoothDevice> pared;
    Dialog dialog;
   Button lineplay;
    SetPivotName namePivote;
    SetPivotValue pivotValue;





    ListView myListView;




  boolean bnote=true;




    float pivote50=50;
    float pivote100=100;
    float pivote_50=-50;
    float pivote_100=-100;


    TextView row100,row50,row_100,row_50,row0;


    boolean b_notch=false;

    boolean set_dimens=true;

    boolean k=true;


    private ArrayAdapter<String> adapter;

    ObjectAnimator animatorX;
    AnimatorSet animatorSet;
    Animator.AnimatorListener animatorListener;

    int acces_to_paly_animation =0;

    int acces_to_set_change =0;
    boolean single_root=false;

    Dialog choiceDialog;

    Button choise;


    int set_stop_play =0;
    int one=0;

int line_play=0;

  static TextView V0,V1000,V2000,V3000,V4000,V5000,V6000,V7000,V8000;
    private BaseSurfaceEightRoot surface;
    String1 string1;
    Counter counter;
    Vibrator vibrator;
    BufferedReader myReader;
    int g=0;
    float play_text = (float) 1.0;
    int text_play=0;
    int notchcount;
    Activity activity;
    GraphView graphView1;
    int playcount;

int is_change_text=0;

 static TextView ch[]=new TextView[65];


    public static TextView getV0() {
        return V0;
    }public static TextView getV1000() {
        return V1000;
    }public static TextView getV2000() {
        return V2000;
    } public static TextView getV3000() {
        return V3000;
    } public static TextView getV4000() {
        return V4000;
    } public static TextView getV5000() {
        return V5000;
    } public static TextView getV6000() {
        return V6000;
    } public static TextView getV7000() {
        return V7000;
    } public static TextView getV8000() {
        return V8000;
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume()
    {


        super.onResume();


        surface.startDrawThread(0);

        counter.setStartdraw_record(1);
        counter.setEnddraw_record((int)counter.getHorizontal_scale()*counter.getRate_in_s()*2);

        counter.setStartdraw_root(1);
        counter.setEnddraw_root((int)counter.getHorizontal_scale()*counter.getRate_in_s()*2);


        counter.setEight_step_x((float) counter.getSurface_width()/(counter.getRate_in_s()*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/200);
        counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);

        Log.e("on resume.....",""+string1.getChannel_count());

        counter.setCount_of_set_i_channel(0);
        counter.setCount_of_set_j_channel(0);



        counter.setActivity_on_load(true);

        pivote50 = 50;
        pivote100 = 100;
        pivote_50 = -50;
        pivote_100 = -100;

        row_100.setText("-100µV");
        row100.setText("100µV");
        row50.setText("50µV");
        row_50.setText("-50µV");


        counter.setChannel_load(0);


        try {
            counter.setSeconds_count0_root(0);
            counter.setSeconds_count1000_root(counter.getSeconds_count0_root()+(1 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count2000_root(counter.getSeconds_count0_root()+(2 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count3000_root(counter.getSeconds_count0_root()+(3 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count4000_root(counter.getSeconds_count0_root()+(4 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count5000_root(counter.getSeconds_count0_root()+(5 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count6000_root(counter.getSeconds_count0_root()+(6 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count7000_root(counter.getSeconds_count0_root()+(7 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count8000_root(counter.getSeconds_count0_root()+(8 *  counter.getHorizontal_scale() / 8));

            counter.setSeconds_count0_root(0);
            counter.setSeconds_count1000_record(counter.getSeconds_count0_record()+(1 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count2000_record(counter.getSeconds_count0_record()+(2 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count3000_record(counter.getSeconds_count0_record()+(3 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count4000_record(counter.getSeconds_count0_record()+(4 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count5000_record(counter.getSeconds_count0_record()+(5 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count6000_record(counter.getSeconds_count0_record()+(6 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count7000_record(counter.getSeconds_count0_record()+(7 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count8000_record(counter.getSeconds_count0_record()+(8 *  counter.getHorizontal_scale() / 8));




            EightRootActivity.getV0().setText((int)counter.getSeconds_count0_root()+"s");
            EightRootActivity.getV1000().setText((int)counter.getSeconds_count1000_root()+"s");
            EightRootActivity.getV2000().setText((int)counter.getSeconds_count2000_root()+"s");
            EightRootActivity.getV3000().setText((int)counter.getSeconds_count3000_root()+"s");
            EightRootActivity.getV4000().setText((int)counter.getSeconds_count4000_root()+"s");
            EightRootActivity.getV5000().setText((int)counter.getSeconds_count5000_root()+"s");
            EightRootActivity.getV6000().setText((int)counter.getSeconds_count6000_root()+"s");
            EightRootActivity.getV7000().setText((int)counter.getSeconds_count7000_root()+"s");
            EightRootActivity.getV8000().setText((int)counter.getSeconds_count8000_root()+"s");





            EightRecordActivity.getV0().setText(counter.getSeconds_count0_record()+"s");
            EightRecordActivity.getV1000().setText(counter.getSeconds_count1000_record()+"s");
            EightRecordActivity.getV2000().setText(counter.getSeconds_count2000_record()+"s");
            EightRecordActivity.getV3000().setText(counter.getSeconds_count3000_record()+"s");
            EightRecordActivity.getV4000().setText(counter.getSeconds_count4000_record()+"s");
            EightRecordActivity.getV5000().setText(counter.getSeconds_count5000_record()+"s");
            EightRecordActivity.getV6000().setText(counter.getSeconds_count6000_record()+"s");
            EightRecordActivity.getV7000().setText(counter.getSeconds_count7000_record()+"s");
            EightRecordActivity.getV8000().setText(counter.getSeconds_count8000_record()+"s");










        }
        catch (NullPointerException e){
            e.printStackTrace();
        }



        if (counter.getHorizontal_scale() < 8) {

            EightRootActivity.getV1000().setVisibility(View.INVISIBLE);
            EightRootActivity.getV3000().setVisibility(View.INVISIBLE);
            EightRootActivity.getV5000().setVisibility(View.INVISIBLE);
            EightRootActivity.getV7000().setVisibility(View.INVISIBLE);


        } else {

            EightRootActivity.getV1000().setVisibility(View.VISIBLE);
            EightRootActivity.getV3000().setVisibility(View.VISIBLE);
            EightRootActivity.getV5000().setVisibility(View.VISIBLE);
            EightRootActivity.getV7000().setVisibility(View.VISIBLE);


        }

        animatorSet = new AnimatorSet();
        lineplay.setTranslationX(0);

        if (string1.getChannel_count()>=32){

            animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-10);

        }
        else {
            animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-95);

        }

        animatorX.setDuration(counter.getRate_in_s()*2*(int)counter.getHorizontal_scale());
        animatorSet.playTogether(animatorX);

        play.setBackgroundResource(R.drawable.play_foreground);
        playcount=0;
        set_stop_play=1;
        is_change_text=0;
        //lineplay.setVisibility(View.INVISIBLE);



        if (string1.getChannel_count()==8)
        {



        }
        if (string1.getChannel_count()>16)
        {
            findViewById(R.id.left_linearlayout).setVisibility(View.GONE);
            findViewById(R.id.textview0).setVisibility(View.GONE);





        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (set_dimens) {
                    if (counter.getSurfaceviewheheight()>0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int paint_screen=counter.getSurfaceviewheheight();
                                float button_step = (float) paint_screen / ((counter.getDefault_channel()) * 2);
                                int k=counter.getDefault_channel();


                                for (int o=0;o<counter.getDefault_channel();o++){
                                    Log.e(""+(float) (((2*o)+1) * button_step),""+(float) (((2*o)+1) * button_step));
                                    ch[o+1].setTranslationY((float) (((2*o)+0.5) * button_step));
                                }
                                for (int o=counter.getDefault_channel();o<64;o++){
                                    ch[o+1].setTranslationY(1000+paint_screen);
                                }
                                for (int s=1;s<65;s++)
                                {
                                    if (k>12)
                                        ch[s].setScaleY((float) 1-((float) 1.25*k/100));
                                    ch[s].setScaleX((float) 1-((float)1.25*k/100));


                                }



                            }
                        });
                        set_dimens=false;
                    }
                }
            }

        }).start();
        counter.setEightRecord_ispause(false);
        for (int i=0;i<counter.getHorizontal_scale();i++) {
            for (int j=0;j<16000;j++) {
               counter.setBuffer(counter.getPart_data(),i,j);
            }
        }







    }



    public void restchannel(){
        for (int i=0;i<32;i++) {
            for (int j=0;j<800_000;j++) {
                counter.setChannel((float) 1000.0,i,j);
            }
        }
    }

    @Override
    protected void onPause()
    {


        super.onPause();
        counter.setActivity_on_load(false);
        counter.setLoadfor(false);


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eightroot);



ch[1]=findViewById(R.id.axis_textview_1);

        ch[2]=findViewById(R.id.axis_textview_2);
        ch[3]=findViewById(R.id.axis_textview_3);
        ch[4]=findViewById(R.id.axis_textview_4);
        ch[5]=findViewById(R.id.axis_textview_5);
        ch[6]=findViewById(R.id.axis_textview_6);
        ch[7]=findViewById(R.id.axis_textview_7);
        ch[8]=findViewById(R.id.axis_textview_8);
        ch[9]=findViewById(R.id.axis_textview_9);
        ch[10]=findViewById(R.id.axis_textview_10);
        ch[11]=findViewById(R.id.axis_textview_11);
        ch[12]=findViewById(R.id.axis_textview_12);
        ch[13]=findViewById(R.id.axis_textview_13);
        ch[14]=findViewById(R.id.axis_textview_14);
        ch[15]=findViewById(R.id.axis_textview_15);
        ch[16]=findViewById(R.id.axis_textview_16);
        ch[17]=findViewById(R.id.axis_textview_17);
        ch[18]=findViewById(R.id.axis_textview_18);
        ch[19]=findViewById(R.id.axis_textview_19);
        ch[20]=findViewById(R.id.axis_textview_20);
        ch[21]=findViewById(R.id.axis_textview_21);
        ch[22]=findViewById(R.id.axis_textview_22);
        ch[23]=findViewById(R.id.axis_textview_23);
        ch[24]=findViewById(R.id.axis_textview_24);
        ch[25]=findViewById(R.id.axis_textview_25);
        ch[26]=findViewById(R.id.axis_textview_26);
        ch[27]=findViewById(R.id.axis_textview_27);
        ch[28]=findViewById(R.id.axis_textview_28);
        ch[29]=findViewById(R.id.axis_textview_29);
        ch[30]=findViewById(R.id.axis_textview_30);
        ch[31]=findViewById(R.id.axis_textview_31);
        ch[32]=findViewById(R.id.axis_textview_32);
        ch[33]=findViewById(R.id.axis_textview_33);
        ch[34]=findViewById(R.id.axis_textview_34);
        ch[35]=findViewById(R.id.axis_textview_35);
        ch[36]=findViewById(R.id.axis_textview_36);
        ch[37]=findViewById(R.id.axis_textview_37);
        ch[38]=findViewById(R.id.axis_textview_38);
        ch[39]=findViewById(R.id.axis_textview_39);
        ch[40]=findViewById(R.id.axis_textview_40);
        ch[41]=findViewById(R.id.axis_textview_41);
        ch[42]=findViewById(R.id.axis_textview_42);
        ch[43]=findViewById(R.id.axis_textview_43);
        ch[44]=findViewById(R.id.axis_textview_44);
        ch[45]=findViewById(R.id.axis_textview_45);
        ch[46]=findViewById(R.id.axis_textview_46);
        ch[47]=findViewById(R.id.axis_textview_47);
        ch[48]=findViewById(R.id.axis_textview_48);
        ch[49]=findViewById(R.id.axis_textview_49);
        ch[50]=findViewById(R.id.axis_textview_50);
        ch[51]=findViewById(R.id.axis_textview_51);
        ch[52]=findViewById(R.id.axis_textview_52);
        ch[53]=findViewById(R.id.axis_textview_53);
        ch[54]=findViewById(R.id.axis_textview_54);
        ch[55]=findViewById(R.id.axis_textview_55);
        ch[56]=findViewById(R.id.axis_textview_56);
        ch[57]=findViewById(R.id.axis_textview_57);
        ch[58]=findViewById(R.id.axis_textview_58);
        ch[59]=findViewById(R.id.axis_textview_59);
        ch[60]=findViewById(R.id.axis_textview_60);
        ch[61]=findViewById(R.id.axis_textview_61);
        ch[62]=findViewById(R.id.axis_textview_62);
        ch[63]=findViewById(R.id.axis_textview_63);
        ch[64]=findViewById(R.id.axis_textview_64);




        Display display=getWindowManager().getDefaultDisplay();
        Point size =new Point();
        display.getSize(size);
        int width=size.x;
        int height =size.y;
        string1=new String1();
        counter=new Counter();

        counter.setExist_in_secound(0);

        counter.setCount_of_set_i_channel(0);
        counter.setCount_of_set_j_channel(0);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


string1.setSview("eight");

counter.setLine_stop_counter(0);
counter.setLoop_counter(1);
counter.setRecordcount(1);
for (int t=0;t<40;t++){
    counter.setStop_line(10000,t);
}

        counter.setSurface_height(height);
        counter.setSurface_width(width);


        Log.e("Screen width",""+width);
        Log.e("Screen height",""+height);


        choiceDialog=new Dialog(EightRootActivity.this);
        choiceDialog.setContentView(R.layout.choice_dialog);
        choiceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        activity=this;
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        notchcount=0;
        playcount=0;

        dialog=new Dialog(EightRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        FindViewById();








        animatorSet = new AnimatorSet();
        lineplay.setTranslationX(0);
        lineplay.setVisibility(View.INVISIBLE);




        if (string1.getChannel_count()>31){

            animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-10);

        }
        else {
            animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-95);

        }
        animatorX.setDuration(counter.getRate_in_s()*2*(int)counter.getHorizontal_scale());
        animatorSet.playTogether(animatorX);








        textplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);



                if (text_play==0){
                    textplay.setText("×2");
                    text_play=1;
                    play_text = (float) 0.5;
/*
                    animatorSet.end();
                    animatorSet.removeAllListeners();
                    animatorSet.removeListener(animatorListener);
                    animatorX.setDuration(500*counter.getHorizontal_scale());
                    play.setBackgroundResource(R.drawable.pause_root_foreground);
                    lineplay.setVisibility(View.VISIBLE);
                    animatorSet.start();

 */

                }
                else if (text_play==1){
                    textplay.setText("×0.5");
                    text_play=2;
                    play_text=2;
/*
                    animatorSet.end();
                    animatorSet.removeAllListeners();
                    animatorSet.removeListener(animatorListener);
                    animatorX.setDuration(2000*counter.getHorizontal_scale());

                    play.setBackgroundResource(R.drawable.pause_root_foreground);

                    lineplay.setVisibility(View.VISIBLE);
                    animatorSet.start();


 */
                }
                else if (text_play==2){
                    textplay.setText("×1");
                    text_play=0;
                    play_text=1;
/*
                    animatorSet.end();
                    animatorSet.removeAllListeners();
                    animatorSet.removeListener(animatorListener);
                    animatorX.setDuration(1000*counter.getHorizontal_scale());

                    play.setBackgroundResource(R.drawable.pause_root_foreground);

                    lineplay.setVisibility(View.VISIBLE);
                    animatorSet.start();


 */

                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (playcount==1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                play.setBackgroundResource(R.drawable.play_foreground);

                                set_stop_play = 1;
                                acces_to_paly_animation = 0;
                                lineplay.setVisibility(View.INVISIBLE);
                                lineplay.setTranslationX(0);
                                is_change_text = 0;
                                animatorSet.end();
                                animatorSet.removeAllListeners();
                                animatorSet.removeListener(animatorListener);


                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }


                                play.setBackgroundResource(R.drawable.pause_root_foreground);
                                playcount = 1;
                                set_stop_play = 0;
                                acces_to_paly_animation = 1;
                                lineplay.setTranslationX(0);
                                lineplay.setVisibility(View.VISIBLE);
                                Setlinebtnanim();


                            }
                        });

                    }
                }
                }
                ).start();



            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!counter.isB_touch()){
                if (playcount == 0) {
                    play.setBackgroundResource(R.drawable.pause_root_foreground);
                    playcount = 1;
                    set_stop_play = 0;
                    acces_to_paly_animation = 1;
                    lineplay.setTranslationX(0);
                    lineplay.setVisibility(View.VISIBLE);
                    Setlinebtnanim();

                }
                else if (playcount == 1) {
                    play.setBackgroundResource(R.drawable.play_foreground);
                    playcount = 0;
                    set_stop_play = 1;
                    acces_to_paly_animation = 0;
                    lineplay.setVisibility(View.INVISIBLE);
                    lineplay.setTranslationX(0);
                    is_change_text = 0;
                    animatorSet.end();
                    animatorSet.removeAllListeners();
                    animatorSet.removeListener(animatorListener);


                }
                }

            }});

        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListView =  choiceDialog.findViewById(R.id.choice_list_view);
                ArrayList<String> myStringArray1 = new ArrayList<String>();




                myStringArray1.add("Mono");
                myStringArray1.add("Banana");

                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, myStringArray1);
                myListView.setAdapter(adapter);
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        montage.setText(myStringArray1.get(i));
                        choiceDialog.dismiss();
                        //  myStringArray1.clear();


                    }
                });

                // dialog1.show();



            }
        });


        choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myListView =  choiceDialog.findViewById(R.id.choice_list_view);
                ArrayList<String> myStringArray1 = new ArrayList<String>();


for (int t=0 ; t<counter.getDefault_channel();t++){
    myStringArray1.add(string1.getPivote(t));
}




                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, myStringArray1);
                myListView.setAdapter(adapter);






                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        choise.setText(myStringArray1.get(i));

                        surface.startDrawThread(i);

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        choiceDialog.dismiss();
                                    }
                                });

                            }
                        }).start();

                        // myStringArray1.clear();


                    }
                });


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                choiceDialog.show();
                            }
                        });
                    }
                }).start();

//////////////
            }
        });


        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!single_root) {



                        findViewById(R.id.left_linearlayout_singlere).setVisibility(View.VISIBLE);
                        findViewById(R.id.left_linearlayout).setVisibility(View.GONE);
                    if (k) {


                        k=false;
                    }

                    counter.setLine_clecked(0);
                    choise.setVisibility(View.VISIBLE);
                    line.setBackgroundResource(R.drawable.one_line_foreground);
                    single_root=true;
                    zoomin_single.setVisibility(View.VISIBLE);
                    zoomout_single.setVisibility(View.VISIBLE);

                    zoomin_eight.setVisibility(View.GONE);
                    zoomout_eight.setVisibility(View.GONE);
                    string1.setSview(string1.getSsingle());

                }
                else {
                    findViewById(R.id.left_linearlayout_singlere).setVisibility(View.GONE);
                    findViewById(R.id.left_linearlayout).setVisibility(View.VISIBLE);

                    line.setBackgroundResource(R.drawable.multi_line_foreground);
                   choise.setVisibility(View.INVISIBLE);
                    single_root=false;

                    zoomin_single.setVisibility(View.GONE);
                    zoomout_single.setVisibility(View.GONE);

                    zoomin_eight.setVisibility(View.VISIBLE);
                    zoomout_eight.setVisibility(View.VISIBLE);
                    string1.setSview(string1.getSeight());


                }


                Log.e("set to","0");
                //Intent intent=new Intent(getApplicationContext(),SingleRootActivity.class);
                //startActivity(intent);
                //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                vibrator.vibrate(70);


              //  finish();

            }
        });
        DrawerLayout drawerLayout=findViewById(R.id.draver_eightroot);
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (bnote) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                else {

                }


            }
        });

        zoomout_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    vibrator.vibrate(40);
                    counter.setEight_step_y((float) ((float) (counter.getEight_step_y() -(string1.getChannel_count()*(counter.getEight_step_y()/100)))));

            }

        });
        zoomin_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);
                    counter.setEight_step_y((float) (counter.getEight_step_y() +(string1.getChannel_count()*(counter.getEight_step_y()/50))));


            }




        });





        zoomout_single.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                if(counter.getEight_step_y()>0) {
                    counter.setSingle_step_y((float) (counter.getSingle_step_y() / (1.1)));
                    pivote_50 = (float) (pivote_50 * 1.1);
                    pivote_100 = (float) (pivote_100 * 1.1);
                    pivote50 = (float) (pivote50 * 1.1);
                    pivote100 = (float) (pivote100 * 1.1);


                    row50.setText( (int) (pivote50)+"µV");
                    row100.setText((int) (pivote100)+"µV");
                    row_50.setText ((int) (pivote_50)+"µV");
                    row_100.setText( (int) (pivote_100)+"µV");


                    vibrator.vibrate(40);

                }






            }
        });
        zoomin_single.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(pivote50>3) {
                    counter.setSingle_step_y((float) (counter.getSingle_step_y() * (1.1)));

                    pivote50 = (float) (pivote50 / 1.1);
                    pivote100 = (float) (pivote100 / 1.1);
                    pivote_100 = (float) (pivote_100 / 1.1);
                    pivote_50 = (float) (pivote_50 / 1.1);


                    row50.setText ((int) (pivote50)+"µV");
                    row100.setText((int) (pivote100)+"µV");
                    row_50.setText((int) (pivote_50)+"µV");
                    row_100.setText((int) (pivote_100)+"µV");

                    vibrator.vibrate(40);





                }

            }
        });










        notch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                vibrator.vibrate(40);

                if(!b_notch) {
                    notch.setBackgroundResource(R.drawable.notch_on);
                   b_notch=true;
                }
                else {
                    notch.setBackgroundResource(R.drawable.notch_off);
                    b_notch=false;


                }

            }
        });
counter.setB_touch(false);
    crop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play.setBackgroundResource(R.drawable.play_foreground);
            playcount = 0;
            set_stop_play = 1;
            acces_to_paly_animation = 0;
            lineplay.setVisibility(View.INVISIBLE);
            lineplay.setTranslationX(0);
            is_change_text = 0;
            animatorSet.end();
            animatorSet.removeAllListeners();
            animatorSet.removeListener(animatorListener);

            vibrator.vibrate(40);
            if (!counter.isB_touch()){

                counter.setStartdraw_root_clone(counter.getStartdraw_root());
                counter.setEnddraw_root_clone(counter.getEnddraw_root());
                counter.setSeconds_count0_root_clone(counter.getSeconds_count0_root());

                counter.setSingle_step_x_clone(counter.getSingle_step_x());
                counter.setEight_step_x_clone(counter.getEight_step_x());

                counter.setHorizontal_scale_clone(counter.getHorizontal_scale());

                bnote=false;

                counter.setB_touch(true);

                crop.setBackgroundResource(R.drawable.crop_on_foreground);
                textplay.setVisibility(View.INVISIBLE);
                play.setBackgroundResource(R.drawable.play_disable_foreground);
                note.setBackgroundResource(R.drawable.note_off_foreground);


            }
            else {

                counter.setB_touch(false);
                crop.setBackgroundResource(R.drawable.crop_off_foreground);
                textplay.setVisibility(View.VISIBLE);
                play.setBackgroundResource(R.drawable.play_foreground);

                note.setBackgroundResource(R.drawable.notes_foreground);


                bnote=true;





                counter.setStartdraw_root(counter.getStartdraw_root_clone());
                counter.setEnddraw_root(counter.getEnddraw_root_clone());
                counter.setSeconds_count0_root(counter.getSeconds_count0_root_clone());

                counter.setSingle_step_x(counter.getSingle_step_x_clone());
                counter.setEight_step_x(counter.getEight_step_x_clone());


                counter.setHorizontal_scale((int)counter.getHorizontal_scale_clone());





                counter.setSeconds_count1000_root((int)counter.getSeconds_count0_root()+(1 * counter.getHorizontal_scale() / 8));
                counter.setSeconds_count2000_root((int)counter.getSeconds_count0_root()+(2 *  counter.getHorizontal_scale() / 8));
                counter.setSeconds_count3000_root((int)counter.getSeconds_count0_root()+(3 *  counter.getHorizontal_scale() / 8));
                counter.setSeconds_count4000_root((int)counter.getSeconds_count0_root()+(4 *  counter.getHorizontal_scale() / 8));
                counter.setSeconds_count5000_root((int)counter.getSeconds_count0_root()+(5 *  counter.getHorizontal_scale() / 8));
                counter.setSeconds_count6000_root((int)counter.getSeconds_count0_root()+(6 *  counter.getHorizontal_scale() / 8));
                counter.setSeconds_count7000_root((int)counter.getSeconds_count0_root()+(7 * counter.getHorizontal_scale() / 8));
                counter.setSeconds_count8000_root((int)counter.getSeconds_count0_root()+(8 *  counter.getHorizontal_scale() / 8));

                EightRootActivity.getV0().setText((int) counter.getSeconds_count0_root()+"s");
                EightRootActivity.getV1000().setText((int)counter.getSeconds_count1000_root()+"s");
                EightRootActivity.getV2000().setText((int)counter.getSeconds_count2000_root()+"s");
                EightRootActivity.getV3000().setText((int)counter.getSeconds_count3000_root()+"s");
                EightRootActivity.getV4000().setText((int)counter.getSeconds_count4000_root()+"s");
                EightRootActivity.getV5000().setText((int)counter.getSeconds_count5000_root()+"s");
                EightRootActivity.getV6000().setText((int)counter.getSeconds_count6000_root()+"s");
                EightRootActivity.getV7000().setText((int)counter.getSeconds_count7000_root()+"s");
                EightRootActivity.getV8000().setText((int)counter.getSeconds_count8000_root()+"s");



              EightRootActivity.getV0().setVisibility(View.VISIBLE);
                EightRootActivity.getV2000().setVisibility(View.VISIBLE);
                EightRootActivity.getV4000().setVisibility(View.VISIBLE);
                EightRootActivity.getV6000().setVisibility(View.VISIBLE);
                EightRootActivity.getV8000().setVisibility(View.VISIBLE);

if (counter.getHorizontal_scale()>7){
     EightRootActivity.getV1000().setVisibility(View.VISIBLE);

     EightRootActivity.getV3000().setVisibility(View.VISIBLE);

     EightRootActivity.getV5000().setVisibility(View.VISIBLE);

      EightRootActivity.getV7000().setVisibility(View.VISIBLE);

}


            }




        }
    });

    /////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////
/*
        graphView9 = findViewById(R.id.eightgraphview9);

        LineGraphSeries<DataPoint> series9 = new LineGraphSeries<DataPoint>(new DataPoint[]{});


        graphView9.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graphView9.getGridLabelRenderer().setGridStyle( GridLabelRenderer.GridStyle.HORIZONTAL);
        graphView9.addSeries(series8);



        series9.setColor(Color.BLUE);
        series9.setDrawBackground(false);




 */
////////////////////////////////////////////////////////////////////////////////////////
      //  Log.e("is",""+string1.getLine_count());

new Thread(new Runnable() {
    @Override
    public void run() {
if(counter.getLine_clecked()==2) {
 counter.setCount_of_set_i_channel(0);
    counter.setCount_of_set_j_channel(0);

    counter.setLoadfor(true);

   runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FileReader fileReader = new FileReader(getApplicationContext(),activity,string1, counter, pivotValue);
                    fileReader.read();

                    if (string1.getChannel_count()>31){

                        animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-10);

                    }
                    else {
                        animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-95);

                    }

                    animatorX.setDuration(counter.getRate_in_s()*2*(int)counter.getHorizontal_scale());
                    animatorSet.playTogether(animatorX);


                    if (string1.getChannel_count()==8)
                    {


                    }
                    else if (string1.getChannel_count()>16)
                    {
                        findViewById(R.id.left_linearlayout).setVisibility(View.GONE);
                        findViewById(R.id.textview0).setVisibility(View.GONE);




                    }
                   // ConnectGraphview drawGraphview1=new ConnectGraphview(graphView1,counter,string1);
                   // drawGraphview1.draw();
                }
            });



            //  Log.e("is", " 2");
        }



    }
}).start();






        invalidateOptionsMenu();

    }




    private void FindViewById() {
        surface = (BaseSurfaceEightRoot) findViewById(R.id.eightrootsurfaceview);
        line=findViewById(R.id.line_eightroot);
        textplay=findViewById(R.id.eighttextplay);
        play=findViewById(R.id.play_eightroot);
        note =findViewById(R.id.note_eightroot);
        notch=findViewById(R.id.notch_eightroot);
        montage=findViewById(R.id.montage_eightroot);
        listView=dialog.findViewById(R.id.list_device);
        crop =findViewById(R.id.crop_eightrecord);

        zoomout_eight=findViewById(R.id.zoomout_eightroot);
        zoomin_eight=findViewById(R.id.zoomin_eightroot);

        zoomout_single=findViewById(R.id.zoomout_singleroot);
        zoomin_single=findViewById(R.id.zoomin_singleroot);



        choise=findViewById( R.id.choise_channel_root);

        V0=findViewById(R.id.SM_0);
        V1000=findViewById(R.id.SM_1000);
        V2000=findViewById(R.id.SM_2000);
        V3000=findViewById(R.id.SM_3000);
        V4000=findViewById(R.id.SM_4000);
        V5000=findViewById(R.id.SM_5000);
        V6000=findViewById(R.id.SM_6000);
        V7000=findViewById(R.id.SM_7000);
        V8000=findViewById(R.id.SM_8000);


        row100=findViewById(R.id.VS100);
        row50=findViewById(R.id.VS50);
        row0=findViewById(R.id.VS0);
        row_50=findViewById(R.id.VS_50);
        row_100=findViewById(R.id.VS_100);



        lineplay=findViewById(R.id.eightroot_playline1);

        //graphView1=findViewById(R.id.eightgraphview1);
    }
    private void Setlinebtnanim(){
        lineplay.setVisibility(View.VISIBLE);

    new Thread(new Runnable() {
    @SuppressLint("SetTextI18n")
    @Override
    public void run() {
        float width;
        if (string1.getChannel_count()>31) {
            width = counter.getSurface_width();
        }
        else {
            width = counter.getSurfaceviewhewidth();
        }
        counter.setAnim_sleep((long) ((float) ( counter.getHorizontal_scale()*play_text*1000)/width));



        Log.e("llllllllllllll",""+counter.getAnim_sleep());

        float t =(float)(counter.getExist_in_secound())/(counter.getRate_in_s());
        float t1=counter.getSeconds_count8000_root();

        for (line_play = 0; line_play <= width; line_play++) {
            if (acces_to_paly_animation==0){
                lineplay.setTranslationX(0);
                break;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lineplay.setTranslationX(line_play);
                }
            });
            try {
                Thread.sleep(counter.getAnim_sleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

while (t>t1)
{
    Log.e(""+t,">"+t1);
    if (acces_to_paly_animation==0){
        lineplay.setTranslationX(0);

        break;
    }
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            counter.setStartdraw_record(counter.getStartdraw_record() + (counter.getRate_in_s() * (int)counter.getHorizontal_scale()));
            counter.setEnddraw_record(counter.getEnddraw_record() + (counter.getRate_in_s() * (int)counter.getHorizontal_scale()));


            counter.setStartdraw_root(counter.getStartdraw_root() + (counter.getRate_in_s() *(int) counter.getHorizontal_scale()));
            counter.setEnddraw_root(counter.getEnddraw_root() + (counter.getRate_in_s() * (int)counter.getHorizontal_scale()));


            counter.setSeconds_count0_root(counter.getSeconds_count0_root()+ counter.getHorizontal_scale());
            EightRootActivity.getV0().setText((int)counter.getSeconds_count0_root()+"s");



            counter.setSeconds_count1000_root(counter.getSeconds_count1000_root()+ counter.getHorizontal_scale());
            EightRootActivity.getV1000().setText((int)counter.getSeconds_count1000_root()+"s");


            counter.setSeconds_count2000_root(counter.getSeconds_count2000_root()+ counter.getHorizontal_scale());
            EightRootActivity.getV2000().setText((int)counter.getSeconds_count2000_root()+"s");


            counter.setSeconds_count3000_root(counter.getSeconds_count3000_root()+  counter.getHorizontal_scale());
            EightRootActivity.getV3000().setText((int)counter.getSeconds_count3000_root()+"s");


            counter.setSeconds_count4000_root(counter.getSeconds_count4000_root()+ counter.getHorizontal_scale());
            EightRootActivity.getV4000().setText((int)counter.getSeconds_count4000_root()+"s");


            counter.setSeconds_count5000_root(counter.getSeconds_count5000_root()+  counter.getHorizontal_scale());
            EightRootActivity.getV5000().setText((int)counter.getSeconds_count5000_root()+"s");


            counter.setSeconds_count6000_root(counter.getSeconds_count6000_root()+  counter.getHorizontal_scale());
            EightRootActivity.getV6000().setText((int)counter.getSeconds_count6000_root()+"s");


            counter.setSeconds_count7000_root(counter.getSeconds_count7000_root()+  counter.getHorizontal_scale());
            EightRootActivity.getV7000().setText((int)counter.getSeconds_count7000_root()+"s");


            counter.setSeconds_count8000_root(counter.getSeconds_count8000_root()+  counter.getHorizontal_scale());
            EightRootActivity.getV8000().setText((int)counter.getSeconds_count8000_root()+"s");


        }
    });


    for (line_play = 0; line_play < width; line_play++) {
        if (acces_to_paly_animation==0){
            lineplay.setTranslationX(0);

            break;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lineplay.setTranslationX(line_play);
            }
        });
        try {

            Thread.sleep(counter.getAnim_sleep());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    t1=counter.getSeconds_count8000_root();


}
        lineplay.setTranslationX(0);
        play.setBackgroundResource(R.drawable.play_foreground);
        playcount=0;
        set_stop_play=1;
        is_change_text=0;
        lineplay.setVisibility(View.INVISIBLE);


    }
}).start();



    }




    }

