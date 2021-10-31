package com.example.myapplication.V.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemAdvancedSettingAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemNotchAdapter;
import com.example.myapplication.M.Item.ItemAdvancedSetting;
import com.example.myapplication.M.Item.ItemNotch;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSettingActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    List<ItemAdvancedSetting> list1 = new ArrayList<>();
    ItemAdvancedSettingAdapter itemAdapter1;


    RecyclerView recyclerView2;
    List<ItemNotch> list2 = new ArrayList<>();
    ItemNotchAdapter itemAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_setting);



        recyclerView1 = findViewById(R.id.recycleadvancedsetting);
        itemAdapter1 = new ItemAdvancedSettingAdapter(list1, getApplicationContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);


        list1.add(new ItemAdvancedSetting("α","2048"));

        list1.add(new ItemAdvancedSetting("β","1.4"));

        list1.add(new ItemAdvancedSetting("TO DO","0.002"));




        itemAdapter1.notifyDataSetChanged();







    }
}
