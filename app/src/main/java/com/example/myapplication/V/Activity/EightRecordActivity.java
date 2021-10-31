package com.example.myapplication.V.Activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Set;


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

    int recordcount;

    int notchcount;

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
        notchcount=0;
        recordcount=0;
        dialog=new Dialog(EightRecordActivity.this);
        dialog.setContentView(R.layout.bluetooth_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DrawerLayout drawerLayout=findViewById(R.id.draver_eightrecord);
        btn=findViewById(R.id.note_eightrecord);
        line=findViewById(R.id.line_eightrecord);
        record=findViewById(R.id.record_eightrecord);
        replay=findViewById(R.id.replay_eightrecord);
        bluetooth=findViewById(R.id.bluetoooth_eightrecord);
        montage=findViewById(R.id.montage_eightrecord);
        notch=findViewById(R.id.notch_eightrecord);
        listView=dialog.findViewById(R.id.list);
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
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pared=bluetoothAdapter.getBondedDevices();
                ArrayList list=new ArrayList();
                for (BluetoothDevice bt:pared){
                    list.add(bt.getName());

                }
                ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);
                dialog.show();
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recordcount==0) {
                    record.setBackgroundResource(R.drawable.rect_stop_record);
                    recordcount=1;
                }
                else if(recordcount==1) {
                    record.setBackgroundResource(R.drawable.red_record_drawable);
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
    }

