package com.example.myapplication.V.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.Editable;

import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.R;
import com.example.myapplication.V.BaseSurfaceEightRecord;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;


public class EightRecordActivity extends AppCompatActivity {

    EditText ech2,ech3,ech4,ech5,ech6,ech7,ech8;
    Button bch1,bch2,bch3,bch4,bch5,bch6,bch7,bch8;

    static TextView ch[]=new TextView[65];

    public static TextView getCh1() {
        return ch[1];
    }

    TextInputEditText ech1;

    TextInputLayout lch1,lch2,lch3,lch4,lch5,lch6,lch7,lch8;

    Button cch1,cch2,cch3,cch4,cch5,cch6,cch7,cch8;

    String montageS;

    Animation animation1,animation2;
    Button btn;
    Button montage;
    Button line;
    ImageView notch;
    Button replay;
    Button zoomout;
    Button zoomin;
    Button record;
    String text_ch1="";
    Button resize;
    Button bluetooth;
    ListView listView;

    boolean animation_bluetooth=true;

    boolean set_dimens=true;

    Button check_circle1,check_circle2,check_circle3,check_circle4,check_circle5,check_circle6,check_circle7,check_circle8;


    Set<BluetoothDevice> pared;
    static Dialog dialog,dialog1,dialog2,dialog3,dialog4,dialog5,dialog6,dialog7,dialog8;




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

    int i=0;
    int o;

    boolean bb=false;
    boolean ggg=false;
    int byt=0;

    InputStream inputStream;
    OutputStream outputStream;



    int s;
    static final int STATE_LISTENING = 1;
    static final int STATE_CONNECTING=2;
    static final int STATE_CONNECTED=3;
    static final int STATE_CONNECTION_FAILED=4;
    static final int STATE_MESSAGE_RECEIVED=5;

    int REQUEST_ENABLE_BLUETOOTH=1;

    InputStream tempIn=null;
    OutputStream tempOut=null;
    boolean is_activity_on =true;



    private BluetoothDevice device;


    int y=0;

    private static final String APP_NAME = "BTChat";


    private static final UUID MY_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");////hc05
    //private static final UUID MY_UUID=UUID.fromString("8ce255c0-223a-11e0-ac64-0803450c9a66");////mobile

    Handler handler=new Handler(new Handler.Callback() {
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

                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Connected To '"+bluetooth_name+"'", Snackbar.LENGTH_LONG).show();
                    animation_bluetooth=false;


                    if (SingleRecordActivity.isRecordcount()){
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Log.e("is start", "is start");
                                record.setBackgroundResource(R.drawable.rect_stop_record);
                                String string = "CONTB\r\n";
                                set_limit = 1;
                                sendReceive = new EightRecordActivity.SendReceive(objects.getSocket());
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
                    record.setBackgroundResource(R.drawable.red_record_drawable);
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
    });

    @Override
    protected void onPause() {
        super.onPause();
        is_activity_on=false;

        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<9000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);

            }
        }

        is_activity_on=false;
        String string = "NOP\r\n";
        set_limit = 1;

        Log.e("EonPause","EonPause");


        if (objects.getSocket()!=null){
            try {
                sendReceive.write(string.getBytes());
                objects.getSocket().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        recordcount = 0;
        i=0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {

        super.onResume();
        Log.e("EonResume","EonResume");

        is_disconnected=false;

        is_activity_on=true;
        data_count=0;
        conter=0;
        is_connected=false;
        is_open=false;




        animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bluetooth_anim_1);
        animation2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bluetooth_anim_2);
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








        if (objects.getSocket()!=null){
            if (objects.getSocket().isConnected()){

            }
        }
        counter.setStartdraw(1);

        if (counter.isBluetooth_drawabe()){
            bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
        }

        counter.setEnddraw(counter.getHorizontal_scale()*counter.getRate_in_s());
        counter.setEight_step_x((float) counter.getSurface_width()/(counter.getRate_in_s()*counter.getHorizontal_scale()));



        V0.setText(""+0);
        V1000.setText(""+(float)(int)((125*counter.getHorizontal_scale()))/1000);
        V2000.setText(""+(float)(int)((2*125*counter.getHorizontal_scale()))/1000);
        V3000.setText(""+(float)(int)((3*125*counter.getHorizontal_scale()))/1000);
        V4000.setText(""+(float)(int)((4*125*counter.getHorizontal_scale()))/1000);
        V5000.setText(""+(float)(int)((5*125*counter.getHorizontal_scale()))/1000);
        V6000.setText(""+(float)(int)((6*125*counter.getHorizontal_scale()))/1000);
        V7000.setText(""+(float)(int)((7*125*counter.getHorizontal_scale()))/1000);
        V8000.setText(""+(float)(int)((8*125*counter.getHorizontal_scale()))/1000);
        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<9000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);

            }
        }
        i=0;

        if (string1.getPivote(0)!=null)
        {
            for (int y=0;y<counter.getDefault_channel();y++) {
                ch[y].setText(string1.getPivote(y));
            }

        }
        bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);

        try {
            for (int m=1;m<65;m++){
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("bch"+m, MODE_PRIVATE);
                ch[m].setText(sharedPreferences.getString("name","ch"+m).toString());

            }

        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (is_activity_on) {

                    //  Log.e("i=",""+i);
                    if ((i - data_count) < 200 && recordcount == 1 && objects.getSocket().isConnected()) {
                        conter++;
                        if (conter > 1) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    record.setBackgroundResource(R.drawable.red_record_drawable);
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
                                    Snackbar.make(parentLayout, "'" + "Bluetooth" + " Disconnected'", Snackbar.LENGTH_LONG).show();

                                    bluetooth.startAnimation(animation1);
                                    animation_bluetooth=true;


                                    bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);


                                }
                            });


                        }
                    }
                    if (objects.getSocket()!=null)
                    {
                        if (!objects.getSocket().isConnected()) {
                            Log.e("is true", "is true");
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
                    else {

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







                    data_count=i;
                    try {

                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                while (set_dimens) {
                    if (counter.getSurfaceviewheheight()>0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                int paint_screen=counter.getSurfaceview_height_record();
                                float button_step = (float) paint_screen / (((counter.getDefault_channel()) * 2));
                                int k=counter.getDefault_channel();
                                Toast.makeText(getApplicationContext(), "" + counter.getSurfaceviewheheight(), Toast.LENGTH_SHORT).show();


                                for (int o=0;o<counter.getDefault_channel();o++){
                                    Log.e(""+(float) (((2*o)+0.5) * button_step),""+(float) (((2*o)+0.5) * button_step));
                                    ch[o+1].setTranslationY((float) (((2*o)+0.5) * button_step));
                                }
                                for (int s=1;s<65;s++)
                                {
                                    ch[s].setTranslationY((float) ((float) ch[s].getTranslationY()-(0.5*button_step)));
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
                                //   findViewById(R.id.left_linearlayout_re).setTranslationY((float) (button_step*-1));



                            }
                        });
                        set_dimens=false;
                    }
                }
            }
        }).start();


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

        Log.e("EonCreate","EonCreate");


        drawerLayout=findViewById(R.id.draver_eightrecord);
        counter=new Counter();
        string1=new String1();
        objects=new Objects();

        i=0;
        FindViewBiId();
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        objects.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());

        counter.setEnddraw(counter.getHorizontal_scale()*counter.getRate_in_s());
        counter.setEight_step_x((float) counter.getSurfaceviewhewidth()/(counter.getRate_in_s()*counter.getHorizontal_scale()));

        counter.setEight_step_y((float) counter.getSurfaceviewhewidth()/200);
        counter.setEight_step_y((counter.getEight_step_y()/counter.getDefault_channel())/2);


        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<9000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);

            }
        }

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
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }

            }
        };
        registerReceiver(scanmodereceiver,scanintentFilter);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        objects.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());
        if (objects.getBluetoothAdapter()==null){
            Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();
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


        implementListeners();

    }
    public void mono(){
        try {


            for (int u=1;u<65;u++){

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("bch"+u, MODE_PRIVATE);
                ch[u].setText(sharedPreferences.getString("name","ch"+u).toString());


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

        }




    }


    private void implementListeners() {

        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                    for (int n=0;n<btArray.length;n++){
                        if (btArray[n].getName().charAt(0)=='H'  &&
                                btArray[n].getName().charAt(1)=='C' &&
                                btArray[n].getName().charAt(2)=='-' &&
                                btArray[n].getName().charAt(3)=='0' &&
                                btArray[n].getName().charAt(4)=='5'
                        ){

                            EightRecordActivity.ClientClass clientClass=new EightRecordActivity.ClientClass(btArray[n]);
                            bluetooth_name=strings[n]+"";
                            clientClass.start();
                        }
                    }
                }
                // dialog.show();







            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (objects.getSocket() != null ){
                    vibrator.vibrate(40);
                    if (recordcount == 0) {
                        record.setBackgroundResource(R.drawable.rect_stop_record);
                        String string = "CONTB\r\n";
                        set_limit = 1;
                        Recordcount=true;
                        SingleRecordActivity.setIs_isRecordcount(true);
                        sendReceive = new SendReceive(objects.getSocket());
                        sendReceive.write(string.getBytes());
                        recordcount = 1;

                    } else if (recordcount == 1) {
                        record.setBackgroundResource(R.drawable.red_record_drawable);
                        String string = "NOP\r\n";
                        Recordcount=false;
                        SingleRecordActivity.setIs_isRecordcount(false);
                        set_limit = 1;
                        sendReceive.write(string.getBytes());

                        recordcount = 0;
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
                    notch.setBackgroundResource(R.mipmap.notch_);
                    notchcount=1;
                }
                else if(notchcount==1) {
                    notch.setBackgroundResource(R.mipmap.notch_off_);
                    notchcount=0;


                }
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);

                startActivity(new Intent(getApplicationContext(),EightRootActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(70);
                startActivity(new Intent(getApplicationContext(),SingleRecordActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }
        });

        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(EightRecordActivity.this,montage);
                popup.getMenuInflater().inflate(R.menu.montage, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        montage.setText(menuItem.getTitle());
                        string1.setMontage(menuItem.getTitle().toString());


                        if (menuItem.getTitle().equals("mono")){
                            allow_rename=true;
                            mono();
                        }
                        else {
                            allow_rename=false;
                            banana();
                        }
                        return true;
                    }
                });
                popup.show();


            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counter.getEight_step_y()>0) {
                    vibrator.vibrate(40);
                    counter.setEight_step_y((float) ((float) (counter.getEight_step_y() -(counter.getDefault_channel()*(counter.getEight_step_y()/100)))));
                }
            }

        });
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(40);
                counter.setEight_step_y((float) (counter.getEight_step_y() +(counter.getDefault_channel()*(counter.getEight_step_y()/50))));



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





        zoomout=findViewById(R.id.zoomout_eightrecord);
        zoomin=findViewById(R.id.zoomin_eightrecord);

        parentLayout = findViewById(android.R.id.content);




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
                handler.sendMessage(message);


                sendReceive=new SendReceive(objects.getSocket());

                sendReceive.start();

            } catch (IOException e) {
                e.printStackTrace();
                Message message=Message.obtain();
                message.what=STATE_CONNECTION_FAILED;
                handler.sendMessage(message);
            }
        }
    }

    private class SendReceive extends Thread
    {
        private final BluetoothSocket bluetoothSocket;


        public SendReceive (BluetoothSocket socket)
        {

            bluetoothSocket=socket;


            try {
                tempIn=bluetoothSocket.getInputStream();
                tempOut=bluetoothSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            inputStream=tempIn;
            outputStream=tempOut;
        }

        public void run()
        {
            byte[] buffer=new byte[counter.getRate_in_s()];

            no_limit=80001-(counter.getHorizontal_scale()*counter.getRate_in_s()*3);
            while (is_activity_on)
            {

                try {

                    s=inputStream.read();

                } catch (IOException e) {

                    e.printStackTrace();
                    break;
                }
                // bytes =s;
                handler.obtainMessage(STATE_MESSAGE_RECEIVED, s, -1, buffer).sendToTarget();


                if (channel!=-1)
                {

                    if (next_is_zarib){
                        zarib=s;
                        next_is_zarib=false;

                    }
                    else {
                        next_is_zarib=true;
                        data=(zarib*256)+s;
                        if (zarib<255){
                            o=(i/counter.getDefault_channel())%(no_limit);




                            counter.setBuffer(((float) ((data - 2048) / 1.4)), channel, o);
                            channel++;

                            if (channel==counter.getDefault_channel()) {
                                channel=0;
                                counter.setRefresh(true);
                                counter.setBuffer( ((float)  ((data - 2048) / 1.4)), counter.getDefault_channel()-1, o);

                            }


                            i++;

                        }
                    }
                }
                if (s==255)
                {


                    y++;
                }



                if (y==1 && s<255){

                    y=0;
                }
                if (y==2)
                {
                    y=0;



                    channel=0;
                    next_is_zarib=true;
                }



            }
        }
        public void write(byte[] bytes)
        {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

