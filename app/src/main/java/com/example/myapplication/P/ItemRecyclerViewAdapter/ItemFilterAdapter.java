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

import com.example.myapplication.M.Item.ItemFilter;
import com.example.myapplication.R;

import java.util.List;


public class ItemFilterAdapter extends RecyclerView.Adapter<ItemFilterAdapter.MyViewHolder> {
    List<ItemFilter> itwm;
    Context context;
    public ItemFilterAdapter(List<ItemFilter> itwm,Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemFilter item=itwm.get(position);
        holder.icon.setText(item.getIcon());
        holder.title.setText(item.getTitle());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PopupMenu popup = new PopupMenu(context,view);
                            popup.getMenuInflater().inflate(R.menu.lowcut,popup.getMenu());


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
                if (position==1){
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PopupMenu popup = new PopupMenu(context,view);
                            popup.getMenuInflater().inflate(R.menu.highcut,popup.getMenu());


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
            linearLayout=itemView.findViewById(R.id.item_filter_layout);
            icon = itemView.findViewById(R.id.btn_item_filter);
            title = itemView.findViewById(R.id.txt_item_filter);

        }
    }

}
