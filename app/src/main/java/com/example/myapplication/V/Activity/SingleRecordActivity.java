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
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
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
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class SingleRecordActivity extends AppCompatActivity {






    BluetoothAdapter bluetoothAdapter;


    Dialog dialog;

    /////////////////////////////////////////////////
    TextView ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8;
    EditText ech1,ech2,ech3,ech4,ech5,ech6,ech7,ech8;
    Button bch1,bch2,bch3,bch4,bch5,bch6,bch7,bch8;
    Button choise;
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

    TextView textplay,row100,row50,row_100,row_50,row0;

    int recordcount=0;
    int notchcount=0;
    String bluetooth_name="";
    DrawerLayout drawerLayout;
    String1 string1 ;
    Objects objects;
    Counter counter;
    /////////////////////////////////////////////////
    Button listDevices;


    static TextView V0_,V1000_,V2000_,V3000_,V4000_,V5000_,V6000_,V7000_,V8000_;


    BaseSurfaceEightRecord msg_box;
    String tempMsg;
    TextView writeMsg;
    Vibrator vibrator;
    float pivote50=50;
    float pivote100=100;
    float pivote_50=-50;
    float pivote_100=-100;

    int channel =-1;
    boolean next_is_zarib=true;
    int zarib=0;

    BluetoothDevice[] btArray;

    static SingleRecordActivity.SendReceive sendReceive;
    int q=0;
    int set_limit=0;

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
        return V0_;
    }public static TextView getV1000() {
        return V1000_;
    }public static TextView getV2000() {
        return V2000_;
    } public static TextView getV3000() {
        return V3000_;
    } public static TextView getV4000() {
        return V4000_;
    } public static TextView getV5000() {
        return V5000_;
    } public static TextView getV6000() {
        return V6000_;
    } public static TextView getV7000() {
        return V7000_;
    } public static TextView getV8000() {
        return V8000_;
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
                    bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Connected To '"+bluetooth_name+"'", Snackbar.LENGTH_LONG).show();
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


        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<80000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
                counter.setBuffer_clone(counter.getPart_data(), j2, j1);
            }
        }


        String string = "NOP\r\n";
        set_limit = 1;



        if (objects.getSocket()!=null){
            try {
                sendReceive.write(string.getBytes());
                //  objects.getSocket().close();
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
        if (objects.getSocket()!=null){
            if (objects.getSocket().isConnected()){
                bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);
            }
        }
        counter.setStartdraw(1);



        counter.setSingle_step_x((float) counter.getSurface_width()/(500*counter.getHorizontal_scale()));
        counter.setSingle_step_y((float) counter.getSurface_height()/200);

        V0_.setText(""+0);
        V1000_.setText(""+(float)(int)((125*counter.getHorizontal_scale()))/1000);
        V2000_.setText(""+(float)(int)((2*125*counter.getHorizontal_scale()))/1000);
        V3000_.setText(""+(float)(int)((3*125*counter.getHorizontal_scale()))/1000);
        V4000_.setText(""+(float)(int)((4*125*counter.getHorizontal_scale()))/1000);
        V5000_.setText(""+(float)(int)((5*125*counter.getHorizontal_scale()))/1000);
        V6000_.setText(""+(float)(int)((6*125*counter.getHorizontal_scale()))/1000);
        V7000_.setText(""+(float)(int)((7*125*counter.getHorizontal_scale()))/1000);
        V8000_.setText(""+(float)(int)((8*125*counter.getHorizontal_scale()))/1000);
        for (int j2=0;j2<8;j2++){
            for (int j1=0;j1<80000;j1++) {
                counter.setBuffer(counter.getPart_data(), j2, j1);
                counter.setBuffer_clone(counter.getPart_data(), j2, j1);
            }
        }
        i=0;
counter.setShow_record_ch(0);

        if (objects.getSocket()!=null){
            record.setBackgroundResource(R.drawable.rect_stop_record);
            String string = "CONTB\r\n";
            set_limit = 1;
            sendReceive = new SingleRecordActivity.SendReceive(objects.getSocket());
            sendReceive.write(string.getBytes());
            recordcount = 1;
        }



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
        setContentView(R.layout.singlerecord);
        notchcount=0;
        recordcount=0;
        dialog=new Dialog(SingleRecordActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        drawerLayout=findViewById(R.id.draver_singlerecord);
        counter=new Counter();
        string1=new String1();
        objects=new Objects();


        i=0;
        FindViewById();
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        objects.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());

        counter.setEnddraw(counter.getHorizontal_scale()*counter.getRate_in_s());
        counter.setEight_step_x((float) counter.getSurfaceviewhewidth()/(counter.getRate_in_s()*counter.getHorizontal_scale()));

        counter.setEight_step_y((float) counter.getSurfaceviewhewidth()/200);
        counter.setEight_step_y((counter.getEight_step_y()/counter.getDefault_channel())/2);
        choise.setText(EightRecordActivity.getCh1().getText().toString());

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
                        bluetooth.setBackgroundResource(R.drawable.bluetooth_on_foreground);

                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
                    {

                    }else if (modevalue==BluetoothAdapter.SCAN_MODE_NONE)
                    {
                        bluetooth.setBackgroundResource(R.drawable.bluetooth_off_foreground);


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
                }
                dialog.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        SingleRecordActivity.ClientClass clientClass=new SingleRecordActivity.ClientClass(btArray[i]);
                        bluetooth_name=strings[i]+"";
                        clientClass.start();


                    }
                });

            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (objects.getSocket() != null ) {
                    vibrator.vibrate(40);
                    if (recordcount == 0) {
                        record.setBackgroundResource(R.drawable.rect_stop_record);
                        String string = "CONTB\r\n";
                        set_limit = 1;
                        sendReceive = new SingleRecordActivity.SendReceive(objects.getSocket());
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
        montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(SingleRecordActivity.this,montage);
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
                startActivity(new Intent(getApplicationContext(),EightRecordActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                vibrator.vibrate(70);
                finish();


            }
        });

        DrawerLayout drawerLayout=findViewById(R.id.draver_singlerecord);
        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

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


        choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                record.setBackgroundResource(R.drawable.red_record_drawable);
                String string = "NOP\r\n";
                set_limit = 1;
                sendReceive.write(string.getBytes());
                recordcount = 0;

                PopupMenu popup = new PopupMenu(SingleRecordActivity.this,montage);
                popup.getMenuInflater().inflate(R.menu.choose_channel, popup.getMenu());


                string1.setPivote(0,EightRecordActivity.getCh1().getText().toString());
                string1.setPivote(1,EightRecordActivity.getCh2().getText().toString());
                string1.setPivote(2,EightRecordActivity.getCh3().getText().toString());
                string1.setPivote(3,EightRecordActivity.getCh4().getText().toString());
                string1.setPivote(4,EightRecordActivity.getCh5().getText().toString());
                string1.setPivote(5,EightRecordActivity.getCh6().getText().toString());
                string1.setPivote(6,EightRecordActivity.getCh7().getText().toString());
                string1.setPivote(7,EightRecordActivity.getCh8().getText().toString());





                popup.getMenu().add(string1.getPivote(0));

                popup.getMenu().add(string1.getPivote(1));
                popup.getMenu().add(string1.getPivote(2));
                popup.getMenu().add(string1.getPivote(3));
                popup.getMenu().add(string1.getPivote(4));
                popup.getMenu().add(string1.getPivote(5));
                popup.getMenu().add(string1.getPivote(6));
                popup.getMenu().add(string1.getPivote(7));







                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        choise.setText(menuItem.getTitle());
                        record.setBackgroundResource(R.drawable.rect_stop_record);
                        String string = "CONTB\r\n";
                        set_limit = 1;
                        sendReceive = new SingleRecordActivity.SendReceive(objects.getSocket());
                        sendReceive.write(string.getBytes());
                        recordcount = 1;
                        if (menuItem.getTitle() == string1.getPivote(0)) {
                            counter.setShow_record_ch(0);
                        }
                        if (menuItem.getTitle() == string1.getPivote(1)) {
                            counter.setShow_record_ch(1);
                        }
                        if (menuItem.getTitle() == string1.getPivote(2)) {
                            counter.setShow_record_ch(2);
                        }
                        if (menuItem.getTitle() == string1.getPivote(3)) {
                            counter.setShow_record_ch(3);
                        }
                        if (menuItem.getTitle() == string1.getPivote(4)) {
                            counter.setShow_record_ch(4);
                        }
                        if (menuItem.getTitle() == string1.getPivote(5)) {
                            counter.setShow_record_ch(5);
                        }
                        if (menuItem.getTitle() == string1.getPivote(6)) {
                            counter.setShow_record_ch(6);
                        }
                        if (menuItem.getTitle() == string1.getPivote(7)) {
                            counter.setShow_record_ch(7);
                        }


                        return true;
                    }
                });

                                popup.show();

//////////////
            }
        });
    }

    private void FindViewById() {
        line=findViewById(R.id.line_singlerecord);
        btn=findViewById(R.id.note_singlerecord);
        record=findViewById(R.id.record_singlerecord);
        notch=findViewById(R.id.notch_singlerecord);
        bluetooth=findViewById(R.id.bluetoooth_singlerecord);
        montage=findViewById(R.id.montage_singlerecord);
        listView=dialog.findViewById(R.id.list_device);

        V0_=findViewById(R.id.SS_0rec);
        V1000_=findViewById(R.id.SS_1000rec);
        V2000_=findViewById(R.id.SS_2000rec);
        V3000_=findViewById(R.id.SS_3000rec);
        V4000_=findViewById(R.id.SS_4000rec);
        V5000_=findViewById(R.id.SS_5000rec);
        V6000_=findViewById(R.id.SS_6000rec);
        V7000_=findViewById(R.id.SS_7000rec);
        V8000_=findViewById(R.id.SS_8000rec);



        row100=findViewById(R.id.VS100rec);
        row50=findViewById(R.id.VS50rec);
        row0=findViewById(R.id.VS0rec);
        row_50=findViewById(R.id.VS_50rec);
        row_100=findViewById(R.id.VS_100rec);

        choise=findViewById(R.id.choise_channel_record);

        zoomout=findViewById(R.id.zoomout_singlerecord);
        zoomin=findViewById(R.id.zoomin_singlerecord);
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


                sendReceive=new SingleRecordActivity.SendReceive(objects.getSocket());

                sendReceive.start();

            } catch (IOException e) {
                e.printStackTrace();
                Message message=Message.obtain();
                message.what=STATE_CONNECTION_FAILED;
                handler.sendMessage(message);
            }
        }
    }

    public class SendReceive extends Thread
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


            while (true)
            {

                try {

                    s=inputStream.read();
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
                                o=(i/8)%80000;
                                Log.e("i=", "" + o);
                                if (channel==0) {
                                    channel=1;
                                    counter.setBuffer(((float) ((data - 2048) / 1.4)), 0,o);
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
                    if (y==2)
                    {
                        channel=0;
                        next_is_zarib=true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
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
