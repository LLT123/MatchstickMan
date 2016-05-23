package com.cloud.matchstickman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cloud.matchstickman.enter.GameMain;
import com.cloud.matchstickman.util.ColorPoint;
import com.cloud.matchstickman.util.DebugUtil;
import com.cloud.matchstickman.util.GdxUtil;
public abstract class FatherScreen extends ScreenAdapter {
	
	protected GameMain main=GdxUtil.getGameMain();
	
	public Stage mainStage;
	
	
	@Override
	public void show() {
		super.show();
		mainStage=new Stage(new StretchViewport(960, 540));
		Gdx.input.setInputProcessor(mainStage);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mainStage.draw();
		mainStage.act();
		
		
		
		
		ColorPoint.draw();
		DebugUtil.getInst().drawFPS();
	}
	@Override
	public void hide() {
		super.hide();
		mainStage.clear();
		mainStage.dispose();
	}
	
}
