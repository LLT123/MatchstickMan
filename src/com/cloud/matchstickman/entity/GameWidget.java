package com.cloud.matchstickman.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.cloud.matchstickman.entity.hero.HEROSTATE;
import com.cloud.matchstickman.util.Asset;
import com.cloud.matchstickman.util.ButtonExC;
import com.cloud.matchstickman.util.GdxUtil;

public class GameWidget extends Group{

	ButtonExC leftBtn,rightBtn,attakBtn;
	public GameWidget(){
		
		leftBtn=new ButtonExC("button_turn.png");
		TextureRegion tr=new TextureRegion(Asset.getInst().getTexture("btn/button_turn.png"));
		tr.flip(true, false);
		leftBtn.setUpDrawable(tr);
		leftBtn.setDownDrawable(ButtonExC.getGrayDrawable(tr));;
		leftBtn.setPosition(0, 0);
		leftBtn.addListener(input);
		addActor(leftBtn);
		
		rightBtn=new ButtonExC("button_turn.png");
		rightBtn.setPosition(leftBtn.getWidth(), 0);
		rightBtn.addListener(input);
		addActor(rightBtn);

		attakBtn=new ButtonExC("button_attack.png");
		attakBtn.setPosition(960-attakBtn.getWidth(), 0);
		attakBtn.addListener(input);
		addActor(attakBtn);
		
	}
	InputListener input=new InputListener(){
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			Actor actor=event.getListenerActor();
			if(actor==leftBtn){
				GdxUtil.getGameScreen().hero.setState(HEROSTATE.MOVE_LEFT);
			}else if(actor==rightBtn){
				GdxUtil.getGameScreen().hero.setState(HEROSTATE.MOVE_RIGHT);
			}
			
			return true;
		}
		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			super.touchUp(event, x, y, pointer, button);
			Actor actor=event.getListenerActor();
			if(actor==leftBtn){
				GdxUtil.getGameScreen().hero.setState(HEROSTATE.IDLE);
			}else if(actor==rightBtn){
				GdxUtil.getGameScreen().hero.setState(HEROSTATE.IDLE);
			}
		}
	};
}
