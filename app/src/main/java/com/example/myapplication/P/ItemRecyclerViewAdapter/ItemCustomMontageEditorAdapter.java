package com.example.myapplication.P.ItemRecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.M.Item.ItemCustomMontageEditor;
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.MontageEditorActivity;
import com.example.myapplication.V.Activity.RenameChannelsActivity;

import java.util.List;





public class ItemCustomMontageEditorAdapter extends RecyclerView.Adapter<ItemCustomMontageEditorAdapter.MyViewHolder> {
    List<ItemCustomMontageEditor> itwm;
    Context context;
    public ItemCustomMontageEditorAdapter(List<ItemCustomMontageEditor> itwm,Context context) {
        this.itwm = itwm;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcustommontageeditor,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemCustomMontageEditor item=itwm.get(position);
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
                            popup.getMenuInflater().inflate(R.menu.number_of_channel,popup.getMenu());


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
                            Navigation.findNavController(view).navigate(R.id.action_montage_Fragment_to_renameChannelFragment);

                           // context.startActivity(new Intent(context, RenameChannelsActivity.class));

                        }
                    });
                }
                if (position==2){
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Navigation.findNavController(view).navigate(R.id.action_montage_Fragment_to_montageEditorFragment);

                           // context.startActivity(new Intent(context, MontageEditorActivity.class));

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
            linearLayout=itemView.findViewById(R.id.item_custommontageeditor_layout);
            icon = itemView.findViewById(R.id.btn_item_custommontageeditor);
            title = itemView.findViewById(R.id.txt_item_custommontageeditor);

        }
    }

}