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

		Rect soundRect = new Rect();
		soundRect.set(700, 450, 350, 190);
		Paint blue = new Paint();
		blue.setColor(Color.BLUE);
		blue.setStyle(Paint.Style.FILL);

		c.drawRect(soundRect, blue);

	}

}


