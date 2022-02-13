package com.example.myapplication;

import android.content.pm.PackageInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.M.Item.ItemReplay;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemReplayAdapter;

import java.util.ArrayList;
import java.util.List;


public class Replay_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;


    RecyclerView recyclerView;
    List<ItemReplay> list = new ArrayList<>();
    ItemReplayAdapter itemAdapter;
    PackageInfo info;
    Button back;


    private String mParam1;
    private String mParam2;

    public Replay_Fragment() {
    }


    public static Replay_Fragment newInstance(String param1, String param2) {
        Replay_Fragment fragment = new Replay_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.replay_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclereplay);
        itemAdapter = new ItemReplayAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);


        list.add(new ItemReplay("Speed", "2"));

        itemAdapter.notifyDataSetChanged();


        back=view.findViewById(R.id.back_pointer_replay);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_replay_Fragment_to_setting_fragmnet);


            }
        });



        return view;
    }
}