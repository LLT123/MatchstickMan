package com.cloud.matchstickman.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.utils.ObjectMap;

public class Asset {

	private static final Asset INSTANCE = new Asset();

	// 存放临时申明的资源
	private final ObjectMap<String, Texture> textureMap = new ObjectMap<String, Texture>();
	private final ObjectMap<String, BitmapFont> fontMap = new ObjectMap<String, BitmapFont>();
	private final ObjectMap<String, ParticleEffectPool> particleMap = new ObjectMap<String, ParticleEffectPool>();
	
	public static Asset getInst() {
		return INSTANCE;
	}

	public Texture getTexture(String filePath) {
		if (textureMap.containsKey(filePath)) {
			return textureMap.get(filePath);
		}
		TextureEx texture = null;
		texture = new TextureEx(filePath);
		textureMap.put(filePath, texture);
		return texture;
	}
	public BitmapFont getBitmapFont(String filePath) {
		if (fontMap.containsKey(filePath)) {
			return fontMap.get(filePath);
		} else {
			BitmapFont font = new BitmapFont(Gdx.files.internal(filePath),
					false);
			font.getRegion().getTexture()
					.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			fontMap.put(filePath, font);
			return font;
		}
	}
	public ParticleEffect getParticle(String effectFile, String imagesDir,
			int initNum, int maxNum) {
		ParticleEffect effect = null;
		if (particleMap.containsKey(effectFile)) {
			effect = particleMap.get(effectFile).obtain();
		} else {
			effect = new ParticleEffect();
			effect.load(Gdx.files.internal(effectFile),
					Gdx.files.internal(imagesDir));
			ParticleEffectPool pool = new ParticleEffectPool(effect, initNum,
					maxNum);
			particleMap.put(effectFile, pool);
			effect = particleMap.get(effectFile).obtain();
		}
		return effect;
	}

}
