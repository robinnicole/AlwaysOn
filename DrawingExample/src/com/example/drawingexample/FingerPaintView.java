package com.example.drawingexample;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class FingerPaintView extends View implements OnTouchListener {
    private static final String TAG = "FingerPaintView";

    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
 
    


    public FingerPaintView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        //paint.setColor(Color.RED);
        //paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Path path = new Path ();
        boolean first = true;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        
    	for (Point point : points) {
    		if(first){
    			first = false;
    			path.moveTo(point.x, point.y);
    		}
    		
    		else {
    			path.lineTo(point.x, point.y);
    		}
    		
            canvas.drawPath(path, paint);
            // Log.d(TAG, "Painting: "+point);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        // if(event.getAction() != MotionEvent.ACTION_DOWN)
        // return super.onTouchEvent(event);
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        points.add(point);
        invalidate();
        Log.d(TAG, "point: " + point);
        return true;
    }
}

class Point {
    float x, y;

    @Override
    public String toString() {
        return x + ", " + y;
    }
}