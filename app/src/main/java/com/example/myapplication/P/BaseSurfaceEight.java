package com.example.myapplication.P;

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
import android.widget.Toast;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

public class BaseSurfaceEight extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener, Runnable
{
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

    public BaseSurfaceEight(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        counter=new Counter();
        string1=new String1();
        setOnTouchListener(this);



        Log.e("....................",""+counter.getEight_step_y());

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
        Log.d(LOGTAG, "Created");
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
                drawThread.join(5000);
                break;
            } catch (Exception e)
            {
                Log.e(LOGTAG, "Could not join with draw thread");
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
        Log.d(LOGTAG, "Draw thread started");
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


                        canvas.drawColor(Color.rgb(230,230,230));

                        //  canvas.drawColor(Color.rgb(230,230,230));

                      //  canvas.drawRect(0, ((getHeight() / 4)*1)-1, getWidth(), (getHeight() / 4)*1, samplePaint);
                       // canvas.drawRect(0, ((getHeight() / 4)*2)-1, getWidth(), (getHeight() / 4)*2, samplePaint);
                      //  canvas.drawRect(0, ((getHeight() / 4)*3)-1, getWidth(), (getHeight() / 4)*3, samplePaint);



                        canvas.drawRect( ((getWidth() / 4)*1)-1,0, (getWidth() / 4)*1 , getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*2)-1,0, (getWidth() / 4)*2, getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*3)-1,0, (getWidth() / 4)*3, getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*4)-1,0, (getWidth() / 4)*4, getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*5)-1,0, (getWidth() / 4)*5 , getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*6)-1,0, (getWidth() / 4)*6 , getHeight(), samplePaint);
                        canvas.drawRect( ((getWidth() / 4)*7)-1,0, (getWidth() / 4)*7, getHeight(), samplePaint);



                        canvas.drawRect(0, 0 ,1500,1, samplePaint);



                        samplePaint1.setColor(Color.RED);
                          Log.e("getSurface_height",""+counter.getEight_step_y());
                          Log.e("getSurface_width",""+counter.getEight_step_x());


                        for (int j=0;j<string1.getChannel_count();j++) {
                            for (int i = 0; i < 8000; i++) {
                                //  canvas.drawLine(i, (getHeight()/2)+counter.getChannel(cannel_count,i),i+1,(getHeight()/2)+counter.getChannel(cannel_count,i+1),samplePaint1);
                                canvas.drawLine(
                                        (float) (i*counter.getEight_step_x()),
                                        (float) (((float) ((float)(getHeight()/(float)(string1.getChannel_count()*2)))*(((2*j)+1)))+(counter.getChannel(j,i)*counter.getEight_step_y())),
                                        (float) ((i+1)*counter.getEight_step_x()),
                                        (float) (((float) ((float)(getHeight()/(float)(string1.getChannel_count()*2)))*(((2*j)+1)))+(counter.getChannel(j,i+1)*counter.getEight_step_y())),
                                        samplePaint1);

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

                    } finally
                    {

                        holder.unlockCanvasAndPost(canvas);
                    }
                }


                frameTime = (System.nanoTime() - frameStartTime) / 1000000;

                if (frameTime < MAX_FRAME_TIME) // faster than the max fps - limit the FPS
                {
                    try
                    {
                        Thread.sleep(MAX_FRAME_TIME - frameTime);
                    } catch (InterruptedException e)
                    {
                        // ignore
                    }
                }
            }
        } catch (Exception e)
        {
            Log.w(LOGTAG, "Exception while locking/unlocking");
        }
        Log.d(LOGTAG, "Draw thread finished");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
