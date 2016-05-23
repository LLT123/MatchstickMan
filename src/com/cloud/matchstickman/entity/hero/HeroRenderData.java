package com.cloud.matchstickman.entity.hero;

/**
 * 绘制数据
 */
public class HeroRenderData {

	public float offsetX,offsetY;
	public float originX, originY;
	public float width, height;
	public float scaleX, scaleY; 
	public float rotation;

	public HeroRenderData(float offsetX, float offsetY, float originX, float originY, float width, float height, float scaleX, float scaleY,float rotation){
		this.offsetX=offsetX;
		this.offsetY=offsetY;
		this.originX=originX;
		this.originY=originY;
		this.width=width;
		this.height=height;
		this.scaleX=scaleX;
		this.scaleY=scaleY;
		this.rotation=rotation;
	}
	
}
