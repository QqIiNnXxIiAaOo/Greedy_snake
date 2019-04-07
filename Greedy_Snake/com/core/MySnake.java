package com.core;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import com.constant.Constant;
import com.util.GameUtil;
import com.util.ImageUtil;

public class MySnake extends SnakeObject implements Moveable{

	private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.image.get("snake_head");
	
	private int speed;
	private int length;
	private int num;
	public static List<Point> bodyPoints = new LinkedList<>();
	public int score = 0;
	private static BufferedImage newImgSnakeHead;
	boolean up,down,left,right = true;//��ʼ״̬����
	public MySnake(int x,int y) {
		
		// TODO Auto-generated constructor stub
		this.live = true;
		this.x = x;
		this.y = y;
		this.img = ImageUtil.image.get("snake_body");
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.speed = 5;
		this.length = 500;
		this.num = width/speed;
		newImgSnakeHead = IMG_SNAKE_HEAD;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (!down) {
				up = true;
				down = false;
				left = false;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if (!right) {
				up = false;
				down = false;
				left = true;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (!left) {
				up = false;
				down = false;
				left = false;
				right = true;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 0);
			}
			break;
			
		case KeyEvent.VK_DOWN:
			if (!up) {
				up = false;
				down = true;
				left = false;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
			}
			break;
		}
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (up)
			y-=speed;
		else if (down)
			y+=speed;
		else if(left)
			x-=speed;
		else if(right)
			x+=speed;
	}

	@Override
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		outOfBounds();//����
		eatBody();//�����Լ�
		bodyPoints.add(new Point(x,y));//����켣
		if(bodyPoints.size()==(this.length+1)*num) {//������Ĺ켣�ĵ�ĸ���Ϊ�ߵĳ���+1��num��ʱ
			bodyPoints.remove(0);//�Ƴ���һ��
		}
		g.drawImage(newImgSnakeHead, x, y, null);
		drawBody(g);
		move();
		
	}

	private void drawBody(Graphics g) {
		// TODO Auto-generated method stub
		int length = bodyPoints.size()-1-num;
		for (int i = length; i >= num; i-=num) {
			Point p = bodyPoints.get(i);
			g.drawImage(img, p.x, p.y, null);
			
		}
	}

	private void eatBody() {
		// TODO Auto-generated method stub
		for(Point point:bodyPoints) {
			for (Point point2 : bodyPoints) {
				if (point.equals(point2)&&point!=point2) {
					this.live = false;
				}
			}
		}
	}
	

	private void outOfBounds() {
		// TODO Auto-generated method stub
		boolean xout = (x<=0||x>(Constant.GAME_WIDTH-width));
		boolean yout = (y<=40||y>=(Constant.GAME_HEIGHT-height));
		if(xout||yout)
			live =false;
		
	}
	
	
}

