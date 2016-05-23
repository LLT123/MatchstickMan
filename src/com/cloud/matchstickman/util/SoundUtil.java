package com.cloud.matchstickman.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ObjectMap;
/**
 * 背景音乐和游戏音效的播放工具
 */
public class SoundUtil {
	private static Music music;
	
	public static boolean isSoundOn=true;
	public static boolean isMusicOn=true;
	
	public static ObjectMap<String,Sound> sounds=new ObjectMap<String,Sound>();
	
	
	public static void init(){
		FileHandle files[]=Gdx.files.internal("sound").list();//所有音效文件
		Gdx.app.log("SoundUtil", files.length+"个音效文件");
		for (int i = 0; i < files.length; i++) {
			if(!files[i].isDirectory()){
				sounds.put(files[i].file().getName(),Gdx.audio.newSound(files[i]));
				Gdx.app.log("SoundUtil", "载入"+files[i].file().getName());
			}
		}
	}
	
	//播放背景音乐
	public static void playMusic(String fileName){
		if(isMusicOn){
			if(music!=null&&music.isPlaying()){
				music.stop();
				music.dispose();
			}
			music=Gdx.audio.newMusic(Gdx.files.internal("sound/voice"+fileName));
			music.play();
		}
	}
	public static void stopMusic(){
		if(music!=null&&music.isPlaying()){
			music.stop();
		}
	}
	
	//播放音效
	public static void playSound(String soundName){
		if(isSoundOn){
			sounds.get(soundName+".mp3").play();
		} 
	}
}
