package com.example.myapplication.V.Activity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemReplayAdapter;
import com.example.myapplication.M.Item.ItemReplay;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ReplayActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<ItemReplay> list = new ArrayList<>();
    ItemReplayAdapter itemAdapter;
    PackageInfo info;
    Button back;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replay);
        recyclerView = findViewById(R.id.recyclereplay);
        itemAdapter = new ItemReplayAdapter(list, getApplicationContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);


        list.add(new ItemReplay("Speed", "2"));

        itemAdapter.notifyDataSetChanged();


        back=findViewById(R.id.back_pointer_replay);
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
