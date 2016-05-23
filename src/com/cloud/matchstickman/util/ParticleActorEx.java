package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class ParticleActorEx extends ActorEx{
	public static final float parDelta = 1 / 45f;
	private ParticleEffect effect;
	private boolean isLoop=false;
	private float lastX,lastY;
	public ParticleActorEx(String parName) {
		effect = Asset.getInst().getParticle("particle/"+parName, "particle", 2, 3);
		effect.start();
	}
	public ParticleActorEx setPos(float x, float y) {
		super.setPosition(x, y);
		effect.setPosition(x,y);
		return this;
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if(getX()!=lastX||getY()!=lastY){
			effect.setPosition(getX(), getY());
			lastX=getX();
			lastY=getY();
		}
		effect.draw(batch,parDelta);
		 
		if(effect.isComplete()){
			if(isLoop){
				effect.reset();
			}else{
				remove();
			}
		}
	}
	public ParticleActorEx setLoop(boolean isLoop){
		this.isLoop=isLoop;
		return this;
	}
	
}
