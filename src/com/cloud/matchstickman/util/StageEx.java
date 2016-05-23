package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * 自定义stage，使用自定义的刷新时间，保证同步
 */
public class StageEx extends Stage{
	
	public StageEx(Viewport viewport) {
		super(viewport);
	}
	
	public StageEx(Viewport viewport, Batch batch) {
		super(viewport, batch);
	}

	@Override
	public void act() {
//		super.act();
//		act(Gdx.graphics.getDeltaTime());
//		act(FatherScreen.delta);
	}
	
}
