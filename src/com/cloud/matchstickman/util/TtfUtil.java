package com.cloud.matchstickman.util;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class TtfUtil {
	private static final TtfUtil INSTANCE=new TtfUtil();
	private final StringBuilder sb = new StringBuilder();
	private FreeTypeFontGenerator generator;
	private TreeSet<Character> strSet;
	private List<BitmapFont> fonts;
	
	private TtfUtil() {
		generator=new FreeTypeFontGenerator(Gdx.files.internal("font/allFont.ttf"));
		strSet=new TreeSet<Character>();
		fonts=new LinkedList<BitmapFont>();
	}
	
	public static TtfUtil getInstace(){
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @return
	 */
	public BitmapFont getFont(String string,int size){
		return this.getFont(string, size, Color.WHITE , 0 , Color.BLACK);
	}
	
	/**
	 * 获取加粗字体
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param color 字体颜色，区别于label的颜色
	 * @return
	 */
	public BitmapFont getFontBold(String string,int size,Color color){
		return this.getFont(string, size, color, 0.5f, color);
	}
	
	/**
	 * 外边框宽度为1
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param fontColor 字体颜色，区别于label的颜色
	 * @param borderColor 外边框的颜色
	 * @return
	 */
	public BitmapFont getFont(String string,int size,Color fontColor, Color borderColor){
		return this.getFont(string, size, fontColor, 1f, borderColor);
	}
	
	/**
	 * 
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param fontColor 字体颜色，区别于label的颜色
	 * @param borderWidth 外边框宽度
	 * @param borderColor 外边框的颜色
	 * @return
	 */
	public BitmapFont getFont(String string,int size,Color fontColor, float borderWidth, Color borderColor){
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.minFilter=TextureFilter.Linear;
		parameter.magFilter=TextureFilter.Linear;
		parameter.characters = getNoReapteStr(string);
		parameter.size = size;
		parameter.color=fontColor;
		parameter.borderWidth=borderWidth;
		parameter.borderColor=borderColor;
		BitmapFont font=generator.generateFont(parameter);
		fonts.add(font);
		return font;
	}
	
	
	public BitmapFont getNoReapteFont(String NoReapteString,int size){
		return this.getNoReapteFont(NoReapteString, size, Color.WHITE,0 ,Color.BLACK);
	}
	
	/**
	 * 获取加粗字体
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param color 字体颜色，区别于label的颜色
	 * @return
	 */
	public BitmapFont getNoReapteFontBold(String NoReapteString,int size,Color color){
		return this.getNoReapteFont(NoReapteString, size, color, 0.5f, color);
	}
	
	/**
	 * 外边框宽度为1
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param fontColor 字体颜色，区别于label的颜色
	 * @param borderColor 外边框的颜色
	 * @return
	 */
	public BitmapFont getNoReapteFont(String NoReapteString,int size,Color fontColor, Color borderColor){
		return this.getNoReapteFont(NoReapteString, size, fontColor, 1f, borderColor);
	}
	
	/**
	 * 
	 * @param string font所包含的字体
	 * @param size font的字体大小
	 * @param fontColor 字体颜色，区别于label的颜色
	 * @param borderWidth 外边框宽度
	 * @param borderColor 外边框的颜色
	 * @return
	 */
	public BitmapFont getNoReapteFont(String NoReapteString,int size,Color fontColor, float borderWidth, Color borderColor){
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.minFilter=TextureFilter.Linear;
		parameter.magFilter=TextureFilter.Linear;
		parameter.characters = NoReapteString;
		parameter.size = size;
		parameter.color=fontColor;
		parameter.borderWidth=borderWidth;
		parameter.borderColor=borderColor;
		BitmapFont font=generator.generateFont(parameter);
		fonts.add(font);
		return font;
	}
	
	public String getNoReapteStr(String str){
		sb.setLength(0);
		for (int i = 0,length=str.length(); i < length; i++) {
			char charAt = str.charAt(i);
			if (!strSet.contains(charAt)) {
				sb.append(charAt);
				strSet.add(charAt);
			}
		}
		strSet.clear();
		return sb.toString();
	}
	
	public void disposeFont(){
		for (int i = 0; i < fonts.size(); i++) {
			BitmapFont font=fonts.remove(i);
			font.dispose();
		}
	}
	 
	public void dispose(){
		disposeFont();
		generator.dispose();
	}
}

