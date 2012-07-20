package com.compass.sample;

import com.marakana.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.ImageView;

public class Rose extends ImageView {
  Paint paint;
  float direction =0;

  public Rose(Context context) {
    super(context);

    paint = new Paint();
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(2);
    paint.setStyle(Style.STROKE);

    this.setImageResource(R.drawable.fing);
  }

  @Override
  public void onDraw(Canvas canvas) {
    
	  //canvas.scale(70, 70);
	
	  int height = this.getHeight();
    int width = this.getWidth();

    
    canvas.rotate(-direction, width / 2, height / 2);
    super.onDraw(canvas);
  }

  public void setDirection(float matrixValues) {
    this.direction = matrixValues;
    this.invalidate();
  }

}
