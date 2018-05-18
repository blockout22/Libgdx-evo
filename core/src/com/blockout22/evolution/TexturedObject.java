package com.blockout22.evolution;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class TexturedObject extends GameObject{

    private Sprite sprite;

    public TexturedObject(Sprite sprite){
        this.sprite = sprite;
        this.transform.size.set(sprite.getRegionWidth(), sprite.getRegionHeight());
        this.transform.scale.set(1, 1);
    }

    public Sprite getSprite() {
        return sprite;
    }
}
