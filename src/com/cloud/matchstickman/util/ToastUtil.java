package com.cloud.matchstickman.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;

import android.widget.Toast;

public class ToastUtil {

	private static String lastTxt="";
	
	public static void show(final String str) {
		AndroidApplication app = (AndroidApplication) Gdx.app;
		if(!lastTxt.equals(str)){
			lastTxt=str;
			app.handler.post(new Runnable() {
				public void run() {
					Toast.makeText((AndroidApplication)Gdx.app, lastTxt, Toast.LENGTH_SHORT).show();
				}
			});
			app.handler.postDelayed(run2,2000);//两秒后允许再弹相同字
		}	
	}
	private static Runnable run2 = new Runnable() {
		public void run() {
			lastTxt="";
		}
	};
}
