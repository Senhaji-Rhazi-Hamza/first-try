package com.example.qdt;

public class Circle {
private int posX;
private int posY;
private int radius;
private int bgcolor;
public Circle()
{
	this.posX=0;
	this.posY=0;
	this.radius=0;
	this.bgcolor=0;
}
public Circle(int x,int y,int r,int c)
{
	this.posX=x;
	this.posY=y;
	this.radius=r;
	this.bgcolor=c;
}
public int getposx()
{
return this.posX;
}
public int getposy()
{
return this.posY;
}
public int getradius()
{
return this.radius;
}
public int getbgcolor()
{
return this.bgcolor;
}
public void setposx(int x){
	this.posX=x;
}
public void setposy(int y){
	this.posY=y;
}
public void setradius(int r){
	this.radius=r;
}
public void setcolor(int c){
	this.bgcolor=c;
}
}
