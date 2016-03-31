package com.kaanaykut.icehockey.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.kaanaykut.icehockey.Buttons.Buttons;
import com.kaanaykut.icehockey.ImageLoader.ImageLoader;

/**
 * Created by kaan on 15.03.2016.
 */
public class MenuState extends State {


    private StateManager sm;
    private Buttons playButton,aboutButton,optionButton;

    private float buttonX;
    private float buttonY;

    public MenuState(StateManager sm) {
        super(sm);
        this.sm=sm;

        buttonX = Gdx.graphics.getWidth()/6;
        buttonY = Gdx.graphics.getHeight()/4;

        playButton = new Buttons(buttonX,buttonY, ImageLoader.playButtonRegion);
        aboutButton = new Buttons(buttonX,buttonY*2,ImageLoader.aboutButtonRegion);
        optionButton = new Buttons(buttonX,buttonY*3,ImageLoader.optionButtonRegion);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(ImageLoader.bgRegion,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        sb.end();
        playButton.render(sb);
        aboutButton.render(sb);
        optionButton.render(sb);

    }

    @Override
    public void update(float delta) {


    }

    @Override
    public void handleInput() {

    }
}
