package com.example.myapplication.V.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemFilterAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemNotchAdapter;
import com.example.myapplication.M.Item.ItemFilter;
import com.example.myapplication.M.Item.ItemNotch;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    List<ItemFilter> list1 = new ArrayList<>();
    ItemFilterAdapter itemAdapter1;


    RecyclerView recyclerView2;
    List<ItemNotch> list2 = new ArrayList<>();
    ItemNotchAdapter itemAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        recyclerView1 = findViewById(R.id.recyclefilter);
        itemAdapter1 = new ItemFilterAdapter(list1, getApplicationContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);
        list1.add(new ItemFilter("Low Cut","0.5 Hz"));
        list1.add(new ItemFilter("Hight Cut","70 Hz"));
        itemAdapter1.notifyDataSetChanged();


        recyclerView2 = findViewById(R.id.recyclenotch);
        itemAdapter2 = new ItemNotchAdapter(list2, getApplicationContext());
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView2.setAdapter(itemAdapter2);
        list2.add(new ItemNotch(true,"50 Hz",true,"60 Hz"));
        itemAdapter1.notifyDataSetChanged();
    }
}
