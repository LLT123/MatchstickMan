package com.cloud.matchstickman.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageEx extends Image{
	
	public ImageEx(String filePath){
		super(Asset.getInst().getTexture(filePath));
	}
	public ImageEx(Color color){
		super(new Texture(PixmapFactroy.getRect(1, 1, color)));
	}
	public ImageEx setPos(float x,float y){
		setPosition(x, y);
		return this;
	}
	public ImageEx addTo(Stage stage){
		stage.addActor(this);
		return this;
	}
	public ImageEx addTo(Group group){
		group.addActor(this);
		return this;
	}
	public void setDraw(String imgPath) {
		super.setDrawable(new TextureRegionDrawable(new TextureRegion(Asset.getInst().getTexture(imgPath))));
	}
}
