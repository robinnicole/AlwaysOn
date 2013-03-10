package com.example.newrecord;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.newrecord.NewRecord.SoundMeter;

public class DrawingTheMeter extends View{
	
	public DrawingTheMeter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	protected void onDraw(Canvas c) {
		
		super.onDraw(c);

		Rect soundRect = new Rect();
		soundRect.set(700, 450, 100, 100);
		Paint blue = new Paint();
		blue.setColor(Color.BLUE);
		blue.setStyle(Paint.Style.FILL);

		c.drawRect(soundRect, blue);

	}


}
