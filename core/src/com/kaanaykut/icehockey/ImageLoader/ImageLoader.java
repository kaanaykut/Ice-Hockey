package com.kaanaykut.icehockey.ImageLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by kaan on 15.03.2016.
 */
public class ImageLoader {

    public static Texture Buttons,background;

    public static TextureRegion playButtonRegion,aboutButtonRegion,optionButtonRegion,backButtonRegion,bgRegion,puddleRegion;



    public static void load(){

        Buttons = new Texture(Gdx.files.internal("Buttons.png"));

        playButtonRegion = new TextureRegion(Buttons,1,1,300,100);
        playButtonRegion.flip(false,true);

        optionButtonRegion = new TextureRegion(Buttons,1,120,300,100);
        optionButtonRegion.flip(false,true);

        aboutButtonRegion = new TextureRegion(Buttons,1,240,300,100);
        aboutButtonRegion.flip(false,true);

        backButtonRegion = new TextureRegion(Buttons,1,350,150,100);
        backButtonRegion.flip(false,true);

        background = new Texture(Gdx.files.internal("background_texture.png"));
        bgRegion = new TextureRegion(background,0,0,477,800);
        bgRegion.flip(false,true);

        puddleRegion = new TextureRegion(background,500,400,30,30);
        puddleRegion.flip(false,true);
    }

    public static void dispose(){
        Buttons.dispose();

    }

}
