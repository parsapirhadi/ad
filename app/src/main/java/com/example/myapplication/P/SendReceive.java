package com.example.myapplication.P;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.util.Log;


import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;
import com.example.myapplication.V.Activity.EightRecordActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.example.myapplication.V.Activity.EightRecordActivity.STATE_MESSAGE_RECEIVED;

public class SendReceive extends Thread {

    InputStream tempIn=null;
    OutputStream tempOut=null;

    boolean is_buffer_null=false;

    boolean next_is_zarib=true;

    int channel=-1;

    float data=0;

    int zarib=0;

    int change_counter=1;
    int y =0;
    int o;

int s;

    InputStream inputStream;
    OutputStream outputStream;
    Objects objects;

Counter counter;



    private final BluetoothSocket bluetoothSocket;


    public SendReceive (BluetoothSocket socket, Counter counter, Objects objects)
    {

        bluetoothSocket=socket;

        this.counter=counter;

        this.objects=objects;

        try {
            tempIn=bluetoothSocket.getInputStream();

            tempOut=bluetoothSocket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        inputStream=tempIn;
        outputStream=tempOut;
    }

    @SuppressLint({"SetTextI18n", "LongLogTag"})
    public void run()
    {
        byte[] buffer=new byte[counter.getRate_in_s()];

        while (counter.is_receive_activity_on())
        {

           Log.d("mmmmm","mmmm");
            try {

                s=inputStream.read();
                counter.setSignal_is_weak(false);




            } catch (IOException e) {

                e.printStackTrace();
                break;
            }
            // bytes =s;




            objects.getHandler().obtainMessage(STATE_MESSAGE_RECEIVED, s, -1, buffer).sendToTarget();



            if (channel!=-1)
            {

                if (next_is_zarib){

                    zarib=s;
                    next_is_zarib=false;

                }
                else {

                    next_is_zarib=true;
                    data=(zarib*256)+s;
                    if (zarib<255){

                        if (counter.getBuffere(0,1500)==counter.getPart_data()) {
                            counter.setChangeScreen_eight(true);


                        }


                        counter.setO((int) ((counter.getBuffer_count()/counter.getDefault_channel())%(counter.getHorizontal_scale()*counter.getRate_in_s()*0.95)));


                        if (counter.isChangeScreen_eight()
                                &&
                           counter.getBuffere(0,(counter.getHorizontal_scale()*(counter.getRate_in_s()-30)))!=counter.getPart_data()
                        ){
                            change_counter++;
                            counter.setChangeScreen_eight(false);













                            Log.e("mmm",""+counter.getBuffer_count());

                            counter.setSeconds_count0(counter.getSeconds_count0()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count1000(counter.getSeconds_count1000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count2000(counter.getSeconds_count2000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count3000(counter.getSeconds_count3000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count4000(counter.getSeconds_count4000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count5000(counter.getSeconds_count5000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count6000(counter.getSeconds_count6000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count7000(counter.getSeconds_count7000()+(counter.getHorizontal_scale()));
                            counter.setSeconds_count8000(counter.getSeconds_count8000()+(counter.getHorizontal_scale()));



                            EightRecordActivity.getV0().setText(counter.getSeconds_count0()+ "s");
                            EightRecordActivity.getV1000().setText(counter.getSeconds_count1000()+ "s");
                            EightRecordActivity.getV2000().setText(counter.getSeconds_count2000()+ "s");
                            EightRecordActivity.getV3000().setText(counter.getSeconds_count3000()+ "s");
                            EightRecordActivity.getV4000().setText(counter.getSeconds_count4000()+ "s");
                            EightRecordActivity.getV5000().setText(counter.getSeconds_count5000()+ "s");
                            EightRecordActivity.getV6000().setText(counter.getSeconds_count6000()+ "s");
                            EightRecordActivity.getV7000().setText(counter.getSeconds_count7000()+ "s");
                            EightRecordActivity.getV8000().setText(counter.getSeconds_count8000()+ "s");

                        }


                        counter.setBuffer(((float) ((data - 2048) / 1.4)), channel, counter.getO());
                        channel++;

                        if (counter.getO()%(counter.getHorizontal_scale()*counter.getRate_in_s()*0.95)==0) {


                            if (counter.isEightRecord_ispause() ){






                                for (int j2 = 0; j2 < 8; j2++) {
                                for (int j1 = 0; j1 < 16000; j1++) {

                                    counter.setSignal_is_weak(false);

                                    counter.setBuffer(counter.getPart_data(), j2, j1);



                                }
                            }
                        }

                        }

                        if (channel==counter.getDefault_channel()) {
                            channel=0;
                            counter.setRefresh(true);
                            counter.setBuffer( ((float)  ((data - 2048) / 1.4)), counter.getDefault_channel()-1, counter.getO());


                        }


                        counter.setBuffer_count(counter.getBuffer_count()+1);

                    }


                }
            }
            if (s==255)
            {


                y++;
            }



            if (y==1 && s<255){

                y=0;
            }
            if (y==2)
            {
                y=0;



                channel=0;
                next_is_zarib=true;
            }



        }
    }
    public void write(byte[] bytes)
    {
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}