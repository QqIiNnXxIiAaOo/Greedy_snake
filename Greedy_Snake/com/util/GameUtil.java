package com.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	public static Image getImage(String imagePth) {
		URL url = GameUtil.class.getClassLoader().getResource(imagePth);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return img;
	}
	
	public static Image rotateImage(final BufferedImage bufferedImage,final int degree) {
		int w = bufferedImage.getWidth();//图片宽度
		int h = bufferedImage.getHeight();//图片高度
		int type = bufferedImage.getColorModel().getTransparency();//得到图片透明度
		BufferedImage img;
		Graphics2D graphics2d;
		(graphics2d=(img = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degree), w/2, h/2);//旋转，degree是旋转角度
		graphics2d.drawImage(bufferedImage, 0, 0, null);//从bufferedimage复制到img，0,0是img的坐标
		graphics2d.dispose();
		return img;
		
	}
}
