package com.blockout22.evolution.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.blockout22.evolution.TexturedObject;

public abstract class Entity extends TexturedObject {

    private Sprite sprite;

    public Entity(Sprite sprite){
        super(sprite);
        this.transform.size.set(25, 25);
    }
}
