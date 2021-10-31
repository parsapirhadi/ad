package com.example.myapplication.V.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.P.SetPivotName;
import com.example.myapplication.P.SetPivotValue;
import com.example.myapplication.R;
import com.example.myapplication.V.ConnectGraphview;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;

public class EightRootActivity extends AppCompatActivity {
    Button line,btn,bluetooth,montage,play,zoomout;
    ImageView notch;
    TextView textplay;
    ListView listView;
    Set<BluetoothDevice> pared;
    Dialog dialog;
    Button lineplay;
    SetPivotName namePivote;
    SetPivotValue pivotValue;

    String1 string1;
    Counter counter;
    BufferedReader myReader;
    int g=0;

    int text_play=0;
    int notchcount;
    Activity activity;
    GraphView graphView1,graphView2,graphView3,graphView4,graphView5,graphView6,graphView7,graphView8,graphView9;
    int playcount;

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

        Toast.makeText(getApplicationContext(),""+width,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),""+height,Toast.LENGTH_SHORT).show();





        LinearLayout linearLayout=findViewById(R.id.left_linearlayout);
activity=this;
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        notchcount=0;
        playcount=0;
        string1=new String1();
        counter=new Counter();
        dialog=new Dialog(EightRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        FindViewById();
        lineplay.setVisibility(View.INVISIBLE);
Intent intent=getIntent();

Log.e("?????????",""+intent.getSerializableExtra("string1"));

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
                    play.setBackgroundResource(R.drawable.pause_root_foreground);
                    playcount=1;
                }
                else if(playcount==1) {
                    play.setBackgroundResource(R.drawable.play_foreground);
                    playcount=0;

                }
lineplay.setVisibility(View.VISIBLE);
                    Setlinebtnanim();




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
                graphView1.getViewport().setMaxX(4000);
                graphView1.getViewport().setMinX(0);
                graphView1.getViewport().setMaxY((string1.getChannel_count()*100)-100);
                graphView1.getViewport().setMinY(-100);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
                graphView1.addSeries(series);


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
            drawGraphview1.draw();
        }


        else if(counter.getLine_clecked()==2) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FileReader fileReader = new FileReader(activity,string1, counter, namePivote, pivotValue);
                    fileReader.read();
                    ConnectGraphview drawGraphview1=new ConnectGraphview(graphView1,counter,string1);
                    drawGraphview1.draw();
                }
            });


            //  Log.e("is", " 2");
        }



    }
}).start();




        lineplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        invalidateOptionsMenu();

    }




    private void FindViewById() {
        line=findViewById(R.id.line_eightroot);
        textplay=findViewById(R.id.eighttextplay);
        play=findViewById(R.id.plsy_eightroot);
        btn=findViewById(R.id.note_eightroot);
        notch=findViewById(R.id.notch_eightroot);
        montage=findViewById(R.id.montage_eightroot);
        listView=dialog.findViewById(R.id.list);
        zoomout=findViewById(R.id.zoomout_eightroot);
        lineplay=findViewById(R.id.playline);
        graphView1=findViewById(R.id.eightgraphview1);
    }
    private void Setlinebtnanim(){
new Thread(new Runnable() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.anim);
                lineplay.startAnimation(animation);
            }
        });

    }
}).start();




    }




    }

