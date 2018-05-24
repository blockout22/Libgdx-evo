package com.blockout22.evolution;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.Random;

public class Statics {

    public final static ExtendViewport viewport = new ExtendViewport(640, 480);
    public final static Camera camera = new OrthographicCamera(viewport.getWorldWidth(), viewport.getWorldHeight());
    public final static AssetManager assetManager = new AssetManager();
    public final static Random random = new Random();
    public static Color defaultColor = new Color(1, 1, 1, 1);

//    public static Array<Entity> entities;

    //Strings
    public static String    TEXTURE_FEMALE = "female.jpg",
                            TEXTURE_MALE = "male.png",
                            TEXTURE_GRASS = "grass.png",
                            TEXTURE_DIRT = "dirt.png",
                            TEXTURE_WATER = "water.jpg";

    public static void init()
    {
 //        entities = new Array<Entity>();

        assetManager.load("badlogic.jpg", Texture.class);
//        assetManager.finishLoading();
        assetManager.load(TEXTURE_MALE, Texture.class);
        assetManager.load(TEXTURE_FEMALE, Texture.class);
        assetManager.load(TEXTURE_GRASS, Texture.class);
        assetManager.load(TEXTURE_DIRT, Texture.class);
        assetManager.load(TEXTURE_WATER, Texture.class);
//        assetManager.finishLoading();
    }

    public static void load(String asset, Class type)
    {
     assetManager.load(asset, type);
    }

    public static boolean assetsLoading()
    {
        return !assetManager.update();
    }


    public static void dispose() {
//        for (int i = 0; i < entities.size; i++) {
//            entities.get(i).getSprite().getTexture().dispose();
//        }
        assetManager.dispose();
    }

    public static int randomRange(int max, int min) {
        return random.nextInt(max + 1 - min) + min;
    }

    public static float map(float value, float istart, float istop, float ostart, float ostop) {
        return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
    }

    public static float dist(Vector2 v1, Vector2 v2) {
        float dx = v1.x - v2.x;
        float dy = v1.y - v2.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * a convenient method that will fill in all the draw arguments from spritebatch
     * @param batch
     * @param to
     */
    public static void batchRenderTextureTransform(SpriteBatch batch, TexturedObject to){
        batch.draw(to.getSprite(), to.transform.position.x, to.transform.position.y, 0, 0, to.transform.size.x, to.transform.size.y, to.transform.scale.x, to.transform.scale.y, to.transform.rotation);
    }
}
