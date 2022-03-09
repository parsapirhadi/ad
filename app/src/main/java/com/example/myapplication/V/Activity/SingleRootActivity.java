package com.example.myapplication.V.Activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.V.BaseSurfaceSingleRoot;
import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;

import java.util.Set;

public class SingleRootActivity extends AppCompatActivity {

int set_stop_play=0;

int check_non_two_end=0;

    ListView listView;
    Set<BluetoothDevice> pared;
    Dialog dialog;
    TextView textplay,row100,row50,row_100,row_50,row0;
    ImageView notch;
   static TextView V0,V1000,V2000,V3000,V4000,V5000,V6000,V7000,V8000;
    String1 string1;
    GraphView graphView;
    Button line,btn,montage,zoomout,play,choose_channel,zoomin,lineplay;


    Animator.AnimatorListener animatorListener;

    int is_change_text=0;
    int acces_to_paly_animation =0;

    float play_text = (float) 1.0;



    Counter counter;

    float [] f= new float[8];

    private BaseSurfaceSingleRoot surface;

    ObjectAnimator animatorX;
    AnimatorSet animatorSet;
    int notchcount;
    int playcount;
    int text_play=0;


    int line_play=0;


    float pivote50=50;
    float pivote100=100;
     float pivote_50=-50;
    float pivote_100=-100;


    float d=2;



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



    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume()
    {


        super.onResume();
        surface.startDrawThread(0);

        counter.setStartdraw_record(1);
        counter.setEnddraw_record((int)counter.getHorizontal_scale()*1000);

        counter.setSingle_step_x((float) counter.getSurface_width()/(500*counter.getHorizontal_scale()));
        counter.setSingle_step_y((float) counter.getSurface_height()/200);

        Log.e("on resume.....",""+counter.getHorizontal_scale());

        V0.setText(""+0);
        V1000.setText(""+(float)(int)((125*counter.getHorizontal_scale()))/1000);
        V2000.setText(""+(float)(int)((2*125*counter.getHorizontal_scale()))/1000);
        V3000.setText(""+(float)(int)((3*125*counter.getHorizontal_scale()))/1000);
        V4000.setText(""+(float)(int)((4*125*counter.getHorizontal_scale()))/1000);
        V5000.setText(""+(float)(int)((5*125*counter.getHorizontal_scale()))/1000);
        V6000.setText(""+(float)(int)((6*125*counter.getHorizontal_scale()))/1000);
        V7000.setText(""+(float)(int)((7*125*counter.getHorizontal_scale()))/1000);
        V8000.setText(""+(float)(int)((8*125*counter.getHorizontal_scale()))/1000);




        animatorSet = new AnimatorSet();
        lineplay.setTranslationX(0);
        animatorX = ObjectAnimator.ofFloat(lineplay, "x", counter.getSurface_width()-10);
        animatorX.setDuration(1000*(int)counter.getHorizontal_scale());
        animatorSet.playTogether(animatorX);

        play.setBackgroundResource(R.drawable.play_foreground);
        playcount=0;
        set_stop_play=1;
        is_change_text=0;
        lineplay.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void onPause()
    {

        animatorSet.end();
        animatorSet.removeAllListeners();
        animatorSet.removeListener(animatorListener);
        lineplay.setTranslationX(0);
        surface.stopDrawThread();
        super.onPause();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleroot);
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        surface = (BaseSurfaceSingleRoot) findViewById(R.id.singlesurfaceview);
        string1=new String1();
        counter=new Counter();
       Intent intent=getIntent();
      Log.e("{}LHFSZBNWN",""+string1.getLine_count());

        notchcount=0;
        playcount=0;
        dialog=new Dialog(SingleRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        FindViewById();

        lineplay.setVisibility(View.INVISIBLE);

     listView=dialog.findViewById(R.id.list_device);
        choose_channel.setText(string1.getPivote(0));


        counter.setSingle_step_x((float) counter.getSurface_width()/((500)*counter.getHorizontal_scale()));
        counter.setSingle_step_y((float) counter.getSurface_height()/200);

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

                play.setBackgroundResource(R.drawable.play_foreground);
                playcount=0;
                set_stop_play=1;
                acces_to_paly_animation=0;
                lineplay.setVisibility(View.INVISIBLE);
                lineplay.setTranslationX(0);
                is_change_text=0;
                lineplay.setTranslationX(0);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(playcount==0) {
                    play.setBackgroundResource(R.drawable.pause_root_foreground);
                    playcount=1;
                    set_stop_play=0;
                    acces_to_paly_animation=1;
                    lineplay.setTranslationX(0);
                    lineplay.setVisibility(View.VISIBLE);
                    Setlinebtnanim();
                }
                else if(playcount==1) {
                    play.setBackgroundResource(R.drawable.play_foreground);
                    playcount=0;
                    set_stop_play=1;
                    acces_to_paly_animation=0;
                    lineplay.setVisibility(View.INVISIBLE);
                    lineplay.setTranslationX(0);
                    is_change_text=0;
                    animatorSet.end();
                    animatorSet.removeAllListeners();
                    animatorSet.removeListener(animatorListener);


                }





            }});


        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SingleRootActivity.this,montage);
                popup.getMenuInflater().inflate(R.menu.montage, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        montage.setText(menuItem.getTitle());

                        return true;
                    }
                });
                popup.show();


            }
        });
        notch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notchcount==0) {
                   // notch.setBackgroundResource(R.mipmap.notch_);
                    notchcount=1;
                }
                else if(notchcount==1) {
                  //  notch.setBackgroundResource(R.mipmap.notch_off_);
                    notchcount=0;

                }
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setCount_of_set_i_channel(0);
                counter.setCount_of_set_j_channel(0);

                Intent intent1=new Intent(getApplicationContext(),EightRootActivity.class);
                startActivity(intent1);

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                counter.setLine_clecked(1);
                vibrator.vibrate(70);
                finish();

            }
        });

        DrawerLayout drawerLayout=findViewById(R.id.draver_singleroot);

        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        choose_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SingleRootActivity.this,choose_channel);
                popup.getMenuInflater().inflate(R.menu.choose_channel, popup.getMenu());
                for(int v=0;v<string1.getChannel_count();v++) {
                     popup.getMenu().add(string1.getPivote(v));



                   // Log.e("&&&&&&&", "" + string1.getPivote(v));


                }
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                        for(int v=0;v<string1.getChannel_count();v++) {
                         if(menuItem.getTitle()==string1.getPivote(v)){
                             surface.startDrawThread(v);

                         }
                        }
                        choose_channel.setText(menuItem.getTitle());

                       return true;
                    }
                });
                popup.show();

            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                if(counter.getEight_step_y()>0) {
                    counter.setSingle_step_y((float) (counter.getSingle_step_y() / (1.1)));
                    pivote_50 = (float) (pivote_50 * 1.1);
                    pivote_100 = (float) (pivote_100 * 1.1);
                    pivote50 = (float) (pivote50 * 1.1);
                    pivote100 = (float) (pivote100 * 1.1);


                    row50.setText("" + (int) (pivote50));
                    row100.setText("" + (int) (pivote100));
                    row_50.setText("" + (int) (pivote_50));
                    row_100.setText("" + (int) (pivote_100));


                    vibrator.vibrate(40);

                }






            }
        });
        zoomin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(Float.parseFloat(row50.getText().toString())>3) {
                    counter.setSingle_step_y((float) (counter.getSingle_step_y() * (1.1)));

                    pivote50 = (float) (pivote50 / 1.1);
                    pivote100 = (float) (pivote100 / 1.1);
                    pivote_100 = (float) (pivote_100 / 1.1);
                    pivote_50 = (float) (pivote_50 / 1.1);


                    row50.setText("" + (int) (pivote50));
                    row100.setText("" + (int) (pivote100));
                    row_50.setText("" + (int) (pivote_50));
                    row_100.setText("" + (int) (pivote_100));

vibrator.vibrate(40);


                }

            }
        });




//////////////////////////////////////////////////////////////////////////////////////////////




///////////////////////////////////////////////////////////////////////////////////////////////////




    }

    private void FindViewById() {

        line=findViewById(R.id.line_singleroot);
        play=findViewById(R.id.plsy_singleroot);
        btn=findViewById(R.id.note_singleroot);
        textplay=findViewById(R.id.singletextplay);
        notch=findViewById(R.id.notch_singleroot);
        montage=findViewById(R.id.montage_singleroot);
        choose_channel=findViewById(R.id.choise_channel_root);
        zoomout=findViewById(R.id.zoomout_singleroot);
        zoomin=findViewById(R.id.zoomin_singleroot);

        row100=findViewById(R.id.VS100);
        row50=findViewById(R.id.VS50);
        row0=findViewById(R.id.VS0);
        row_50=findViewById(R.id.VS_50);
        row_100=findViewById(R.id.VS_100);

        lineplay=findViewById(R.id.singleroot_playline);

        V0=findViewById(R.id.SS_0);
        V1000=findViewById(R.id.SS_1000);
        V2000=findViewById(R.id.SS_2000);
        V3000=findViewById(R.id.SS_3000);
        V4000=findViewById(R.id.SS_4000);
        V5000=findViewById(R.id.SS_5000);
        V6000=findViewById(R.id.SS_6000);
        V7000=findViewById(R.id.SS_7000);
        V8000=findViewById(R.id.SS_8000);


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
                counter.setAnim_sleep((long) ((long) (( counter.getHorizontal_scale()*1000)/width)*play_text));



                float t =(float)(counter.getExist_in_secound()*2)/1000;
                float t1=Float.parseFloat(SingleRootActivity.getV8000().getText().toString());

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
                    if (acces_to_paly_animation==0){
                        lineplay.setTranslationX(0);

                        break;
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.setStartdraw_record(counter.getStartdraw_record() + (500 * (int)counter.getHorizontal_scale()));
                            counter.setEnddraw_record(counter.getEnddraw_record() + (500 *(int) counter.getHorizontal_scale()));

                            float z = Float.parseFloat(SingleRootActivity.getV0().getText().toString()) + (counter.getHorizontal_scale());
                            SingleRootActivity.getV0().setText("" + z);

                            SingleRootActivity.getV1000().setText("" + (z + (0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV2000().setText("" + (z + (2 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV3000().setText("" + (z + (3 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV4000().setText("" + (z + (4 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV5000().setText("" + (z + (5 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV6000().setText("" + (z + (6 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV7000().setText("" + (z + (7 * 0.125 * counter.getHorizontal_scale())));
                            SingleRootActivity.getV8000().setText("" + (z + (8 * 0.125 * counter.getHorizontal_scale())));

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




                    t1=Float.parseFloat(SingleRootActivity.getV8000().getText().toString());


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
