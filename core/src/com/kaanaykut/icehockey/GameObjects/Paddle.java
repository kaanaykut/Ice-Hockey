package com.kaanaykut.icehockey.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kaan on 19.03.2016.
 */
public class Paddle implements GameObject {

    private float positionX;
    private float positionY;
    private Sprite sprite;
    private SpriteBatch sb;



    private World world;
    private Body body;
    private BodyDef bodyDef;
    private Fixture fixture;
    private FixtureDef fixtureDef;

    //private OrthographicCamera boxcam;
    //private Box2DDebugRenderer box2DDebugRenderer;

    private Circle circleRect;
    boolean kaan = false;


    public Paddle(World world,float positionX,float positionY){

        this.world = world;
        this.positionX=positionX;
        this.positionY=positionY;


        sb = new SpriteBatch();
        //sprite = new Sprite();

        //world = new World(new Vector2(0,1f),true);

        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(positionX,positionY);

        body = world.createBody(bodyDef);

        //sprite.setPosition(body.getPosition().x,body.getPosition().y);

        fixtureDef = new FixtureDef();
        fixtureDef.density = 10.0f;
        fixtureDef.friction = 0.3f;
        fixtureDef.restitution = 0.5f;
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(30);
        fixtureDef.shape = circleShape;

        fixture = body.createFixture(fixtureDef);

        //boxcam = new OrthographicCamera();
        //boxcam.setToOrtho(true,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//
        //box2DDebugRenderer = new Box2DDebugRenderer();

        circleRect = new Circle(positionX,positionY,30);

        body.setUserData(circleShape);

    }

    @Override
    public void render(SpriteBatch sb) {



        //sprite.draw(sb);

        //box2DDebugRenderer.render(world, boxcam.combined);
    }

    @Override
    public void update(float delta) {
        body.isAwake();

        world.step(delta, 6, 2);

        setPositionX(body.getPosition().x);
        setPositionY(body.getPosition().y);


        circleRect.x = positionX;
        circleRect.y = positionY;



        if (kaan) {
            //setPositionX(Gdx.input.getX());
            //setPositionY(Gdx.input.getY());

            body.setTransform(Gdx.input.getX(),Gdx.input.getY(),0f);
        }



    }



    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public Circle getCircleRect() {
        return circleRect;
    }

    public void setKaan(boolean kaan) {
        this.kaan = kaan;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }
}

