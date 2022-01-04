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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////  start

        SharedPreferences pref_start_1 = getApplicationContext().getSharedPreferences("bch1_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_1 = pref_start_1.edit();
        if (string1.getPivote_from(0) != null && string1.getPivote_from(0).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_1.putString("name", "" + string1.getPivote_from(0));
            editor_start_1.apply();
        }
        SharedPreferences pref_start_2 = getApplicationContext().getSharedPreferences("bch2_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_2 = pref_start_2.edit();
        if (string1.getPivote_from(1) != null && string1.getPivote_from(1).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_2.putString("name", "" + string1.getPivote_from(1));
            editor_start_2.apply();
        }
        SharedPreferences pref_start_3 = getApplicationContext().getSharedPreferences("bch3_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_3 = pref_start_3.edit();
        if (string1.getPivote_from(2) != null && string1.getPivote_from(2).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_3.putString("name", "" + string1.getPivote_from(2));
            editor_start_3.apply();
        }
        SharedPreferences pref_start_4 = getApplicationContext().getSharedPreferences("bch4_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_4 = pref_start_4.edit();
        if (string1.getPivote_from(3) != null && string1.getPivote_from(3).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_4.putString("name", "" + string1.getPivote_from(3));
            editor_start_4.apply();
        }
        SharedPreferences pref_start_5 = getApplicationContext().getSharedPreferences("bch5_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_5 = pref_start_5.edit();
        if (string1.getPivote_from(4) != null && string1.getPivote_from(4).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_5.putString("name", "" + string1.getPivote_from(4));
            editor_start_5.apply();
        }
        SharedPreferences pref_start_6 = getApplicationContext().getSharedPreferences("bch6_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_6 = pref_start_6.edit();
        if (string1.getPivote_from(5) != null && string1.getPivote_from(5).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_6.putString("name", "" + string1.getPivote_from(5));
            editor_start_6.apply();
        }
        SharedPreferences pref_start_7 = getApplicationContext().getSharedPreferences("bch7_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_7 = pref_start_7.edit();
        if (string1.getPivote_from(6) != null && string1.getPivote_from(6).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_7.putString("name", "" + string1.getPivote_from(6));
            editor_start_7.apply();
        }
        SharedPreferences pref_start_8 = getApplicationContext().getSharedPreferences("bch8_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_8 = pref_start_8.edit();
        if (string1.getPivote_from(7) != null && string1.getPivote_from(7).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_8.putString("name", "" + string1.getPivote_from(7));
            editor_start_8.apply();
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////  end

        SharedPreferences pref_end_1 = getApplicationContext().getSharedPreferences("bch1_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_1 = pref_end_1.edit();
        if (string1.getPivote_to(0) != null && string1.getPivote_to(0).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_1.putString("name", "" + string1.getPivote_to(0));
            editor_end_1.apply();
        }
        SharedPreferences pref_end_2 = getApplicationContext().getSharedPreferences("bch2_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_2 = pref_end_2.edit();
        if (string1.getPivote_to(1) != null && string1.getPivote_to(1).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_2.putString("name", "" + string1.getPivote_to(1));
            editor_end_2.apply();
        }
        SharedPreferences pref_end_3 = getApplicationContext().getSharedPreferences("bch3_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_3 = pref_end_3.edit();
        if (string1.getPivote_to(2) != null && string1.getPivote_to(2).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_3.putString("name", "" + string1.getPivote_to(2));
            editor_end_3.apply();
        }
        SharedPreferences pref_end_4 = getApplicationContext().getSharedPreferences("bch4_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_4 = pref_end_4.edit();
        if (string1.getPivote_to(3) != null && string1.getPivote_to(3).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_4.putString("name", "" + string1.getPivote_to(3));
            editor_end_4.apply();
        }
        SharedPreferences pref_end_5 = getApplicationContext().getSharedPreferences("bch5_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_5 = pref_end_5.edit();
        if (string1.getPivote_to(4) != null && string1.getPivote_to(4).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_5.putString("name", "" + string1.getPivote_to(4));
            editor_end_5.apply();
        }
        SharedPreferences pref_end_6 = getApplicationContext().getSharedPreferences("bch6_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_6 = pref_end_6.edit();
        if (string1.getPivote_to(5) != null && string1.getPivote_to(5).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_6.putString("name", "" + string1.getPivote_to(5));
            editor_end_6.apply();
        }
        SharedPreferences pref_end_7 = getApplicationContext().getSharedPreferences("bch7_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_7 = pref_end_7.edit();
        if (string1.getPivote_to(6) != null && string1.getPivote_to(6).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_7.putString("name", "" + string1.getPivote_to(6));
            editor_end_7.apply();
        }
        SharedPreferences pref_end_8 = getApplicationContext().getSharedPreferences("bch8_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_8 = pref_end_8.edit();
        if (string1.getPivote_to(7) != null && string1.getPivote_to(7).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_8.putString("name", "" + string1.getPivote_to(7));
            editor_end_8.apply();
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
                ""+getApplicationContext().getSharedPreferences("bch1_end", MODE_PRIVATE).getString("name","ch1")));

        list.add(new ItemMontageEditor("CH2",
                ""+getApplicationContext().getSharedPreferences("bch2_start", MODE_PRIVATE).getString("name","ch2"),
                ""+getApplicationContext().getSharedPreferences("bch2_end", MODE_PRIVATE).getString("name","ch2")));


        list.add(new ItemMontageEditor("CH3",
                ""+getApplicationContext().getSharedPreferences("bch3_start", MODE_PRIVATE).getString("name","ch3"),
                ""+getApplicationContext().getSharedPreferences("bch3_end", MODE_PRIVATE).getString("name","ch3")));

        list.add(new ItemMontageEditor("CH4",
                ""+getApplicationContext().getSharedPreferences("bch4_start", MODE_PRIVATE).getString("name","ch4"),
                ""+getApplicationContext().getSharedPreferences("bch4_end", MODE_PRIVATE).getString("name","ch4")));

        list.add(new ItemMontageEditor("CH5",
                ""+getApplicationContext().getSharedPreferences("bch5_start", MODE_PRIVATE).getString("name","ch5"),
                ""+getApplicationContext().getSharedPreferences("bch5_end", MODE_PRIVATE).getString("name","ch5")));

        list.add(new ItemMontageEditor("CH6",
                ""+getApplicationContext().getSharedPreferences("bch6_start", MODE_PRIVATE).getString("name","ch6"),
                ""+getApplicationContext().getSharedPreferences("bch6_end", MODE_PRIVATE).getString("name","ch6")));

        list.add(new ItemMontageEditor("CH7",
                ""+getApplicationContext().getSharedPreferences("bch7_start", MODE_PRIVATE).getString("name","ch7"),
                ""+getApplicationContext().getSharedPreferences("bch7_end", MODE_PRIVATE).getString("name","ch7")));

        list.add(new ItemMontageEditor("CH8",
                ""+getApplicationContext().getSharedPreferences("bch8_start", MODE_PRIVATE).getString("name","ch8"),
                ""+getApplicationContext().getSharedPreferences("bch8_end", MODE_PRIVATE).getString("name","ch8")));




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

