package com.cloud.matchstickman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cloud.matchstickman.entity.GameWidget;
import com.cloud.matchstickman.entity.hero.Hero;
import com.cloud.matchstickman.util.ImageEx;


public class GameScreen extends FatherScreen {
	
	
	Stage frontStage;
	
	GameWidget gameWidget; 
	public Hero hero;
	
	
	@Override
	public void show() {
		super.show();
		frontStage=new Stage(new StretchViewport(960, 540));
		Gdx.input.setInputProcessor(frontStage);
		new ImageEx("img/scene.jpg").addTo(mainStage);
		
		gameWidget=new GameWidget();
		frontStage.addActor(gameWidget);
	
		hero=new Hero();
		hero.setPosition(100, 150);
		mainStage.addActor(hero);
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		frontStage.draw();
		frontStage.act();
		
		mainStage.getCamera().position.x=hero.getX();
		
	}
}
