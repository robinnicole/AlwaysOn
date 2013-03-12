package com.example.newrecord;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class SoundMeter extends View {
	
	int volume = 0;
	Paint paint=new Paint(); 
	public SoundMeter(Context context) {
		super(context);
		
	}
	
	public SoundMeter(Context context, AttributeSet attrs) {
		super(context,attrs);

	}

	public SoundMeter(Context context, AttributeSet attrs, int defStyle) {
		super(context,attrs,defStyle);

	}
	
protected void onDraw(Canvas c) {
		
		super.onDraw(c);
		
		//Circle soundCircle = new Circle();
		//Rect soundRect = new Rect();
		//soundRect.set(700, 450, 350, 190);
		//soundCircle.set(700, 450, 100, paint);
		 //paint.setARGB (155, (volume%255), 60, 60);
		 paint.setARGB ((volume%255), 255, 60, 60);
		//paint.setStyle(Paint.Style.FILL);
		//c.drawRect(soundRect, paint);
		//c.drawCircle(325,150,100, paint);
		c.drawCircle(325,150,(volume%100), paint);
		
		//paint.setARGB(a, r, g, b);

		//canvas.drawCircle(x, y, 20, paint);

	}
//pull in the amplitude value from progress update and pass it into this constructor



public void setAmp(int amp) {

	volume = amp;
	invalidate();
}

}



