package com.blockout22.evolution.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.blockout22.evolution.MapTile;
import com.blockout22.evolution.Statics;
import com.blockout22.evolution.entity.EntityHumanFemale;

public class DesktopInput extends InputAdapter {

    // camera movement
    private final Vector3 curr = new Vector3();
    private final Vector3 last = new Vector3(-1, -1, -1);
    private final Vector3 delta = new Vector3();
    private final Vector2 dragStart = new Vector2();
    public static final Plane plane = new Plane(new Vector3(0, 1, 0), 0);
    private boolean justDragged = false;

    public DesktopInput()
    {
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.R){
            int maxXRange = 100 * MapTile.getGridSize();
            int maxYRange = 100 * MapTile.getGridSize();
            Vector3 pos = new Vector3((int)(Math.random() * maxXRange), (int)(Math.random() * maxYRange), 0);
            Statics.camera.position.set(pos);
            return true;
        }

        if(keycode == Input.Keys.G){
            EntityHumanFemale e = new EntityHumanFemale();
            e.transform.position.set(Statics.camera.position.x, Statics.camera.position.y);
            Statics.entities.add(e);
        }

        if(keycode == Input.Keys.L){
            System.out.println("Loading more assets");
            Statics.assetManager.load("temp/1.jpg", Texture.class);
            Statics.assetManager.load("temp/2.jpg", Texture.class);
            Statics.assetManager.load("temp/3.jpg", Texture.class);
            Statics.assetManager.load("temp/4.jpg", Texture.class);
            Statics.assetManager.load("temp/5.png", Texture.class);
            Statics.assetManager.load("temp/6.jpg", Texture.class);
            Statics.assetManager.load("temp/7.jpg", Texture.class);
            Statics.assetManager.load("temp/8.jpg", Texture.class);
            Statics.assetManager.load("temp/9.jpg", Texture.class);
            Statics.assetManager.load("temp/10.jpg", Texture.class);
        }

        if(keycode == Input.Keys.U){
            Statics.assetManager.unload("temp/1.jpg");
            Statics.assetManager.unload("temp/2.jpg");
            Statics.assetManager.unload("temp/3.jpg");
            Statics.assetManager.unload("temp/4.jpg");
            Statics.assetManager.unload("temp/5.png");
            Statics.assetManager.unload("temp/6.jpg");
            Statics.assetManager.unload("temp/7.jpg");
            Statics.assetManager.unload("temp/8.jpg");
            Statics.assetManager.unload("temp/9.jpg");
            Statics.assetManager.unload("temp/10.jpg");
            System.out.println("Unloaded assets");
        }

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        dragStart.set(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //check if a popup(/menu) is showing, if showing then ignore actions

        last.set(-1, -1, -1);
        if(justDragged){
            justDragged = false;
        }else{
            //perform a click event
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //check if a popup(/menu) is showing, if showing then ignore actions

        int xDistance = (int) (dragStart.x - screenX);
        int yDistance = (int)(dragStart.y - screenY);
        float distTollorence = 1;

        if (Gdx.input.isTouched()) {
            if (xDistance < -distTollorence || xDistance > distTollorence || yDistance < -distTollorence || yDistance > distTollorence) {
                justDragged = true;
            }
        }

        float x= Gdx.input.getDeltaX();
        float y = Gdx.input.getDeltaY();
        Statics.camera.position.add(-x, y, 0);

        last.set(screenX, screenY, 0);
        return true;
    }
}
