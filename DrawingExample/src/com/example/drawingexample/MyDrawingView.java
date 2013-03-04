package com.example.drawingexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyDrawingView extends View implements OnTouchListener{
	
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Path mPath;
	
	public MyDrawingView(Context context){
 
	 
	 super(context);
	 setOnTouchListener(this);
	 
	 mBitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
	 mCanvas = new Canvas(mBitmap);
	 mPath = new Path ();
	}
 


	public MyDrawingView(Context context, AttributeSet attrs){
	
	super(context, attrs);
	setOnTouchListener(this);
 	}

 	public MyDrawingView(Context context, AttributeSet attrs, int defStyle){
	
	super(context,attrs,defStyle);
	setOnTouchListener(this);
 	}
 	
 	@Override
 	protected void onDraw (Canvas canvas) {
 		
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		//canvas.dra
		
 		//canvas.drawCircle(getWidth()/2,getHeight()/2,30, paint);
		//canvas.drawCircle(x,y, 20, paint);
 	}
 	
 	
float x = 0;
float y = 0;
int[] xpos = new int[50]; 
int[] ypos = new int[50];



public void addToXandY(int[] xpos, int[] ypos) {

	for (int i = 0; i < xpos.length; i ++ ) {
	    xpos[i] = 0; 
	    ypos[i] = 0;
	  }
	
	for (int i = 0; i < xpos.length-1; i ++ ) {

	    xpos[i] = xpos[i+1];
	    ypos[i] = ypos[i+1];
	  }

	
	//x = x + xval;
	//y = y + yval;
//	
//	if (x< 0) x = 0;
//	if (x > getWidth()) x = getWidth();
//	if (y > getHeight()) y = getHeight();
	
	invalidate();
	
}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Log.v("onTouch","I am here");
		
		
		int action = event.getAction();	
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.v("MOTION","Action Down");
		
		x = event.getX();
		y = event.getY();
		invalidate();
			break;
		case MotionEvent.ACTION_CANCEL:
			Log.v("MOTION","Action Cancel");
			break;
		case MotionEvent.ACTION_UP:
			Log.v("MOTION","Action Up");
			break;
		case MotionEvent.ACTION_MOVE:
			
			Log.v("MOTION","Action Move");
		x = event.getX();
		y = event.getY();
		invalidate();//calls the draw method again
			break;
			
		default:
			break;
			
		}
		return true;
	}
 	
 	
 	
 	}
	

	

