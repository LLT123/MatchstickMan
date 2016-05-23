package com.cloud.matchstickman.screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cloud.matchstickman.util.GdxUtil;
import com.cloud.matchstickman.util.LabelEx;
import com.cloud.matchstickman.util.LabelEx.FontType;
import com.cloud.matchstickman.util.TextButtonEx;

public class StartScreen extends FatherScreen {
	@Override
	public void show() {
		super.show();

		LabelEx label=new LabelEx("火材人联盟", FontType.WHITE_32);
		label.setPosition(480, 270, Align.center);
		mainStage.addActor(label);

		TextButtonEx tb=new TextButtonEx("开始游戏", "button_red.png", 22);
		tb.setX(960/2-tb.getWidth()/2);
		mainStage.addActor(tb);
		tb.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				GdxUtil.getGameMain().setScreen(new GameScreen());
			}});
	}

}
