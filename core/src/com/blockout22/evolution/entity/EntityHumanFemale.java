package com.blockout22.evolution.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.blockout22.evolution.Statics;

public class EntityHumanFemale extends EntityHuman{

    public EntityHumanFemale() {
        super(new Sprite(Statics.assetManager.get(Statics.TEXTURE_FEMALE, Texture.class)), Gender.FEMALE);
    }

    @Override
    public void update() {

    }
}
