package com.blockout22.evolution;

import com.blockout22.evolution.entity.Transform;

public abstract class GameObject
{
    public Transform transform;

    public GameObject()
    {
        this.transform = new Transform();
    }

    public abstract void update();

    public Transform getTransform() {
        return transform;
    }
}
