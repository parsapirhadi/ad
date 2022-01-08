package com.example.myapplication.V.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemRename;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemRenameAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemScaleAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


/*
SharedPreferences pref = getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putString("name","7459");
    editor.apply();



    SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE);
    ch1.setText(sharedPreferences.getString("name",null).toString());


*/

public class RenameChannelsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ItemRename> list = new ArrayList<>();
    ItemRenameAdapter itemAdapter;
    Counter counter;
    String1 string1;

    Button back;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pref1 = getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = pref1.edit();
        if (string1.getPivote(0)!=null && string1.getPivote(0).length()<4 && string1.getPivote(0).length()!=0) {
            editor1.putString("name", "" + string1.getPivote(0));
            editor1.apply();
        }
        SharedPreferences pref2 = getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref2.edit();
        if (string1.getPivote(1)!=null && string1.getPivote(1).length()<4 && string1.getPivote(0).length()!=0) {
            editor2.putString("name", "" + string1.getPivote(1));
            editor2.apply();
        }
        SharedPreferences pref3 = getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        if (string1.getPivote(2)!=null && string1.getPivote(2).length()<4 && string1.getPivote(0).length()!=0) {
            editor3.putString("name", "" + string1.getPivote(2));
            editor3.apply();
        }
        SharedPreferences pref4 = getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        if (string1.getPivote(3)!=null && string1.getPivote(3).length()<4 && string1.getPivote(0).length()!=0) {
            editor4.putString("name", "" + string1.getPivote(3));
            editor4.apply();
        }
        SharedPreferences pref5 = getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = pref5.edit();
        if (string1.getPivote(4)!=null && string1.getPivote(4).length()<4 && string1.getPivote(0).length()!=0) {
            editor5.putString("name", "" + string1.getPivote(4));
            editor5.apply();
        }
        SharedPreferences pref6 = getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE);
        SharedPreferences.Editor editor6 = pref6.edit();
        if (string1.getPivote(5)!=null && string1.getPivote(5).length()<4 && string1.getPivote(0).length()!=0) {
            editor6.putString("name", "" + string1.getPivote(5));
            editor6.apply();
        }
        SharedPreferences pref7 = getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE);
        SharedPreferences.Editor editor7 = pref7.edit();
        if (string1.getPivote(6)!=null && string1.getPivote(6).length()<4 && string1.getPivote(0).length()!=0) {
            editor7.putString("name", "" + string1.getPivote(7));
            editor7.apply();
        }
        SharedPreferences pref8 = getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE);
        SharedPreferences.Editor editor8 = pref8.edit();
        if (string1.getPivote(7)!=null && string1.getPivote(7).length()<4 && string1.getPivote(0).length()!=0) {
            editor8.putString("name", "" + string1.getPivote(7));
            editor8.apply();
        }






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rename_channel);

        string1=new String1();
        counter=new Counter();
        recyclerView = findViewById(R.id.recyclerename_channel);
        itemAdapter = new ItemRenameAdapter(list, getApplicationContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);




        list.add(new ItemRename("CH1",""+getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name","ch1")));
        list.add(new ItemRename("CH2",""+getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE).getString("name","ch2")));
        list.add(new ItemRename("CH3",""+getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name","ch3")));
        list.add(new ItemRename("CH4",""+getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name","ch4")));
        list.add(new ItemRename("CH5",""+getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name","ch5")));
        list.add(new ItemRename("CH6",""+getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name","ch6")));
        list.add(new ItemRename("CH7",""+getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name","ch7")));
        list.add(new ItemRename("CH8",""+getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name","ch8")));



        itemAdapter.notifyDataSetChanged();


        back=findViewById(R.id.back_pointer_renamechannel);
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


