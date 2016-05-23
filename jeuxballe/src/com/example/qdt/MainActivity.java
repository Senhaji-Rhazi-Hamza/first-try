package com.example.qdt;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.Telephony.Sms.Conversations;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
public int height ;
public 	int width ;
public int score=0;
public static int L;
public static int s;
public static Boolean Debut=false;

public static int Count;
private static final int CODE_MON_ACTIVITE = 1;
public static OnCustomCircleClicklistner click;
Button Bstart; 
RatingBar Rbarre;
TextView Bscore;
public static Boolean triche;
public static Boolean clickValide;
public String sco=null;

public void onRestart(){
super.onRestart();
//Toast.makeText(this,"Restart activé:Count"+Count, Toast.LENGTH_LONG).show();
init(); 
}
protected void onActivityResult(int requestCode, int resultCode,
		Intent data) {
		
			 // Le code de requête est utilisé pour identifier l’activité enfant
			   switch(requestCode){
			   case CODE_MON_ACTIVITE: 
			   {Toast.makeText(this,"votre score est de :"+resultCode+"   "+MainActivity.Count, Toast.LENGTH_LONG).show();
			   init();
			   if(sco!="")
				{
					if(Integer.parseInt(sco)<resultCode)
					{ 
						ecrireFicher("SCORE",""+resultCode);
					Bscore.setText("meilleur score:"+resultCode);
					}
				}
				else
				
				{
					ecrireFicher("SCORE",""+resultCode);
				Bscore.setText("meilleur score:"+resultCode);
				}
				
			   
			   return;
			   }
			   default:
			      // Faire quelque chose
			      return;
			   }
		      }
	private void init() {
		sco=lireFichier("SCORE");	
	score=0;
	Count=5;
	s=1;
	L=10;
	Debut=false;
	clickValide=true;
	triche=false;
	
}
	@SuppressWarnings("deprecation")
	 @Override
	//public Metrics getTaille(get) {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	Bstart=(Button) findViewById(R.id.Bstart);
	Rbarre=(RatingBar) findViewById(R.id.ratingBar1);
    Bscore=(TextView) findViewById(R.id.textView3);
	sco=lireFichier("SCORE");
	init();
	if(sco!="")
		{Bscore.setText("meilleur score;"+sco);}
		else
			{Bscore.setText("meilleur score:0");}
	
	OnRatingBarChangeListener RL= new OnRatingBarChangeListener() {
		
		

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			//Toast.makeText(this,"vous choisissez le niveau de difficulté", Toast.LENGTH_SHORT).show()	;	
			int r;
			r=(int)rating;
			init();
			Toast.makeText(MainActivity.this, "vous choisissez le niveau de difficulté"+r, Toast.LENGTH_SHORT).show();
		
		switch(r){
		case 1:{
			L=10; 
			s=1;
			Count=5;
			break;
		}
		case 2:{
			L=10; 
			s=1;
			Count=4;
			break;
		}
		case 3:
		{
			L=12;
			s=2;
			Count=3; 
			break;
		} 
		case 4:{ 
			L=12;
			s=2;
			Count=2;
			break;
		}
		case 5:{
			L=12; 
			s=2; 
			Count=1;
			break;
		}
		default:
		{
			L=10;
			s=1;
			Count=3;
			break;
		}
	
		}
		}
	};
	Rbarre.setOnRatingBarChangeListener(RL);
	Bstart.setOnClickListener(this);
	/*	DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		 height = metrics.heightPixels;
		 width = metrics.widthPixels;
		int pox=width/2;
		int poy=height/2;
final Circlev cercle= new Circlev(this);
cercle.circle.setcolor(Color.RED);
cercle.circle.setposx(pox);
cercle.circle.setposy(poy);
cercle.circle.setradius(width/L);
final PosThread Pr1=new PosThread(cercle, width, height);
//cercle.circle.setposx(this.DISPLAY_SERVICE.he)*/
		RelativeLayout lyt=(RelativeLayout) findViewById(R.id.layout1s);
		//TextView monTexte = new TextView(this);
		//monTexte.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		//lyt.addView(monTexte);
		//monTexte.setText(score);
		//monTexte.setBackgroundColor(Color.YELLOW);
		/*cercle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		lyt.addView(cercle);
		Pr1.start();
		cercle.setCustomCircleClicklistner(new OnCustomCircleClicklistner() {
			
			@Override
			public void onCircleClick() {
				score=score+50;
				Toast.makeText(MainActivity.this, "cercle cliqué score: !"+score, Toast.LENGTH_SHORT).show();
			
				
			}  
		});
    */

	}
	@Override
	public void onClick(View v) {
		
Intent intent = new Intent(this,GameActivity.class);
	
		
		startActivityForResult(intent, CODE_MON_ACTIVITE);
		
		 
	}
	private void ecrireFicher(String nomFichier,String monText) {

        BufferedWriter writer = null;

        try {

               File dir = getDir("ToutMesFichiers",MODE_PRIVATE);

               File newfile = new File(dir.getAbsolutePath() + File.separator + nomFichier);

               newfile.createNewFile();

               writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile)));

               writer.write(monText);

        } catch (Exception e) {

               e.printStackTrace();

        } finally {

               if (writer != null) {

                      try {

                             writer.close();

                      } catch (IOException e) {

                             e.printStackTrace();

                      }

               }

        }

  }
	 private String lireFichier(String nomFichier) {

         File dir = getDir("ToutMesFichiers",MODE_PRIVATE);

         File newfile = new File(dir.getAbsolutePath() + File.separator + nomFichier);

         String monText="";

         BufferedReader input = null;

         try {

           input = new BufferedReader(new InputStreamReader( new FileInputStream(newfile)

                ));

           String line;

           StringBuffer buffer = new StringBuffer();

           while ((line = input.readLine()) != null) {

                buffer.append(line);

           }

            monText = buffer.toString();

         } catch (Exception e) {

                e.printStackTrace();

         } finally {

         if (input != null) {

           try {

                input.close();

                } catch (IOException e) {

                       e.printStackTrace();

                }

           }

         }

       return monText;

       }
	}
    