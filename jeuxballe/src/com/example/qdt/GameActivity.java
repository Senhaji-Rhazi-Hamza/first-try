package com.example.qdt;

import android.support.v7.app.ActionBarActivity;
import android.text.BoringLayout.Metrics;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
@SuppressLint("NewApi")
public class GameActivity extends ActionBarActivity {
public int height ;
public 	int width ;
public int score=0;
public int C;
int LL;
int ss;

PosThread Pr1;
public void onStop() { 
super.onStop();

Pr1.interrupt();
//Toast.makeText(GameActivity.this, "activé onstop !", 300).show();
}



@SuppressWarnings("deprecation")
	 @Override
	//public Metrics getTaille(get) {
	
 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jeux);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		 height = metrics.heightPixels;
		 width = metrics.widthPixels;
		int pox=width/2;
		int poy=height/2;
		//ss=MainActivity.s;
		//C=MainActivity.Count;
		//LL=MainActivity.L;
		init();
final Circlev cercle= new Circlev(this);

Toast.makeText(GameActivity.this, "activé Oncreate !"+"valeurC"+MainActivity.Count, 500).show();
////////////
OnCustomCircleClicklistner gclick=new OnCustomCircleClicklistner() {
	
	@Override
	public synchronized void onCircleClick() { 
		 MainActivity.clickValide=true;
		if(MainActivity.triche==false){
		switch (C){
		case 5:	score=(score+ss*LL/20)+1;break;
		case 4:	score=(score+ss*LL/15)+2;break;
		case 3:	score=(score+ss*LL/10)+3;break;
		case 2:	score=(score+ss*LL/2);break;
		case 1:score=(score+ss*LL*2);break;
			
			default:
				score=10;
		
		}
		
		
		MainActivity.triche=true;
	}
		Toast.makeText(GameActivity.this, "cercle cliqué score: !"+score+"count"+MainActivity.Count, 300).show();
		
	}
	@Override
	public void gameOver() {
		//Toast.makeText(GameActivity.this, "game over", 300).show();

		setResult(score);
			finish(); 
		
	}  };
////////////

	MainActivity.click=gclick;

	Pr1=new PosThread(cercle, width, height);

cercle.circle.setcolor(Color.RED);
cercle.circle.setposx(pox);
cercle.circle.setposy(poy);
cercle.circle.setradius(width/LL);
//final PosThread Pr1=new PosThread(cercle, width, height);
//cercle.circle.setposx(this.DISPLAY_SERVICE.he)
		RelativeLayout lyt=(RelativeLayout) findViewById(R.id.Jeux);
		//TextView monTexte = new TextView(this);
		//monTexte.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		//lyt.addView(monTexte);
		//monTexte.setText(score);
		//monTexte.setBackgroundColor(Color.YELLOW);
		cercle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		lyt.addView(cercle);
		
		Pr1.start();
		cercle.setCustomCircleClicklistner(gclick);
		
    }
private void init() {
	score=0;
	ss=MainActivity.s;
	C=MainActivity.Count;
	LL=MainActivity.L;
	
	
}

	
}    