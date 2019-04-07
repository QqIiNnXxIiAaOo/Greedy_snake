package com.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class SnakeObject implements Drawable{

	int x;//ºá×ø±ê
	int y;//×Ý×ø±ê
	Image img;//Í¼Æ¬
	int width;//Í¼Æ¬¿í¶È
	int height;//Í¼Æ¬¸ß¶È
	public boolean live;//ËÀÍöor´æ»õ
	@Override
	public  void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getrectangle() {
		return new Rectangle(x,y,width,height);
	}
	
	
}
