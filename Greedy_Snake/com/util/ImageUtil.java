package com.util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.constant.Constant;

public class ImageUtil {

	public static Map<String , Image> image = new HashMap<>();
	
	static {
		image.put("snake_body", GameUtil.getImage(Constant.IMG_PRE+"snake_body.png"));
		image.put("food", GameUtil.getImage(Constant.IMG_PRE+"food.png"));
		image.put("snake_head", GameUtil.getImage(Constant.IMG_PRE+"snake_head.png"));
		image.put("background", GameUtil.getImage(Constant.IMG_PRE+"background.jpg"));
		image.put("fail", GameUtil.getImage(Constant.IMG_PRE+"fail.png"));		
	}
}
