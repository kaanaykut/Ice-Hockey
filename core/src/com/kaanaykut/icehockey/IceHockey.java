package com.kaanaykut.icehockey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kaanaykut.icehockey.ImageLoader.ImageLoader;
import com.kaanaykut.icehockey.States.MenuState;
import com.kaanaykut.icehockey.States.PlayState;
import com.kaanaykut.icehockey.States.StateManager;

public class IceHockey extends ApplicationAdapter {

	public static int WIDTH = 480;
	public static int HEIGHT = 800;
	public static StateManager sm;
	private SpriteBatch sb;
	
	@Override
	public void create () {

		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);

		ImageLoader.load();
		sb = new SpriteBatch();

		sm = new StateManager(sm);
		sm.pushState(new PlayState(sm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.render(sb);
		sm.update(Gdx.graphics.getDeltaTime());

	}

	public void dispose(){

		ImageLoader.dispose();
		super.dispose();
	}
}
