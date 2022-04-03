package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.Item.ItemAdvancedSetting;
import com.example.myapplication.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ItemAdvancedSettingAdapter extends RecyclerView.Adapter<ItemAdvancedSettingAdapter.MyViewHolder> {
    List<ItemAdvancedSetting> itwm;
    Context context;
    Counter counter;
    boolean b=false;
    public ItemAdvancedSettingAdapter(List<ItemAdvancedSetting> itwm,Context context) {
        this.itwm = itwm;
        this.context=context;
        counter=new Counter();
    }

    @Override
    public ItemAdvancedSettingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advanced_setting,parent,false);

        return new ItemAdvancedSettingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdvancedSettingAdapter.MyViewHolder holder, int position) {
        ItemAdvancedSetting item=itwm.get(position);
        holder.icon.setText(item.getIcon());
        holder.title.setText(item.getTitle());



        holder.icon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


try
{
if (!holder.icon.getText().toString().equals("")) {
    if (position == 0) {

        counter.setAlpha(Float.parseFloat(holder.icon.getText().toString()));

    }
    if (position == 1) {
        counter.setBeta(Float.parseFloat(holder.icon.getText().toString()));

    }
    if (position == 2) {
        counter.setRate_in_s(Integer.parseInt(holder.icon.getText().toString()));
    }

    SharedPreferences pref1 = context.getSharedPreferences("alpha", MODE_PRIVATE);
    SharedPreferences.Editor editor1 = pref1.edit();
    editor1.putString("name", "" + counter.getAlpha());
    editor1.apply();

    SharedPreferences pref2 = context.getSharedPreferences("beta", MODE_PRIVATE);
    SharedPreferences.Editor editor2 = pref2.edit();
    editor2.putString("name", "" + counter.getBeta());
    editor2.apply();

    SharedPreferences pref3 = context.getSharedPreferences("rate_in_s", MODE_PRIVATE);
    SharedPreferences.Editor editor3 = pref3.edit();
    editor3.putString("name", "" + counter.getRate_in_s());
    editor3.apply();
}


}catch (NumberFormatException e){
    e.printStackTrace();
}


            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {


            }
        });



        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(position==2){

    PopupMenu popup = new PopupMenu(context,view);
    popup.getMenuInflater().inflate(R.menu.baud_rate,popup.getMenu());


    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            holder.icon.setText(menuItem.getTitle());
            counter.setRate_in_s(Integer.parseInt(menuItem.getTitle()+""));

            return true;
        }
    });
   // popup.show();

}





            }
        });



    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public EditText icon;
        public TextView title;

        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_advanced_setting_layout);
            title = itemView.findViewById(R.id.btn_item_advanced_setting);
            icon = itemView.findViewById(R.id.txt_item_advanced_setting);

        }
    }

}