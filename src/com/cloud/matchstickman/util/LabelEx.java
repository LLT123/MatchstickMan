package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class LabelEx extends Label{

	FontType type;
	public enum FontType{
		WHITE_18,
		WHITE_22,
		WHITE_32,
	}
	
	public LabelEx(String text,FontType type) {
		super(text, new LabelStyle(getFont(text, type), Color.WHITE));
		this.type=type;
	}
	
	public LabelEx(String text,BitmapFont font) {
		super(text, new LabelStyle(font, Color.WHITE));
	}
	
	private static BitmapFont getFont(String text,FontType type){
		switch (type) {
		case WHITE_18:
			return TtfUtil.getInstace().getFont(text, 18, Color.WHITE, Color.BLACK);
		case WHITE_22:
			return TtfUtil.getInstace().getFont(text, 22, Color.WHITE, Color.BLACK);
		case WHITE_32:
			return TtfUtil.getInstace().getFont(text, 32, Color.WHITE, Color.BLACK);
		default:
			return null;
		}
	}
	@Override
	public void setText(CharSequence newText) {		//如果有新字 更新BitmapFont
		BitmapFont oldFont=getStyle().font;
		char[] newChars=newText.toString().toCharArray();
		for (int i = 0; i < newChars.length; i++) {
			char c = newChars[i];
			if(!oldFont.getData().hasGlyph(c)){//有一个字符原Bitmapfont中没有就重新生成
				oldFont.dispose();
				setStyle(new LabelStyle(getFont(newText.toString(), type), Color.WHITE));
				break;
			}
		}
		super.setText(newText);
	}
	
	//--------------------
	public LabelEx setPos(float x,float y){
		setPosition(x, y);
		return this;
	}
	public LabelEx addTo(Stage stage){
		stage.addActor(this);
		return this;
	}
	public LabelEx addTo(Group group){
		group.addActor(this);
		return this;
	}
	@Deprecated
	public LabelEx setSca(float fontScale){
		setFontScale(fontScale);
		return this;
	}
	public LabelEx setXCenter(float x){
		setX(x-getWidth()/2);
		setAlignment(Align.center);
		return this;
	}
	public LabelEx setAlign(int alignment) {
		setAlignment(alignment);
		return this;
	}
	public LabelEx setCor(float r, float g, float b, float a) {
		super.setColor(r, g, b, a);
		return this;
	}
}
