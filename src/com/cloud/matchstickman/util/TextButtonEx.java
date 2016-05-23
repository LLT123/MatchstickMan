package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TextButtonEx extends TextButton{

	public TextButtonEx(String text,String btnFileName, int size) {
		this(text, Asset.getInst().getTexture("btn/"+btnFileName), size);
	}
	public TextButtonEx(String text,Texture upT, int size) {
		super(text, new TextButtonStyle(new TextureRegionDrawable(new TextureRegion(upT)), getGrayDrawable(new TextureRegion(upT)), null, TtfUtil.getInstace().getFont(text, size,Color.BLACK,2,Color.WHITE)));
	}

	private static Drawable getGrayDrawable(TextureRegion upTr){
		Sprite sprite=new Sprite(upTr);
		sprite.setColor(Color.GRAY);
		SpriteDrawable sd=new SpriteDrawable(sprite);
		return sd;
	}
}
