package com.example.qdt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.math.*;

public class Circlev extends View {
	
private OnCustomCircleClicklistner onCustomCircleClicklistner;
private Paint paint= new Paint();
Circle circle =new Circle();
	public Circlev(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public Circlev(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public Circlev(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onDraw(Canvas canvas) {
	 // TODO Auto-generated method stub
	 super.onDraw(canvas);
	 
	 paint.setColor(circle.getbgcolor());
	 paint.setStyle(Paint.Style.FILL);
	 canvas.drawCircle(circle.getposx(),circle.getposy(),circle.getradius(), paint);
	}
 
	public void setCustomCircleClicklistner(OnCustomCircleClicklistner onCustomCircleClicklistner)
	{
		this.onCustomCircleClicklistner=onCustomCircleClicklistner;
	}
	public  synchronized boolean dispatchTouchEvent(MotionEvent event) {
		
		   int eventaction=event.getAction();
		   int touchx=(int)event.getX();
		   int touchy=(int)event.getY();
		   int radx=touchx-circle.getposx();
		   int rady=touchy-circle.getposy();
		  
		 
		  if (circle.getradius()>Math.sqrt(radx*radx +rady*rady)){
			  MainActivity.Debut=true;
			 // MainActivity.clickValide=true;
		 // circle.setposx(3); 
		// circle.setposy(touchy);
		  
		    if(onCustomCircleClicklistner!=null){
		    	onCustomCircleClicklistner.onCircleClick();
		    	}
		   
		   }
		
		 
		    return super.dispatchTouchEvent(event);
		}
}
