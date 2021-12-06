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
import com.example.myapplication.V.Activity.EightRecordActivity;
import com.example.myapplication.V.Activity.EightRootActivity;

public class BaseSurfaceEightRecord extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener
{
    float  f[] =new float[5];
    private SurfaceHolder holder;

    float x=0 ,y=0;
    float y0 =0,y1=0,y2=0,y3=0,y4=0,y5=0,y6=0,y7=0;
    float dy,dx;
    Counter counter;

    private Thread drawThread;

float [] o={
           11,11 , 500,500 ///////////////////////////////////////////////
        ,500,500 , 500,11//////////////////////////////////////////////////////
         ,500,11 , 800,11/////////////////////////////////////////////////////
};

    int positive=0;

    private boolean surfaceReady = false;

    int cannel_count=0;

    private boolean drawingActive = false;

    private Paint samplePaint = new Paint();
    private Paint samplePaint0 = new Paint();
    private Paint samplePaint1 = new Paint();
    private Paint samplePaint2 = new Paint();
    private Paint samplePaint3 = new Paint();
    private Paint samplePaint4 = new Paint();
    private Paint samplePaint5 = new Paint();
    private Paint samplePaint6 = new Paint();
    private Paint samplePaint7 = new Paint();

    Canvas canvas;

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
        samplePaint0.setStrokeWidth(4);
        samplePaint1.setStrokeWidth(4);
        samplePaint2.setStrokeWidth(4);
        samplePaint3.setStrokeWidth(4);
        samplePaint4.setStrokeWidth(4);
        samplePaint5.setStrokeWidth(4);
        samplePaint6.setStrokeWidth(4);
        samplePaint7.setStrokeWidth(4);


        samplePaint0.setColor(Color.rgb(189, 95, 130));
        samplePaint1.setColor(Color.rgb(156, 1, 150));
        samplePaint2.setColor(Color.rgb(225, 32, 32));
        samplePaint3.setColor(Color.rgb(190, 2, 130));
        samplePaint4.setColor(Color.rgb(137, 32, 28));
        samplePaint5.setColor(Color.rgb(189, 95, 14));
        samplePaint6.setColor(Color.rgb(220, 40, 50));
        samplePaint7.setColor(Color.rgb(237, 38, 154));


        samplePaint1.setStrokeWidth(3);

        samplePaint0.setDither(true);
        samplePaint1.setDither(true);
        samplePaint2.setDither(true);
        samplePaint3.setDither(true);
        samplePaint4.setDither(true);
        samplePaint5.setDither(true);
        samplePaint6.setDither(true);
        samplePaint7.setDither(true);


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
            drawThread = new Thread(runnable1, "Draw thread");
            drawingActive = true;
            drawThread.start();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////



    @SuppressLint("SetTextI18n")
    Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            // Log.d(LOGTAG, "Draw thread started");
            long frameStartTime;
            long frameTime;
            if (holder == null) {

            }
            try {
                while (drawingActive) {
                    if (holder == null) {
                        return;
                    }

                    frameStartTime = System.nanoTime();
                    canvas = holder.lockCanvas();
                    if (canvas != null) {

                        try {
                            int t = 0;


                            canvas.drawColor(Color.rgb(230, 230, 230));

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


                            canvas.drawRect(0, getHeight() - 4, getWidth(), getHeight(), samplePaint);

                            canvas.drawRect(0, 0, 1500, 1, samplePaint);


                            y0 = 0;
                            y1 = 0;
                            y2 = 0;
                            y3 = 0;
                            y4 = 0;
                            y5 = 0;
                            y6 = 0;
                            y7 = 0;
                            if (counter.getChannel(0, counter.getEnddraw() - 250) != counter.getPart_data()) {

                                for (int j2 = 0; j2 < 9; j2++) {
                                    for (int j1 = 0; j1 < (counter.getEnddraw()); j1++) {
                                        counter.setChannel(counter.getPart_data(), j2, j1);
                                    }

                                }

                                counter.setStartdraw(counter.getStartdraw() + (500 * counter.getHorizontal_scale()));
                                counter.setEnddraw(counter.getEnddraw() + (500 * counter.getHorizontal_scale()));
                                counter.setX(counter.getX() + 1);

                            }
                            float g = (float) getHeight() / 16;


                            //canvas.drawLine(0,0,getWidth(),getHeight(),samplePaint4);
                            canvas.drawLines(o,samplePaint4);


                            for (int i = 1 + counter.getStartdraw(); i < counter.getEnddraw(); i++) {
                                //if (counter.getChannel(0, i)!=1000 ) {
                                canvas.drawPoint((y0) * counter.getEight_step_x(), (float) (((float) ((float) (g * 1) + (counter.getChannel(0, i) * counter.getEight_step_y())))), samplePaint0);
                                //canvas.drawLine((y0)*counter.getEight_step_x()
                                //   ,   (float) (((float) ((float) (g*1) + (counter.getChannel(0,i-1) * counter.getEight_step_y()))))
                                //   , (y0 + 1)*counter.getEight_step_x()
                                //   ,   (float) (((float) (g*1) + (counter.getChannel(0, i) * counter.getEight_step_y()))),samplePaint0);


                                y0++;

                                //  }
                                // if (counter.getChannel(1, i)!=1000 ) {
                                canvas.drawPoint((y1) * counter.getEight_step_x(), (float) (((float) ((float) (g * 3) + (counter.getChannel(1, i) * counter.getEight_step_y())))), samplePaint1);

                                // canvas.drawLine((y1)*counter.getEight_step_x()
                                //    ,   (float) (((float) ((float) (g*3) + (counter.getChannel(1,i-1) * counter.getEight_step_y()))))
                                //   , (y1 + 1)*counter.getEight_step_x()
                                //   ,   (float) (((float) (g*3) + (counter.getChannel(1, i ) * counter.getEight_step_y()))),samplePaint1);
                                y1++;

                                // }  if (counter.getChannel(2, i)!=1000 ) {
                                canvas.drawPoint((y2) * counter.getEight_step_x(), (float) (((float) ((float) (g * 5) + (counter.getChannel(2, i) * counter.getEight_step_y())))), samplePaint2);

                                //  canvas.drawLine((y2)*counter.getEight_step_x()
                                //     ,   (float) (((float) ((float) (g*5) + (counter.getChannel(2,i-1) * counter.getEight_step_y()))))
                                //     , (y2 + 1)*counter.getEight_step_x()
                                //    ,   (float) (((float) (g*5) + (counter.getChannel(2, i ) * counter.getEight_step_y()))),samplePaint2);
                                y2++;

                                // }  if (counter.getChannel(3, i)!=1000 ) {
                                canvas.drawPoint((y3) * counter.getEight_step_x(), (float) (((float) ((float) (g * 7) + (counter.getChannel(3, i) * counter.getEight_step_y())))), samplePaint3);

                                //   canvas.drawLine((y3)*counter.getEight_step_x()
                                // ,   (float) (((float) ((float) (g*7) + (counter.getChannel(3,i-1) * counter.getEight_step_y()))))
                                //  , (y3 + 1)*counter.getEight_step_x()
                                //   ,   (float) (((float) (g*7) + (counter.getChannel(3, i ) * counter.getEight_step_y()))),samplePaint3);
                                y3++;

                                //  }  if (counter.getChannel(4, i)!=1000 ) {
                                canvas.drawPoint((y4) * counter.getEight_step_x(), (float) (((float) ((float) (g * 9) + (counter.getChannel(4, i) * counter.getEight_step_y())))), samplePaint4);

                                // canvas.drawLine((y4)*counter.getEight_step_x()
                                //     ,   (float) (((float) ((float) (g*9) + (counter.getChannel(4,i-1) * counter.getEight_step_y()))))
                                //   , (y4 + 1)*counter.getEight_step_x()
                                //   ,   (float) (((float) (g*9) + (counter.getChannel(4, i) * counter.getEight_step_y()))),samplePaint4);
                                y4++;

                                //  }  if (counter.getChannel(5, i)!=1000 ) {
                                canvas.drawPoint((y5) * counter.getEight_step_x(), (float) (((float) ((float) (g * 11) + (counter.getChannel(5, i) * counter.getEight_step_y())))), samplePaint5);

                                // canvas.drawLine((y5)*counter.getEight_step_x()
                                //     ,   (float) (((float) ((float) (g*11) + (counter.getChannel(5,i-1) * counter.getEight_step_y()))))
                                //    , (y5 + 1)*counter.getEight_step_x()
                                //     ,   (float) (((float) (g*11) + (counter.getChannel(5, i ) * counter.getEight_step_y()))),samplePaint5);
                                y5++;
                                // }  if (counter.getChannel(6, i)!=1000 ) {
                                canvas.drawPoint((y6) * counter.getEight_step_x(), (float) (((float) ((float) (g * 13) + (counter.getChannel(6, i) * counter.getEight_step_y())))), samplePaint6);

                                //canvas.drawLine((y6)*counter.getEight_step_x()
                                //    ,   (float) (((float) ((float) (g*13) + (counter.getChannel(6,i-1) * counter.getEight_step_y()))))
                                //    , (y6 + 1)*counter.getEight_step_x()
                                //    ,   (float) (((float) (g*13) + (counter.getChannel(6, i ) * counter.getEight_step_y()))),samplePaint6);
                                y6++;

                                //  }  if (counter.getChannel(7, i)!=1000 ) {
                                canvas.drawPoint((y7) * counter.getEight_step_x(), (float) (((float) ((float) (g * 15) + (counter.getChannel(7, i) * counter.getEight_step_y())))), samplePaint0);

                                //canvas.drawLine((y7)*counter.getEight_step_x()
                                //  ,   (float) (((float) ((float) (g*15) + (counter.getChannel(7,i-1) * counter.getEight_step_y()))))
                                //  , (y7 + 1)*counter.getEight_step_x()
                                //  ,   (float) (((float) (g*15) + (counter.getChannel(7, i ) * counter.getEight_step_y()))),samplePaint7);
                                y7++;

                                // }

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

                        } finally {

                            holder.unlockCanvasAndPost(canvas);
                        }
                    }


                    //  frameTime = (System.nanoTime() - frameStartTime) / 1000000;

                    //  if (frameTime < MAX_FRAME_TIME) // faster than the max fps - limit the FPS
                    //  {
                    //    try
                    //    {
                    //     Thread.sleep(MAX_FRAME_TIME - frameTime);
                    //    } catch (InterruptedException e)
                    //   {
                    // ignore
                    //   }
                    //  }
                }
            } catch (Exception e) {
                //  Log.w(LOGTAG, "Exception while locking/unlocking");
            }
            //    Log.d(LOGTAG, "Draw thread finished");
        }
    };


    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
