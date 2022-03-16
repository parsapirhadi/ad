package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemCustomMontageEditor;
import com.example.myapplication.M.Item.ItemMontage;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemCustomMontageEditorAdapter;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemMontageAdapter;
import com.example.myapplication.V.Activity.MenuActivity;
import com.example.myapplication.V.Activity.MontageActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Montage_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Montage_Fragment extends Fragment {


    View view;

    RecyclerView recyclerView1;
    List<ItemMontage> list1 = new ArrayList<>();
    ItemMontageAdapter itemAdapter1;
    Button back;
String1 string1;

    RecyclerView recyclerView2;
    List<ItemCustomMontageEditor> list2 = new ArrayList<>();
    ItemCustomMontageEditorAdapter itemAdapter2;

    com.example.myapplication.M.DataType.Objects objects;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Montage_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Montage_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Montage_Fragment newInstance(String param1, String param2) {
        Montage_Fragment fragment = new Montage_Fragment();
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

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
view =inflater.inflate(R.layout.montage_fragment, container, false);

objects=new Objects();
string1=new String1();



        recyclerView1 = view.findViewById(R.id.recyclemontage);
        itemAdapter1 = new ItemMontageAdapter(list1, getContext());
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView1.setAdapter(itemAdapter1);

        list1.add(new ItemMontage(true, "Mono",true, "Banana"));

        itemAdapter1.notifyDataSetChanged();



        recyclerView2 = view.findViewById(R.id.custom_montage_editor);
        itemAdapter2 = new ItemCustomMontageEditorAdapter(list2, getContext());
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView2.setAdapter(itemAdapter2);
        list2.add(new ItemCustomMontageEditor("Number of channels","8"));
        list2.add(new ItemCustomMontageEditor("Rename channels",""));

        list2.add(new ItemCustomMontageEditor("Montage Editor",""));

        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion()+""+string1.getVersionId());


        itemAdapter1.notifyDataSetChanged();


        back=view.findViewById(R.id.back_pointer_montage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                 Navigation.findNavController(view).navigate(R.id.action_montage_Fragment_to_setting_fragmnet);

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
                Navigation.findNavController(view).navigate(R.id.action_montage_Fragment_to_setting_fragmnet);

            }



        });

        return view;
    }

}