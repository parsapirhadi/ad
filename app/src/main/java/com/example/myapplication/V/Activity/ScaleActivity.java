package com.example.myapplication.V.Activity;

import android.content.pm.PackageInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemScaleAdapter;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ScaleActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        List<ItemScale> list = new ArrayList<>();
        ItemScaleAdapter itemAdapter;
        PackageInfo info;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.scale);
            recyclerView = findViewById(R.id.recyclerscale);
            itemAdapter = new ItemScaleAdapter(list, getApplicationContext());
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setAdapter(itemAdapter);


            list.add(new ItemScale("Horizontal Scale","8 sec per page"));
            list.add(new ItemScale("EEG Sensivity","70µV per page"));

            itemAdapter.notifyDataSetChanged();
        }
    }


