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
import android.widget.Toast;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.V.Activity.EightRootActivity;
import com.example.myapplication.V.Activity.SingleRootActivity;

public class BaseSurfaceSingle extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener, Runnable
{
float  f[] =new float[5];
    private SurfaceHolder holder;

    float x=0 ,y =0;
    float dy,dx;


    private Thread drawThread;

    int positive=0;

    private boolean surfaceReady = false;

    int cannel_count=0;

    private boolean drawingActive = false;

    private Paint samplePaint = new Paint();
    private Paint samplePaint1 = new Paint();
Counter counter;


    private static final int MAX_FRAME_TIME = (int) (1000.0 / 60.0);

    private static final String LOGTAG = "surface";


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

            float f=Float.parseFloat( SingleRootActivity.getV0().getText().toString())-counter.getHorizontal_scale();

            if(dx>100 && f>=0){
                if (dx>dy)
                {

                    counter.setStartdraw(counter.getStartdraw()-(500*counter.getHorizontal_scale()));
                    counter.setEnddraw(counter.getEnddraw()-(500*counter.getHorizontal_scale()));

                    float z=Float.parseFloat(SingleRootActivity.getV0().getText().toString())-(counter.getHorizontal_scale());

                    SingleRootActivity.getV0().setText(""+z);
                    SingleRootActivity.getV1000().setText(""+(z+(0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV2000().setText(""+(z+(2*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV3000().setText(""+(z+(3*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV4000().setText(""+(z+(4*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV5000().setText(""+(z+(5*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV6000().setText(""+(z+(6*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV7000().setText(""+(z+(7*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV8000().setText(""+(z+(8*0.125*counter.getHorizontal_scale())));
                }
            }
            else if (dx<-100)

            {
                float t =(float)(counter.getExist_in_secound()*2)/1000;
                float t1=Float.parseFloat(SingleRootActivity.getV8000().getText().toString());

                if (dx<dy && t>t1) {




                    counter.setStartdraw(counter.getStartdraw()+(500*counter.getHorizontal_scale()));
                    counter.setEnddraw(counter.getEnddraw()+(500*counter.getHorizontal_scale()));

                    float z=Float.parseFloat(SingleRootActivity.getV0().getText().toString())+(counter.getHorizontal_scale());
                    SingleRootActivity.getV0().setText(""+z);

                    SingleRootActivity.getV1000().setText(""+(z+(0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV2000().setText(""+(z+(2*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV3000().setText(""+(z+(3*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV4000().setText(""+(z+(4*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV5000().setText(""+(z+(5*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV6000().setText(""+(z+(6*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV7000().setText(""+(z+(7*0.125*counter.getHorizontal_scale())));
                    SingleRootActivity.getV8000().setText(""+(z+(8*0.125*counter.getHorizontal_scale())));
                }
            }

            else if(dy>100 && dy> dx ){


            }
            else if (dy<-100 && dy<dx){

            }
        }
        return true;

    }


    public BaseSurfaceSingle(Context context, AttributeSet attrs)
    {
       super(context, attrs);
    SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        counter=new Counter();
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
                        for (int i=counter.getStartdraw();i<counter.getEnddraw();i++) {


                            canvas.drawLine(y*counter.getSingle_step_x(), (getHeight()/2)+(counter.getChannel(cannel_count,i)*counter.getSingle_step_y()),(y+1)*counter.getSingle_step_x(),(getHeight()/2)+(counter.getChannel(cannel_count,i+1)*counter.getSingle_step_y()),samplePaint1);
                       y++;
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
