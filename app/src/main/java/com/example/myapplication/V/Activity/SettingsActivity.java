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



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        
    }
}
