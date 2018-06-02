package com.blockout22.evolution;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;
import com.blockout22.evolution.entity.Entity;
import com.blockout22.evolution.entity.EntityHumanFemale;
import com.blockout22.evolution.gui.DebugInfo;
import com.blockout22.evolution.gui.Hud;
import com.blockout22.evolution.gui.ProgressWindow;
import com.blockout22.evolution.input.DesktopInput;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;

public class Evolution extends ApplicationAdapter {

    private boolean loadedSetup = false;

    private DebugInfo debugInfo;

	private SpriteBatch batch;
	private Hud hud;
	private ProgressWindow assetLoadingWindow;

	private Skin uiSkin;

	private WaterRender water;
	private WorldMap worldMap;

	private VisLabel textInfo;

	private InputAdapter input;

    private EntityHumanFemale e1;
	int counter = 0;

	//used to save data every x amount of seconds;
    private long timer;
    private long waitSaveTime = 5000;
	
	@Override
	public void create () {
        System.out.println("Libgdx Version: " + Version.VERSION);
	    Gdx.gl.glEnable(GL20.GL_CULL_FACE);
	    Gdx.gl.glCullFace(GL20.GL_FRONT);
        Statics.init();
        uiSkin = Statics.assetManager.get(Statics.SKIN_UI, Skin.class);
        VisUI.load(VisUI.SkinScale.X2);
//        Statics.camera.position.set(320, 240, 0);
        assetLoadingWindow = new ProgressWindow("Loading...");
        batch = new SpriteBatch();

        switch (Gdx.app.getType()){
            case Android:
                //android input
                break;
            case iOS:
                //IOS input
                break;
            case WebGL:
                //webGL input
                break;

            default:
                    input = new DesktopInput();
                    System.out.println("On Desktop");

        }
	}

	private void load()
    {
        debugInfo = new DebugInfo();
        hud = new Hud("Hud");

        water = new WaterRender();
        worldMap = new WorldMap();
        int maxXRange = worldMap.getMapXSize() * MapTile.getGridSize();
        int maxYRange = worldMap.getMapYSize() * MapTile.getGridSize();
        Vector3 pos = new Vector3((int)(Math.random() * maxXRange), (int)(Math.random() * maxYRange), 0);
        Statics.camera.position.set(pos);

        hud.setFillParent(true);
        hud.align(Align.bottom);
        Statics.overlayStage.addActor(hud);

        Table info = new Table();
        info.setFillParent(true);
        textInfo = new VisLabel();
        textInfo.setX(0);
        info.add(textInfo);
        info.align(Align.topLeft);
        Statics.overlayStage.addActor(info);
//        textInfo.setY(Gdx.graphics.getHeight() - textInfo.getPrefHeight() / 2);

        Statics.camera.update();
        Gdx.input.setInputProcessor(new InputMultiplexer(Statics.overlayStage, debugInfo.getStage(), input));

        e1 = new EntityHumanFemale();
//        e1.transform.scale.set(1, 1);
//        e1.transform.size.set(1, 1);
//        entities.add(e1);

        timer = System.currentTimeMillis();
    }

    public boolean entityOnTile(Entity e){
        Vector2 ePos = e.transform.position;
        int tileX = (int)(ePos.x) / MapTile.getGridSize();
        int tileY = (int)(ePos.y) / MapTile.getGridSize();
        MapTile tile = null;
        try{
           tile = worldMap.getTileMap()[tileX][tileY];
        }catch(ArrayIndexOutOfBoundsException e1){
            return false;
        }

        if(tile != null){
            return true;
//            if(tile.)
        }

            return false;
    }



    @Override
    public void resize(int width, int height) {
        Statics.overlayStage.getViewport().update(width, height, true);

        if(debugInfo != null){
	        debugInfo.getStage().getViewport().update(width, height, true);
        }

        Statics.viewport.update(width, height, false);
        Statics.camera.viewportWidth = Statics.viewport.getWorldWidth();
        Statics.camera.viewportHeight = Statics.viewport.getWorldHeight();
        Statics.camera.update();
    }

    @Override
	public void render () {
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Statics.camera.update();

        boolean loading = Statics.assetsLoading();
        assetLoadingWindow.setProgress(Statics.assetManager.getProgress());

        //blocks rendering of  main content till loaded
        if(loading && !loadedSetup)
        {
            assetLoadingWindow.setShowing(loading, true);
            return;
        }

        if(!loadedSetup){
            System.out.println("Finished Loading");
            load();
            loadedSetup = true;
        }


	    counter++;
//	    if(counter % 10 == 0){
//	        e1.transform.size.x += 1.1f;
//	        e1.transform.size.y += 1.1f;
	        e1.transform.position.x += 3.1f;
//        }

        water.render();

	    batch.setProjectionMatrix(Statics.camera.combined);
	    batch.begin();
        {
            //render map
            worldMap.render(batch);
            //render entities
            for(Entity e : Statics.entities){
//                batch.draw(e.getSprite(), e.transform.position.x, e.transform.position.y);
                Statics.batchRenderTextureTransform(batch, e);
                e.update();
//                batch.draw(e.getSprite(), e.transform.position.x, e.transform.position.y, 0, 0, e.transform.size.x, e.transform.size.y, e.transform.scale.x, e.transform.scale.y, e.transform.rotation);
//                    Statics.batchRenderTextureTransform(batch, e);
            }

        }
        batch.end();

        textInfo.setText("FPS: " + Gdx.graphics.getFramesPerSecond() + " Counter Population: " + Statics.entities.size);


        //render overlay
//        debugInfo.draw();
//        overlay.act();
        hud.update();
        Statics.overlayStage.draw();

        assetLoadingWindow.setShowing(loading, false);

        Gdx.graphics.setTitle("FPS: " + Gdx.graphics.getFramesPerSecond() + " : " + Statics.camera.position);

        if(TimeUtils.timeSinceMillis(timer) > waitSaveTime){
            timer = System.currentTimeMillis();
            Statics.prefs.flush();
            System.out.println("Game Saved");
        }

//        if (Gdx.graphics.getFramesPerSecond() < 60) {
//            Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " FPS " + Statics.entities.size + " Entities "  + " WARNING: [FPS IS BELOW 60]");
//        } else {
//            Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " FPS " + Statics.entities.size + " Entities ");
//        }

	}
	
	@Override
	public void dispose () {
        debugInfo.dispose();
        uiSkin.dispose();
        water.dispose();
	    assetLoadingWindow.dispose();
	    Statics.dispose();
	    batch.dispose();
	    VisUI.dispose();
	}
}
