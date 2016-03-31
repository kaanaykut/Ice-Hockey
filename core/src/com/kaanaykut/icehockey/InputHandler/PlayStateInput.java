package com.kaanaykut.icehockey.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.kaanaykut.icehockey.States.PlayState;

/**
 * Created by kaan on 20.03.2016.
 */
public class PlayStateInput implements InputProcessor {

    private PlayState playState;
    private Vector2 EndKord;

    public PlayStateInput(PlayState playState){

        this.playState = playState;

        EndKord = new Vector2(Gdx.input.getX(),Gdx.input.getY());
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


    if (playState.getGameWorld().getPaddle().getCircleRect().contains(screenX, screenY)) {
        System.out.println("dokundun");
        playState.getGameWorld().getPaddle().setKaan(true);

    }


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        playState.getGameWorld().getPaddle().setKaan(false);

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (playState.getGameWorld().getPaddle().getCircleRect().contains(screenX, screenY)) {
            System.out.println("dokundun");
            playState.getGameWorld().getPaddle().setKaan(true);

        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {


        return false;
    }


    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
