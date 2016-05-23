package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimEx extends ActorEx {
	protected Animation animation;
	protected float timer=0;//动画时间
	protected boolean isStart=true;
	protected int playTimesUpper,playTimes;//播放次数
	protected float animTimer=0,timerUpper=0;//播放时间
	
	public AnimEx(float duration, Texture[] textureExs, PlayMode mode) {
		TextureRegion[] regions=new TextureRegion[textureExs.length];
		for (int i = 0; i < regions.length; i++) {
			regions[i]=new TextureRegion(textureExs[i]);
		}
		animation=new Animation(duration, regions) ;
		animation.setPlayMode(mode);
		setSize(textureExs[0].getWidth(), textureExs[0].getHeight());
	}
	public AnimEx(String frontPath, int count, String endPath, float frameDuration, PlayMode playMode) {
		animation=AnimateFactory.getAnimate(frontPath, count, endPath, frameDuration, playMode);
		Texture texture=Asset.getInst().getTexture(frontPath+0+endPath);
		setSize(texture.getWidth(), texture.getHeight());
	}
	public AnimEx(String filePath, int tileW,int tileH,float frameDuration,PlayMode playMode) {
		animation=AnimateFactory.getAnimate(filePath, tileW, tileH, frameDuration, playMode);
		setSize(tileW, tileH);
	}
	public AnimEx(Animation animation) {
		this.animation=animation;
		setSize(animation.getKeyFrames()[0].getRegionWidth(),animation.getKeyFrames()[0].getRegionHeight());
	}
	public void reset(){
		timer=0;
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		if(!isStart)return;
		timer+=delta;
		if(animation.isAnimationFinished(timer)){
			playTimes++;
			reset();
		}
		if(playTimes>=playTimesUpper&&playTimesUpper!=0){
			remove();
		}
		//播放时间
		if(timerUpper!=0){
			animTimer+=delta;
			if(animTimer>=timerUpper){
				remove();
			}
		}
	}
	public void setRemoveTimer(float time){
		this.timerUpper=time;
	}
	public void setRemoveOnFinsh() {
		playTimesUpper=1;
	}
	public void setPlayTimesUpper(int num) {
		playTimesUpper=num;
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		TextureRegion region=animation.getKeyFrame(timer);
		
		if (getWidth()==0||getHeight()==0) {
			batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), region.getRegionWidth(), region.getRegionHeight(), getScaleX(), getScaleY(), getRotation());
		}else {
			batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		}
	}
	
}
