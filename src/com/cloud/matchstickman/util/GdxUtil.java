package com.cloud.matchstickman.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.cloud.matchstickman.enter.GameMain;
import com.cloud.matchstickman.screen.FatherScreen;
import com.cloud.matchstickman.screen.GameScreen;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class GdxUtil {

	public static Screen getScreen(){
		return ((GameMain)Gdx.app.getApplicationListener()).getScreen();
	}
	public static FatherScreen getFatherScreen(){
		return (FatherScreen)((GameMain)Gdx.app.getApplicationListener()).getScreen();
	}
	public static GameScreen getGameScreen(){
		return (GameScreen)((GameMain)Gdx.app.getApplicationListener()).getScreen();
	}
	public static GameMain getGameMain(){
		return (GameMain)Gdx.app.getApplicationListener();
	}
	public static AndroidApplication getActivity(){
		return (AndroidApplication)Gdx.app;
	}
	public static void showExitDialog() {
		getActivity().handler.post(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder builder = new AlertDialog.Builder((AndroidApplication)Gdx.app);
				builder.setTitle("提示")
						.setMessage("退出游戏？")
						.setPositiveButton("是",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										System.exit(0);
									}
								})
						.setNegativeButton("否",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();
									}
								}).create().show();
			}
		});
	}
}
