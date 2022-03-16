package com.example.myapplication.V;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemSetting;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemSettingAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.V.Activity.CustomDrawerLayout.dismissDrawerlayout;
import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.dismissmenu;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;


public class Setting_Fragment extends Fragment  {
    Button gotoFragment2;

    RecyclerView recyclerView;
    List<ItemSetting> list = new ArrayList<>();
    ItemSettingAdapter itemAdapter;
    Button back;
    Vibrator vibrator;
    Objects objects;

    String1 string1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        objects= new Objects();
        string1=new String1();
        objects.setSettingView(view);


        recyclerView = view.findViewById(R.id.recyclesetting);
        itemAdapter = new ItemSettingAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);
      // vibrator= (Vibrator) view.getSystemService(Context.VIBRATOR_SERVICE);



      list.add(new ItemSetting(R.drawable.notch_on, "Filters"));
        //list.add(new ItemSetting(R.drawable.replay_root_foreground, "Replay"));
        list.add(new ItemSetting(R.drawable.scale_root_foreground, "Scale"));
        list.add(new ItemSetting(R.drawable.montage_root_foreground, "Montage"));
       list.add(new ItemSetting(R.drawable.setting_foreground, "Advanced Setting"));


        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion()+""+string1.getVersionId());



        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                if (menuDialog.isShowing()) {
                    menuDialog.dismiss();
                }

                if (drawerLayoutDialog.isShowing()) {

                }
                drawerLayoutDialog.dismiss();
            }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
        }



        });

        itemAdapter.notifyDataSetChanged();









        return view;
    }



}