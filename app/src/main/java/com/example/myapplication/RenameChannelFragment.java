package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemRename;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemRenameAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RenameChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RenameChannelFragment extends Fragment {

    RecyclerView recyclerView;
    List<ItemRename> list = new ArrayList<>();
    ItemRenameAdapter itemAdapter;
    Counter counter;
    String1 string1;

    Button back;

    View view;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RenameChannelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RenameChannelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RenameChannelFragment newInstance(String param1, String param2) {
        RenameChannelFragment fragment = new RenameChannelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }






    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences pref1 = getContext().getSharedPreferences("bch1", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = pref1.edit();
        if (string1.getPivote(0)!=null && string1.getPivote(0).length()<4 && string1.getPivote(0).length()!=0) {
            editor1.putString("name", "" + string1.getPivote(0));
            editor1.apply();
        }
        SharedPreferences pref2 = getContext().getSharedPreferences("bch2", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref2.edit();
        if (string1.getPivote(1)!=null && string1.getPivote(1).length()<4 && string1.getPivote(0).length()!=0) {
            editor2.putString("name", "" + string1.getPivote(1));
            editor2.apply();
        }
        SharedPreferences pref3 = getContext().getSharedPreferences("bch3", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        if (string1.getPivote(2)!=null && string1.getPivote(2).length()<4 && string1.getPivote(0).length()!=0) {
            editor3.putString("name", "" + string1.getPivote(2));
            editor3.apply();
        }
        SharedPreferences pref4 = getContext().getSharedPreferences("bch4", MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        if (string1.getPivote(3)!=null && string1.getPivote(3).length()<4 && string1.getPivote(0).length()!=0) {
            editor4.putString("name", "" + string1.getPivote(3));
            editor4.apply();
        }
        SharedPreferences pref5 = getContext().getSharedPreferences("bch5", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = pref5.edit();
        if (string1.getPivote(4)!=null && string1.getPivote(4).length()<4 && string1.getPivote(0).length()!=0) {
            editor5.putString("name", "" + string1.getPivote(4));
            editor5.apply();
        }
        SharedPreferences pref6 = getContext().getSharedPreferences("bch6", MODE_PRIVATE);
        SharedPreferences.Editor editor6 = pref6.edit();
        if (string1.getPivote(5)!=null && string1.getPivote(5).length()<4 && string1.getPivote(0).length()!=0) {
            editor6.putString("name", "" + string1.getPivote(5));
            editor6.apply();
        }
        SharedPreferences pref7 = getContext().getSharedPreferences("bch7", MODE_PRIVATE);
        SharedPreferences.Editor editor7 = pref7.edit();
        if (string1.getPivote(6)!=null && string1.getPivote(6).length()<4 && string1.getPivote(0).length()!=0) {
            editor7.putString("name", "" + string1.getPivote(7));
            editor7.apply();
        }
        SharedPreferences pref8 = getContext().getSharedPreferences("bch8", MODE_PRIVATE);
        SharedPreferences.Editor editor8 = pref8.edit();
        if (string1.getPivote(7)!=null && string1.getPivote(7).length()<4 && string1.getPivote(0).length()!=0) {
            editor8.putString("name", "" + string1.getPivote(7));
            editor8.apply();
        }






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

        view =inflater.inflate(R.layout.rename_channel_fragment, container, false);

        string1=new String1();
        counter=new Counter();
        recyclerView = view.findViewById(R.id.recyclerename_channel);
        itemAdapter = new ItemRenameAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);




        list.add(new ItemRename("CH1",""+getContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name","ch1")));
        list.add(new ItemRename("CH2",""+getContext().getSharedPreferences("bch2", MODE_PRIVATE).getString("name","ch2")));
        list.add(new ItemRename("CH3",""+getContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name","ch3")));
        list.add(new ItemRename("CH4",""+getContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name","ch4")));
        list.add(new ItemRename("CH5",""+getContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name","ch5")));
        list.add(new ItemRename("CH6",""+getContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name","ch6")));
        list.add(new ItemRename("CH7",""+getContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name","ch7")));
        list.add(new ItemRename("CH8",""+getContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name","ch8")));



        itemAdapter.notifyDataSetChanged();

        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion());


        back=view.findViewById(R.id.back_pointer_renamechannel);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Navigation.findNavController(view).navigate(R.id.action_renameChannelFragment_to_montage_Fragment);

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
                Navigation.findNavController(view).navigate(R.id.action_renameChannelFragment_to_setting_fragmnet);

            }



        });
        // Inflate the layout for this fragment
        return view;
    }
}