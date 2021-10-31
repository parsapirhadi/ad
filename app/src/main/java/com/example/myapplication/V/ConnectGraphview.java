package com.example.myapplication.V;

import android.graphics.Color;
import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;
import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ConnectGraphview {
   GraphView graphView;
   Counter counter;
   String1 string1;
  int r=255;
  int g=100;
   int b=0;

    int count=0;

    public ConnectGraphview(GraphView graphView, Counter counter,String1 string1) {
        this.graphView = graphView;
        this.counter= counter;
        this.string1=string1;

        Log.e("{{{{{{{{{{{{{{{{{{{{{{{",""+string1.getChannel_count());
        count=255/string1.getChannel_count();
    }

    public void draw(){
        DrawGraphView drawGraphView=new DrawGraphView(string1.getChannel_count(),string1);
        for (int i=0;i<string1.getChannel_count();i++) {
            drawGraphView.draw(i, counter, graphView,r-=count,g,b+=count);
        }
        /*
    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{

            new DataPoint(0, 1),
            new DataPoint(1, 3),
            new DataPoint(2, 4),
            new DataPoint(3, 9),
            new DataPoint(4, 6),
            new DataPoint(5, 3),
            new DataPoint(6, 6),
            new DataPoint(7, 1),
            new DataPoint(8, 2)
    });


         */
/*
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series3= new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series6 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series7 = new LineGraphSeries<DataPoint>();
        LineGraphSeries<DataPoint> series8 = new LineGraphSeries<DataPoint>();

        if(counter.getChannel_count()>8){
          //////////////////16channel
        }
        if(counter.getChannel_count()>16){
            //////////////////32channel

        }
        if(counter.getChannel_count()>32){
            //////////////////64channel
        }

         for(int z=0;z<60000;z+=6) {

            series1.appendData(new DataPoint(z,  counter.getAll(z)), false, 65000);
            series2.appendData(new DataPoint(z, counter.getAll(z) + 100), false, 65000);
            series3.appendData(new DataPoint(z, counter.getAll(z) + 200), false, 65000);
            series4.appendData(new DataPoint(z, counter.getAll(z) + 300), false, 65000);
            series5.appendData(new DataPoint(z, counter.getAll(z) - 100), false, 65000);
            series6.appendData(new DataPoint(z, counter.getAll(z) - 200), false, 65000);
            series7.appendData(new DataPoint(z, counter.getAll(z) - 300), false, 65000);
            series8.appendData(new DataPoint(z, counter.getAll(z) - 400), false, 65000);

        }



        graphView.getViewport().setMaxX(4000);
        graphView.getViewport().setMinX(0);

        graphView.getViewport().setMaxY(300);
        graphView.getViewport().setMinY(-500);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalableY(true);

        //graphView.setTitle("My Graph View");
        //// graphView.setTitleTextSize(9);

        graphView.addSeries(series8);
        graphView.addSeries(series1);
        graphView.addSeries(series2);
        graphView.addSeries(series3);
        graphView.addSeries(series4);
        graphView.addSeries(series5);
        graphView.addSeries(series6);
        graphView.addSeries(series7);

        series3.setColor(Color.BLUE);
        series2.setColor(Color.YELLOW);
        series1.setColor(Color.GREEN);
        series8.setColor(Color.CYAN);
        series4.setColor(Color.BLUE);
        series5.setColor(Color.YELLOW);
        series6.setColor(Color.GREEN);
        series7.setColor(Color.CYAN);




        series8.setColor(Color.rgb(30,30,30));


 */
    }

}


