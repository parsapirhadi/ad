package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemMontage;
import com.example.myapplication.R;

import java.util.List;

public class ItemMontageAdapter extends RecyclerView.Adapter<ItemMontageAdapter.MyViewHolder> {
    List<ItemMontage> itwm;
    Context context;
    public ItemMontageAdapter(List<ItemMontage> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public ItemMontageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_montage,parent,false);

        return new ItemMontageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemMontageAdapter.MyViewHolder holder, int position) {
        ItemMontage item=itwm.get(position);
        holder.icon1.setEnabled(item.getIcon1());
        holder.title1.setText(item.getTitle1());
        holder.icon2.setEnabled(item.getIcon2());
        holder.title2.setText(item.getTitle2());


holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        holder.icon1.setChecked(true);
        holder.icon2.setChecked(false);

    }
});
             holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     holder.icon2.setChecked(true);
                     holder.icon1.setChecked(false);


                 }
             });






    }

    @Override
    public int getItemCount() {
        return itwm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RadioButton icon1;
        public TextView title1;
        public RadioButton icon2;
        public TextView title2;

        public LinearLayout linearLayout;
        public LinearLayout linearLayout1;
        public LinearLayout linearLayout2;



        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_montage_layout);
            linearLayout1=itemView.findViewById(R.id.item_montage_layout1);
            linearLayout2=itemView.findViewById(R.id.item_montage_layout2);

            icon1 = itemView.findViewById(R.id.radio_item_montage1);
            title1= itemView.findViewById(R.id.txt_item_montage1);

            icon2 = itemView.findViewById(R.id.radio_item_montage2);
            title2= itemView.findViewById(R.id.txt_item_montage2);
        }
    }

}
