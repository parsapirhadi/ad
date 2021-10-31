package com.example.myapplication.P;

import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

public class SetPivotName {
    String one="";
    Counter integer1=new Counter();
    int q =0;
    int pivote_counter=0;
    String1 string1;
    Counter  counter;

    public SetPivotName(String one, String1 string1,Counter counter) {
        this.one = one;
        this.string1 = string1;
        this.counter=counter;
    }





    public void set(){
        int w=one.length();
        w-=2;
        Log.e("0",""+w);
        one_item();
 findcountname(0,one.length());

    }
    public void setname(int i, int j) { //////////////////gh


        String sum = "";
        String h;
        String ft = "";
        for (int b = i; b <= j; b++) {
            sum += one.charAt(b);
        }

        ft =sum;

        string1.setChannel_count(string1.getChannel_count()+1);
        ////////////////////////////////////////////


        ////////////////////////////////////////////


      string1.setPivote(q,ft);
   q++;



    }
    public void findcountname(int i,int j){ ////////////////////////sd
        for(int b=6;b<=j-1;b++){
            if(one.charAt(b)==' '){
                for(int y=b-1;y>b-6;y--){
                    if(one.charAt(y)==' '){

                        setname(y+1,b-1);
                        y=-1;

                        break;

                    }
                }
            }

        }
    }
    public void one_item() {
        String h="";
        int s=0;
        //Log.e("fffffffffffff","5555");

        for(s=0;s<6;s++){
            if(one.charAt(s)!=' '){
                h+=one.charAt(s);

            }
            else {break;}
        }
        setname(0,s-1);
    }

}
