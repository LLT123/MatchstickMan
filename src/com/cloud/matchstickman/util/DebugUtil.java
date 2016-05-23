package com.cloud.matchstickman.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import android.annotation.SuppressLint;

public class DebugUtil {

	private final float SCREENW=960;
	private final float SCREENH=540;
	
	private Batch debugBatch;
	private ShapeRenderer sr;
	private BitmapFont font;
	private String logTxt="";//最后的输出文字
	public DebugUtil(){
		//初始化工具
		Matrix4 matrix=new Stage(new StretchViewport(SCREENW, SCREENH)).getCamera().combined;
		
		debugBatch=new SpriteBatch();
		debugBatch.setProjectionMatrix(matrix);
		sr=new ShapeRenderer();
		sr.setProjectionMatrix(matrix);
		
		BitmapFontData bitmapFontData=new BitmapFontData(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), false);
		bitmapFontData.setScale(1.5f);
		font=new BitmapFont(bitmapFontData, 
				new TextureRegion(new Texture(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"), false)), true);
		font.setColor(Color.RED);
	}
	
	//屏幕log
	@SuppressLint("SimpleDateFormat")
	public void log(String logTxt) {
		this.logTxt = "Log:"+new SimpleDateFormat("hh-mm-ss").format(new Date(System.currentTimeMillis()))+">>>>>>"+logTxt;
	}
	public void drawScreenLog(){
		debugBatch.begin();
		font.draw(debugBatch, logTxt, 0,SCREENH-25);
		debugBatch.end();
	}
	
	public void drawFPS(){
		debugBatch.begin();
		font.draw(debugBatch, "FPS:"+Gdx.graphics.getFramesPerSecond()+" Heap:"+Gdx.app.getJavaHeap()/1000+"KB", 0,SCREENH);
		debugBatch.end();
	}
	public void drawScreenRuler(){
		sr.begin(ShapeType.Line);
		for (int i = 0; i < SCREENW/10; i++) {
			if(i%10==0){
				sr.setColor(Color.RED);
				sr.line(i*10, 0, i*10, 40);
			}else if(i%5==0){
				sr.setColor(Color.BLUE);
				sr.line(i*10, 0, i*10, 20);
			}else{
				sr.setColor(Color.BLACK);
				sr.line(i*10, 0, i*10, 10);
			}
		}
		for (int i = 0; i < SCREENH/10; i++) {
			if(i%10==0){
				sr.setColor(Color.RED);
				sr.line(0,i*10,40,i*10);
			}else if(i%5==0){
				sr.setColor(Color.BLUE);
				sr.line(0,i*10,20,i*10);
			}else{
				sr.setColor(Color.BLACK);
				sr.line(0,i*10,10,i*10);
			}
		}
		sr.end();
	}
	
	private static DebugUtil INSTANCE=new DebugUtil();
	public static DebugUtil getInst(){
		return INSTANCE;
	} 
	
	
	
}
