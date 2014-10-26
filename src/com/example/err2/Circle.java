package com.example.err2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Circle extends View {

	int radius, number, fontSize = 80;
	Paint myPaint;

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private void init() {
		Log.d("init", "start");
		myPaint = new Paint();
		myPaint.setColor(Color.RED);
	}

	public Circle(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.save();
		// Drawing main crcle
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, myPaint);
		myPaint.setColor(Color.WHITE);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius - 10, myPaint);
		// end of main circle

		// drawing text-number
		myPaint.setColor(Color.BLACK);
		myPaint.setTextSize(fontSize);
		myPaint.setTextAlign(Align.CENTER);
		myPaint.setFakeBoldText(true);
		canvas.drawText(number + "", getWidth() / 2, getHeight() / 2 + fontSize
				/ 3, myPaint);
		// end of drwaing text

		// drawing point on circle boundry
		// findPointLocation();
		double deg = number * 3.6f;
		double radians = Math.toRadians(deg);
		int px = (int) Math.abs(radius * Math.sin(radians));
		int py = (int) Math.abs(radius * Math.cos(radians));
		if (number <= 25) {
			px = -px;
		} else if (number <= 50) {
			px = -px;
			py = -py;
		} else if (number <= 75) {
			py = -py;
		}
		// end od find point
		myPaint.setColor(Color.GREEN);
		canvas.drawCircle(getWidth() / 2 + px, getHeight() / 2 + py, 15,
				myPaint);
		// end of drawing point
		canvas.restore();
	}
}
