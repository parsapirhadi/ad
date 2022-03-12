package com.example.myapplication.V.Activity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemScaleAdapter;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ScaleActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        List<ItemScale> list = new ArrayList<>();
        ItemScaleAdapter itemAdapter;

        Counter counter;
    Button back;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.scale);
            counter=new Counter();
            recyclerView = findViewById(R.id.recyclerscale);
            itemAdapter = new ItemScaleAdapter(list, getApplicationContext());
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setAdapter(itemAdapter);


            list.add(new ItemScale("Horizontal Scale",(int)counter.getHorizontal_scale()+" sec per page"));
            list.add(new ItemScale("EEG Sensivity","70µV per page"));


            itemAdapter.notifyDataSetChanged();


            back=findViewById(R.id.back_pointer_scale);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onBackPressed();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
            });
        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
    }


