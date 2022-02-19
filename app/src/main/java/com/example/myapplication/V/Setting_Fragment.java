package com.example.myapplication.V;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.Item.ItemSetting;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemSettingAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Setting_Fragment extends Fragment  {
    Button gotoFragment2;

    RecyclerView recyclerView;
    List<ItemSetting> list = new ArrayList<>();
    ItemSettingAdapter itemAdapter;
    Button back;
    Vibrator vibrator;
    Objects objects;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        objects= new Objects();
        objects.setSettingView(view);


        recyclerView = view.findViewById(R.id.recyclesetting);
        itemAdapter = new ItemSettingAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);
      // vibrator= (Vibrator) view.getSystemService(Context.VIBRATOR_SERVICE);



      // list.add(new ItemSetting(R.mipmap.notch_setting__foreground, "Filters"));
        //list.add(new ItemSetting(R.drawable.replay_root_foreground, "Replay"));
        list.add(new ItemSetting(R.drawable.scale_root_foreground, "Scale"));
        list.add(new ItemSetting(R.drawable.montage_root_foreground, "Montage"));
       list.add(new ItemSetting(R.drawable.setting_foreground, "Advanced Setting"));




        itemAdapter.notifyDataSetChanged();









        return view;
    }



}