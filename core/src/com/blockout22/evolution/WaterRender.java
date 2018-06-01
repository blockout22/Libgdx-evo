package com.blockout22.evolution;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WaterRender {

    private SpriteBatch batch;
    private Texture water;
    private TextureRegion textureRegion;
    private Image image;
    float drawingWidth,drawingHeight;

    public WaterRender(){
        batch = new SpriteBatch();
        water = Statics.assetManager.get(Statics.TEXTURE_WATER, Texture.class);
//        water.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        textureRegion = new TextureRegion(water, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        drawingWidth = Gdx.graphics.getWidth();
        drawingHeight = Gdx.graphics.getHeight();
    }

    public void render()
    {
        batch.begin();
        batch.draw(water, 0, 0, drawingWidth, drawingHeight);
        batch.end();
    }

    public void dispose()
    {
        batch.dispose();
    }

}
