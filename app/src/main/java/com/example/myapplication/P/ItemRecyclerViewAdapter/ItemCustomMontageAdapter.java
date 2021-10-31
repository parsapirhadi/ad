package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemCustomMontage;
import com.example.myapplication.R;

import java.util.List;

public class ItemCustomMontageAdapter extends RecyclerView.Adapter<ItemCustomMontageAdapter.MyViewHolder> {
    List<ItemCustomMontage> itwm;
    Context context;
    public ItemCustomMontageAdapter(List<ItemCustomMontage> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public ItemCustomMontageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_costom_montage,parent,false);

        return new ItemCustomMontageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCustomMontageAdapter.MyViewHolder holder, int position) {
        ItemCustomMontage item=itwm.get(position);
        holder.title.setText(item.getTitle());




    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RadioButton icon;
        public TextView title;

        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }

}
