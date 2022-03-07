package com.example.myapplication.V;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.V.Activity.EightRootActivity;

public class
BaseSurfaceEightRoot extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener, Runnable
{
float x=0 ,y =0;
float dy,dx;
    private Paint paint[]=new Paint[64];

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("................ :","touch");




        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            Log.e("................ :","down");

            x=event.getX();
            y=event.getY();




        }



        if (event.getAction()==MotionEvent.ACTION_UP)
        {
            Log.e("................ :","up");


            dx= event.getX()- x;
            dy=event.getY()-y;



            ///////////////////////////////////////////////////////////////////////////////////////////

float f=counter.getSeconds_count0_root()-1;

            if(dx>100 && f>-1){
                if (dx>dy)
                {

                    counter.setStartdraw_record(counter.getStartdraw_record()-(counter.getRate_in_s()*counter.getHorizontal_scale()));
                    counter.setEnddraw_record(counter.getEnddraw_record()-(counter.getRate_in_s()*counter.getHorizontal_scale()));



                    counter.setSeconds_count0_root(counter.getSeconds_count0_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV0().setText(counter.getSeconds_count0_root()+"s");



                    counter.setSeconds_count1000_root(counter.getSeconds_count1000_root()- counter.getHorizontal_scale());
                    EightRootActivity.getV1000().setText(counter.getSeconds_count1000_root()+"s");


                    counter.setSeconds_count2000_root(counter.getSeconds_count2000_root()- counter.getHorizontal_scale());
                    EightRootActivity.getV2000().setText(counter.getSeconds_count2000_root()+"s");


                    counter.setSeconds_count3000_root(counter.getSeconds_count3000_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV3000().setText(counter.getSeconds_count3000_root()+"s");


                    counter.setSeconds_count4000_root(counter.getSeconds_count4000_root()- counter.getHorizontal_scale());
                    EightRootActivity.getV4000().setText(counter.getSeconds_count4000_root()+"s");


                    counter.setSeconds_count5000_root(counter.getSeconds_count5000_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV5000().setText(counter.getSeconds_count5000_root()+"s");


                    counter.setSeconds_count6000_root(counter.getSeconds_count6000_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV6000().setText(counter.getSeconds_count6000_root()+"s");


                    counter.setSeconds_count7000_root(counter.getSeconds_count7000_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV7000().setText(counter.getSeconds_count7000_root()+"s");


                    counter.setSeconds_count8000_root(counter.getSeconds_count8000_root()-  counter.getHorizontal_scale());
                    EightRootActivity.getV8000().setText(counter.getSeconds_count8000_root()+"s");



                }
            }
            else if (dx<-100)
            {
                float t =(float)(counter.getExist_in_secound()*2)/1000;
                float t1=counter.getSeconds_count8000_root();

                if (dx<dy && t>t1) {




                    counter.setStartdraw_record(counter.getStartdraw_record()+(counter.getRate_in_s()*counter.getHorizontal_scale()));
                    counter.setEnddraw_record(counter.getEnddraw_record()+(counter.getRate_in_s()*counter.getHorizontal_scale()));


                    counter.setSeconds_count0_root(counter.getSeconds_count0_root()+  counter.getHorizontal_scale());
                    EightRootActivity.getV0().setText(counter.getSeconds_count0_root()+"s");



                    counter.setSeconds_count1000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()/8)*1));
                    EightRootActivity.getV1000().setText(counter.getSeconds_count1000_root()+"s");


                    counter.setSeconds_count2000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*2)/8));
                    EightRootActivity.getV2000().setText(counter.getSeconds_count2000_root()+"s");


                    counter.setSeconds_count3000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*3)/8));
                    EightRootActivity.getV3000().setText(counter.getSeconds_count3000_root()+"s");


                    counter.setSeconds_count4000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*4)/8));
                    EightRootActivity.getV4000().setText(counter.getSeconds_count4000_root()+"s");


                    counter.setSeconds_count5000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*5)/8));
                    EightRootActivity.getV5000().setText(counter.getSeconds_count5000_root()+"s");


                    counter.setSeconds_count6000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*6)/8));
                    EightRootActivity.getV6000().setText(counter.getSeconds_count6000_root()+"s");


                    counter.setSeconds_count7000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale()*7)/8));
                    EightRootActivity.getV7000().setText(counter.getSeconds_count7000_root()+"s");


                    counter.setSeconds_count8000_root(counter.getSeconds_count0_root()+ ( (counter.getHorizontal_scale())));
                    EightRootActivity.getV8000().setText(counter.getSeconds_count8000_root()+"s");






                }
            }

            else if(dy>100 && dy> dx ){




            }
            else if (dy<-100 && dy<dx){

            }
        }
        return true;

    }





    float  f[] =new float[5];
    private SurfaceHolder holder;

    private Thread drawThread;

    private boolean surfaceReady = false;

    int cannel_count=0;

    private boolean drawingActive = false;

    private Paint samplePaint = new Paint();
    private Paint samplePaint1 = new Paint();
    Counter counter;
    String1 string1;


    private static final int MAX_FRAME_TIME = (int) (1000.0 / 60.0);

    private static final String LOGTAG = "surface";

    public BaseSurfaceEightRoot(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        counter=new Counter();
        string1=new String1();
        setOnTouchListener(this);




        //  counter.setEight_step_y((float) (counter.getEight_step_y()/(string1.getChannel_count())*2));

      //  Log.e("getSurface_width",""+(float) counter.getSurface_width()/8000);
      //  Log.e("getSurface_height",""+(float) counter.getSurface_height()/200);


        //counter.setSurface_height(getHeight());
       // counter.setSurface_width(getWidth());

       // counter.setEight_step_x(counter.getSurface_width()/8000);
       // counter.setEight_step_y(counter.getSurface_height()/200);


        samplePaint.setColor(Color.BLACK);


        samplePaint.setAntiAlias(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)

    {
        if (width == 0 || height == 0)
        {
            return;
        }


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        this.holder = holder;

        counter.setSurfaceviewheheight(getWidth());



        if (drawThread != null)
        {
            Log.d(LOGTAG, "draw thread still active..");
            drawingActive = false;
            try
            {
                drawThread.join();
            } catch (InterruptedException e)
            { // do nothing
            }
        }

        surfaceReady = true;
        startDrawThread(0);

        for (int t=0;t<64;t++) {
            paint[t] = new Paint();
            paint[t].setStrokeWidth(3);
        }



        paint[0].setColor(Color.rgb(109, 195, 255));
        paint[1].setColor(Color.rgb(43, 175, 20));
        paint[2].setColor(Color.rgb(255, 20, 148));
        paint[3].setColor(Color.rgb(248, 102, 38));
        paint[4].setColor(Color.rgb(0, 38, 234));
        paint[5].setColor(Color.rgb(46, 96, 122));
        paint[6].setColor(Color.rgb(179, 146, 35));
        paint[7].setColor(Color.rgb(214, 57, 20));




        counter.setSurfaceviewheheight(getHeight());
        counter.setSurfaceviewhewidth(getWidth());

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {

        stopDrawThread();

        holder.getSurface().release();

        this.holder = null;
        surfaceReady = false;
    }





    public void stopDrawThread()
    {
        if (drawThread == null)
        {
            return;
        }
        drawingActive = false;
        while (true)
        {
            try
            {
                drawThread.join(5000);
                break;
            } catch (Exception e)
            {
            }
        }
        drawThread = null;
    }



    public void startDrawThread(int i)
    {

        cannel_count=i;
        if (surfaceReady && drawThread == null)
        {
            drawThread = new Thread(this, "Draw thread");
            drawingActive = true;
            drawThread.start();
        }
    }

    @Override
    public void run()
    {
        long frameStartTime;
        long frameTime;



        try
        {
            while (drawingActive)
            {
                if (holder == null)
                {
                    return;
                }

                frameStartTime = System.nanoTime();
                Canvas canvas = holder.lockCanvas();
                if (canvas != null)
                {

                    try
                    {
                        int t=0;

                        if (string1.getSview().equals(string1.getSeight())) {


                            canvas.drawColor(Color.rgb(230, 230, 230));

                            //  canvas.drawColor(Color.rgb(230,230,230));

                            //  canvas.drawRect(0, ((getHeight() / 4)*1)-1, getWidth(), (getHeight() / 4)*1, samplePaint);
                            // canvas.drawRect(0, ((getHeight() / 4)*2)-1, getWidth(), (getHeight() / 4)*2, samplePaint);
                            //  canvas.drawRect(0, ((getHeight() / 4)*3)-1, getWidth(), (getHeight() / 4)*3, samplePaint);


                            canvas.drawRect(((getWidth() / 4) * 1) - 1, 0, (getWidth() / 4) * 1, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 2) - 1, 0, (getWidth() / 4) * 2, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 3) - 1, 0, (getWidth() / 4) * 3, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 4) - 1, 0, (getWidth() / 4) * 4, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 5) - 1, 0, (getWidth() / 4) * 5, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 6) - 1, 0, (getWidth() / 4) * 6, getHeight(), samplePaint);
                            canvas.drawRect(((getWidth() / 4) * 7) - 1, 0, (getWidth() / 4) * 7, getHeight(), samplePaint);


                            canvas.drawRect(0, 0, getWidth(), 1, samplePaint);
                            canvas.drawRect(0, getHeight() - 4, getWidth(), getHeight(), samplePaint);


                            samplePaint1.setColor(Color.RED);


                            for (int j = 0; j < string1.getChannel_count(); j++) {
                                int y = 0;
                                for (int i = counter.getStartdraw_record(); i < counter.getEnddraw_record(); i++) {
                                    if (counter.getChannel(j, i) != 1000.0) {
                                        canvas.drawLine(
                                                (float) (y * counter.getEight_step_x()),
                                                (float) (((float) ((float) (getHeight() / (float) (string1.getChannel_count() * 2))) * (((2 * j) + 1))) + (counter.getChannel(j, i) * counter.getEight_step_y())),
                                                (float) ((y + 1) * counter.getEight_step_x()),
                                                (float) (((float) ((float) (getHeight() / (float) (string1.getChannel_count() * 2))) * (((2 * j) + 1))) + (counter.getChannel(j, i + 1) * counter.getEight_step_y())),
                                                paint[j]);
                                    }
                                    y++;

                                }
                            }
/*
for (int j=0;j<1000;j+=50) {
    if (t==255){
        t=0;
    }
    for (float i = 0; i < 1400; i += 0.05) {



        canvas.drawRect(i+(j*10), j, (float) (i+0.04), (float) (j+10), samplePaint);
        t++;
    }
}

 */
                        }else               //////single root
                            {


                                canvas.drawColor(Color.rgb(230,230,230));

                                //  canvas.drawColor(Color.rgb(230,230,230));





                                canvas.drawRect(0, ((getHeight() / 4)*1)-1, getWidth(), (getHeight() / 4)*1, samplePaint);
                                canvas.drawRect(0, ((getHeight() / 4)*2)-1, getWidth(), (getHeight() / 4)*2, samplePaint);
                                canvas.drawRect(0, ((getHeight() / 4)*3)-1, getWidth(), (getHeight() / 4)*3, samplePaint);



                                canvas.drawRect( ((getWidth() / 4)*1)-1,0,(getWidth() / 4)*1 , getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*2)-1,0, (getWidth() / 4)*2, getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*3)-1,0, (getWidth() / 4)*3, getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*4)-1,0, (getWidth() / 4)*4, getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*5)-1,0,(getWidth() / 4)*5 , getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*6)-1,0,(getWidth() / 4)*6 , getHeight(), samplePaint);
                                canvas.drawRect( ((getWidth() / 4)*7)-1,0, (getWidth() / 4)*7, getHeight(), samplePaint);


                                canvas.drawRect( 0,getHeight()-4, getWidth(), getHeight(), samplePaint);

                                canvas.drawRect(0, 0 ,1500,1, samplePaint);



                                samplePaint1.setColor(Color.rgb(65, 148, 255));
                                samplePaint1.setStrokeWidth(3);


                                int y=0;
                                for (int i = counter.getStartdraw_record(); i<counter.getEnddraw_record(); i++) {

                                    if (counter.getChannel(cannel_count,i)!=1000.0) {
                                        canvas.drawLine(y * counter.getSingle_step_x(), (getHeight() / 2) + (counter.getChannel(cannel_count, i) * counter.getSingle_step_y()), (y + 1) * counter.getSingle_step_x(), (getHeight() / 2) + (counter.getChannel(cannel_count, i + 1) * counter.getSingle_step_y()), samplePaint1);
                                    }
                                    y++;
                                }






                            }




                    } finally
                    {

                        holder.unlockCanvasAndPost(canvas);
                    }
                }




            }
        } catch (Exception e)
        {
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
