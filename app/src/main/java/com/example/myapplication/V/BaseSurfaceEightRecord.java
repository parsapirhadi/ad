package com.example.myapplication.V;




import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
//import android.util.Log;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.R;

public class BaseSurfaceEightRecord extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener
{
    float  f[] =new float[5];
    private SurfaceHolder holder;


    int y=0;
    float y0 =0,y1=0,y2=0,y3=0,y4=0,y5=0,y6=0,y7=0;
    float dy,dx;
    Counter counter;
    String1 string1;


    int i1=1;
    int g;


    private Thread drawThread;

    float [] o={
            11,11 , 500,500 ///////////////////////////////////////////////
            ,500,500 , 500,11//////////////////////////////////////////////////////
            ,500,11 , 800,11/////////////////////////////////////////////////////
    };
    int no_limit;
    int positive=0;
    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
    private boolean surfaceReady = false;

    int cannel_count=0;

    private boolean drawingActive = false;

    private Paint samplePaint = new Paint();

    private Paint samplePaint0 = new Paint();


   private Paint paint[]=new Paint[64];

    private Paint single_paint = new Paint();

    private Paint samplePaint1 = new Paint();
    private Paint samplePaint2 = new Paint();
    private Paint samplePaint3 = new Paint();
    private Paint samplePaint4 = new Paint();
    private Paint samplePaint5 = new Paint();
    private Paint samplePaint6 = new Paint();
    private Paint samplePaint7 = new Paint();

    private Paint samplePaintW = new Paint();

    Canvas canvas;

    int i=1;

    private static final int MAX_FRAME_TIME = (int) (1000.0 / 60.0);

    private static final String LOGTAG = "surface";




    public BaseSurfaceEightRecord(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setOnTouchListener(this);




        samplePaint.setColor(Color.BLACK);


        samplePaint.setAntiAlias(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)

    {
        samplePaint1.setColor(Color.RED);

        if (width == 0 || height == 0)
        {
            return;
        }


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        this.holder = holder;

        if (drawThread != null)
        {
            samplePaint1.setColor(Color.RED);

            // Log.d(LOGTAG, "draw thread still active..");
            drawingActive = false;
            try
            {
                drawThread.join(0);
            } catch (InterruptedException e)
            { // do nothing
            }
        }

        surfaceReady = true;
        startDrawThread(0);
        // Log.d(LOGTAG, "Created");
        counter =new Counter();
        string1=new String1();
        samplePaint0.setStrokeWidth(4);
        samplePaint1.setStrokeWidth(4);
        samplePaint2.setStrokeWidth(4);
        samplePaint3.setStrokeWidth(4);
        samplePaint4.setStrokeWidth(4);
        samplePaint5.setStrokeWidth(4);
        samplePaint6.setStrokeWidth(4);
        samplePaint7.setStrokeWidth(4);


        samplePaint0.setColor(Color.GREEN);

        samplePaint2.setColor(Color.GREEN);
        samplePaint3.setColor(Color.GREEN);
        samplePaint4.setColor(Color.GREEN);
        samplePaint5.setColor(Color.GREEN);
        samplePaint6.setColor(Color.GREEN);
        samplePaint7.setColor(Color.GREEN);





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


        single_paint.setColor(Color.rgb(0, 158, 255));



        single_paint.setStrokeWidth(3);

        counter.getSp().setColor(Color.rgb(230,230,230));


        samplePaintW.setColor(Color.WHITE);

        samplePaint1.setStrokeWidth(3);




        Canvas c = holder.lockCanvas(null);

        ondraw(c);
        holder.unlockCanvasAndPost(c);

        no_limit=24990-(counter.getHorizontal_scale()*counter.getRate_in_s()*3);



        counter.setSurface_height(getHeight());
        counter.setSurface_width(getWidth());

        counter.setSingle_step_x((float) counter.getSurface_width() / (counter.getRate_in_s() * counter.getHorizontal_scale()));
        counter.setSingle_step_y((float) counter.getSurface_height() / 200);


       // counter.setEight_step_x((float) counter.getSurface_width()/(500*counter.getHorizontal_scale()));
       // counter.setEight_step_y((float) counter.getSurface_height()/200);
     //   counter.setEight_step_y((counter.getEight_step_y()/string1.getChannel_count())/2);


        counter.setEight_step_x((float) counter.getSurface_width()/(counter.getRate_in_s()*counter.getHorizontal_scale()));
        counter.setEight_step_y((float) counter.getSurface_height()/200);
        counter.setEight_step_y((counter.getEight_step_y()/counter.getDefault_channel())/2);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {

        stopDrawThread();

        holder.getSurface().release();

        this.holder = null;
        surfaceReady = false;
        Log.d(LOGTAG, "Destroyed");


    }




    public void stopDrawThread()
    {
        if (drawThread == null)
        {
            Log.d(LOGTAG, "DrawThread is null");
            return;
        }
      drawingActive = false;
        while (true)
        {
            try
            {
                Log.d(LOGTAG, "Request last frame");
                drawThread.join(0);
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
            samplePaint1.setColor(Color.RED);
            drawThread = new Thread(runnable1, "Draw thread");
            drawingActive = true;
            drawThread.start();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////



    @SuppressLint("SetTextI18n")
    Runnable runnable1=new Runnable() {
        @Override
        public void run()
        {
            long frameStartTime;
            long frameTime;

            counter.setSurfaceview_height_eightrecord(getHeight());
            counter.setSurfaceview_Width_eightrecord(getWidth());
            samplePaint1.setColor(Color.RED);

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

                        try {
                            int t = 0;


                            if (string1.getSview().equals(string1.getSeight())){



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


                                counter.setSignal_is_weak(true);
                                if (string1.getMontage().equals("mono")){


                                    for (int p=counter.getLoop_counter();p<=counter.getLine_stop_counter() ; p++)
                                        {                                  //      if (counter.getO()>200) {

                                            canvas.drawRect((float) (counter.getStop_line(p%30) - 0.1), 2, 4 + counter.getStop_line(p%30), getHeight() - 4, counter.getSp());

                                        //  }
                                        if (((float)counter.getO()/(0.99*counter.getHorizontal_scale()*counter.getRate_in_s()))*counter.getSurface_width()-counter.getStop_line(p%30)<-2
                                                &&  ((float)counter.getO()/(0.99*counter.getHorizontal_scale()*counter.getRate_in_s()))*counter.getSurface_width()-counter.getStop_line(p%30)>-30

                                        ){
                                             counter.setStop_line(10000,p%30);
                                            counter.setLoop_counter(counter.getLoop_counter()+1);
                                        }
                                    }

                                    for (int j = 0; j < counter.getDefault_channel(); j++) {
                                    int y = 0;

                                    for (i1 = counter.getStartdraw_record(); i1 < (counter.getEnddraw_record()+200); i1++) {

                                   //   Log.e("S = "+counter.getStartdraw(),"E ="+counter.getEnddraw());

                                        if (counter.getBuffere(j, i1) != counter.getPart_data()
                                                && counter.getBuffere(j, i1 - 1) != counter.getPart_data()
                                        ) {


                                            g = (i1 % 15000) - 1;


                                            canvas.drawLine(
                                                    (float) (y * counter.getEight_step_x()),
                                                    (float) (((float) ((float) (getHeight() / (float) (counter.getDefault_channel() * 2))) * (((2 * j) + 1))) + (counter.getBuffere(j, g) * counter.getEight_step_y())),
                                                    (float) ((y + 1) * counter.getEight_step_x()),
                                                    (float) (((float) ((float) (getHeight() / (float) (counter.getDefault_channel() * 2))) * (((2 * j) + 1))) + (counter.getBuffere(j, (g + 1)) * counter.getEight_step_y())),
                                                    paint[j]);

                                        }
                                        y++;

                                    }
                                }


                            }


                            if (string1.getMontage().equals("banana")) {





                                for (int j = 0; j < counter.getDefault_channel(); j++) {
                                    int y = 0;
                                    for (i1 = (counter.getStartdraw_record()+10); i1 < counter.getEnddraw_record(); i1++) {
                                        if (counter.getBuffere(j, i1 + 1) != counter.getPart_data()) {



                                            g = (i1 % 15000) - 1;
                                            //Log.e("i=", "" + g);

                                            canvas.drawLine(
                                                    (float) (y * counter.getEight_step_x()),
                                                    (float) (((float) ((float) (getHeight() / (float) (counter.getDefault_channel() * 2))) * (((2 * j) + 1))) + (counter.getBuffere(j, g) * counter.getEight_step_y())),
                                                    (float) ((y + 1) * counter.getEight_step_x()),
                                                    (float) (((float) ((float) (getHeight() / (float) (counter.getDefault_channel() * 2))) * (((2 * j) + 1))) + (counter.getBuffere(j, (g + 1)) * counter.getEight_step_y())),
                                                    paint[j]);

                                        }
                                        y++;

                                    }
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


                            }
                            else {
                             ///////////////////////////single record


                                canvas.drawColor(Color.rgb(230, 230, 230));
                                //canvas.drawRect(counter.getStop_line(0), 2, 4+counter.getStop_line(0), getHeight()-4, counter.getSp());

                                //  canvas.drawColor(Color.rgb(230,230,230));

                                canvas.drawRect(0, ((getHeight() / 4) * 1) - 1, getWidth(), (getHeight() / 4) * 1, samplePaint);
                                canvas.drawRect(0, ((getHeight() / 4) * 2) - 1, getWidth(), (getHeight() / 4) * 2, samplePaint);
                                canvas.drawRect(0, ((getHeight() / 4) * 3) - 1, getWidth(), (getHeight() / 4) * 3, samplePaint);


                                canvas.drawRect(((getWidth() / 4) * 1) - 1, 0, (getWidth() / 4) * 1, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 2) - 1, 0, (getWidth() / 4) * 2, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 3) - 1, 0, (getWidth() / 4) * 3, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 4) - 1, 0, (getWidth() / 4) * 4, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 5) - 1, 0, (getWidth() / 4) * 5, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 6) - 1, 0, (getWidth() / 4) * 6, getHeight(), samplePaint);
                                canvas.drawRect(((getWidth() / 4) * 7) - 1, 0, (getWidth() / 4) * 7, getHeight(), samplePaint);


                                for (int p=counter.getLoop_counter();p<=counter.getLine_stop_counter() ; p++) {
{                                  //      if (counter.getO()>200) {

                            canvas.drawRect((float) (counter.getStop_line(p%30) - 0.1), 2, 4 + counter.getStop_line(p%30), getHeight() - 4, counter.getSp());
}
                              //  }
                                    if (((float)counter.getO()/(0.99*counter.getHorizontal_scale()*counter.getRate_in_s()))*counter.getSurface_width()-counter.getStop_line(p%30)<-2
                                    &&  ((float)counter.getO()/(0.99*counter.getHorizontal_scale()*counter.getRate_in_s()))*counter.getSurface_width()-counter.getStop_line(p%30)>-30

                                    ){
                                        counter.setStop_line(10000,p%30);
                                        counter.setLoop_counter(counter.getLoop_counter()+1);
                                    }
                                }


                                canvas.drawRect(0, 0, getWidth(), 1, samplePaint);
                                canvas.drawRect(0, getHeight() - 4, getWidth(), getHeight(), samplePaint);

                                counter.setSignal_is_weak(true);







                                int y = 0;
                                int j = counter.getShow_record_ch();
                                for (i1 = counter.getStartdraw_record(); i1 < (counter.getEnddraw_record()+200); i1++) {



                                    if (counter.getBuffere(j, i1) != counter.getPart_data()
                                            && counter.getBuffere(j, i1 - 1) != counter.getPart_data()
                                    ) {


                                        g = (i1 % 15000) - 1;


                                        canvas.drawLine(
                                                (float) (y * counter.getSingle_step_x()),
                                                (float) (((float) ((float) (getHeight() / 2))) + (counter.getBuffere(j, g) * counter.getSingle_step_y())),
                                                (float) ((y + 1) * counter.getSingle_step_x()),
                                                (float) (((float) ((float) (getHeight() / 2))) + (counter.getBuffere(j, (g + 1)) * counter.getSingle_step_y())),
                                                single_paint);

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
    };


    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }


    public void ondraw(Canvas canvas) {


    }
}