package com.example.myapplication.V.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.R;

import java.util.Calendar;


public class MenuActivity extends AppCompatActivity  {

    Button save;
    Button cancel;
    TextView textView;
    Objects objects;

    Button back;




    Intent intent;

    public static Dialog menuDialog;

    private String mParam1;
    Counter counter;
    String1 string1;
    private String mParam2;

 TextView version_name;








    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        try {
            counter.setSeconds_count0_record(0);
            counter.setSeconds_count1000_record(counter.getSeconds_count0_record()+(1 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count2000_record(counter.getSeconds_count0_record()+(2 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count3000_record(counter.getSeconds_count0_record()+(3 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count4000_record(counter.getSeconds_count0_record()+(4 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count5000_record(counter.getSeconds_count0_record()+(5 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count6000_record(counter.getSeconds_count0_record()+(6 *  counter.getHorizontal_scale() / 8));
            counter.setSeconds_count7000_record(counter.getSeconds_count0_record()+(7 * counter.getHorizontal_scale() / 8));
            counter.setSeconds_count8000_record(counter.getSeconds_count0_record()+(8 *  counter.getHorizontal_scale() / 8));






            EightRecordActivity.getV0().setText(counter.getSeconds_count0_record()+"s");
            EightRecordActivity.getV1000().setText(counter.getSeconds_count1000_record()+"s");
            EightRecordActivity.getV2000().setText(counter.getSeconds_count2000_record()+"s");
            EightRecordActivity.getV3000().setText(counter.getSeconds_count3000_record()+"s");
            EightRecordActivity.getV4000().setText(counter.getSeconds_count4000_record()+"s");
            EightRecordActivity.getV5000().setText(counter.getSeconds_count5000_record()+"s");
            EightRecordActivity.getV6000().setText(counter.getSeconds_count6000_record()+"s");
            EightRecordActivity.getV7000().setText(counter.getSeconds_count7000_record()+"s");
            EightRecordActivity.getV8000().setText(counter.getSeconds_count8000_record()+"s");





        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        LinearLayout settings =findViewById(R.id.layoutsetting_menu);
        LinearLayout newrecord =findViewById(R.id.layoutnewrecord_menu);
        LinearLayout loadpatient =findViewById(R.id.layoutloadrecord_menu);



        menuDialog=new Dialog(MenuActivity.this);
        menuDialog.setContentView(R.layout.settings);
        menuDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button icon_setting=findViewById(R.id.icon_setting_menu);
        Button icon_newrecord=findViewById(R.id.icon_newpatient_menu);
        Button icon_loadrecord=findViewById(R.id.icon_loadpatient_menu);


        version_name=findViewById(R.id.name_version_name_menu);





        back=menuDialog.findViewById(R.id.back_pointer_settings);


        counter=new Counter();
        string1=new String1();


        version_name.setText(string1.getNameVersion()+""+string1.getVersionId());

        Dialog dialog=new Dialog(MenuActivity.this);
        dialog.setContentView(R.layout.new_record);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        save=dialog.findViewById(R.id.save);
        cancel=dialog.findViewById(R.id.cancel);




        menuDialog.setCancelable(false);


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
                menuDialog.show();
               // startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
               // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
                        startActivity(new Intent(getApplicationContext(), EightRecordActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


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








        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                menuDialog.show();
//               objects.setContext(MenuActivity.this);
               // startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
               // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);



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
                        startActivity(new Intent(getApplicationContext(),EightRecordActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                        Toast.makeText(getApplicationContext(),"' "+textView.getText()+" "+ Calendar.getInstance().getTime()+" '"+" created",Toast.LENGTH_LONG).show();



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

                intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,1);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });








    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==-1) {
            string1.setChannel_count(0);
            Intent intent=(new Intent(getApplicationContext(), EightRootActivity.class));
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




            new Thread(new Runnable() {
                @Override
                public void run() {
                    Uri uri = data.getData();
                    string1.setFilepatch(uri);
                    counter.setLine_clecked(2);
                    Log.e("set to","1");
                    intent.putExtra("h",string1);

                }
            }).start();









        }

    }






     static public void dismissmenu(){
        menuDialog.dismiss();

         Counter counter=new Counter();

         counter.setEight_step_x((float) counter.getSurfaceviewhewidth()/(counter.getRate_in_s()*counter.getHorizontal_scale()));

         counter.setEight_step_y((float) counter.getSurfaceviewhewidth()/200);
         counter.setEight_step_y((counter.getEight_step_y()/counter.getDefault_channel())/2);

     }


}
