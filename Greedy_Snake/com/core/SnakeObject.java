package com.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class SnakeObject implements Drawable{

	int x;//������
	int y;//������
	Image img;//ͼƬ
	int width;//ͼƬ���
	int height;//ͼƬ�߶�
	public boolean live;//����or���
	@Override
	public  void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getrectangle() {
		return new Rectangle(x,y,width,height);
	}
	
	
}
