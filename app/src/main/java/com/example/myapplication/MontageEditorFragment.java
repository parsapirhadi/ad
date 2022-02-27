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
import com.example.myapplication.M.Item.ItemMontageEditor;
import com.example.myapplication.P.ItemRecyclerViewAdapter.ItemMontageEditorAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.myapplication.V.Activity.CustomDrawerLayout.drawerLayoutDialog;
import static com.example.myapplication.V.Activity.MenuActivity.menuDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MontageEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MontageEditorFragment extends Fragment {
  private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    View view;

    RecyclerView recyclerView;
    List<ItemMontageEditor> list = new ArrayList<>();
    ItemMontageEditorAdapter itemAdapter;

    Counter counter;
    Button back;
    String1 string1;


    @Override
    public void onPause() {
        super.onPause();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////  start

        SharedPreferences pref_start_1 = getContext().getSharedPreferences("bch1_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_1 = pref_start_1.edit();
        if (string1.getPivote_from(0) != null && string1.getPivote_from(0).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_1.putString("name", "" + string1.getPivote_from(0));
            editor_start_1.apply();
        }
        SharedPreferences pref_start_2 = getContext().getSharedPreferences("bch2_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_2 = pref_start_2.edit();
        if (string1.getPivote_from(1) != null && string1.getPivote_from(1).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_2.putString("name", "" + string1.getPivote_from(1));
            editor_start_2.apply();
        }
        SharedPreferences pref_start_3 = getContext().getSharedPreferences("bch3_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_3 = pref_start_3.edit();
        if (string1.getPivote_from(2) != null && string1.getPivote_from(2).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_3.putString("name", "" + string1.getPivote_from(2));
            editor_start_3.apply();
        }
        SharedPreferences pref_start_4 = getContext().getSharedPreferences("bch4_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_4 = pref_start_4.edit();
        if (string1.getPivote_from(3) != null && string1.getPivote_from(3).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_4.putString("name", "" + string1.getPivote_from(3));
            editor_start_4.apply();
        }
        SharedPreferences pref_start_5 = getContext().getSharedPreferences("bch5_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_5 = pref_start_5.edit();
        if (string1.getPivote_from(4) != null && string1.getPivote_from(4).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_5.putString("name", "" + string1.getPivote_from(4));
            editor_start_5.apply();
        }
        SharedPreferences pref_start_6 = getContext().getSharedPreferences("bch6_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_6 = pref_start_6.edit();
        if (string1.getPivote_from(5) != null && string1.getPivote_from(5).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_6.putString("name", "" + string1.getPivote_from(5));
            editor_start_6.apply();
        }
        SharedPreferences pref_start_7 = getContext().getSharedPreferences("bch7_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_7 = pref_start_7.edit();
        if (string1.getPivote_from(6) != null && string1.getPivote_from(6).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_7.putString("name", "" + string1.getPivote_from(6));
            editor_start_7.apply();
        }
        SharedPreferences pref_start_8 = getContext().getSharedPreferences("bch8_start", MODE_PRIVATE);
        SharedPreferences.Editor editor_start_8 = pref_start_8.edit();
        if (string1.getPivote_from(7) != null && string1.getPivote_from(7).length() < 4 && string1.getPivote_from(0).length() != 0) {
            editor_start_8.putString("name", "" + string1.getPivote_from(7));
            editor_start_8.apply();
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////  end

        SharedPreferences pref_end_1 = getContext().getSharedPreferences("bch1_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_1 = pref_end_1.edit();
        if (string1.getPivote_to(0) != null && string1.getPivote_to(0).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_1.putString("name", "" + string1.getPivote_to(0));
            editor_end_1.apply();
        }
        SharedPreferences pref_end_2 = getContext().getSharedPreferences("bch2_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_2 = pref_end_2.edit();
        if (string1.getPivote_to(1) != null && string1.getPivote_to(1).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_2.putString("name", "" + string1.getPivote_to(1));
            editor_end_2.apply();
        }
        SharedPreferences pref_end_3 = getContext().getSharedPreferences("bch3_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_3 = pref_end_3.edit();
        if (string1.getPivote_to(2) != null && string1.getPivote_to(2).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_3.putString("name", "" + string1.getPivote_to(2));
            editor_end_3.apply();
        }
        SharedPreferences pref_end_4 = getContext().getSharedPreferences("bch4_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_4 = pref_end_4.edit();
        if (string1.getPivote_to(3) != null && string1.getPivote_to(3).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_4.putString("name", "" + string1.getPivote_to(3));
            editor_end_4.apply();
        }
        SharedPreferences pref_end_5 = getContext().getSharedPreferences("bch5_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_5 = pref_end_5.edit();
        if (string1.getPivote_to(4) != null && string1.getPivote_to(4).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_5.putString("name", "" + string1.getPivote_to(4));
            editor_end_5.apply();
        }
        SharedPreferences pref_end_6 = getContext().getSharedPreferences("bch6_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_6 = pref_end_6.edit();
        if (string1.getPivote_to(5) != null && string1.getPivote_to(5).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_6.putString("name", "" + string1.getPivote_to(5));
            editor_end_6.apply();
        }
        SharedPreferences pref_end_7 = getContext().getSharedPreferences("bch7_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_7 = pref_end_7.edit();
        if (string1.getPivote_to(6) != null && string1.getPivote_to(6).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_7.putString("name", "" + string1.getPivote_to(6));
            editor_end_7.apply();
        }
        SharedPreferences pref_end_8 = getContext().getSharedPreferences("bch8_end", MODE_PRIVATE);
        SharedPreferences.Editor editor_end_8 = pref_end_8.edit();
        if (string1.getPivote_to(7) != null && string1.getPivote_to(7).length() < 4 && string1.getPivote_to(0).length() != 0) {
            editor_end_8.putString("name", "" + string1.getPivote_to(7));
            editor_end_8.apply();
        }


    }


    public MontageEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MontageEditorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MontageEditorFragment newInstance(String param1, String param2) {
        MontageEditorFragment fragment = new MontageEditorFragment();
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
        view=inflater.inflate(R.layout.montage_editor_fragment, container, false);





        counter=new Counter();
        string1=new String1();
        recyclerView = view.findViewById(R.id.recycler_montage_editor);
        itemAdapter = new ItemMontageEditorAdapter(list, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(itemAdapter);


        list.add(new ItemMontageEditor("CH1",
                ""+getContext().getSharedPreferences("bch1_start", MODE_PRIVATE).getString("name","ch1"),
                ""+getContext().getSharedPreferences("bch1_end", MODE_PRIVATE).getString("name","ch1")));

        list.add(new ItemMontageEditor("CH2",
                ""+getContext().getSharedPreferences("bch2_start", MODE_PRIVATE).getString("name","ch2"),
                ""+getContext().getSharedPreferences("bch2_end", MODE_PRIVATE).getString("name","ch2")));


        list.add(new ItemMontageEditor("CH3",
                ""+getContext().getSharedPreferences("bch3_start", MODE_PRIVATE).getString("name","ch3"),
                ""+getContext().getSharedPreferences("bch3_end", MODE_PRIVATE).getString("name","ch3")));

        list.add(new ItemMontageEditor("CH4",
                ""+getContext().getSharedPreferences("bch4_start", MODE_PRIVATE).getString("name","ch4"),
                ""+getContext().getSharedPreferences("bch4_end", MODE_PRIVATE).getString("name","ch4")));

        list.add(new ItemMontageEditor("CH5",
                ""+getContext().getSharedPreferences("bch5_start", MODE_PRIVATE).getString("name","ch5"),
                ""+getContext().getSharedPreferences("bch5_end", MODE_PRIVATE).getString("name","ch5")));

        list.add(new ItemMontageEditor("CH6",
                ""+getContext().getSharedPreferences("bch6_start", MODE_PRIVATE).getString("name","ch6"),
                ""+getContext().getSharedPreferences("bch6_end", MODE_PRIVATE).getString("name","ch6")));

        list.add(new ItemMontageEditor("CH7",
                ""+getContext().getSharedPreferences("bch7_start", MODE_PRIVATE).getString("name","ch7"),
                ""+getContext().getSharedPreferences("bch7_end", MODE_PRIVATE).getString("name","ch7")));

        list.add(new ItemMontageEditor("CH8",
                ""+getContext().getSharedPreferences("bch8_start", MODE_PRIVATE).getString("name","ch8"),
                ""+getContext().getSharedPreferences("bch8_end", MODE_PRIVATE).getString("name","ch8")));


        TextView textView;
        textView=view.findViewById(R.id.name_version);
        textView.setText(string1.getNameVersion());


        itemAdapter.notifyDataSetChanged();


        back=view.findViewById(R.id.back_pointer_montage_editor);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Navigation.findNavController(view).navigate(R.id.action_montageEditorFragment_to_montage_Fragment);



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
                Navigation.findNavController(view).navigate(R.id.action_montageEditorFragment_to_setting_fragmnet);

            }



        });



        return view;
    }
}