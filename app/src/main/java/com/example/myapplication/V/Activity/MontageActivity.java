package com.example.myapplication.V.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.Item.ItemCustomMontageEditor;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemCustomMontageEditorAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemMontageAdapter;
import com.example.myapplication.M.Item.ItemMontage;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MontageActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    List<ItemMontage> list1 = new ArrayList<>();
    ItemMontageAdapter itemAdapter1;
    Button back;


    RecyclerView recyclerView2;
    List<ItemCustomMontageEditor> list2 = new ArrayList<>();
    ItemCustomMontageEditorAdapter itemAdapter2;


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



        recyclerView2 = findViewById(R.id.custom_montage_editor);
        itemAdapter2 = new ItemCustomMontageEditorAdapter(list2, MontageActivity.this);
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView2.setAdapter(itemAdapter2);
        list2.add(new ItemCustomMontageEditor("Number of channels","8"));
        list2.add(new ItemCustomMontageEditor("Rename channels",""));

        list2.add(new ItemCustomMontageEditor("Montage Editor",""));



        itemAdapter1.notifyDataSetChanged();


        back=findViewById(R.id.back_pointer_montage);
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
