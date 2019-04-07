package com.core;

import java.awt.Graphics;
import com.constant.Constant;
import com.util.ImageUtil;

public class Food extends SnakeObject{

	public Food() {
		this.live = true;
		this.img = ImageUtil.image.get("food");
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = (int)(Math.random()*(Constant.GAME_WIDTH-width+10));
		this.y = (int)(Math.random()*(Constant.GAME_HEIGHT-40-height)+40);	
	}
	
	public void eaten(MySnake mySnake){
		if(mySnake.getrectangle().intersects(this.getrectangle())&&live&&mySnake.live){
			this.live=false;//食物死亡
			mySnake.setLength(mySnake.getLength()+1);//长度加一
			mySnake.score+=10*mySnake.getLength();//加分
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
	}	
}
