package com.cloud.matchstickman.screen;

import com.cloud.matchstickman.data.Data;
import com.cloud.matchstickman.util.GdxUtil;
import com.cloud.matchstickman.util.SoundUtil;

public class LoadingScreen extends FatherScreen{

	@Override
	public void show() {
		super.show();
		
		Data.init();
		SoundUtil.init();
		
		GdxUtil.getGameMain().setScreen(new StartScreen());
		
//		new LayoutDebug(mainStage, logo);
	}
	
}
