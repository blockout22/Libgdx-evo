package com.blockout22.evolution.entity;

import com.badlogic.gdx.math.Vector2;

public class Transform {
    public Vector2 position = new Vector2();
    public float rotation = 0f;
    public Vector2 size = new Vector2();
    public Vector2 scale = new Vector2();

    public String toString()
    {
        return "Position [" + position.x + ", " + position.y + "] Rotation [" + rotation + "] Size [" + size.x + ", " + size.y + "] Scale [" + scale.x + ", " + scale.y + "]";
    }
}
