package com.kaanaykut.icehockey.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kaan on 16.03.2016.
 */

public class Puck implements GameObject {

    private World world;
    private Body body;
    private BodyDef bodyDef;
    private Fixture fixture;
    private FixtureDef fixtureDef;

    //private OrthographicCamera boxCam;
    //private Box2DDebugRenderer box2DDebugRenderer;



    public Puck(World world){

        //world = new World(new Vector2(0,9.81f),true);

        this.world=world;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Gdx.graphics.getWidth()/5-10,Gdx.graphics.getHeight()/2);

        body = world.createBody(bodyDef);

        fixtureDef= new FixtureDef();
        fixtureDef.density = 0.25f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.5f;

        CircleShape dynamicCircle = new CircleShape();
        dynamicCircle.setRadius(20);
        fixtureDef.shape=dynamicCircle;

        fixture = body.createFixture(fixtureDef);

        //boxCam = new OrthographicCamera();
        //boxCam.setToOrtho(true,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//
        //box2DDebugRenderer = new Box2DDebugRenderer();



    }


    @Override
    public void render(SpriteBatch sb) {

        //box2DDebugRenderer.render(world,boxCam.combined);

    }

    @Override
    public void update(float delta) {

    }
}
