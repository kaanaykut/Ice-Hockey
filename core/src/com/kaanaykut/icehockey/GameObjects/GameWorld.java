package com.kaanaykut.icehockey.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by kaan on 16.03.2016.
 */

public class GameWorld implements GameObject {

    private World world;
    private Puck puck;
    private Paddle paddle;


    private OrthographicCamera boxcam;
    private Box2DDebugRenderer box2DDebugRenderer;



    public GameWorld(){


        world = new World(new Vector2(0,0),true);


        puck = new Puck(world);
        paddle = new Paddle(world,Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/5);


        boxcam = new OrthographicCamera();
        boxcam.setToOrtho(true,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        box2DDebugRenderer = new Box2DDebugRenderer();


        paddle.getBody().getUserData();

    }

    @Override
    public void render(SpriteBatch sb) {


        box2DDebugRenderer.render(world, boxcam.combined);


        sb.begin();


        puck.render(sb);
        paddle.render(sb);


        sb.end();

        world.step(1/45f, 6, 2);
    }

    @Override
    public void update(float delta) {

        puck.update(delta);
        paddle.update(delta);

    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }


}
