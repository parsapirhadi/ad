package com.example.myapplication.V;



import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.myapplication.R;
import com.example.myapplication.V.Activity.EightRecordActivity;
import com.example.myapplication.V.Activity.EightRootActivity;
import com.example.myapplication.V.Activity.SingleRecordActivity;

public class BaseSurfaceSingleRecord extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener
{
    float  f[] =new float[5];
    private SurfaceHolder holder;

    int x=1,y=0;

    Counter counter;



    private Thread drawThread;

    float [] o={
            11,11 , 500,500 ///////////////////////////////////////////////
            ,500,500 , 500,11//////////////////////////////////////////////////////
            ,500,11 , 800,11/////////////////////////////////////////////////////
    };

    int positive=0;
    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
    private boolean surfaceReady = false;

    int cannel_count=0;

    private boolean drawingActive = false;

    private Paint samplePaint = new Paint();
    private Paint samplePaint0 = new Paint();
    private Paint samplePaint1 = new Paint();


     SingleRecordActivity.SendReceive sendReceive;
    private Paint samplePaintW = new Paint();

    Canvas canvas;




    int i1=1;
    int g;


    private static final int MAX_FRAME_TIME = (int) (1000.0 / 60.0);

    private static final String LOGTAG = "surface";




    public BaseSurfaceSingleRecord(Context context, AttributeSet attrs)
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



        samplePaint0.setColor(Color.GREEN);
        samplePaint1.setColor(Color.rgb(93, 155, 255));


        samplePaintW.setColor(Color.WHITE);

        samplePaint1.setStrokeWidth(3);

        Canvas c = holder.lockCanvas(null);

        ondraw(c);
        holder.unlockCanvasAndPost(c);

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
        public void run()
        {
            long frameStartTime;
            long frameTime;

            counter.setSurfaceview_height_singlerecord(getHeight());
            counter.setSurfaceview_Width_singlerecord(getWidth());

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



                            canvas.drawRect( ((getWidth() / 4)*1)-1,0, (getWidth() / 4)*1 , getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*2)-1,0, (getWidth() / 4)*2, getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*3)-1,0, (getWidth() / 4)*3, getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*4)-1,0, (getWidth() / 4)*4, getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*5)-1,0, (getWidth() / 4)*5 , getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*6)-1,0, (getWidth() / 4)*6 , getHeight(), samplePaint);
                            canvas.drawRect( ((getWidth() / 4)*7)-1,0, (getWidth() / 4)*7, getHeight(), samplePaint);




                            canvas.drawRect(0, 0 ,getWidth(),1, samplePaint);
                            canvas.drawRect( 0,getHeight()-4, getWidth(), getHeight(), samplePaint);

                            if ( counter.getBuffere(0,(counter.getHorizontal_scale()*500*x)-100)!=1000.0 ){
                                if (counter.isChangeScreen_single()) {
                                       counter.setChangeScreen_single(false);
                                    SingleRecordActivity.getV0().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV0().getText().toString())) + "");
                                    SingleRecordActivity.getV1000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV1000().getText().toString())) + "");
                                    SingleRecordActivity.getV2000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV2000().getText().toString())) + "");
                                    SingleRecordActivity.getV3000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV3000().getText().toString())) + "");
                                    SingleRecordActivity.getV4000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV4000().getText().toString())) + "");
                                    SingleRecordActivity.getV5000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV5000().getText().toString())) + "");
                                    SingleRecordActivity.getV6000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV6000().getText().toString())) + "");
                                    SingleRecordActivity.getV7000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV7000().getText().toString())) + "");
                                    SingleRecordActivity.getV8000().setText(((counter.getHorizontal_scale()) + Float.parseFloat(SingleRecordActivity.getV8000().getText().toString())) + "");


                                    counter.setEnddraw(counter.getEnddraw()+(counter.getHorizontal_scale()*500));
                                    counter.setStartdraw(counter.getStartdraw()+(counter.getHorizontal_scale()*500));
                                    x++;
                                }



                            }





                                int y=0;
                                int j=counter.getShow_record_ch();
                                for (i1 = counter.getStartdraw(); i1 < counter.getEnddraw(); i1++) {
                                    if (counter.getBuffere(j,i1+1)!=1000.0  ) {
                                        if (i1%30000==39990-(counter.getHorizontal_scale()*counter.getRate_in_s()*3)){



                                            for (int j2=0;j2<8;j2++){
                                                for (int j1=0;j1<40000;j1++) {
                                                    counter.setBuffer(counter.getPart_data(), j2, j1);
                                                }
                                            }

                                            counter.setStartdraw(1);
                                            counter.setEnddraw(counter.getHorizontal_scale()*counter.getRate_in_s());
                                            i1=1;




                                           x=1;

                                        }
                                        g=(i1%30000)-1;



                                        canvas.drawLine(
                                                (float) (y * counter.getSingle_step_x()),
                                                (float) (((float) ((float) (getHeight() / 2 ))) + (counter.getBuffere(j, g) * counter.getSingle_step_y())),
                                                (float) ((y+1) * counter.getSingle_step_x()),
                                                (float) (((float) ((float) (getHeight() / 2))) + (counter.getBuffere(j, (g+1)) * counter.getSingle_step_y())),
                                                samplePaint1);

                                    }
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