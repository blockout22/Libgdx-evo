package com.blockout22.evolution.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.blockout22.evolution.Bounds;
import com.blockout22.evolution.Statics;
import com.blockout22.evolution.entity.Entity;

public class AIWander extends AIEntityTask {

    private final Vector2 velocity;
    private final Vector2 acceleration;
    private Vector2 targetLocation;
    private float maxforce;
    private float maxspeed;

    private Bounds bounds = null;

    //
    private Vector2 desired = new Vector2();

    //the distance the AI can wander to based on its previous position
    private int range = 200;

    public AIWander(Entity entity){
        super(entity);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        targetLocation = null;
        this.maxforce = 5f;
        this.maxspeed = 5f;
    }

    public void setBounds(Bounds bounds){
        this.bounds = bounds;
    }

    public void setMaxspeed(float value){
        this.maxspeed = value;
    }

    public void setRange(int value){
        this.range = value;
    }

    @Override
    public void update() {
        if(targetLocation == null){
            targetLocation = entity.transform.position.cpy();
        }
        float dist = Statics.dist(entity.transform.position, targetLocation);
        arrive();

        if(dist < 0.1) {
            if (Statics.random.nextInt(100) < 1) {
                if (bounds != null) {
                    Vector2 min = bounds.getMin();
                    Vector2 max = bounds.getMax();
                    float x = Statics.randomRange((int) max.x, (int) min.x);
                    float y = Statics.randomRange((int) max.y, (int) min.y);
                    setTargetLocation(x, y);
                } else {
                    float x = Statics.randomRange((int) entity.transform.position.x + 100, (int) entity.transform.position.x - 100);
                    float y = Statics.randomRange((int) entity.transform.position.y + 100, (int) entity.transform.position.y - 100);
                    setTargetLocation(x, y);
                }
            }
        }
        float speed = 5;
        velocity.add(acceleration);
        velocity.limit(maxspeed);
        entity.transform.position.add((Gdx.graphics.getDeltaTime() * velocity.x) * speed, (Gdx.graphics.getDeltaTime() * velocity.y) * speed);
        acceleration.set(0, 0);
    }

    public void setTargetLocation(float x, float y){
        targetLocation.set(x, y);
    }

    private void arrive(){
        desired.set(targetLocation);
        desired.sub(entity.transform.position);

        float d = desired.len();
        desired.nor();
        if(d < 25){
            float m = Statics.map(d, 0, 20, 0, maxspeed);
            desired.scl(m);
        }else{
            desired.scl(maxspeed);
        }

        Vector2 steer = desired.sub(velocity);
        steer.limit(maxforce);
        applyForce(steer);
    }

    private void applyForce(Vector2 force) {
        acceleration.add(force.x, force.y);
    }
}
