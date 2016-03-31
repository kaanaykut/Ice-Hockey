package com.kaanaykut.icehockey.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by kaan on 16.03.2016.
 */
public class Buttons {

    private TextureRegion buttonImage;
    private float xKord,yKord,width,height;


    public Buttons(float xKord,float yKord, TextureRegion buttonImage){

        this.buttonImage=buttonImage;
        this.xKord = xKord;
        this.yKord = yKord;

        width = (Gdx.graphics.getWidth()*2)/3;
        height = (float) (width*0.2);
    }


    public void render(SpriteBatch sb){
        sb.begin();

        sb.draw(buttonImage,xKord,yKord,width,height);

        sb.end();

    }

    public void update(float delta){



    }
}
