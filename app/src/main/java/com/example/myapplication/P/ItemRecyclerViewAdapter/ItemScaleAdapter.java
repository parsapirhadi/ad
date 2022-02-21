package com.example.myapplication.P.ItemRecyclerViewAdapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.Item.ItemScale;
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.EightRecordActivity;

import java.util.List;

public class ItemScaleAdapter extends RecyclerView.Adapter<ItemScaleAdapter.MyViewHolder> {
    List<ItemScale> itwm;
    Context context;
    Counter counter;

    public ItemScaleAdapter(List<ItemScale> itwm, Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scale,parent,false);
        counter=new Counter();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemScale item=itwm.get(position);
        holder.icon.setText(item.getIcon());
        holder.title.setText(item.getTitle());



        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){

                PopupMenu popup = new PopupMenu(context,view);
                popup.getMenuInflater().inflate(R.menu.horizontal_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                       String t=menuItem.getTitle().toString();
                        holder.title.setText(t);
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

                        counter.setSingle_step_x((float) counter.getSurface_width() / (counter.getRate_in_s() * counter.getHorizontal_scale()));
                        counter.setSingle_step_y((float) counter.getSurface_height() / 200);


                        counter.setEight_step_x((float) counter.getSurface_width() / (counter.getRate_in_s() * counter.getHorizontal_scale()));


                        for (int j2=0;j2<8;j2++){
                            for (int j1=0;j1<16000;j1++) {
                                counter.setBuffer(counter.getPart_data(), j2, j1);
                            }
                        }
                        EightRecordActivity.getV0().setText(""+Math.round((counter.getBuffer_count()/(counter.getDefault_channel()*counter.getHorizontal_scale()))));
                        counter.setBuffer_count(0);

                        if(counter.getHorizontal_scale()<8){
                            EightRecordActivity.getV1000().setVisibility(View.INVISIBLE);
                            EightRecordActivity.getV3000().setVisibility(View.INVISIBLE);
                            EightRecordActivity.getV5000().setVisibility(View.INVISIBLE);
                            EightRecordActivity.getV7000().setVisibility(View.INVISIBLE);

                        }
                        else{
                            EightRecordActivity.getV1000().setVisibility(View.VISIBLE);
                            EightRecordActivity.getV3000().setVisibility(View.VISIBLE);
                            EightRecordActivity.getV5000().setVisibility(View.VISIBLE);
                            EightRecordActivity.getV7000().setVisibility(View.VISIBLE);

                        }



                        return true;
                    }
                });
                popup.show();
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
                                    holder.title.setText(menuItem.getTitle());

                                    return true;
                                }
                            });
                            popup.show();


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
        public TextView title;

        public LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_scale_layout);
            icon = itemView.findViewById(R.id.btn_item_scale);
            title= itemView.findViewById(R.id.txt_item_scale);

        }
    }

}
