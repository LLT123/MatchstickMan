package com.cloud.matchstickman.entity.hero;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 英雄绘制器
 */
public class HeroAnimRender {

	private Hero hero;
	
	private Animation anim;
	private float renderTimer=0;
	private HeroRenderData renderData;
	
	public HeroAnimRender(Hero hero){
		this.hero=hero;
	}
	
	public void setAnim(Animation anim) {
		this.anim = anim;
	}

	public void act(float delta){
		renderTimer+=delta;
	}
	
	public void draw(Batch batch) {
		TextureRegion tmpTr=anim.getKeyFrame(renderTimer);
		batch.draw(tmpTr, hero.getX()+renderData.offsetX, hero.getY()+renderData.offsetX, renderData.originX, renderData.originY, renderData.width, renderData.height, renderData.scaleX, renderData.scaleY, renderData.rotation);
	}
}
