package com.blockout22.evolution.ai;

import com.blockout22.evolution.entity.Entity;

public abstract class AIEntityTask extends AITask{

    public Entity entity;

    public AIEntityTask(Entity entity){
        this.entity = entity;
    }

    public Entity getEntity()
    {
        return entity;
    }

}
