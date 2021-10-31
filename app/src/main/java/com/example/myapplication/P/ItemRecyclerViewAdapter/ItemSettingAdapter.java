package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemSetting;
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.AdvancedSettingActivity;
import com.example.myapplication.V.Activity.FilterActivity;
import com.example.myapplication.V.Activity.MontageActivity;
import com.example.myapplication.V.Activity.ReplayActivity;
import com.example.myapplication.V.Activity.ScaleActivity;

import java.util.List;


public class ItemSettingAdapter extends RecyclerView.Adapter<ItemSettingAdapter.MyViewHolder> {
    List<ItemSetting> itwm;
    Context context;
    public ItemSettingAdapter(List<ItemSetting> itwm,Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemSetting item=itwm.get(position);
        holder.icon.setBackgroundResource(item.getIcon());
        holder.title.setText(item.getTitle());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){

                    context.startActivity(new Intent(context, FilterActivity.class));
                   // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
                if(position==1){
                    context.startActivity(new Intent(context, ReplayActivity.class));

                    //context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
                if(position==2){
                    context.startActivity(new Intent(context, ScaleActivity.class));
                    //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }

                if(position==3){
                    context.startActivity(new Intent(context, MontageActivity.class));
                    //context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
                if(position==4){
                    context.startActivity(new Intent(context, AdvancedSettingActivity.class));
                    //context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public Button icon;
        public TextView title;

        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_setting_layout);
            icon = itemView.findViewById(R.id.btn_item_setting);
            title = itemView.findViewById(R.id.txt_item_setting);

        }
    }

}
