package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemNotch;
import com.example.myapplication.R;

import java.util.List;


public class ItemNotchAdapter extends RecyclerView.Adapter<ItemNotchAdapter.MyViewHolder> {
    List<ItemNotch> itwm;
    Context context;
    public ItemNotchAdapter(List<ItemNotch> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notch,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemNotch item=itwm.get(position);
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


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {



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
            linearLayout=itemView.findViewById(R.id.item_notch_layout);
            linearLayout1=itemView.findViewById(R.id.item_notch_layout1);
            linearLayout2=itemView.findViewById(R.id.item_notch_layout2);

            icon1 = itemView.findViewById(R.id.radio_item_notch1);
            title1= itemView.findViewById(R.id.txt_item_notch1);

            icon2 = itemView.findViewById(R.id.radio_item_notch);
            title2= itemView.findViewById(R.id.txt_item_notch);
        }
    }

}
