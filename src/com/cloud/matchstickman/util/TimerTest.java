package com.cloud.matchstickman.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class TimerTest {
	private static long timer;
	static long max=0;
	public static void start(){
		timer=TimeUtils.millis();
	}
	
	public static void end(String tag){
		long now=(TimeUtils.millis()-timer);
		if(now>max)max=now;
		Gdx.app.log("timer",tag+" "+now+" max="+max);
	}
}
