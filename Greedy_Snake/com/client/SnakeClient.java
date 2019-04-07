package com.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.core.Food;
import com.core.MyFrame;
import com.core.MySnake;
import com.util.ImageUtil;

public class SnakeClient extends MyFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MySnake mySnake = new MySnake(100, 100);//��
	public Food food = new Food();//ʳ��
	Image background = ImageUtil.image.get("background");//����ͼƬ
	Image fail = ImageUtil.image.get("fail");//
	
	@Override
	public void loadFrame() {
		super.loadFrame();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mySnake.keyPressed(e);//ί�и�mysnake
			}
		});
	}
	/**
	 * ���ƽ���
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);//���Ʊ���
		if(mySnake.live){//����߻��ţ��ͻ���
			mySnake.draw(g);
			if(food.live){//���ʳ����ţ��ͻ���
				food.draw(g);
				food.eaten(mySnake);
			}else{//���򣬲�����ʳ��
				food = new Food();
			}
		}else{//��������������Ϸ��������
			g.drawImage(fail, (background.getWidth(null)-fail.getWidth(null))/2, (background.getHeight(null)-fail.getHeight(null))/2, null);
		}
		drawScore(g);//���Ʒ���
	}
	/**
	 * ���Ʒ���
	 * @param g
	 */
	public void drawScore(Graphics g){
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+mySnake.score,700,100);
	}
	public static void main(String[] args) {
		new SnakeClient().loadFrame();//���ش���
	}
}