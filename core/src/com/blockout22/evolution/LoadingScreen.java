package com.blockout22.evolution;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingScreen {

    private SpriteBatch batch;
    private Texture texture;
    private FinishListener finishListener;
    private boolean hasLoaded = false;

    public LoadingScreen(FinishListener finishListener){
        this.finishListener = finishListener;
        batch = new SpriteBatch();
        texture = Statics.assetManager.get("badlogic.jpg", Texture.class);
    }

    /**
     * returns true if still loading...
     * @return
     */
    public void update()
    {
        boolean state = Statics.assetManager.update();
        if(state && !hasLoaded){
            finishListener.action();
            hasLoaded = true;
        }else if(!state){
            hasLoaded = false;
            batch.begin();
            batch.draw(texture, 0, 0);
            batch.end();
        }
    }

    public void queAsset(String asset, Class type)
    {
        Statics.assetManager.load(asset, type);
    }
}
