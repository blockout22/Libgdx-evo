package com.blockout22.evolution;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class SplashScreen {

    private SpriteBatch batch;
    private Texture texture;
    private long startTime;
    private long delay;
    private boolean showing = false;

    /**
     * shows a splash screen for x amount of time in milliseconds
     * @param batch
     * @param texture
     * @param timeMilli
     */
    public SplashScreen(SpriteBatch batch, Texture texture, long timeMilli){
        this.batch = batch;
        this.texture = texture;
        this.delay = timeMilli;
    }

    public boolean show()
    {
        if(!showing){
            System.out.println("Setting showing stuff");
            startTime = System.currentTimeMillis();
            showing = true;
        }

        long timeSince = TimeUtils.timeSinceMillis(startTime);
        if(timeSince < delay){
            double perc = delay / (timeSince + 1) / 100;
            System.out.println(perc);
            batch.begin();
            batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
            return true;
        }
        return false;
    }

    public void reset(){
        showing = false;
    }
}
