package com.blockout22.evolution.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.blockout22.evolution.Statics;
import com.blockout22.evolution.ai.AIWander;

public class EntityHumanFemale extends EntityHuman{

    private AIWander aiWander;

    public EntityHumanFemale() {
        super(new Sprite(Statics.assetManager.get(Statics.TEXTURE_FEMALE, Texture.class)), Gender.FEMALE);
        aiWander = new AIWander(this);
    }

    @Override
    public void update() {
        aiWander.update();

    }
}
