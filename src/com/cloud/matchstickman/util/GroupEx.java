package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.SnapshotArray;

public class GroupEx extends Group{
	Rectangle[] rectangles;
	
	public GroupEx() {
		this.rectangles=new Rectangle[]{new Rectangle(0, 0, 0, 0)};
	}
	public GroupEx(Rectangle ...rectangles) {
		this.rectangles=rectangles;
	}
	
	public void setRects(Rectangle ...rectangles) {
		this.rectangles=rectangles;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		applyTransform(batch, computeTransform());
		batch.flush();
		for (int i = 0,size=rectangles.length; i < size; i++) {
			Rectangle viewRect=rectangles[i];
			clipRect(batch, parentAlpha, viewRect.x, viewRect.y, viewRect.width, viewRect.height);
		}
		
		resetTransform(batch);
	}
	
	private void clipRect(Batch batch, float parentAlpha,float x, float y,float width, float height){
		if (clipBegin(x, y, width, height)) {
			drawChildren(batch, parentAlpha,x, y, width, height);
			batch.flush();
			clipEnd();
		}
	}
	
	private void drawChildren(Batch batch, float parentAlpha, float x, float y,
			float width, float height) {
		parentAlpha *= this.getColor().a;
		SnapshotArray<Actor> children = this.getChildren();
		Actor[] actors = children.begin();
		for (int i = 0, n = children.size; i < n; i++) {
			Actor child = actors[i];
			if (!(child.getX()+child.getWidth()<x||child.getX()>x+width||child.getY()>y+height||child.getY()+child.getHeight()<y)) {
				if (!child.isVisible()) continue;
				child.draw(batch, parentAlpha);
			}
		}
		children.end();
	}
}
