package com.example.myapplication.P.ItemRecyclerViewAdapter;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemRename;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.EightRecordActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class ItemRenameAdapter extends RecyclerView.Adapter<ItemRenameAdapter.MyViewHolder> {
    List<ItemRename> itwm;
    Context context;
    Counter counter;
    String1 string1;



    TextInputEditText ech1;

    Button check_circle1,check_circle2,check_circle3,check_circle4,check_circle5,check_circle6,check_circle7,check_circle8;

    TextInputLayout lch1,lch2,lch3,lch4,lch5,lch6,lch7,lch8;

    Button cch1,cch2,cch3,cch4,cch5,cch6,cch7,cch8;

    EditText ech2,ech3,ech4,ech5,ech6,ech7,ech8;
    Button bch1,bch2,bch3,bch4,bch5,bch6,bch7,bch8;


    public ItemRenameAdapter(List<ItemRename> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rename,parent,false);
        counter=new Counter();
        string1=new String1();



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemRename item=itwm.get(position);
        holder.icon.setText(item.getIcon());
        holder.title.setHint(item.getTitle());



            holder.title.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }


                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (position==0) {

                        string1.setPivote(0,holder.title.getText().toString());

                     }
                    if (position==1) {
                        string1.setPivote(1,holder.title.getText().toString());
                    }
                    if (position==2) {
                        string1.setPivote(2,holder.title.getText().toString());
                    }
                    if (position==3) {
                        string1.setPivote(3,holder.title.getText().toString());
                    }
                    if (position==4) {
                        string1.setPivote(4,holder.title.getText().toString());
                    }
                    if (position==5) {
                        string1.setPivote(5,holder.title.getText().toString());
                    }
                    if (position==6) {
                        string1.setPivote(6,holder.title.getText().toString());
                    }
                    if (position==7) {
                        string1.setPivote(7,holder.title.getText().toString());
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });



        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){



                   PopupMenu popup = new PopupMenu(context,view);
                    popup.getMenuInflater().inflate(R.menu.horizontal_menu, popup.getMenu());

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {



                            String t=menuItem.getTitle().toString();
                            holder.title.setHint(t);
                            int f=0;
                            String r="";
                            for(f=0;f<5;f++){
                                if (t.charAt(f)==' '){
                                    break;
                                }

                            }
                            for (int s=0;s<f;s++){
                                r+=t.charAt(s)+"";

                            }
                            counter.setHorizontal_scale(Integer.parseInt(r));





                            return true;
                        }
                    });

                }
                if (position==1){
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PopupMenu popup = new PopupMenu(context,view);
                            popup.getMenuInflater().inflate(R.menu.eeg_sensivity,popup.getMenu());


                            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {


                                    holder.title.setHint(menuItem.getTitle());

                                    EditText d;

                                    return true;
                                }
                            });


                        }
                    });

                }



            }

        });





    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView icon;
        public EditText title;

        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_rename_layout);
            icon = itemView.findViewById(R.id.btn_item_rename);
            title= itemView.findViewById(R.id.txt_item_rename);

        }
    }

}
