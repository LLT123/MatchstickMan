package com.cloud.matchstickman.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
/**
 * 1，弹框消失动画结束后接代码块
 * 2，弹框部件摆到弹框外面去，需要传入最大的透明Texture即可
 * 3，返回键事件
 * 4，自定义弹框出现消失动画
 */
public class DialogEx extends Dialog{

	private float bgAlpha=0.5f;//背景透明度
	private InputProcessor backInput=new BackInput();
	/**
	 * 创建一个显示区域为传入Texture大小的弹框，超过大小不会显示。
	 * 此dialog的宽和高都将等于此Texture的宽高
	 */
	public DialogEx(Texture texture) {
		this("", new BitmapFont(), Color.WHITE, texture);
	}
	private DialogEx(String titleTxt,BitmapFont font,Color fontColor,Texture texture) {
		super(titleTxt, new WindowStyle(font, fontColor,new TextureRegionDrawable(new TextureRegion(texture))));
		setSize(getStyle().background.getMinWidth(),getStyle().background.getMinHeight());
		setOrigin(Align.center);	
//		debug();
//		getContentTable().debug();
//		getButtonTable().debug();
	}
	
	public void setBgAlpha(float bgAlpha) {
		this.bgAlpha = bgAlpha;
	}
	/**
	 * 设置点弹框外面隐藏弹框
	 */
	public void hideOnClickOuter(){
		addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				if(x<0||y<0||x>getWidth()||y>getHeight()){//点到弹框外面
					hide();
				}
			}});
	}
	/**
	 * 可复写此方法改变弹框弹出动画
	 */
	protected Action showAnim(Stage stage){
		return Actions.sequence(Actions.fadeIn(0.1f));
	}
	/**
	 * 可复写此方法改变弹框隐藏动画
	 */
	protected Action hideAnim(){
		return Actions.sequence(Actions.fadeOut(0.1f));
	}
	/**
	 * 在这里设置弹框弹出动画前的默认位置
	 * @param stage
	 */
	protected void setDefultPlace(Stage stage) {
		setPosition(Math.round((stage.getWidth() - getWidth()) / 2), Math.round((stage.getHeight() - getHeight()) / 2));
	}
	/**
	 * 复写此方法改变返回键事件
	 */
	protected void backEvent(){
		Gdx.app.log("DialogEx", getClass().getSimpleName()+"弹框的返回键按下");
	}
	//以下方法不建议复写-------------------------------------------------------------------
	@Override
	public Dialog show(Stage stage) {
		if(bgAlpha!=0)addGrayImg(stage);
		setDefultPlace(stage);
		((InputMultiplexer)Gdx.input.getInputProcessor()).addProcessor(0,backInput);
		return super.show(stage, showAnim(stage));//添加动画出现
	}
	@Override
	public void hide() {
		hideClear();
		super.hide(hideAnim());
	}
	/**
	 * 弹框动画消失后接可运行的代码块功能
	 * @param run
	 */
	public void hide(Runnable run){
		hideClear();
		super.hide(Actions.sequence(hideAnim(),Actions.run(run)));
	}
	private void hideClear(){
		clearListeners();
		removeGrayImg();
		((InputMultiplexer)Gdx.input.getInputProcessor()).removeProcessor(backInput);
	}
	private void removeGrayImg(){
		if(bgAlpha!=0)getParent().findActor("dialogGrayImg"+this.hashCode()).remove();
	}
	private void addGrayImg(Stage stage){
		Pixmap pix=new Pixmap(540, 960, Format.RGBA8888);
		pix.setColor(0, 0, 0, bgAlpha);
		pix.fill();
		Image dialogGrayImg=new Image(new Texture(pix));
		dialogGrayImg.setName("dialogGrayImg"+this.hashCode());
		stage.addActor(dialogGrayImg);
	}
	class BackInput extends InputAdapter{
		@Override
		public boolean keyDown(int keycode) {
			if(keycode==Input.Keys.BACK||keycode==Input.Keys.ESCAPE){
				backEvent();
			}
			return true;
		}
	}
}
