package com.example.myapplication.V.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemCustomMontageAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemMontageAdapter;
import com.example.myapplication.M.Item.ItemCustomMontage;
import com.example.myapplication.M.Item.ItemMontage;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MontageActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    List<ItemMontage> list1 = new ArrayList<>();
    ItemMontageAdapter itemAdapter1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montage);


        recyclerView1 = findViewById(R.id.recyclemontage);
        itemAdapter1 = new ItemMontageAdapter(list1, getApplicationContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);

        list1.add(new ItemMontage(true, "Mono",true, "Banana"));

        itemAdapter1.notifyDataSetChanged();










    }
}
