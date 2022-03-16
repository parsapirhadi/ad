package com.example.myapplication.V.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.Editable;

import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;
//import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.SendReceive;
import com.example.myapplication.R;
import com.example.myapplication.V.BaseSurfaceEightRecord;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;


public class EightRecordActivity extends AppCompatActivity {

    EditText ech2,ech3,ech4,ech5,ech6,ech7,ech8;
    Button bch1,bch2,bch3,bch4,bch5,bch6,bch7,bch8;

    static TextView ch[]=new TextView[65];

    private ArrayAdapter<String> adapter;

    public static TextView getCh1() {
        return ch[1];

    }

    TextInputEditText ech1;

    TextInputLayout lch1,lch2,lch3,lch4,lch5,lch6,lch7,lch8;

    Button cch1,cch2,cch3,cch4,cch5,cch6,cch7,cch8;


    Animation animation1,animation2;
    Button btn;
    Button montage;
    Button line;
    ImageView notch;
    Button replay;
    Button eight_zoomout;
    Button eight_zoomin;


    float pivote50=50;
    float pivote100=100;
    float pivote_50=-50;
    float pivote_100=-100;

    TextView row100,row50,row_100,row_50;

    Button single_zoomout;
    Button single_zoomin;

    Button record;

    Button bluetooth;
    ListView listView;

    boolean animation_bluetooth=true;

    boolean set_dimens=true;

    Button check_circle1,check_circle2,check_circle3,check_circle4,check_circle5,check_circle6,check_circle7,check_circle8;


    Set<BluetoothDevice> pared;
    static Dialog dialog,dialog1,dialog2,dialog3,dialog4,dialog5,dialog6,dialog7,dialog8;

   Dialog choiceDialog;

    int metode_counter=1;
    int connect_counter=0;

    boolean is_connected=false;
    boolean is_open=false;

    static boolean Recordcount=false;

    public static boolean isRecordcount() {
        return Recordcount;
    }

    public static void setRecordcount(boolean recordcount) {
        Recordcount = recordcount;
    }

    boolean is_disconnected=false;



    boolean allow_rename=true;

    int data_count=0;
    int conter=0;

    long bluetoothDelay=100;

    Button choise;
    ListView myListView;

    boolean is_one_second=false;

    View parentLayout;
    int recordcount=0;
    int notchcount=0;
    String bluetooth_name="";
    DrawerLayout drawerLayout;
    String1 string1 ;
    Objects objects;
    Counter counter;
    /////////////////////////////////////////////////
    Button listDevices;
    int t;

    static TextView V0,V1000,V2000,V3000,V4000,V5000,V6000,V7000,V8000;

    public static TextView getV0() {
        return V0;
    }

    public static void setV0(TextView v0) {
        V0 = v0;
    }

    public static TextView getV1000() {
        return V1000;
    }

    public static void setV1000(TextView v1000) {
        V1000 = v1000;
    }

    public static TextView getV2000() {
        return V2000;
    }

    public static void setV2000(TextView v2000) {
        V2000 = v2000;
    }

    public static TextView getV3000() {
        return V3000;
    }

    public static void setV3000(TextView v3000) {
        V3000 = v3000;
    }

    public static TextView getV4000() {
        return V4000;
    }

    public static void setV4000(TextView v4000) {
        V4000 = v4000;
    }

    public static TextView getV5000() {
        return V5000;
    }

    public static void setV5000(TextView v5000) {
        V5000 = v5000;
    }

    public static TextView getV6000() {
        return V6000;
    }

    public static void setV6000(TextView v6000) {
        V6000 = v6000;
    }

    public static TextView getV7000() {
        return V7000;
    }

    public static void setV7000(TextView v7000) {
        V7000 = v7000;
    }

    public static TextView getV8000() {
        return V8000;
    }

    public static void setV8000(TextView v8000) {
        V8000 = v8000;
    }


    BaseSurfaceEightRecord msg_box;
    String tempMsg;
    TextView writeMsg;
    Vibrator vibrator;


    int channel =-1;
    boolean next_is_zarib=true;
    int zarib=0;

    BluetoothDevice[] btArray;

    static SendReceive sendReceive;
    int q=0;
    int set_limit=0;
    int no_limit;

    float data=0;
    int g;

    Snackbar snackbar_connecting;

    int o;

    boolean bb=false;
    boolean ggg=false;
    int byt=0;



    int s;
    static final int STATE_LISTENING = 1;
    static final int STATE_CONNECTING=2;
    static final int STATE_CONNECTED=3;
    static final int STATE_CONNECTION_FAILED=4;
    public static final int STATE_MESSAGE_RECEIVED=5;

    int REQUEST_ENABLE_BLUETOOTH=1;





    private BluetoothDevice device;


    int y=0;

    private static final String APP_NAME = "BTChat";


    private static final UUID MY_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");////hc05
    //private static final UUID MY_UUID=UUID.fromString("8ce255c0-223a-11e0-ac64-0803450c9a66");////mobile



    @Override
    protected void onPause() {
        super.onPause();

        String string = "NOP\r\n";
        counter.setEightRecord_ispause(false);
        if (objects.getSocket()!=null){
            try {
                sendReceive.write(string.getBytes());
                //  objects.getSocket().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        record.setBackgroundResource(R.drawable.red_record_foreground);
        counter.set_draw_activity_on(false);
        set_dimens=false;
        counter.set_receive_activity_on(false);


   // for (int j2=0;j2<8;j2++){
         //   for (int j1=0;j1<16000;j1++) {
          //      counter.setBuffer(counter.getPart_data(), j2, j1);
//
         //   }
      //  }




        record.setBackgroundResource(R.drawable.red_record_foreground);
        Recordcount=false;
      //  SingleRecordActivity.setIs_isRecordcount(false);
        set_limit = 1;

  recordcount = 0;

        //counter.setBuffer_count(0);
 }




    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {

        super.onResume();
        Log.e("EonResume", "EonResume");
        counter.setShow_record_ch(0);

        is_disconnected = false;

        counter.set_receive_activity_on(true);
        counter.set_draw_activity_on(true);



        data_count = 0;
        conter = 0;
        is_connected = false;
        is_open = false;

        set_dimens=true;

        pivote50 = 50;
        pivote100 = 100;
        pivote_50 = -50;
        pivote_100 = -100;

        row_100.setText("-100µV");
        row100.setText("100µV");
        row50.setText("50µV");
        row_50.setText("-50µV");

        Log.e("onResume","onResume");

        String string = "NOP\r\n";
        set_limit = 1;

        if (objects.getSocket() != null) {
            try {
                record.setBackgroundResource(R.drawable.red_record_foreground);
                sendReceive.write(string.getBytes());
                objects.getSocket().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                counter.setEightRecord_ispause(true);


            }
        }).start();


        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bluetooth_anim_1);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bluetooth_anim_2);
        bluetooth.startAnimation(animation1);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (animation_bluetooth) {
                    bluetooth.startAnimation(animation1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                bluetooth.startAnimation(animation2);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        if (objects.getSocket() != null) {
            if (objects.getSocket().isConnected()) {

            }
        }


        if (counter.isBluetooth_drawabe()) {
            bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
        }


        try {


            EightRecordActivity.getV0().setText( (int)counter.getSeconds_count0_record() + "s");
            EightRecordActivity.getV1000().setText( (int)counter.getSeconds_count1000_record() + "s");
            EightRecordActivity.getV2000().setText( (int)counter.getSeconds_count2000_record() + "s");
            EightRecordActivity.getV3000().setText( (int)counter.getSeconds_count3000_record() + "s");
            EightRecordActivity.getV4000().setText( (int)counter.getSeconds_count4000_record() + "s");
            EightRecordActivity.getV5000().setText( (int)counter.getSeconds_count5000_record() + "s");
            EightRecordActivity.getV6000().setText( (int)counter.getSeconds_count6000_record() + "s");
            EightRecordActivity.getV7000().setText( (int)counter.getSeconds_count7000_record() + "s");
            EightRecordActivity.getV8000().setText( (int)counter.getSeconds_count8000_record() + "s");


        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // counter.setBuffer_count(0);

        try {
            if (string1.getPivote(0) != null) {
                for (int y = 0; y < counter.getDefault_channel(); y++) {
                    ch[y].setText(string1.getPivote(y));
                }

            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);

        try {
            for (int m = 1; m < 65; m++) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("bch" + m, MODE_PRIVATE);
                ch[m].setText(sharedPreferences.getString("name", "ch" + m).toString());

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @SuppressLint("LongLogTag")
            @Override
            public void run() {
                while (counter.is_draw_activity_on()) {
                    bluetoothDelay=100;

                      Log.e("counter.is_draw_activity_on","counter.is_draw_activity_on");

                    if (is_one_second && counter.isSignal_is_weak() && (counter.getBuffer_count() - data_count) < counter.getMin_receive_data() && recordcount == 1 && objects.getSocket().isConnected()) {

                        try {
                            metode(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    try {
                        tryToConnect();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    data_count = (int) counter.getBuffer_count();
                    try {

                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        TextView ctext = findViewById(R.id.choise_channel_record);
        ctext.setText(getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name", "ch1").toString());


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (set_dimens) {
                    if (counter.getSurfaceview_height_eightrecord() > 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                              Log.e("set_dimens","set_dimens");
                                int paint_screen = counter.getSurfaceview_height_eightrecord();
                                float button_step = (float) paint_screen / (((counter.getDefault_channel()) * 2));
                                int k = counter.getDefault_channel();


                                for (int o = 0; o < counter.getDefault_channel(); o++) {
                                    ch[o + 1].setTranslationY((float) (((2 * o) + 0.5) * button_step));
                                }
                                for (int s = 1; s < 65; s++) {
                                    ch[s].setTranslationY((float) ((float) ch[s].getTranslationY() - (0.5 * button_step)));
                                }
                                for (int o = counter.getDefault_channel(); o < 64; o++) {
                                    ch[o + 1].setTranslationY(1000 + paint_screen);
                                }
                                for (int s = 1; s < 65; s++) {
                                    if (k > 12) {
                                        ch[s].setScaleY((float) 1 - ((float) 1.25 * k / 100));
                                        ch[s].setScaleX((float) 1 - ((float) 1.25 * k / 100));
                                    }

                                }
                                //   findViewById(R.id.left_linearlayout_re).setTranslationY((float) (button_step*-1));


                                float f = counter.getSurfaceview_Width_eightrecord();

                                getV0().setTranslationX(0);
                                getV1000().setTranslationX(((float) f / 8) * 1);
                                getV2000().setTranslationX(((float) f / 8) * 2);
                                getV3000().setTranslationX(((float) f / 8) * 3);
                                getV4000().setTranslationX(((float) f / 8) * 4);
                                getV5000().setTranslationX(((float) f / 8) * 5);
                                getV6000().setTranslationX(((float) f / 8) * 6);
                                getV7000().setTranslationX(((float) f / 8) * 7);
                                getV8000().setTranslationX(((float) f / 8) * 8 - 30);


                            }
                        });


                        set_dimens = false;


                    }
                }
            }
        }).start();

        snackbar_connecting = Snackbar.make(parentLayout, "' " + "Bluetooth" + " is connecting '" + "   " + "' Please approach the device '", Snackbar.LENGTH_LONG);





        snackbar_connecting.setDuration(400000);

            snackbar_connecting.show();



        if(counter.getHorizontal_scale()<8){
            getV1000().setVisibility(View.INVISIBLE);
            getV3000().setVisibility(View.INVISIBLE);
            getV5000().setVisibility(View.INVISIBLE);
            getV7000().setVisibility(View.INVISIBLE);

        }
        else{
            getV1000().setVisibility(View.VISIBLE);
            getV3000().setVisibility(View.VISIBLE);
            getV5000().setVisibility(View.VISIBLE);
            getV7000().setVisibility(View.VISIBLE);

        }




    }

    private void metode(int i) throws InterruptedException {

        counter.setStop_line((float) (((float) counter.getO() / (0.99*counter.getHorizontal_scale()*counter.getRate_in_s())) * counter.getSurface_width()), counter.getRecordcount()%30);

        if (i==1){
            Log.e("start metode 1","start metode 1");
            conter++;


                if (conter > 1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            record.setBackgroundResource(R.drawable.red_record_foreground);
                            String string = "NOP\r\n";
                            set_limit = 1;
                            conter = 0;
                            sendReceive.write(string.getBytes());
                            recordcount = 0;
                            try {
                                objects.getSocket().close();
                                is_connected = false;
                                is_open = true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            is_disconnected = true;
                            snackbar_connecting.setDuration(400000);
                            snackbar_connecting.show();

                            bluetooth.startAnimation(animation1);
                            animation_bluetooth=true;


                            bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);


                        }
                    });


                }

        }
        else if (i==2){
            Log.e("start metode 2","start metode 2");

                 metode_counter=1;
                 connect_counter=1;
                conter++;


            objects.getBluetoothAdapter().disable();


            Thread.sleep(bluetoothDelay);
            bluetoothDelay+=500;

            objects.getBluetoothAdapter().enable();




                }





    }

    private void tryToConnect() throws InterruptedException {






        if (objects.getSocket()!=null)
        {
            if (!objects.getSocket().isConnected()) {
                connect_counter++;
                if (connect_counter==7){
                    metode(2);
                }
                Log.e("try to conneect","try to conneect");
                Log.e("connect_counter",""+connect_counter);
                Set<BluetoothDevice> bt = objects.getBluetoothAdapter().getBondedDevices();
                String[] strings = new String[bt.size()];
                btArray = new BluetoothDevice[bt.size()];
                int index = 0;

                if (bt.size() > 0) {
                    for (BluetoothDevice device : bt) {
                        btArray[index] = device;
                        strings[index] = device.getName();
                        index++;
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, strings);
                    listView.setAdapter(arrayAdapter);
                    for (int n = 0; n < btArray.length; n++) {
                        if (btArray[n].getName().charAt(0) == 'H' &&
                                btArray[n].getName().charAt(1) == 'C' &&
                                btArray[n].getName().charAt(2) == '-' &&
                                btArray[n].getName().charAt(3) == '0' &&
                                btArray[n].getName().charAt(4) == '5'
                        ) {

                            EightRecordActivity.ClientClass clientClass = new EightRecordActivity.ClientClass(btArray[n]);
                            bluetooth_name = strings[n] + "";
                            clientClass.start();


                        }
                    }
                }
                try {

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else {
                connect_counter=0;
            }
        }
        else {
            Log.e("socket not null","try to conneect");

            Set<BluetoothDevice> bt = objects.getBluetoothAdapter().getBondedDevices();
            String[] strings = new String[bt.size()];
            btArray = new BluetoothDevice[bt.size()];
            int index = 0;

            if (bt.size() > 0) {
                for (BluetoothDevice device : bt) {
                    btArray[index] = device;
                    strings[index] = device.getName();
                    index++;
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, strings);
                listView.setAdapter(arrayAdapter);
                for (int n = 0; n < btArray.length; n++) {
                    if (btArray[n].getName().charAt(0) == 'H' &&
                            btArray[n].getName().charAt(1) == 'C' &&
                            btArray[n].getName().charAt(2) == '-' &&
                            btArray[n].getName().charAt(3) == '0' &&
                            btArray[n].getName().charAt(4) == '5'
                    ) {

                        EightRecordActivity.ClientClass clientClass = new EightRecordActivity.ClientClass(btArray[n]);
                        bluetooth_name = strings[n] + "";
                        clientClass.start();


                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }





    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eightrecord);
        dialog=new Dialog(EightRecordActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));




        choiceDialog=new Dialog(EightRecordActivity.this);
        choiceDialog.setContentView(R.layout.choice_dialog);
        choiceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        dialog1=new Dialog(EightRecordActivity.this);
        dialog1.setContentView(R.layout.rename_ch1);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog2=new Dialog(EightRecordActivity.this);
        dialog2.setContentView(R.layout.rename_ch2);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog3=new Dialog(EightRecordActivity.this);
        dialog3.setContentView(R.layout.rename_ch3);
        dialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog4=new Dialog(EightRecordActivity.this);
        dialog4.setContentView(R.layout.rename_ch4);
        dialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog5=new Dialog(EightRecordActivity.this);
        dialog5.setContentView(R.layout.rename_ch5);
        dialog5.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog6=new Dialog(EightRecordActivity.this);
        dialog6.setContentView(R.layout.rename_ch6);
        dialog6.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog7=new Dialog(EightRecordActivity.this);
        dialog7.setContentView(R.layout.rename_ch7);
        dialog7.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog8=new Dialog(EightRecordActivity.this);
        dialog8.setContentView(R.layout.rename_ch8);
        dialog8.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        drawerLayout=findViewById(R.id.draver_eightrecord);
        counter=new Counter();
        string1=new String1();
        objects=new Objects();

        counter.setFrist_page(false);

        if (counter.getHorizontal_scale()>10){

        //counter.setHorizontal_scale(8);
        }

        counter.setStartdraw_record(1);
        counter.setEnddraw_record((int)counter.getHorizontal_scale()*counter.getRate_in_s());


        counter.setLine_stop_counter(0);
        counter.setLoop_counter(1);
        counter.setRecordcount(1);
        for (int t=0;t<40;t++){
            counter.setStop_line(10000,t);
        }

        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<16100;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
            }
        }







        counter.setBuffer_count(0);
        FindViewBiId();

        try {
            counter.setSeconds_count0_record(0);
            counter.setSeconds_count1000_record(counter.getSeconds_count0_record()+(1 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count2000_record(counter.getSeconds_count0_record()+(2 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count3000_record(counter.getSeconds_count0_record()+(3 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count4000_record(counter.getSeconds_count0_record()+(4 *  counter.getHorizontal_scale() / 8));
           counter.setSeconds_count5000_record(counter.getSeconds_count0_record()+(5 *  counter.getHorizontal_scale() / 8));
          counter.setSeconds_count6000_record(counter.getSeconds_count0_record()+(6 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count7000_record(counter.getSeconds_count0_record()+(7 * counter.getHorizontal_scale() / 8));
           counter.setSeconds_count8000_record(counter.getSeconds_count0_record()+(8 *  counter.getHorizontal_scale() / 8));





            EightRecordActivity.getV0().setText( (int)counter.getSeconds_count0_record()+"s");
            EightRecordActivity.getV1000().setText( (int)counter.getSeconds_count1000_record()+"s");
            EightRecordActivity.getV2000().setText( (int)counter.getSeconds_count2000_record()+"s");
            EightRecordActivity.getV3000().setText( (int)counter.getSeconds_count3000_record()+"s");
            EightRecordActivity.getV4000().setText( (int)counter.getSeconds_count4000_record()+"s");
            EightRecordActivity.getV5000().setText( (int)counter.getSeconds_count5000_record()+"s");
            EightRecordActivity.getV6000().setText( (int)counter.getSeconds_count6000_record()+"s");
            EightRecordActivity.getV7000().setText( (int)counter.getSeconds_count7000_record()+"s");
            EightRecordActivity.getV8000().setText( (int)counter.getSeconds_count8000_record()+"s");





        }
        catch (NullPointerException e){
            e.printStackTrace();
        }




        string1.setSview("eight");

        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        objects.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());

        counter.setRecord_activity(true);

        counter.setEight_step_x((float) counter.getSurfaceviewhewidth()/(counter.getRate_in_s()*counter.getHorizontal_scale()));

        counter.setEight_step_y((float) counter.getSurfaceviewhewidth()/200);
        counter.setEight_step_y((counter.getEight_step_y()/counter.getDefault_channel())/2);


   counter.setMin_receive_data((float) (counter.getRate_in_s()*counter.getDefault_channel()*0.2*0.37));


        if(!objects.getBluetoothAdapter().isEnabled())
        {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent,REQUEST_ENABLE_BLUETOOTH);
        }

        IntentFilter scanintentFilter=new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        BroadcastReceiver scanmodereceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED))
                {
                    int modevalue = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE,BluetoothAdapter.ERROR);
                    if (modevalue==BluetoothAdapter.SCAN_MODE_CONNECTABLE){


                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
                    {

                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_NONE)
                    {



                    }
                    else {
                    }
                }

            }
        };
        registerReceiver(scanmodereceiver,scanintentFilter);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        objects.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());
        if (objects.getBluetoothAdapter()==null){
            finish();
        }
        if (objects.getBluetoothAdapter().isEnabled()){
        }

        if (counter.isBluetooth_drawabe()){
            bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
        }

/*
        Set<BluetoothDevice> bt=objects.getBluetoothAdapter().getBondedDevices();
        String[] strings=new String[bt.size()];
        btArray=new BluetoothDevice[bt.size()];
        int index=0;

        if( bt.size()>0)
        {
            for(BluetoothDevice device : bt)
            {
                btArray[index]= device;
                strings[index]=device.getName();
                index++;
            }
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strings);
            listView.setAdapter(arrayAdapter);
        }

        EightRecordActivity.ClientClass clientClass=new EightRecordActivity.ClientClass(btArray[0]);
        bluetooth_name=strings[0]+"";
        clientClass.start();


        if (counter.isBluetooth_drawabe()){
            bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
        }


 */

        objects.setHandler( new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                switch (msg.what)
                {
                    case STATE_LISTENING:
                        // status.setText("Listening");
                        break;
                    case STATE_CONNECTING:
                        // status.setText("Connecting");
                        break;
                    case STATE_CONNECTED:
                       snackbar_connecting.dismiss();
                        View parentLayout = findViewById(android.R.id.content);
                        Snackbar.make(parentLayout, "' Connected To Device '", 500).show();

                        animation_bluetooth=false;
                        if (counter.getO()>20) {
                            counter.setLine_stop_counter(counter.getLine_stop_counter() + 1);



                            counter.setRecordcount(counter.getRecordcount() + 1);
                        }

                        if (SingleRecordActivity.isRecordcount()){
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    record.setBackgroundResource(R.drawable.rect_stop_record_foreground);
                                    String string = "CONTB\r\n";
                                    set_limit = 1;
                                   sendReceive = new SendReceive(objects.getSocket(),counter,objects);

                                       sendReceive.write(string.getBytes());



                                    recordcount = 1;
                                }
                            }).start();

                        }
                        bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
                        counter.setBluetooth_drawabe(true);
                        is_open=false;
                        is_connected=true;
                        is_disconnected=false;
                        record.setBackgroundResource(R.drawable.red_record_foreground);
                        String string = "NOP\r\n";
                        set_limit = 1;
                        if (objects.getSocket()!=null){
                            sendReceive.write(string.getBytes());
                        }
                        recordcount = 0;

                        dialog.dismiss();
                        break;
                    case STATE_CONNECTION_FAILED:
                        //  status.setText("Connection Failed");
                        break;
                    case STATE_MESSAGE_RECEIVED:
                        byte[] readBuff= (byte[]) msg.obj;
                        tempMsg=new String(readBuff,0,msg.arg1);
                        //  msg_box.setText(tempMsg);
                        break;
                }
                return true;
            }
        }));



        implementListeners();

    }
    public void mono(){
        try {

            for (int u=1;u<65;u++){

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("bch"+u, MODE_PRIVATE);
                ch[u].setText(sharedPreferences.getString("name","ch"+u).toString());
                ch[u].setTextSize(12);

            }



        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }



    }


    @SuppressLint("SetTextI18n")
    public void banana(){


        for (int a=1;a<65;a++){
            SharedPreferences sharedPreferences_start = getApplicationContext().getSharedPreferences("bch"+a+"_start", MODE_PRIVATE);
            SharedPreferences sharedPreferences_end=  getApplicationContext().getSharedPreferences("bch"+a+"_end", MODE_PRIVATE);
            ch[a].setText(sharedPreferences_start.getString("name","ch"+a)+"-"+sharedPreferences_end.getString("name","ch"+a));
            ch[a].setTextSize(10);
        }


    }


    private void implementListeners() {



        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_one_second=false;
                if (counter.getRecordcount()>30){

                   // Toast.makeText(EightRecordActivity.this, "30 is full", Toast.LENGTH_SHORT).show();
                //   counter.setRecordcount(0);

                }


                if (objects.getSocket() != null ){
                    if (recordcount == 0 && is_connected) {

                        vibrator.vibrate(40);
                        counter.getSp().setColor(Color.RED);


                       if (counter.getO()>20) {
                           counter.setLine_stop_counter(counter.getLine_stop_counter() + 1);



                           counter.setRecordcount(counter.getRecordcount() + 1);
                       }

                        record.setBackgroundResource(R.drawable.rect_stop_record_foreground);
                        String string = "CONTB\r\n";


                       steponesecond();


                        set_limit = 1;
                        Recordcount=true;
                        SingleRecordActivity.setIs_isRecordcount(true);
                        sendReceive = new SendReceive(objects.getSocket(),counter,objects);
                        sendReceive.write(string.getBytes());
                        recordcount = 1;

                    } else if (recordcount == 1) {

                        record.setBackgroundResource(R.drawable.red_record_foreground);
                        String string = "NOP\r\n";
                        Recordcount=false;
                        SingleRecordActivity.setIs_isRecordcount(false);
                        set_limit = 1;
                        sendReceive.write(string.getBytes());

                        recordcount = 0;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                counter.setStop_line((float) (((float) counter.getO() / (0.99*counter.getHorizontal_scale()*counter.getRate_in_s())) * counter.getSurface_width()), counter.getRecordcount()%30);
                            }
                        }).start();


                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Please Connect With Bluetooth",Toast.LENGTH_LONG).show();

                }
            }

        });

        notch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(40);

                if(notchcount==0) {
                    notch.setBackgroundResource(R.drawable.notch_on);
                    notchcount=1;
                }
                else if(notchcount==1) {
                   notch.setBackgroundResource(R.drawable.notch_off);
                    notchcount=0;


                }
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


              //  vibrator.vibrate(40);
//
               //  startActivity(new Intent(getApplicationContext(), EightRootActivity.class));
              //   overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




             }
        });


        choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myListView =  choiceDialog.findViewById(R.id.choice_list_view);
                ArrayList<String> myStringArray1 = new ArrayList<String>();





                myStringArray1.add(getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name","ch1").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE).getString("name","ch2").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name","ch3").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name","ch4").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name","ch5").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name","ch6").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name","ch7").toString());;
                myStringArray1.add(getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name","ch8").toString());;



                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, myStringArray1);
                myListView.setAdapter(adapter);






                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        choise.setText(myStringArray1.get(i));
                        counter.setShow_record_ch(i);

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
                vibrator.vibrate(70);

                if(string1.getSview()==string1.getSeight()){
                    line.setBackgroundResource(R.drawable.one_line_foreground);
                    findViewById(R.id.replay_eightrecord).setVisibility(View.GONE);
                    findViewById(R.id.choise_channel_record).setVisibility(View.VISIBLE);
                    findViewById(R.id.left_linearlayout_eightre).setVisibility(View.GONE);
                    findViewById(R.id.left_linearlayout_singlere).setVisibility(View.VISIBLE);
                    findViewById(R.id.zoomin_singlerecord).setVisibility(View.VISIBLE);
                    findViewById(R.id.zoomout_singlerecord).setVisibility(View.VISIBLE);
                    findViewById(R.id.zoomin_eightrecord).setVisibility(View.GONE);
                    findViewById(R.id.zoomout_eightrecord).setVisibility(View.GONE);


                    Log.e("start",""+counter.getStartdraw_record());
                    Log.e("end",""+counter.getEnddraw_record());
                    Log.e("buffercount",""+counter.getBuffer_count());
                    Log.e("timer",""+counter.getTimer());
                    Log.e("ooo",""+counter.getO());
                    Log.e("timer",""+counter.getTimer());
                    Log.e("ooo",""+counter.getO());

                    Log.e("singleX",""+counter.getSingle_step_x());
                    Log.e("eightX",""+counter.getEight_step_x());




                    string1.setSview(string1.getSsingle());

                }

                 else if (string1.getSview()==string1.getSsingle()){
                    line.setBackgroundResource(R.drawable.multi_line_foreground);
                    findViewById(R.id.replay_eightrecord).setVisibility(View.VISIBLE);
                    findViewById(R.id.choise_channel_record).setVisibility(View.GONE);
                    findViewById(R.id.left_linearlayout_eightre).setVisibility(View.VISIBLE);
                    findViewById(R.id.left_linearlayout_singlere).setVisibility(View.GONE);

                    findViewById(R.id.zoomin_singlerecord).setVisibility(View.GONE);
                    findViewById(R.id.zoomout_singlerecord).setVisibility(View.GONE);
                    findViewById(R.id.zoomin_eightrecord).setVisibility(View.VISIBLE);
                    findViewById(R.id.zoomout_eightrecord).setVisibility(View.VISIBLE);


                    string1.setSview(string1.getSeight());

                }


                //startActivity(new Intent(getApplicationContext(),SingleRecordActivity.class));
               // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
             //  finish();

            }
        });

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

        eight_zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(counter.getEight_step_y()>0) {
                    vibrator.vibrate(40);
                    counter.setEight_step_y((float) ((float) (counter.getEight_step_y() -(counter.getDefault_channel()*(counter.getEight_step_y()/100)))));
                }
            }
        });
        eight_zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                vibrator.vibrate(40);
                counter.setEight_step_y((float) (counter.getEight_step_y() +(counter.getDefault_channel()*(counter.getEight_step_y()/50))));
            }
        });

        single_zoomout.setOnClickListener(new View.OnClickListener() {
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
        single_zoomin.setOnClickListener(new View.OnClickListener() {
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


        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        ch[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech1.setText("");
                    check_circle1.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog1.show();
                }
            }
        });
        ch[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech2.setText("");
                    check_circle2.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog2.show();
                }
            }
        });
        ch[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech3.setText("");
                    check_circle3.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog3.show();
                }
            }
        });
        ch[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech4.setText("");
                    check_circle4.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog4.show();
                }
            }
        });
        ch[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech5.setText("");
                    check_circle5.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog5.show();
                }
            }
        });
        ch[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech6.setText("");
                    check_circle6.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog6.show();
                }
            }
        });
        ch[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech7.setText("");
                    check_circle7.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog7.show();
                }
            }
        });
        ch[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allow_rename) {
                    ech8.setText("");
                    check_circle8.setVisibility(View.INVISIBLE);
                    vibrator.vibrate(30);
                    dialog8.show();
                }
            }
        });













        ech1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch1.setError("");

                if (ech1.getText().length()<4 && ech1.getText().length()>0){
                    check_circle1.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle1.setVisibility(View.VISIBLE);
                }
                if (ech1.getText().length()>3 || ech1.getText().length()==0){
                    check_circle1.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle1.setVisibility(View.VISIBLE);
                    lch1.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ech2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch2.setError("");

                if (ech2.getText().length()<4 && ech2.getText().length()>0){
                    check_circle2.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle2.setVisibility(View.VISIBLE);

                }
                if (ech2.getText().length()>3 || ech2.getText().length()==0){
                    check_circle2.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle2.setVisibility(View.VISIBLE);

                    lch2.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch3.setError("");

                if (ech3.getText().length()<4 && ech3.getText().length()>0){
                    check_circle3.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle3.setVisibility(View.VISIBLE);

                }
                if (ech3.getText().length()>3 || ech3.getText().length()==0){
                    check_circle3.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle3.setVisibility(View.VISIBLE);

                    lch3.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch4.setError("");

                if (ech4.getText().length()<4 && ech4.getText().length()>0){
                    check_circle4.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle4.setVisibility(View.VISIBLE);

                }
                if (ech4.getText().length()>3 || ech4.getText().length()==0){
                    check_circle4.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle4.setVisibility(View.VISIBLE);

                    lch4.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch5.setError("");

                if (ech5.getText().length()<4 && ech5.getText().length()>0){
                    check_circle5.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle5.setVisibility(View.VISIBLE);

                }
                if (ech5.getText().length()>3 || ech5.getText().length()==0){
                    check_circle5.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle5.setVisibility(View.VISIBLE);

                    lch5.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch6.setError("");

                if (ech6.getText().length()<4 && ech6.getText().length()>0){
                    check_circle6.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle6.setVisibility(View.VISIBLE);

                }
                if (ech6.getText().length()>3 || ech6.getText().length()==0){
                    check_circle6.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle6.setVisibility(View.VISIBLE);

                    lch6.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch7.setError("");

                if (ech7.getText().length()<4 && ech7.getText().length()>0){
                    check_circle7.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle7.setVisibility(View.VISIBLE);

                }
                if (ech7.getText().length()>3 || ech7.getText().length()==0){
                    check_circle7.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle7.setVisibility(View.VISIBLE);

                    lch7.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ech8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                lch8.setError("");

                if (ech8.getText().length()<4 && ech8.getText().length()>0){
                    check_circle8.setBackgroundResource(R.drawable.check_circle__foreground);
                    check_circle8.setVisibility(View.VISIBLE);

                }
                if (ech8.getText().length()>3 || ech8.getText().length()==0){
                    check_circle8.setBackgroundResource(R.drawable.check_circle_error_foreground);
                    check_circle8.setVisibility(View.VISIBLE);

                    lch8.setError("Maximum 3 Character");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        bch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech1.getText().toString());
                editor.apply();

                if (ech1.getText().toString().length()<8 && ech1.getText().toString().length()>0){

                    ch[1].setText(ech1.getText().toString());
                    dialog1.dismiss();
                }
            }
        });
        bch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech2.getText().toString());
                editor.apply();
                if (ech2.getText().toString().length()<4 && ech2.getText().toString().length()>0) {

                    ch[2].setText(ech2.getText().toString());
                    dialog2.dismiss();
                }
            }
        });
        bch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech3.getText().toString());
                editor.apply();
                if (ech3.getText().toString().length()<4 && ech3.getText().toString().length()>0 ) {

                    ch[3].setText(ech3.getText().toString());
                    dialog3.dismiss();
                }
            }
        });
        bch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech4.getText().toString());
                editor.apply();
                if (ech4.getText().toString().length()<4 && ech4.getText().toString().length()>0) {

                    ch[4].setText(ech4.getText().toString());
                    dialog4.dismiss();
                }
            }
        });
        bch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech5.getText().toString());
                editor.apply();
                if (ech5.getText().toString().length()<4  && ech5.getText().toString().length()>0) {

                    ch[5].setText(ech5.getText().toString());
                    dialog5.dismiss();
                }
            }
        });
        bch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech6.getText().toString());
                editor.apply();
                if (ech6.getText().toString().length()<4 && ech6.getText().toString().length()>0) {

                    ch[6].setText(ech6.getText().toString());
                    dialog6.dismiss();
                }
            }
        });
        bch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech7.getText().toString());
                editor.apply();
                if (ech7.getText().toString().length()<4 && ech7.getText().toString().length()>0) {

                    ch[7].setText(ech7.getText().toString());
                    dialog7.dismiss();
                }
            }
        });
        bch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",ech8.getText().toString());
                editor.apply();
                if (ech8.getText().toString().length()<4 && ech8.getText().toString().length()>0) {

                    ch[8].setText(ech8.getText().toString());
                    dialog8.dismiss();
                }
            }
        });
        cch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
        cch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2.dismiss();
            }
        });
        cch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog3.dismiss();
            }
        });
        cch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog4.dismiss();
            }
        });
        cch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog5.dismiss();
            }
        });
        cch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog6.dismiss();
            }
        });
        cch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog7.dismiss();
            }
        });
        cch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog8.dismiss();
            }
        });




    }

    private void steponesecond() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                is_one_second=true;
            }
        }).start();
    }

    private void FindViewBiId() {
        btn=findViewById(R.id.note_eightrecord);
        line=findViewById(R.id.line_eightrecord);
        record=findViewById(R.id.record_eightrecord);
        replay=findViewById(R.id.replay_eightrecord);
        bluetooth=findViewById(R.id.bluetoooth_eightrecord);
        montage=findViewById(R.id.montage_eightrecord);
        notch=findViewById(R.id.notch_eightrecord);

        listView=dialog.findViewById(R.id.list_device);

        ech1=dialog1.findViewById(R.id.textinputedittext1);
        ech2=dialog2.findViewById(R.id.textinputedittext2);
        ech3=dialog3.findViewById(R.id.textinputedittext3);
        ech4=dialog4.findViewById(R.id.textinputedittext4);
        ech5=dialog5.findViewById(R.id.textinputedittext5);
        ech6=dialog6.findViewById(R.id.textinputedittext6);
        ech7=dialog7.findViewById(R.id.textinputedittext7);
        ech8=dialog8.findViewById(R.id.textinputedittext8);


        lch1=dialog1.findViewById(R.id.textinputeditlayout1);
        lch2=dialog2.findViewById(R.id.textinputeditlayout2);
        lch3=dialog3.findViewById(R.id.textinputeditlayout3);
        lch4=dialog4.findViewById(R.id.textinputeditlayout4);
        lch5=dialog5.findViewById(R.id.textinputeditlayout5);
        lch6=dialog6.findViewById(R.id.textinputeditlayout6);
        lch7=dialog7.findViewById(R.id.textinputeditlayout7);
        lch8=dialog8.findViewById(R.id.textinputeditlayout8);


        check_circle1=dialog1.findViewById(R.id.checkcircle1);
        check_circle2=dialog2.findViewById(R.id.checkcircle2);
        check_circle3=dialog3.findViewById(R.id.checkcircle3);
        check_circle4=dialog4.findViewById(R.id.checkcircle4);
        check_circle5=dialog5.findViewById(R.id.checkcircle5);
        check_circle6=dialog6.findViewById(R.id.checkcircle6);
        check_circle7=dialog7.findViewById(R.id.checkcircle7);
        check_circle8=dialog8.findViewById(R.id.checkcircle8);

        bch1=dialog1.findViewById(R.id.save_renamech1);
        bch2=dialog2.findViewById(R.id.save_renamech2);
        bch3=dialog3.findViewById(R.id.save_renamech3);
        bch4=dialog4.findViewById(R.id.save_renamech4);
        bch5=dialog5.findViewById(R.id.save_renamech5);
        bch6=dialog6.findViewById(R.id.save_renamech6);
        bch7=dialog7.findViewById(R.id.save_renamech7);
        bch8=dialog8.findViewById(R.id.save_renamech8);

        cch1=dialog1.findViewById(R.id.cancel_renamech1);
        cch2=dialog2.findViewById(R.id.cancel_renamech2);
        cch3=dialog3.findViewById(R.id.cancel_renamech3);
        cch4=dialog4.findViewById(R.id.cancel_renamech4);
        cch5=dialog5.findViewById(R.id.cancel_renamech5);
        cch6=dialog6.findViewById(R.id.cancel_renamech6);
        cch7=dialog7.findViewById(R.id.cancel_renamech7);
        cch8=dialog8.findViewById(R.id.cancel_renamech8);


        V0=findViewById(R.id.SM1_0);
        V1000=findViewById(R.id.SM1_1000);
        V2000=findViewById(R.id.SM1_2000);
        V3000=findViewById(R.id.SM1_3000);
        V4000=findViewById(R.id.SM1_4000);
        V5000=findViewById(R.id.SM1_5000);
        V6000=findViewById(R.id.SM1_6000);
        V7000=findViewById(R.id.SM1_7000);
        V8000=findViewById(R.id.SM1_8000);

        choise=findViewById(R.id.choise_channel_record);


        eight_zoomout=findViewById(R.id.zoomout_eightrecord);
        eight_zoomin=findViewById(R.id.zoomin_eightrecord);


        single_zoomin=findViewById(R.id.zoomin_singlerecord);
        single_zoomout=findViewById(R.id.zoomout_singlerecord);



        parentLayout = findViewById(android.R.id.content);


        row100=findViewById(R.id.VS100rec);
        row50=findViewById(R.id.VS50rec);
        row_50=findViewById(R.id.VS_50rec);
        row_100=findViewById(R.id.VS_100rec);

        ch[1]=findViewById(R.id.axis_textview_1_re);
        ch[2]=findViewById(R.id.axis_textview_2_re);
        ch[3]=findViewById(R.id.axis_textview_3_re);
        ch[4]=findViewById(R.id.axis_textview_4_re);
        ch[5]=findViewById(R.id.axis_textview_5_re);
        ch[6]=findViewById(R.id.axis_textview_6_re);
        ch[7]=findViewById(R.id.axis_textview_7_re);
        ch[8]=findViewById(R.id.axis_textview_8_re);
        ch[9]=findViewById(R.id.axis_textview_9_re);
        ch[10]=findViewById(R.id.axis_textview_10_re);
        ch[11]=findViewById(R.id.axis_textview_11_re);
        ch[12]=findViewById(R.id.axis_textview_12_re);
        ch[13]=findViewById(R.id.axis_textview_13_re);
        ch[14]=findViewById(R.id.axis_textview_14_re);
        ch[15]=findViewById(R.id.axis_textview_15_re);
        ch[16]=findViewById(R.id.axis_textview_16_re);
        ch[17]=findViewById(R.id.axis_textview_17_re);
        ch[18]=findViewById(R.id.axis_textview_18_re);
        ch[19]=findViewById(R.id.axis_textview_19_re);
        ch[20]=findViewById(R.id.axis_textview_20_re);
        ch[21]=findViewById(R.id.axis_textview_21_re);
        ch[22]=findViewById(R.id.axis_textview_22_re);
        ch[23]=findViewById(R.id.axis_textview_23_re);
        ch[24]=findViewById(R.id.axis_textview_24_re);
        ch[25]=findViewById(R.id.axis_textview_25_re);
        ch[26]=findViewById(R.id.axis_textview_26_re);
        ch[27]=findViewById(R.id.axis_textview_27_re);
        ch[28]=findViewById(R.id.axis_textview_28_re);
        ch[29]=findViewById(R.id.axis_textview_29_re);
        ch[30]=findViewById(R.id.axis_textview_30_re);
        ch[31]=findViewById(R.id.axis_textview_31_re);
        ch[32]=findViewById(R.id.axis_textview_32_re);
        ch[33]=findViewById(R.id.axis_textview_33_re);
        ch[34]=findViewById(R.id.axis_textview_34_re);
        ch[35]=findViewById(R.id.axis_textview_35_re);
        ch[36]=findViewById(R.id.axis_textview_36_re);
        ch[37]=findViewById(R.id.axis_textview_37_re);
        ch[38]=findViewById(R.id.axis_textview_38_re);
        ch[39]=findViewById(R.id.axis_textview_39_re);
        ch[40]=findViewById(R.id.axis_textview_40_re);
        ch[41]=findViewById(R.id.axis_textview_41_re);
        ch[42]=findViewById(R.id.axis_textview_42_re);
        ch[43]=findViewById(R.id.axis_textview_43_re);
        ch[44]=findViewById(R.id.axis_textview_44_re);
        ch[45]=findViewById(R.id.axis_textview_45_re);
        ch[46]=findViewById(R.id.axis_textview_46_re);
        ch[47]=findViewById(R.id.axis_textview_47_re);
        ch[48]=findViewById(R.id.axis_textview_48_re);
        ch[49]=findViewById(R.id.axis_textview_49_re);
        ch[50]=findViewById(R.id.axis_textview_50_re);
        ch[51]=findViewById(R.id.axis_textview_51_re);
        ch[52]=findViewById(R.id.axis_textview_52_re);
        ch[53]=findViewById(R.id.axis_textview_53_re);
        ch[54]=findViewById(R.id.axis_textview_54_re);
        ch[55]=findViewById(R.id.axis_textview_55_re);
        ch[56]=findViewById(R.id.axis_textview_56_re);
        ch[57]=findViewById(R.id.axis_textview_57_re);
        ch[58]=findViewById(R.id.axis_textview_58_re);
        ch[59]=findViewById(R.id.axis_textview_59_re);
        ch[60]=findViewById(R.id.axis_textview_60_re);
        ch[61]=findViewById(R.id.axis_textview_61_re);
        ch[62]=findViewById(R.id.axis_textview_62_re);
        ch[63]=findViewById(R.id.axis_textview_63_re);
        ch[64]=findViewById(R.id.axis_textview_64_re);





    }






    private class ClientClass extends Thread
    {

        public ClientClass (BluetoothDevice device1)
        {
            device=device1;

            try {
                objects.setSocket(device.createRfcommSocketToServiceRecord(MY_UUID));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run()
        {
            try {

                objects.getSocket().connect();

                Message message=Message.obtain();
                message.what=STATE_CONNECTED;

                objects.getHandler().sendMessage(message);




                sendReceive=new SendReceive(objects.getSocket(),counter,objects);

                sendReceive.start();

            } catch (IOException e) {
                e.printStackTrace();
                Message message=Message.obtain();
                message.what=STATE_CONNECTION_FAILED;


                objects.getHandler().sendMessage(message);

            }
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==42 && resultCode== Activity.RESULT_OK){
            if (data!=null){
                Uri uri=data.getData();
                String path=uri.getPath();
                path=path.substring(path.indexOf(":")+1) ;
                Toast.makeText(getApplicationContext(), ""+path, Toast.LENGTH_SHORT).show();

                 montage.setText(readText(path));
            }
        }


    }

    private String readText(String input){
        File file=new File(Environment.getExternalStorageDirectory(),input);
        StringBuilder text =new StringBuilder();
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine())!=null){
                text.append(line);


            }
            br.close();

        }catch (IOException e){

            e.printStackTrace();

        }
        return text.toString();

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Permission not granted", Toast.LENGTH_SHORT).show();
                finish();
            }
        }


    }
}

