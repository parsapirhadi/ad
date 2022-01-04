package com.example.myapplication.P.ItemRecyclerViewAdapter;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.M.Item.ItemMontageEditor;
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.SingleRecordActivity;
import com.example.myapplication.V.Activity.SingleRootActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class ItemMontageEditorAdapter extends RecyclerView.Adapter<ItemMontageEditorAdapter.MyViewHolder> {
    List<ItemMontageEditor> itwm;
    PopupMenu popup_start;
    PopupMenu popup_end;
            ;
    Context context;
    String1 string1;

    private ArrayAdapter<String> adapter;
    public ItemMontageEditorAdapter(List<ItemMontageEditor> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_montage_editor,parent,false);
        string1=new String1();

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemMontageEditor item = itwm.get(position);

        holder.icon.setText(item.getIcon());
        holder.title_start.setText(item.getTitle_Start());
        holder.title_end.setText(item.getTitle_End());

        holder.title_start.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (position==0) {
                    string1.setPivote_from(0,holder.title_start.getText().toString());
                }
                if (position==1) {
                    string1.setPivote_from(1,holder.title_start.getText().toString());
                }
                if (position==2) {
                    string1.setPivote_from(2,holder.title_start.getText().toString());
                }
                if (position==3) {
                    string1.setPivote_from(3,holder.title_start.getText().toString());
                }
                if (position==4) {
                    string1.setPivote_from(4,holder.title_start.getText().toString());
                }
                if (position==5) {
                    string1.setPivote_from(5,holder.title_start.getText().toString());
                }
                if (position==6) {
                    string1.setPivote_from(6,holder.title_start.getText().toString());
                }
                if (position==7) {
                    string1.setPivote_from(7,holder.title_start.getText().toString());


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        holder.title_end.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (position==0) {

                    string1.setPivote_to(0,holder.title_end.getText().toString());

                }
                if (position==1) {
                    string1.setPivote_to(1,holder.title_end.getText().toString());
                }
                if (position==2) {
                    string1.setPivote_to(2,holder.title_end.getText().toString());
                }
                if (position==3) {
                    string1.setPivote_to(3,holder.title_end.getText().toString());
                }
                if (position==4) {
                    string1.setPivote_to(4,holder.title_end.getText().toString());
                }
                if (position==5) {
                    string1.setPivote_to(5,holder.title_end.getText().toString());
                }
                if (position==6) {
                    string1.setPivote_to(6,holder.title_end.getText().toString());
                }
                if (position==7) {
                    string1.setPivote_to(7,holder.title_end.getText().toString());


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        holder.title_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    popup_start = new PopupMenu(context, holder.title_start);
                    popup_start.getMenuInflater().inflate(R.menu.choose_channel, popup_start.getMenu());


                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name", "ch1").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE).getString("name", "ch2").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name", "ch3").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name", "ch4").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name", "ch5").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name", "ch6").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name", "ch7").toString());

                    popup_start.getMenu().add(context.getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name", "ch8").toString());



                    popup_start.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {


                            holder.title_start.setText(menuItem.getTitle());

                            return true;
                        }
                    });
                    popup_start.show();


            }
        });

holder.title_end.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        popup_end = new PopupMenu(context, holder.title_start);
        popup_end.getMenuInflater().inflate(R.menu.choose_channel, popup_end.getMenu());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch1", MODE_PRIVATE).getString("name", "ch1").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch2", MODE_PRIVATE).getString("name", "ch2").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch3", MODE_PRIVATE).getString("name", "ch3").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch4", MODE_PRIVATE).getString("name", "ch4").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch5", MODE_PRIVATE).getString("name", "ch5").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch6", MODE_PRIVATE).getString("name", "ch6").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch7", MODE_PRIVATE).getString("name", "ch7").toString());

        popup_end.getMenu().add(context.getApplicationContext().getSharedPreferences("bch8", MODE_PRIVATE).getString("name", "ch8").toString());




        popup_end.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                holder.title_end.setText(menuItem.getTitle());

                return true;
            }
        });
        popup_end.show();
    }
});





    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView icon;
        public TextView title_start;
        public TextView title_end;


        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_montage_editor_layout);
            icon = itemView.findViewById(R.id.btn_item_montage_editor);
            title_end = itemView.findViewById(R.id.txt_item_montage_editor_end);
            title_start = itemView.findViewById(R.id.txt_item_montage_editor_start);


        }
    }

}