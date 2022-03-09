package com.example.myapplication.P.ItemRecyclerViewAdapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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
import com.example.myapplication.V.Activity.EightRootActivity;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

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

                            SharedPreferences horizontal_scale= context.getSharedPreferences("horizontal_scale", MODE_PRIVATE);
                            SharedPreferences.Editor editor_start_1 = horizontal_scale.edit();
                            editor_start_1.putString("horizontal_scale", r );
                            editor_start_1.apply();





                            counter.setSeconds_count0_record(Math.round((counter.getTimer()/(counter.getDefault_channel()*counter.getRate_in_s())))-counter.getHorizontal_scale());

                            if (counter.isRecord_activity()) {
                                counter.setFrist_page(true);
                            }
                            else {
                                if (counter.getSeconds_count0_record() < 0){
                                    counter.setSeconds_count0_record(0);
                                }
                            }

                            counter.setStartdraw_root(1);
                            counter.setEnddraw_root((int)counter.getHorizontal_scale()*counter.getRate_in_s()*2);





                            counter.setSeconds_count0_root(0);
                            counter.setSeconds_count1000_root(counter.getSeconds_count0_root()+(1 * counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count2000_root(counter.getSeconds_count0_root()+(2 *  counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count3000_root(counter.getSeconds_count0_root()+(3 *  counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count4000_root(counter.getSeconds_count0_root()+(4 *  counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count5000_root(counter.getSeconds_count0_root()+(5 *  counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count6000_root(counter.getSeconds_count0_root()+(6 *  counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count7000_root(counter.getSeconds_count0_root()+(7 * counter.getHorizontal_scale() / 8));
                            counter.setSeconds_count8000_root(counter.getSeconds_count0_root()+(8 *  counter.getHorizontal_scale() / 8));

try {


    EightRootActivity.getV0().setText(counter.getSeconds_count0_root() + "s");
    EightRootActivity.getV1000().setText(counter.getSeconds_count1000_root() + "s");
    EightRootActivity.getV2000().setText(counter.getSeconds_count2000_root() + "s");
    EightRootActivity.getV3000().setText(counter.getSeconds_count3000_root() + "s");
    EightRootActivity.getV4000().setText(counter.getSeconds_count4000_root() + "s");
    EightRootActivity.getV5000().setText(counter.getSeconds_count5000_root() + "s");
    EightRootActivity.getV6000().setText(counter.getSeconds_count6000_root() + "s");
    EightRootActivity.getV7000().setText(counter.getSeconds_count7000_root() + "s");
    EightRootActivity.getV8000().setText(counter.getSeconds_count8000_root() + "s");
}
catch (NullPointerException e)
{
    e.printStackTrace();
}






                            counter.setSeconds_count1000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*1)/8));
                            counter.setSeconds_count2000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*2)/8));
                            counter.setSeconds_count3000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*3)/8));
                            counter.setSeconds_count4000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*4)/8));
                            counter.setSeconds_count5000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*5)/8));
                            counter.setSeconds_count6000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*6)/8));
                            counter.setSeconds_count7000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale()*7)/8));
                            counter.setSeconds_count8000_record(counter.getSeconds_count0_record()+ ( (counter.getHorizontal_scale())));

                            counter.setSingle_step_x((float) counter.getSurface_width() / (counter.getRate_in_s() * counter.getHorizontal_scale()));
                            // counter.setSingle_step_y((float) counter.getSurface_height() / 200);


                            counter.setEight_step_x((float) counter.getSurface_width() / (counter.getRate_in_s() * counter.getHorizontal_scale()));





                            try {
                                if (counter.isFrist_page()) {

                                    EightRecordActivity.getV0().setText("");
                                    EightRecordActivity.getV1000().setText("");
                                    EightRecordActivity.getV2000().setText("");
                                    EightRecordActivity.getV3000().setText("");
                                    EightRecordActivity.getV4000().setText("");
                                    EightRecordActivity.getV5000().setText("");
                                    EightRecordActivity.getV6000().setText("");
                                    EightRecordActivity.getV7000().setText("");
                                    EightRecordActivity.getV8000().setText("");
                                }
                                else {


                                    EightRecordActivity.getV0().setText(counter.getSeconds_count0_record() + "s");
                                    EightRecordActivity.getV1000().setText(counter.getSeconds_count1000_record() + "s");
                                    EightRecordActivity.getV2000().setText(counter.getSeconds_count2000_record() + "s");
                                    EightRecordActivity.getV3000().setText(counter.getSeconds_count3000_record() + "s");
                                    EightRecordActivity.getV4000().setText(counter.getSeconds_count4000_record() + "s");
                                    EightRecordActivity.getV5000().setText(counter.getSeconds_count5000_record() + "s");
                                    EightRecordActivity.getV6000().setText(counter.getSeconds_count6000_record() + "s");
                                    EightRecordActivity.getV7000().setText(counter.getSeconds_count7000_record() + "s");
                                    EightRecordActivity.getV8000().setText(counter.getSeconds_count8000_record() + "s");






                                }
                            }
                            catch (NullPointerException e){
                                e.printStackTrace();
                            }






                            for (int j2=0;j2<8;j2++){
                                for (int j1=0;j1<16000;j1++) {
                                    counter.setBuffer(counter.getPart_data(), j2, j1);
                                }
                            }



                            for (int p=0;p<40;p++){
                                counter.setStop_line(10000,p);
                            }

                            //counter.setStop_line(10000,counter.getRecordcount()%30);

                            //  counter.setLine_stop_counter(0);
                            // counter.setLoop_counter(1);


                            counter.setBuffer_count(0);

                            try {


                                if (counter.getHorizontal_scale() < 8) {

                                    EightRootActivity.getV1000().setVisibility(View.INVISIBLE);
                                    EightRootActivity.getV3000().setVisibility(View.INVISIBLE);
                                    EightRootActivity.getV5000().setVisibility(View.INVISIBLE);
                                    EightRootActivity.getV7000().setVisibility(View.INVISIBLE);

                                    EightRecordActivity.getV1000().setVisibility(View.INVISIBLE);
                                    EightRecordActivity.getV3000().setVisibility(View.INVISIBLE);
                                    EightRecordActivity.getV5000().setVisibility(View.INVISIBLE);
                                    EightRecordActivity.getV7000().setVisibility(View.INVISIBLE);

                                } else {

                                    EightRootActivity.getV1000().setVisibility(View.VISIBLE);
                                    EightRootActivity.getV3000().setVisibility(View.VISIBLE);
                                    EightRootActivity.getV5000().setVisibility(View.VISIBLE);
                                    EightRootActivity.getV7000().setVisibility(View.VISIBLE);

                                    EightRecordActivity.getV1000().setVisibility(View.VISIBLE);
                                    EightRecordActivity.getV3000().setVisibility(View.VISIBLE);
                                    EightRecordActivity.getV5000().setVisibility(View.VISIBLE);
                                    EightRecordActivity.getV7000().setVisibility(View.VISIBLE);

                                }
                            }
                            catch (NullPointerException e){
                                e.printStackTrace();
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
