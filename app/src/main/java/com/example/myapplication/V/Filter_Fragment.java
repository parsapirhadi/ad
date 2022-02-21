package com.example.myapplication.V;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.M.Item.ItemFilter;
import com.example.myapplication.M.Item.ItemNotch;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemFilterAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemNotchAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;

public class Filter_Fragment extends Fragment {


    RecyclerView recyclerView1;
    List<ItemFilter> list1 = new ArrayList<>();
    ItemFilterAdapter itemAdapter1;
    Button back;


    RecyclerView recyclerView2;
    List<ItemNotch> list2 = new ArrayList<>();
    ItemNotchAdapter itemAdapter2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_fragment, container, false);


        recyclerView1 = view.findViewById(R.id.recyclefilter);
        itemAdapter1 = new ItemFilterAdapter(list1, getContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);
        list1.add(new ItemFilter("Low Cut","0.5 Hz"));
        list1.add(new ItemFilter("Hight Cut","70 Hz"));
        itemAdapter1.notifyDataSetChanged();


        recyclerView2 = view.findViewById(R.id.recyclenotch);
        itemAdapter2 = new ItemNotchAdapter(list2, getContext());
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView2.setAdapter(itemAdapter2);
        list2.add(new ItemNotch(true,"50 Hz",true,"60 Hz"));
        itemAdapter1.notifyDataSetChanged();


        back=view.findViewById(R.id.back_pointer_filter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_filter_fragment_to_setting_fragmnet2);

            }
        });

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
                Navigation.findNavController(view).navigate(R.id.action_filter_fragment_to_setting_fragmnet2);

            }



        });



        return view;
    }
}