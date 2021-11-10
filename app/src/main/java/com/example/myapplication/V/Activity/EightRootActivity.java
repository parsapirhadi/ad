package com.example.myapplication.V.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.V.BaseSurfaceEight;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.P.SetPivotValue;
import com.example.myapplication.R;
import com.example.myapplication.V.ConnectGraphview;
import com.jjoe64.graphview.GraphView;

import java.io.BufferedReader;
import java.util.Set;

public class EightRootActivity extends AppCompatActivity {

    Button line,btn,bluetooth,montage,play,zoomout,zoomin;
    ImageView notch;
    TextView textplay;
    ListView listView;
    TextView pivote8000;
    Animation animation;
    Set<BluetoothDevice> pared;
    Dialog dialog;
   Button lineplay1,lineplay2,lineplay3,lineplay4;
    SetPivotName namePivote;
    SetPivotValue pivotValue;

    int acces_to_paly_animation =0;

    int acces_to_set_change =0;


    int set_stop_play =0;
    int one=0;

    ObjectAnimator animatorX3;
    AnimatorSet animatorSet,animatorSet1,animatorSet3,animatorSet2;

  static TextView V0,V1000,V2000,V3000,V4000,V5000,V6000,V7000,V8000;
    private BaseSurfaceEight surface;
    String1 string1;
    Counter counter;
    Vibrator vibrator;
    BufferedReader myReader;
    int g=0;

    int text_play=0;
    int notchcount;
    Activity activity;
    GraphView graphView1;
    int playcount;




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
        surface.startDrawThread(-1);
//        pivote8000.setText(counter.getHorizontal_scale()*1000+"");
        counter.setEight_step_x((float) counter.getSurface_width()/(500*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/200);
        counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);


        float z=Float.parseFloat(""+counter.getStartdraw())*2;
        V0.setText(""+z/1000);
        V1000.setText(""+(z+(125*counter.getHorizontal_scale()))/1000);
        V2000.setText(""+(z+(2*125*counter.getHorizontal_scale()))/1000);
        V3000.setText(""+(z+(3*125*counter.getHorizontal_scale()))/1000);
        V4000.setText(""+(z+(4*125*counter.getHorizontal_scale()))/1000);
        V5000.setText(""+(z+(5*125*counter.getHorizontal_scale()))/1000);
        V6000.setText(""+(z+(6*125*counter.getHorizontal_scale()))/1000);
        V7000.setText(""+(z+(7*125*counter.getHorizontal_scale()))/1000);
        V8000.setText(""+(z+(8*125*counter.getHorizontal_scale()))/1000);






        if (string1.getChannel_count()==8)
        {
            findViewById(R.id.layout_axis_textview_9).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_10).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_11).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_12).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_13).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_14).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_15).setVisibility(View.GONE);
            findViewById(R.id.layout_axis_textview_16).setVisibility(View.GONE);

        }
        if (string1.getChannel_count()>16)
        {

            findViewById(R.id.left_linearlayout).setVisibility(View.GONE);
            findViewById(R.id.textview0).setVisibility(View.GONE);


        }



    }

    public void restchannel(){
        for (int i=0;i<32;i++) {
            for (int j=0;j<800000;j++) {
                counter.setChannel((float) 1000.0,i,j);
            }
        }
    }

    @Override
    protected void onPause()
    {

        surface.stopDrawThread();
        super.onPause();
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






        Display display=getWindowManager().getDefaultDisplay();
        Point size =new Point();
        display.getSize(size);
        int width=size.x;
        int height =size.y;
        string1=new String1();
        counter=new Counter();



        counter.setSurface_height(height);
        counter.setSurface_width(width);


        Log.e("Screen width",""+width);
        Log.e("Screen height",""+height);




        LinearLayout linearLayout=findViewById(R.id.left_linearlayout);
        activity=this;
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        notchcount=0;
        playcount=0;

        dialog=new Dialog(EightRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        FindViewById();












        lineplay1.setTranslationX(-1*(width/2));
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(lineplay1, "x", width+(width/2));
        animatorX.setDuration(16000);
        animatorX.setRepeatCount(5);
        animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX);



        lineplay2.setTranslationX(-1*(width/2));
        ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(lineplay2, "x", width+(width/2));
        animatorX1.setDuration(16000);
        animatorX1.setRepeatCount(5);
        animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(animatorX1);


        ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(lineplay3, "x", width+(width));
        animatorX2.setDuration(16000);
        animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorX2);


        lineplay4.setTranslationX(-1*(counter.getSurface_width()/2));
        animatorX3 = ObjectAnimator.ofFloat(lineplay4, "x", counter.getSurface_width()+(counter.getSurface_width()/2)-200);
        animatorX3.setDuration(16000);
        animatorSet3 = new AnimatorSet();
        animatorX3.setRepeatCount(5);
        animatorSet3.playTogether(animatorX3);





        counter.setEight_step_x((float) counter.getSurface_width()/(500*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/200);
        counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);



        textplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);



                if (text_play==0){
                    textplay.setText("×2");
                    text_play=1;

                }
                else if (text_play==1){
                    textplay.setText("×0.5");
                    text_play=2;



                }
                else if (text_play==2){
                    textplay.setText("×1");
                    text_play=0;




                }


            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(playcount==0) {
                    lineplay1.setVisibility(View.VISIBLE);
                    lineplay2.setVisibility(View.VISIBLE);
                    lineplay3.setVisibility(View.VISIBLE);
                    lineplay4.setVisibility(View.VISIBLE);

                    play.setBackgroundResource(R.drawable.pause_root_foreground);
                    playcount=1;
                    set_stop_play=0;
                    acces_to_set_change=1;
                    Setlinebtnanim();
                    acces_to_paly_animation=1;




                }
                else if(playcount==1) {
                    play.setBackgroundResource(R.drawable.play_foreground);
                    playcount=0;
                    set_stop_play=1;
                    acces_to_set_change=0;
                    acces_to_paly_animation=0;



                        animatorX.start();
                        animatorX1.start();
                        animatorX2.start();
                        animatorX3.start();


                    animatorX.end();
                    animatorX1.end();
                    animatorX2.end();
                    animatorX3.end();



                }





            }});

        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(EightRootActivity.this,montage);
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
                    notch.setBackgroundResource(R.mipmap.notch_);
                    notchcount=1;
                }
               else if(notchcount==1) {
                    notch.setBackgroundResource(R.mipmap.notch_off_);
                    notchcount=0;

                }
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setLine_clecked(0);
                Log.e("set to","0");
                Intent intent=new Intent(getApplicationContext(),SingleRootActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                vibrator.vibrate(70);


                finish();

            }
        });
        DrawerLayout drawerLayout=findViewById(R.id.draver_eightroot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counter.getEight_step_y()>0) {
                    vibrator.vibrate(40);
                    counter.setEight_step_y((float) ((float) (counter.getEight_step_y() -(string1.getChannel_count()*(counter.getEight_step_y()/100)))));
                }
            }

        });
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);
                    counter.setEight_step_y((float) (counter.getEight_step_y() +(string1.getChannel_count()*(counter.getEight_step_y()/50))));

                    Toast.makeText(getApplicationContext(),"animatorX"+animatorX.isRunning(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"animatorX1"+animatorX1.isRunning(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"animatorX2"+animatorX2.isRunning(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"animatorX3"+animatorX3.isRunning(),Toast.LENGTH_LONG).show();


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

        //  FileReader fileReader = new FileReader(string1, counter, namePivote, pivotValue);
        //  fileReader.read();
        if (counter.getLine_clecked()==0){
            Log.e("is","0");
            // graphView1.removeAllSeries();
            //  ConnectGraphview drawGraphview=new ConnectGraphview(graphView1,counter,string1);
            // drawGraphview.draw();
        }
        else if (counter.getLine_clecked()==1 && string1.getLine_count()!=0){
            Intent intent1=getIntent();
            string1=new String1();
            // Log.e("ccccccccccccccccc",""+string1.getChannel_count());
            //Log.e("ccccccccccccccccc",""+string1.getChannel_count());
            // Log.e("ccccccccccccccccc",""+counter.getChannel(5,6));

            //  Log.e("is", " 1");



            // Log.e("is","null && 1");
            ConnectGraphview drawGraphview1=new ConnectGraphview(graphView1,counter,string1);
           // drawGraphview1.draw();
        }


        else if(counter.getLine_clecked()==2) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FileReader fileReader = new FileReader(activity,string1, counter, namePivote, pivotValue);
                    fileReader.read();





                    if (string1.getChannel_count()==8)
                    {

                        findViewById(R.id.layout_axis_textview_10).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_11).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_12).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_13).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_14).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_15).setVisibility(View.GONE);
                        findViewById(R.id.layout_axis_textview_16).setVisibility(View.GONE);

                    }
                    if (string1.getChannel_count()>16)
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
        surface = (BaseSurfaceEight) findViewById(R.id.eightsurfaceview);
        line=findViewById(R.id.line_eightroot);
        textplay=findViewById(R.id.eighttextplay);
        play=findViewById(R.id.plsy_eightroot);
        btn=findViewById(R.id.note_eightroot);
        notch=findViewById(R.id.notch_eightroot);
        montage=findViewById(R.id.montage_eightroot);
        listView=dialog.findViewById(R.id.list);
        zoomout=findViewById(R.id.zoomout_eightroot);
        zoomin=findViewById(R.id.zoomin_eightroot);

        V0=findViewById(R.id.SM_0);
        V1000=findViewById(R.id.SM_1000);
        V2000=findViewById(R.id.SM_2000);
        V3000=findViewById(R.id.SM_3000);
        V4000=findViewById(R.id.SM_4000);
        V5000=findViewById(R.id.SM_5000);
        V6000=findViewById(R.id.SM_6000);
        V7000=findViewById(R.id.SM_7000);
        V8000=findViewById(R.id.SM_8000);



        lineplay1=findViewById(R.id.eightroot_playline1);
        lineplay2=findViewById(R.id.eightroot_playline2);
        lineplay3=findViewById(R.id.eightroot_playline3);
        lineplay4=findViewById(R.id.eightroot_playline4);



        //graphView1=findViewById(R.id.eightgraphview1);
    }
    private void Setlinebtnanim(){

one=0;
lineplay1.setVisibility(View.VISIBLE);
        lineplay2.setVisibility(View.VISIBLE);
        lineplay3.setVisibility(View.VISIBLE);
        lineplay4.setVisibility(View.VISIBLE);




        acces_to_paly_animation=1;

        Thread btn1= new Thread(new Runnable() {
            @Override
            public void run() {
                if (acces_to_paly_animation==1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btn.setVisibility(View.VISIBLE);
                            animatorSet2.start();
                            Log.e("..............","btn1");

                        }
                    });
                }
            }
        });


        Thread btn2=new Thread(new Runnable() {
            @Override
            public void run() {
                if (acces_to_paly_animation==1) {

if (one==0) {
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    one=1;
}
else if (one==1){
    try {
        Thread.sleep(2);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (acces_to_paly_animation==1) {
                                animatorSet.start();
                                Log.e("..............","btn2");


                            }
                        }
                    });




                }
            }
        });


        Thread btn3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (acces_to_paly_animation== 1) {
                            if (acces_to_paly_animation==1) {
                                animatorSet1.start();
                                Log.e("..............","btn3");

                            }
                        }
                    }
                });
            }
        });


        Thread btn4 =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (acces_to_paly_animation==1) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            animatorSet3.start();
                            Log.e("..............", "btn4");
                        }


                    });
                }
            }
        });

        btn1.start();
        btn2.start();
        btn3.start();
        btn4.start();










        new Thread(new Runnable() {
            @Override
            public void run() {
                while (acces_to_set_change==1) {
                    runOnUiThread(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            counter.setStartdraw(counter.getStartdraw()+(500*counter.getHorizontal_scale()));
                            counter.setEnddraw(counter.getEnddraw()+(500*counter.getHorizontal_scale()));
                            float z=Float.parseFloat(EightRootActivity.getV0().getText().toString())+((counter.getHorizontal_scale()/2));
                            V0.setText(""+z);
                            V1000.setText(""+(z+(0.125*counter.getHorizontal_scale())));
                            V2000.setText(""+(z+(2*0.125*counter.getHorizontal_scale())));
                            V3000.setText(""+(z+(3*0.125*counter.getHorizontal_scale())));
                            V4000.setText(""+(z+(4*0.125*counter.getHorizontal_scale())));
                            V5000.setText(""+(z+(5*0.125*counter.getHorizontal_scale())));
                            V6000.setText(""+(z+(6*0.125*counter.getHorizontal_scale())));
                            V7000.setText(""+(z+(7*0.125*counter.getHorizontal_scale())));
                            V8000.setText(""+(z+(8*0.125*counter.getHorizontal_scale())));
  } });
                    try {
                        Thread.sleep((counter.getHorizontal_scale()*1000)+40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
















/*

new Thread(new Runnable() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.anim);

                animation.setDuration(counter.getHorizontal_scale()*1000);

                lineplay.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        animation.setDuration(counter.getHorizontal_scale()*1000);

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(Animation animation) {
if (set_stop_play==0) {
    lineplay.startAnimation(animation);

    counter.setStartdraw(counter.getStartdraw()+(250*counter.getHorizontal_scale()));
    counter.setEnddraw(counter.getEnddraw()+(250*counter.getHorizontal_scale()));

    float z=Float.parseFloat(EightRootActivity.getV0().getText().toString())+((counter.getHorizontal_scale()/2));
    V0.setText(""+z);

    V1000.setText(""+(z+(0.125*counter.getHorizontal_scale())));
    V2000.setText(""+(z+(2*0.125*counter.getHorizontal_scale())));
    V3000.setText(""+(z+(3*0.125*counter.getHorizontal_scale())));
    V4000.setText(""+(z+(4*0.125*counter.getHorizontal_scale())));
    V5000.setText(""+(z+(5*0.125*counter.getHorizontal_scale())));
    V6000.setText(""+(z+(6*0.125*counter.getHorizontal_scale())));
    V7000.setText(""+(z+(7*0.125*counter.getHorizontal_scale())));
    V8000.setText(""+(z+(8*0.125*counter.getHorizontal_scale())));


}
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

    }
}).start();



 */


    }




    }

