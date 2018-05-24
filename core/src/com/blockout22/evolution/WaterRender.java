package com.blockout22.evolution;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WaterRender {

    private SpriteBatch batch;
    private Texture water;

    public WaterRender(){
        batch = new SpriteBatch();
        water = Statics.assetManager.get(Statics.TEXTURE_WATER, Texture.class);
    }

    public void render()
    {
        batch.begin();
        batch.draw(water, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    public void dispose()
    {
        batch.dispose();
    }

}
