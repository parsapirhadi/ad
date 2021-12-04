package com.example.myapplication.V.Activity;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.R;
import com.example.myapplication.V.BaseSurfaceEightRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;


public class EightRecordActivity extends AppCompatActivity {
    Button btn;
    Button montage;
    Button line;
    ImageView notch;
    Button replay;
    Button record;
    Button resize;
    Button bluetooth;
    BluetoothAdapter bluetoothAdapter;
    ListView listView;
    Set<BluetoothDevice> pared;
    Dialog dialog;
    int recordcount=0;
    int notchcount=0;
    String bluetooth_name="";
    DrawerLayout drawerLayout;
    String1 string1 ;
    Counter counter;
    /////////////////////////////////////////////////
    Button listDevices;

    BaseSurfaceEightRecord msg_box;
    String tempMsg;
    TextView writeMsg;


    int channel =-1;
    boolean next_is_zarib=true;
    int zarib=0;

    BluetoothDevice[] btArray;

    SendReceive sendReceive;
    int q=0;
    int set_limit=0;

    float data=0;
    int g;

    int i=0;

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

    private BluetoothDevice device;
    private BluetoothSocket socket;

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
                    Toast.makeText(getApplicationContext(),"Connected To '"+bluetooth_name+"'", Toast.LENGTH_LONG).show();
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
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eightrecord);
        dialog=new Dialog(EightRecordActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        drawerLayout=findViewById(R.id.draver_eightrecord);
        counter=new Counter();
        string1=new String1();
        FindViewBiId();
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        for (int j2=0;j2<32;j2++){
            for (int j1=0;j1<800000;j1++) {
                counter.setChannel(1000, j2, j1);
            }
        }

        if(!bluetoothAdapter.isEnabled())
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
        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter==null){
            Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();
            finish();
        }
        if (bluetoothAdapter.isEnabled()){
        }

        implementListeners();

       }

    private void implementListeners() {

        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Set<BluetoothDevice> bt=bluetoothAdapter.getBondedDevices();
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

                        ClientClass clientClass=new ClientClass(btArray[i]);
                        bluetooth_name=strings[i]+"";
                        clientClass.start();


                    }
                });

            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recordcount==0) {
                    record.setBackgroundResource(R.drawable.rect_stop_record);
                    String string= "CONTB\r\n";
                    set_limit=1;
                    sendReceive.write(string.getBytes());
                    recordcount=1;
                }
                else if(recordcount==1) {
                    record.setBackgroundResource(R.drawable.red_record_drawable);
                    String string= "NOP\r\n";
                    set_limit=1;
                    sendReceive.write(string.getBytes());

                    recordcount=0;

                }
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
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EightRootActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        btn.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

    }

    private void FindViewBiId() {
        btn=findViewById(R.id.note_eightrecord);
        line=findViewById(R.id.line_eightrecord);
        record=findViewById(R.id.record_eightrecord);
        replay=findViewById(R.id.replay_eightrecord);
        bluetooth=findViewById(R.id.bluetoooth_eightrecord);
        montage=findViewById(R.id.montage_eightrecord);
        notch=findViewById(R.id.notch_eightrecord);
        listView=dialog.findViewById(R.id.list);
    }
    private class ClientClass extends Thread
    {

        public ClientClass (BluetoothDevice device1)
        {
            device=device1;

            try {
                socket=device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run()
        {
            try {

                socket.connect();

                Message message=Message.obtain();
                message.what=STATE_CONNECTED;
                handler.sendMessage(message);


                sendReceive=new SendReceive(socket);

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
                                if (channel==0) {
                                    channel=1;
                                    counter.setChannel((float) ((float) ((data - 2048) / 1.4)), 0, i/8);
                                }
                                else if (channel==1) {
                                    //    Log.e("gggggg",""+s);

                                    channel=2;

                                    counter.setChannel((float) ((float)  ((data - 2048) / 1.4)), 1, i/8);
                                } else if (channel==2) {
                                    channel=3;

                                    counter.setChannel((float) ((float)  ((data - 2048) / 1.4)), 2, i/8);

                                } else if (channel==3) {
                                    channel=4;

                                    counter.setChannel((float) ((float) ((data - 2048) / 1.4)), 3, i/8);

                                } else if (channel==4) {
                                    channel=5;

                                    counter.setChannel((float) ((float)  ((data - 2048) / 1.4)), 4, i/8);

                                }else if (channel==5) {
                                    channel=6;

                                    counter.setChannel((float) ((float) ((data - 2048) / 1.4)), 5, i/8);
                                } else if (channel==6) {
                                    channel=7;

                                    counter.setChannel((float) ((float)  ((data - 2048) / 1.4)), 6, i/8);

                                }else if (channel==7) {
                                    channel=0;

                                    counter.setChannel((float) ((float)  ((data - 2048) / 1.4)), 7, i/8);

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

