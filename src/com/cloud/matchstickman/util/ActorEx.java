package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorEx extends Actor{
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color=getColor();
		batch.setColor(color.r, color.g, color.b, color.a*parentAlpha);
	}
	public float getCenX(){
		return getX()+getWidth()/2;
	}
	public float getCenY(){
		return getY()+getHeight()/2;
	}
}
