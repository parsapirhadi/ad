package com.example.myapplication;

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

import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemAdvancedSetting;
import com.example.myapplication.M.Item.ItemNotch;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemAdvancedSettingAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemNotchAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdvancedStetting_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvancedStetting_Fragment extends Fragment {

View view;
    RecyclerView recyclerView1;
    List<ItemAdvancedSetting> list1 = new ArrayList<>();
    ItemAdvancedSettingAdapter itemAdapter1;

    String1 string1;

    RecyclerView recyclerView2;
    List<ItemNotch> list2 = new ArrayList<>();
    ItemNotchAdapter itemAdapter2;
    Button back;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdvancedStetting_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdvancedStetting_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdvancedStetting_Fragment newInstance(String param1, String param2) {
        AdvancedStetting_Fragment fragment = new AdvancedStetting_Fragment();
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
        // Inflate the layout for this fragment


view=inflater.inflate(R.layout.advancedstetting_fragment, container, false);


        recyclerView1 = view.findViewById(R.id.recycleadvancedsetting);
        itemAdapter1 = new ItemAdvancedSettingAdapter(list1, getContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);


        list1.add(new ItemAdvancedSetting("α","2048"));

        list1.add(new ItemAdvancedSetting("β","1.4"));

        list1.add(new ItemAdvancedSetting("\n" +
                "Baud Rate","512"));

        string1=new String1();


        itemAdapter1.notifyDataSetChanged();

        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion());


        back=view.findViewById(R.id.back_pointer_advanced_setting);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_advancedStetting_Fragment_to_setting_fragmnet);


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
                Navigation.findNavController(view).navigate(R.id.action_advancedStetting_Fragment_to_setting_fragmnet);

            }



        });



        return view;
    }
    void setInformation(){

    }
}