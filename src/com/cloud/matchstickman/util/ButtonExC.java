package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//图片按钮
public class ButtonExC extends Button{

	public ButtonExC (String texturePath) {
		this(Asset.getInst().getTexture("btn/"+texturePath));
	}
	public ButtonExC (Texture upT) {
		super(new ButtonStyle(new TextureRegionDrawable(new TextureRegion(upT)),getGrayDrawable(new TextureRegion(upT)), null));
	}
	public ButtonExC (TextureRegion upTr) {
		super(new ButtonStyle(new TextureRegionDrawable(upTr),getGrayDrawable(upTr), null));
	}
	public void setUpDrawable(TextureRegion tr){
		getStyle().up=new TextureRegionDrawable(tr);
	}
	public void setDownDrawable(TextureRegion tr){
		getStyle().down=new TextureRegionDrawable(tr);
	}
	public void setDownDrawable(Drawable drawable){
		getStyle().down=drawable;
	}
	public static Drawable getGrayDrawable(TextureRegion upTr){
		Sprite sprite=new Sprite(upTr);
		sprite.setColor(Color.GRAY);
		SpriteDrawable sd=new SpriteDrawable(sprite);
		return sd;
	}
	public void setScaleEx(float scaleXY) {
		setSize(getWidth()*scaleXY, getHeight()*scaleXY);
	}
}
