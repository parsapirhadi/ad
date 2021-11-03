package com.example.myapplication.V.Activity;

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
import com.example.myapplication.P.BaseSurfaceSingle;
import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Set;

public class SingleRootActivity extends AppCompatActivity {


    ListView listView;
    Set<BluetoothDevice> pared;
    Dialog dialog;
    TextView textplay;
    ImageView notch;
    String1 string1;
    GraphView graphView;
    Button line,btn,montage,zoomout,play,choose_channel;

    float [] f= new float[8];

    private BaseSurfaceSingle surface;

    int notchcount;
    int playcount;
    int text_play=0;

    float d=2;





    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        surface.startDrawThread(0);
    }

    @Override
    protected void onPause()
    {

        surface.stopDrawThread();
        super.onPause();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleroot);
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        surface = (BaseSurfaceSingle) findViewById(R.id.singlesurfaceview);
        string1=new String1();
        Counter counter=new Counter();
       Intent intent=getIntent();
      Log.e("{}LHFSZBNWN",""+string1.getLine_count());

        notchcount=0;
        playcount=0;
        dialog=new Dialog(SingleRootActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        FindViewById();

     listView=dialog.findViewById(R.id.list);

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
            }
        });


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
                counter.setCount_of_set_i_channel(0);
                counter.setCount_of_set_j_channel(0);

                Intent intent1=new Intent(getApplicationContext(),EightRootActivity.class);
                startActivity(intent1);

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                counter.setLine_clecked(1);
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
        /*
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                graphView.getViewport().setMaxX(4000);
                graphView.getViewport().setMinX(0);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();

                graphView.getViewport().setMaxY(100);
                graphView.getViewport().setMinY(-100);
                graphView.addSeries(series);

            }
        });

         */
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
        choose_channel=findViewById(R.id.choiosechannel);
        zoomout=findViewById(R.id.zoomout_singleroot);

    }

}
