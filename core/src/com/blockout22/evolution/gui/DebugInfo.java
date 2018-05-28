package com.blockout22.evolution.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Version;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.blockout22.evolution.Statics;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisScrollPane;

public class DebugInfo {

    private Stage stage;
    private Table table;
    private VisScrollPane scroll;
    private VisLabel version;
    private VisLabel libGdxVersion;
    private VisLabel javaVersion;
    private VisLabel displaySize;

    private int displayWidth;
    private int displayHeight;

    private float longest = 0;
    private final Vector2 scrollPos = new Vector2();

    public DebugInfo()
    {
        stage = new Stage(Statics.viewport);
        table = new Table();
        scroll = new VisScrollPane(table);

        version = new VisLabel(Statics.GAME_NAME + ": " + Statics.VERSION);
        libGdxVersion = new VisLabel("Libgdx Version: " + Version.VERSION);
        javaVersion = new VisLabel("Java: " + System.getProperty("java.version"));
        displaySize = new VisLabel("Display Size: " + displayWidth + "x" + displayHeight);

        stage.addActor(scroll);
//        scroll.setSize(300, 300);
        table.add(version).left();
        table.row();
        table.add(libGdxVersion).left();
        table.row();
        table.add(javaVersion).left();
        table.row();
        table.add(displaySize).left();

        table.align(Align.bottomLeft).pad(10);
        table.debugAll();
        scroll.setFadeScrollBars(false);
        scrollPos.set(0, 0);

    }

    public Stage getStage()
    {
        return stage;
    }


    public void draw()
    {
        boolean updateDisplaySize = false;
        if(displayWidth != Gdx.graphics.getWidth()){
            displayWidth = Gdx.graphics.getWidth();
            updateDisplaySize = true;
        }

        if(displayHeight != Gdx.graphics.getHeight()){
            displayHeight = Gdx.graphics.getHeight();
            updateDisplaySize = true;
        }

        if(updateDisplaySize){
            displaySize.setText("Display Size: " + displayWidth + "x" + displayHeight);
            scroll.setWidth(table.getMinWidth() + 26 * 2 + scroll.getScrollBarWidth() * 2);

//                stage.getCamera().viewportWidth = displayWidth;
//                stage.getCamera().viewportHeight = displayHeight;

            Statics.moveActorToBottomLeft(stage.getCamera(), Statics.viewport, scroll);
//            scrollPos.set(0, 0);
//            Statics.viewport.unproject(scrollPos);
//            scroll.setX(scrollPos.x);
//            scroll.setY(Statics.viewport.getMinWorldHeight() - scrollPos.y);
//            if(x > 0){
//                scroll.setX(-(x / 2));
//            }
//
//            if(y > 0){
//                scroll.setY(-(y / 2));
//            }
        }

        stage.act();
        stage.draw();
    }

    public void dispose()
    {
        stage.dispose();
    }
}
