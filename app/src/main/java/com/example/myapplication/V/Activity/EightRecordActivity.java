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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.Editable;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;


public class EightRecordActivity extends AppCompatActivity {
    static TextView  ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8;
    EditText ech1,ech2,ech3,ech4,ech5,ech6,ech7,ech8;
    Button bch1,bch2,bch3,bch4,bch5,bch6,bch7,bch8;



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

    Set<BluetoothDevice> pared;
    Dialog dialog,dialog1,dialog2,dialog3,dialog4,dialog5,dialog6,dialog7,dialog8;

    boolean is_connected=false;
    boolean is_open=false;

    boolean is_disconnected=false;


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

    public static TextView getCh1() {
        return ch1;
    }

    public static TextView getCh2() {
        return ch2;
    }

    public static TextView getCh3() {
        return ch3;
    }

    public static TextView getCh4() {
        return ch4;
    }

    public static TextView getCh5() {
        return ch5;
    }

    public static TextView getCh6() {
        return ch6;
    }

    public static TextView getCh7() {
        return ch7;
    }

    public static TextView getCh8() {
        return ch8;
    }

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
            for (int j1=0;j1<80000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
                counter.setBuffer_clone(counter.getPart_data(), j2, j1);
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
            for (int j1=0;j1<80000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
                counter.setBuffer_clone(counter.getPart_data(), j2, j1);
            }
        }
        i=0;

if (string1.getPivote(0)!=null)
{
    ch1.setText(string1.getPivote(0));
    ch2.setText(string1.getPivote(1));
    ch3.setText(string1.getPivote(2));
    ch4.setText(string1.getPivote(3));
    ch5.setText(string1.getPivote(4));
    ch6.setText(string1.getPivote(5));
    ch7.setText(string1.getPivote(6));
    ch8.setText(string1.getPivote(7));
}
        bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);


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
            for (int j1=0;j1<80000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
                counter.setBuffer_clone(counter.getPart_data(), j2, j1);
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
                                    bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);
                                  /*

                                   while (true)
                                   {


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

                                                   SingleRecordActivity.ClientClass clientClass=new SingleRecordActivity.ClientClass(btArray[n]);
                                                   bluetooth_name=strings[n]+"";
                                                   clientClass.start();
                                               }
                                           }

                                       }


                                   }

                                   */
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
                        if (objects.getSocket().isConnected()) {
                            record.setBackgroundResource(R.drawable.rect_stop_record);
                            String string = "CONTB\r\n";
                            set_limit = 1;
                            sendReceive = new EightRecordActivity.SendReceive(objects.getSocket());
                            sendReceive.write(string.getBytes());
                            recordcount = 1;
                        }
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



        implementListeners();

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
                    sendReceive = new SendReceive(objects.getSocket());
                    sendReceive.write(string.getBytes());
                    recordcount = 1;

                } else if (recordcount == 1) {
                    record.setBackgroundResource(R.drawable.red_record_drawable);
                    String string = "NOP\r\n";
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


        ch1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog1.show();
                return false;
            }
        });
        ch2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog2.show();
                return false;
            }
        });
        ch3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog3.show();
                return false;
            }
        });
        ch4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog4.show();
                return false;
            }
        });
        ch5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog5.show();
                return false;
            }
        });
        ch6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog6.show();
                return false;
            }
        });
        ch7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog7.show();
                return false;
            }
        });
        ch8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(30);
                dialog8.show();
                return false;
            }
        });


bch1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ch1.setText(ech1.getText().toString());
        dialog1.dismiss();
    }
});
        bch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch2.setText(ech2.getText().toString());
                dialog2.dismiss();
            }
        });
        bch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch3.setText(ech3.getText().toString());
                dialog3.dismiss();
            }
        });
        bch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch4.setText(ech4.getText().toString());
                dialog4.dismiss();
            }
        });
        bch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch5.setText(ech5.getText().toString());
                dialog5.dismiss();
            }
        });
        bch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch6.setText(ech6.getText().toString());
                dialog6.dismiss();
            }
        });
        bch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch7.setText(ech7.getText().toString());
                dialog7.dismiss();
            }
        });
        bch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch8.setText(ech8.getText().toString());
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

        ech1=dialog1.findViewById(R.id.edittext1);
        ech2=dialog2.findViewById(R.id.edittext2);
        ech3=dialog3.findViewById(R.id.edittext3);
        ech4=dialog4.findViewById(R.id.edittext4);
        ech5=dialog5.findViewById(R.id.edittext5);
        ech6=dialog6.findViewById(R.id.edittext6);
        ech7=dialog7.findViewById(R.id.edittext7);
        ech8=dialog8.findViewById(R.id.edittext8);


        bch1=dialog1.findViewById(R.id.save_renamech1);
        bch2=dialog2.findViewById(R.id.save_renamech2);
        bch3=dialog3.findViewById(R.id.save_renamech3);
        bch4=dialog4.findViewById(R.id.save_renamech4);
        bch5=dialog5.findViewById(R.id.save_renamech5);
        bch6=dialog6.findViewById(R.id.save_renamech6);
        bch7=dialog7.findViewById(R.id.save_renamech7);
        bch8=dialog8.findViewById(R.id.save_renamech8);



        V0=findViewById(R.id.SM1_0);
        V1000=findViewById(R.id.SM1_1000);
        V2000=findViewById(R.id.SM1_2000);
        V3000=findViewById(R.id.SM1_3000);
        V4000=findViewById(R.id.SM1_4000);
        V5000=findViewById(R.id.SM1_5000);
        V6000=findViewById(R.id.SM1_6000);
        V7000=findViewById(R.id.SM1_7000);
        V8000=findViewById(R.id.SM1_8000);


        ch1=findViewById(R.id.ch1);
        ch2=findViewById(R.id.ch2);
        ch3=findViewById(R.id.ch3);
        ch4=findViewById(R.id.ch4);
        ch5=findViewById(R.id.ch5);
        ch6=findViewById(R.id.ch6);
        ch7=findViewById(R.id.ch7);
        ch8=findViewById(R.id.ch8);


        zoomout=findViewById(R.id.zoomout_eightrecord);
        zoomin=findViewById(R.id.zoomin_eightrecord);

        parentLayout = findViewById(android.R.id.content);

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
            byte[] buffer=new byte[512];

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
                                   o=(i/8)%(no_limit);

                                   if (channel==0) {

                                    channel=1;
                                    counter.setBuffer(((float) ((data - 2048) / 1.4)), 0, o);
                                }
                                else if (channel==1) {
                                    //    Log.e("gggggg",""+s);

                                    channel=2;

                                    counter.setBuffer(((float)  ((data - 2048) / 1.4)), 1, o);
                                } else if (channel==2) {
                                    channel=3;

                                    counter.setBuffer( ((float)  ((data - 2048) / 1.4)), 2, o);

                                } else if (channel==3) {
                                    channel=4;

                                    counter.setBuffer(((float) ((data - 2048) / 1.4)), 3, o);

                                } else if (channel==4) {
                                    channel=5;

                                    counter.setBuffer(((float)  ((data - 2048) / 1.4)), 4, o);

                                }else if (channel==5) {
                                    channel=6;

                                    counter.setBuffer( ((float) ((data - 2048) / 1.4)), 5, o);
                                } else if (channel==6) {
                                    channel=7;

                                    counter.setBuffer(((float)  ((data - 2048) / 1.4)), 6, o);

                                }else if (channel==7) {
                                    channel=0;
                                    counter.setRefresh(true);
                                    counter.setBuffer( ((float)  ((data - 2048) / 1.4)), 7, o);

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

