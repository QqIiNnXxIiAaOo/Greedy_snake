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
		int w = bufferedImage.getWidth();//ͼƬ���
		int h = bufferedImage.getHeight();//ͼƬ�߶�
		int type = bufferedImage.getColorModel().getTransparency();//�õ�ͼƬ͸����
		BufferedImage img;
		Graphics2D graphics2d;
		(graphics2d=(img = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degree), w/2, h/2);//��ת��degree����ת�Ƕ�
		graphics2d.drawImage(bufferedImage, 0, 0, null);//��bufferedimage���Ƶ�img��0,0��img������
		graphics2d.dispose();
		return img;
		
	}
}
