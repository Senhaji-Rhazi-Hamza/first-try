package com.example.qdt;

import android.content.Context;
import android.widget.Toast;

public class PosThread extends Thread {
Circlev cercle;
int width;
int height;
int ss;
//Boolean Debut=MainActivity.Debut;
	public PosThread(Circlev cercle,int width,int height) {
		this.cercle=cercle;
		this.width=width;
		this.height=height;
	}
public  void run()
{
	
	ss=MainActivity.s;
	while(true){
		if(interrupted())return;
	if(MainActivity.Debut)
	{
	
	//*/
		if(MainActivity.Count==5){
			MainActivity.triche=false;
	int alx;
	int aly;
	alx=Math.abs((int) (width*Math.random()-2*cercle.circle.getradius()));
	aly=Math.abs((int)(height*Math.random()-3*cercle.circle.getradius()));
 	cercle.circle.setposx(alx); 
	cercle.circle.setposy(aly);
	cercle.postInvalidate();
	
	
	//Toast.makeText(context, "active Start !"+"valeurC"+MainActivity.Count, 500).show();
	
	try {
		sleep(3500/ss); 
		if(MainActivity.clickValide==false)
		{MainActivity.Count--;		}
		
		
		MainActivity.clickValide=false;
	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
else{
	
	MainActivity.click.gameOver();
}
	
}
	
	}
	}
}
