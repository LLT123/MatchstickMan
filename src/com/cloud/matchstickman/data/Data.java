package com.cloud.matchstickman.data;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class Data {
	public static boolean isFirstGame;
	public static int highScore;

	public static void init(){
		highScore=getInteger("highScore", 0);
		isFirstGame=true;
	}
	
	public static Preferences putString(String key, String val){
		return preferences.putString(key, val);
	}
	public static String getString(String key, String defValue){
		return preferences.getString(key, defValue);
	}
	
	public static Preferences putInteger(String key, int val){
		return preferences.putInteger(key, val);
	}
	public static int getInteger(String key, int defValue){
		return preferences.getInteger(key, defValue);
	}
	
	public static Preferences putFloat(String key, float val){
		return preferences.putFloat(key, val);
	}
	public static float getFloat(String key, float defValue){
		return preferences.getFloat(key, defValue);
	}
	
	public static Preferences putBoolean(String key, boolean val){
		return preferences.putBoolean(key, val);
	}
	public static boolean getBoolean(String key, boolean defValue){
		return preferences.getBoolean(key, defValue);
	}
	
	public static Preferences putLong(String key, long val){
		return preferences.putLong(key, val);
	}
	public static long getLong(String key, long defValue){
		return preferences.getLong(key, defValue);
	}
	//提交
	public static void flush(){
		preferences.flush();
	}
	public final static Preferences preferences=Gdx.app.getPreferences("data");
}
