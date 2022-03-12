package com.example.myapplication;

import android.hardware.biometrics.BiometricManager;
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
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemScaleAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Scale_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scale_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    RecyclerView recyclerView;
    List<ItemScale> list = new ArrayList<>();
    ItemScaleAdapter itemAdapter;

    Counter counter;
    Button back;

    String1 string1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;

    public Scale_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Scale_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Scale_Fragment newInstance(String param1, String param2) {
        Scale_Fragment fragment = new Scale_Fragment();
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

       view= inflater.inflate(R.layout.scale_fragment, container, false);


        counter=new Counter();
        string1=new String1();
        recyclerView = view.findViewById(R.id.recyclerscale);
        itemAdapter = new ItemScaleAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);


        list.add(new ItemScale("Horizontal Scale",(int)counter.getHorizontal_scale()+" sec per page"));
        //list.add(new ItemScale("EEG Sensivity","70µV per page"));


        itemAdapter.notifyDataSetChanged();

        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion());


        back=view.findViewById(R.id.back_pointer_scale);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Navigation.findNavController(view).navigate(R.id.action_scale_Fragment_to_setting_fragmnet);


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
                Navigation.findNavController(view).navigate(R.id.action_scale_Fragment_to_setting_fragmnet);

            }



        });
        return view;
    }
}