package com.cloud.matchstickman.enter;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.inaka.scrlog.ScrLog;
import com.inaka.scrlog.ScrLogOptions;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ScrLogOptions options = new ScrLogOptions.Builder()
		                  .numberOfLines(3)
		                  .backgroundColor(Color.parseColor("#D9d6d6d6"))
		                  .textColor(Color.BLACK)
		                  .textSize(10)
		                  .build(); 
		ScrLog.enable(this, options);
		
		initialize(new GameMain());
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ScrLog.disable(this);
	}
}
