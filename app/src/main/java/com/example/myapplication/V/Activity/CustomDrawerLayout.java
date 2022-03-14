package com.example.myapplication.V.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.P.FileReader;
import com.example.myapplication.R;
import com.example.myapplication.V.ConnectGraphview;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;


public class CustomDrawerLayout extends Fragment {

Button save;
Button cancel;
TextView textView;
Objects objects;
Context context;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

   Button close;
String1 string1;
Counter counter;

    Intent intent;
   public static Dialog drawerLayoutDialog;

    private String mParam1;
    private String mParam2;

    static Counter counter1;


    public CustomDrawerLayout() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

context=getContext();
            objects=new Objects();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_note, container, false);

        LinearLayout settings =view.findViewById(R.id.layoutsetting);
        LinearLayout newrecord =view.findViewById(R.id.layoutnewrecord);
        LinearLayout loadpatient =view.findViewById(R.id.layoutloadrecord);

        Button icon_setting=view.findViewById(R.id.icon_setting);
        Button icon_newrecord=view.findViewById(R.id.icon_newpatient);
        Button icon_loadrecord=view.findViewById(R.id.icon_loadpatient);

        Dialog dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.new_record);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        counter=new Counter();

        drawerLayoutDialog=new Dialog(getContext());
        drawerLayoutDialog.setContentView(R.layout.settings);
        drawerLayoutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        drawerLayoutDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {


            }
        });

        string1 = new String1();
        counter1 =new Counter();



        TextView textView1;
        textView1=view.findViewById(R.id.name_version);
        textView1.setText(string1.getNameVersion());



        save=dialog.findViewById(R.id.save);
        cancel=dialog.findViewById(R.id.cancel);


        drawerLayoutDialog.findViewById(R.id.back_pointer_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutDialog.dismiss();
            }
        });

        icon_loadrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,1);

            }
        });
        icon_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayoutDialog.show();



                //startActivity(new Intent(getActivity(), SettingsActivity.class));
               // getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        icon_newrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                textView=dialog.findViewById(R.id.textView11);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(), EightRecordActivity.class));
                        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }



        });




drawerLayoutDialog.setCancelable(false);




        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                drawerLayoutDialog.show();



                 // startActivity(new Intent(getActivity(),SettingsActivity.class));
                //  getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });
        newrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //  startActivity(new Intent(getContext(),NewRecordActivity.class));
                dialog.show();
                textView=dialog.findViewById(R.id.textView11);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       startActivity(new Intent(getContext(),EightRecordActivity.class));
                        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                        Toast.makeText(getContext(),"' "+textView.getText()+" "+ Calendar.getInstance().getTime()+" '"+" created",Toast.LENGTH_LONG).show();



                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    dialog.dismiss();
                    }
                });

            }





        });
        loadpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<32;i++) {
                        for (int j=0;j<1300000;j++) {
                            counter.setChannel((float) 1000.0,i,j);
                        }
                    }
                }
            }).start();
                counter.setLoadfor(false);
                 intent=new Intent(Intent.ACTION_GET_CONTENT);
                 intent.setType("*/*");
                 startActivityForResult(intent,1);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });





        return view;


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1 && resultCode==-1) {

            string1.setChannel_count(0);


            Intent intent=(new Intent(getContext(), EightRootActivity.class));
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




            new Thread(new Runnable() {
    @Override
    public void run() {
  Uri uri = data.getData();
        string1.setFilepatch(uri);
        counter1.setLine_clecked(2);
        Log.e("set to","1");
        intent.putExtra("h",string1);

    }
}).start();









        }

    }
   static public void dismissDrawerlayout(){

       drawerLayoutDialog.dismiss();

}


}