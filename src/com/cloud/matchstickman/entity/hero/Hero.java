package com.cloud.matchstickman.entity.hero;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.cloud.matchstickman.util.ActorEx;

public class Hero extends ActorEx{

	HEROSTATE state=HEROSTATE.IDLE;
	
	HeroAnimRender heroAnimRender;
	
	
	public Hero(){
		
		//英雄绘制器
		heroAnimRender=new HeroAnimRender(this);
		
		
		
		setState(HEROSTATE.IDLE);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		heroControl();
		heroAnimRender.act(delta);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		heroAnimRender.draw(batch);
	}
	
	private void heroControl() {
		switch (state) {
		case IDLE:
			
			break;
		case MOVE_LEFT:
			moveBy(-6, 0);
			break;
		case MOVE_RIGHT:
			moveBy(6, 0);
			break;
		default:
			break;
		}
	}

	public HEROSTATE getState() {
		return state;
	}
	public void setState(HEROSTATE state) {
		this.state = state;
		switch (state) {
		case IDLE:
//			heroAnimRender.setAnim(AnimateFactory.getAnimate("img\anim", count, endPath, frameDuration, playMode));
			
			break;

		default:
			break;
		}
	}
	
}
