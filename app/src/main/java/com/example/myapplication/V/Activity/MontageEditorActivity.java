package com.example.myapplication.V.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemMontageEditor;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemMontageEditorAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemScaleAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MontageEditorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ItemMontageEditor> list = new ArrayList<>();
    ItemMontageEditorAdapter itemAdapter;

    Counter counter;
    Button back;
    String1 string1;


    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref1 = getApplicationContext().getSharedPreferences("bch1_start", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = pref1.edit();
        if (string1.getPivote_from(0) != null && string1.getPivote_from(0).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor1.putString("name", "" + string1.getPivote_from(0));
            editor1.apply();
        }
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("bch2_start", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref2.edit();
        if (string1.getPivote_from(1) != null && string1.getPivote_from(1).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor2.putString("name", "" + string1.getPivote_from(1));
            editor2.apply();
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("bch3_start", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        if (string1.getPivote_from(2) != null && string1.getPivote_from(2).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor3.putString("name", "" + string1.getPivote_from(2));
            editor3.apply();
        }
        SharedPreferences pref4 = getApplicationContext().getSharedPreferences("bch4_start", MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        if (string1.getPivote_from(3) != null && string1.getPivote_from(3).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor4.putString("name", "" + string1.getPivote_from(3));
            editor4.apply();
        }
        SharedPreferences pref5 = getApplicationContext().getSharedPreferences("bch5_start", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = pref5.edit();
        if (string1.getPivote_from(4) != null && string1.getPivote_from(4).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor5.putString("name", "" + string1.getPivote_from(4));
            editor5.apply();
        }
        SharedPreferences pref6 = getApplicationContext().getSharedPreferences("bch6_start", MODE_PRIVATE);
        SharedPreferences.Editor editor6 = pref6.edit();
        if (string1.getPivote_from(5) != null && string1.getPivote_from(5).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor6.putString("name", "" + string1.getPivote_from(5));
            editor6.apply();
        }
        SharedPreferences pref7 = getApplicationContext().getSharedPreferences("bch7_start", MODE_PRIVATE);
        SharedPreferences.Editor editor7 = pref7.edit();
        if (string1.getPivote_from(6) != null && string1.getPivote_from(6).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor7.putString("name", "" + string1.getPivote_from(6));
            editor7.apply();
        }
        SharedPreferences pref8 = getApplicationContext().getSharedPreferences("bch8_start", MODE_PRIVATE);
        SharedPreferences.Editor editor8 = pref8.edit();
        if (string1.getPivote_from(7) != null && string1.getPivote_from(7).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor8.putString("name", "" + string1.getPivote_from(7));
            editor8.apply();
        }



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montage_editor);
        counter=new Counter();
        string1=new String1();
        recyclerView = findViewById(R.id.recycler_montage_editor);
        itemAdapter = new ItemMontageEditorAdapter(list, getApplicationContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);


        list.add(new ItemMontageEditor("CH1",
                ""+getApplicationContext().getSharedPreferences("bch1_start", MODE_PRIVATE).getString("name","ch1"),
                ""+getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name","ch1")));

        list.add(new ItemMontageEditor("CH2",
                ""+getApplicationContext().getSharedPreferences("bch2_start", MODE_PRIVATE).getString("name","ch2"),
                ""+getApplicationContext().getSharedPreferences("bch2_start", MODE_PRIVATE).getString("name","ch2")));


        list.add(new ItemMontageEditor("CH3",
                ""+getApplicationContext().getSharedPreferences("bch3_start", MODE_PRIVATE).getString("name","ch3"),
                ""+getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name","ch3")));

        list.add(new ItemMontageEditor("CH4",
                ""+getApplicationContext().getSharedPreferences("bch4_start", MODE_PRIVATE).getString("name","ch4"),
                ""+getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name","ch4")));

        list.add(new ItemMontageEditor("CH5",
                ""+getApplicationContext().getSharedPreferences("bch5_start", MODE_PRIVATE).getString("name","ch5"),
                ""+getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name","ch5")));

        list.add(new ItemMontageEditor("CH6",
                ""+getApplicationContext().getSharedPreferences("bch6_start", MODE_PRIVATE).getString("name","ch6"),
                ""+getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name","ch6")));

        list.add(new ItemMontageEditor("CH7",
                ""+getApplicationContext().getSharedPreferences("bch7_start", MODE_PRIVATE).getString("name","ch7"),
                ""+getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name","ch7")));

        list.add(new ItemMontageEditor("CH8",
                ""+getApplicationContext().getSharedPreferences("bch8_start", MODE_PRIVATE).getString("name","ch8"),
                ""+getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name","ch8")));




        itemAdapter.notifyDataSetChanged();


        back=findViewById(R.id.back_pointer_montage_editor);
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

