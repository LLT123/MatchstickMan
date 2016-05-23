package com.cloud.matchstickman.enter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.cloud.matchstickman.screen.LoadingScreen;

public class GameMain extends Game {

	 
	@Override
	public void create() {
		// 键盘功能拦截
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setCatchMenuKey(true);
		
		
		setScreen(new LoadingScreen());
	}

	
}
