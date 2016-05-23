package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;

public class PixmapFactroy {

	
	
	public static Pixmap getRect(int width,int height,Color c){
		Pixmap pix=new Pixmap(width, height, Format.RGBA8888);
		pix.setColor(c);
		pix.fill();
		return pix;
	}
	public static Pixmap getCircle(int width,int height,Color c,int x, int y, int radius){
		Pixmap pix=new Pixmap(width, height, Format.RGBA8888);
		pix.setColor(c);
		pix.fillCircle(x, y, radius);
		return pix;
	}
	
	
	
}
