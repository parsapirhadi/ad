package com.example.myapplication.V.Activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemSettingAdapter;
import com.example.myapplication.M.Item.ItemSetting;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<ItemSetting> list = new ArrayList<>();
    ItemSettingAdapter itemAdapter;
    Button back;
    Vibrator vibrator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        recyclerView = findViewById(R.id.recyclesetting);
        itemAdapter = new ItemSettingAdapter(list, SettingsActivity.this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);



        list.add(new ItemSetting(R.mipmap.notch_setting__foreground, "Filters"));
        list.add(new ItemSetting(R.drawable.replay_root_foreground, "Replay"));
        list.add(new ItemSetting(R.drawable.scale_root_foreground, "Scale"));
        list.add(new ItemSetting(R.drawable.montage_root_foreground, "Montage"));
        list.add(new ItemSetting(R.drawable.setting_foreground, "Advanced Setting"));




        itemAdapter.notifyDataSetChanged();



        back=findViewById(R.id.back_pointer_settings);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                vibrator.vibrate(40);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        vibrator.vibrate(40);
    }
}
