package com.example.myapplication.P;

import android.bluetooth.BluetoothSocket;
import android.util.Log;


import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.Objects;

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

    int no_limit;
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

    public void run()
    {
        byte[] buffer=new byte[counter.getRate_in_s()];

        no_limit=16001-(counter.getHorizontal_scale()*counter.getRate_in_s()*3);
        while (counter.is_activity_on())
        {

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

                        o=(counter.getBuffer_count()/counter.getDefault_channel())%(no_limit);

                        while (!is_buffer_null){


                            if (counter.getBuffere(channel,o)==counter.getPart_data()){

                                break;
                            }

                            counter.setSignal_is_weak(false);



                            counter.setBuffer_count(counter.getBuffer_count()+8);

                            o=(counter.getBuffer_count()/8)%(16001-(counter.getHorizontal_scale()*counter.getRate_in_s()*3));


                        }


                        counter.setBuffer(((float) ((data - 2048) / 1.4)), channel, o);
                        channel++;



                        if (o%((500*counter.getHorizontal_scale()))==0) {

                            counter.setChangeScreen_eight(true);

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
                            counter.setBuffer( ((float)  ((data - 2048) / 1.4)), counter.getDefault_channel()-1, o);

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