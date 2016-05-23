package com.cloud.matchstickman.util;


import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CollisionPolygon extends Polygon{
	
	public CollisionPolygon() {
		super();
	}
	
	public CollisionPolygon(Actor actor) {
		super(new float[]{0,0,actor.getWidth(),0,actor.getWidth(),actor.getHeight(),0,actor.getHeight()});
	}
	public CollisionPolygon(float[] vertices) {
		super(vertices);
	}
	
	public CollisionPolygon(float[] vertices,float x, float y, float originX, float originY, float rotation) {
		super(vertices);
		setOrigin(originX, originY);
		setPosition(x, y);
		setRotation(rotation);
	}
	
	public CollisionPolygon(float[] vertices, float originX, float originY, float rotation) {
		this(vertices, 0, 0, originX, originY, rotation);
	}
	
	public CollisionPolygon(float[] vertices, float x, float y) {
		this(vertices, x, y, 0, 0, 0);
	}
	
	public CollisionPolygon(float[] vertices,float x, float y, float originX, float originY) {
		this(vertices, x, y, originX, originY, 0);
	}
	
	public boolean overlaps(Polygon polygon){
		if(!getBoundingRectangle().overlaps(polygon.getBoundingRectangle()))return false;
		
		//检查点是否在另外一个多边形内
		float[] vertices=polygon.getTransformedVertices();
		for (int i = 0; i < vertices.length; i+=2) {
			if (contains(vertices[i], vertices[i+1])) {
				return true;
			}
		}
		
		vertices=getTransformedVertices();
		for (int i = 0; i < vertices.length; i+=2) {
			if (polygon.contains(vertices[i], vertices[i+1])) {
				return true;
			}
		}
		
		//检测边是否相交，防止点都不互相包含，而边确相交的情况
		return intersect(vertices,polygon.getTransformedVertices());
	}

	//检测边界是否相交
	private boolean intersect(float[] vertices, float[] transformedVertices) {
		PointF p1,p2,p3,p4;
		for (int i = 0; i < vertices.length; i+=2) {
			p1=new PointF(vertices[i], vertices[i+1]);
			if (i+2>=vertices.length) {
				p2=new PointF(vertices[0], vertices[1]);
			}else {
				p2=new PointF(vertices[i+2], vertices[i+3]);
			}
			for (int j = 0; j < transformedVertices.length; j+=2) {
				p3=new PointF(transformedVertices[j], transformedVertices[j+1]);
				if (j+2>=transformedVertices.length) {
					p4=new PointF(transformedVertices[0], transformedVertices[1]);
				}else {
					p4=new PointF(transformedVertices[j+2], transformedVertices[j+3]);
				}
				if (checkEdge(p1,p2,p3,p4)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//根据点得到线段，并且判断是否相交。判断p1p2和p3p4是否相交
	private boolean checkEdge(PointF p1, PointF p2, PointF p3,
			PointF p4) {
		float r1=getResult(p1, p2, p3);
		float r2=getResult(p1, p2, p4);
		float r3=getResult(p3, p4, p1);
		float r4=getResult(p3, p4, p2);
		
		if (r1*r2<0 && r3*r4<0) {
			return true;
		}
		if (r1==0 && getSpecialResult(p1, p2, p3)) {
			return true;
		}
		if (r2==0 && getSpecialResult(p1, p2, p4)) {
			return true;
		}
		if (r3==0 && getSpecialResult(p3, p4, p1)) {
			return true;
		}
		if (r4==0 && getSpecialResult(p3, p4, p2)) {
			return true;
		}
		return false;
	}
	
	//当ap和ab的向量积为0时，判断点p是否在ab线段上
	private boolean getSpecialResult(PointF a, PointF b, PointF p){
		return p.x>=Math.min(a.x, b.x) &&
				p.x<=Math.max(a.x, b.x) &&
				p.y>=Math.min(a.y, b.y) &&
				p.y<=Math.max(a.y, b.y) ;
	}
	
	//获取ab和ac的向量积
	private float getResult(PointF a, PointF b, PointF c) {
		return (a.x-c.x)*(a.y-b.y)-(a.y-c.y)*(a.x-b.x);
	}
	class PointF{
		public float x,y;
		public PointF(float x,float y){
			this.x=x;
			this.y=y;
		}
	}
}
