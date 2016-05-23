package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ColorPoint {

	static SpriteBatch batch;
	static Texture t;
	static Color color;
	
	static{
		batch=new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 960, 540);
		color=Color.RED;
	}
	
	public static void draw(){
		if(t==null){
			Pixmap pix=new Pixmap(1, 1, Format.RGBA8888);
			pix.setColor(color);
			pix.fill();
			t=new Texture(pix);
		}
		batch.begin();
		batch.draw(t, 0, 0,5,5);
		batch.end();
	}
	public static void setColor(Color color){
		ColorPoint.color=color;
		ColorPoint.t.dispose();
		ColorPoint.t=null;
	}
}
