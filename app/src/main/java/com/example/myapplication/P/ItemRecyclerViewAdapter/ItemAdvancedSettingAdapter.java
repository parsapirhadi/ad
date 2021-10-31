package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemAdvancedSetting;
import com.example.myapplication.R;

import java.util.List;

public class ItemAdvancedSettingAdapter extends RecyclerView.Adapter<ItemAdvancedSettingAdapter.MyViewHolder> {
    List<ItemAdvancedSetting> itwm;
    Context context;
    public ItemAdvancedSettingAdapter(List<ItemAdvancedSetting> itwm,Context context) {
        this.itwm = itwm;
        this.context=context;
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
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(position==2){

    PopupMenu popup = new PopupMenu(context,view);
    popup.getMenuInflater().inflate(R.menu.to_do,popup.getMenu());


    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            holder.title.setText(menuItem.getTitle());

            return true;
        }
    });
    popup.show();

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