package com.blockout22.evolution;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MapTileDirt extends MapTile{

    public MapTileDirt(int gridX, int gridY) {
        super(new Sprite(Statics.assetManager.get(Statics.TEXTURE_DIRT, Texture.class)), gridX, gridY);
    }

    @Override
    public void update() {

    }
}