package com.kaanaykut.icehockey.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kaanaykut.icehockey.GameObjects.GameWorld;
import com.kaanaykut.icehockey.InputHandler.PlayStateInput;

/**
 * Created by kaan on 16.03.2016.
 */
public class PlayState extends State{

    private GameWorld gameWorld;

    public PlayState(StateManager sm) {

        super(sm);
        gameWorld = new GameWorld();
        Gdx.input.setInputProcessor(new PlayStateInput(this));
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        gameWorld.render(sb);

    }

    @Override
    public void update(float delta) {
        gameWorld.update(delta);
    }

    @Override
    public void handleInput() {

    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }
}
