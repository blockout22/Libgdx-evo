package com.blockout22.evolution.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class EntityHuman extends Entity{

    public Gender gender;

    public EntityHuman(Sprite sprite, Gender gender){
        super(sprite);
        this.gender = gender;
    }
}
