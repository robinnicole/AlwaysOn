package com.example.newrecord;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class SoundMeter extends View {

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
		//changeColor();
		Rect soundRect = new Rect();
		soundRect.set(700, 450, 350, 190);
		Paint paint = new Paint();
		
		//blue.setColor(Color.BLUE);
		paint.setARGB(255, 27, 224, 66);
		//paint.setStyle(Paint.Style.FILL);

		c.drawRect(soundRect, paint);

	}


}






