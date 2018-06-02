package com.blockout22.evolution.gui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.blockout22.evolution.Statics;
import com.blockout22.evolution.entity.EntityHumanFemale;
import com.kotcrab.vis.ui.widget.VisTextButton;

import java.util.concurrent.TimeUnit;

public class Hud extends Table {

    private VisTextButton addFemale, addMale, openBox;

    private long openingTime = 0;
    private final long delay = TimeUnit.MINUTES.toMillis(1);

    public Hud(String title) {
        super();

        //TODO limit this to once a day
        addFemale = new VisTextButton("Add Female");
        addMale = new VisTextButton("Add Male");
        openBox = new VisTextButton("Open Box");
        openBox.setDisabled(true);

        long t = Statics.prefs.getLong("last-box-opened");
        openingTime = t;

        addFemale.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                EntityHumanFemale e = new EntityHumanFemale();
                e.transform.position.set(Statics.camera.position.x, Statics.camera.position.y);
                Statics.entities.add(e);
//                Entity e = new EntityHumanFemale(new Sprite(Statics.asset.get("female.jpg", Texture.class)));
//                e.setLocation(new Vector2(MathUtils.random(200) - 100, MathUtils.random(200) - 100));
//                Statics.entities.add(e);
            }
        });

        addMale.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
//                Entity e = new EntityHumanMale(new Sprite(Statics.asset.get("male.png", Texture.class)));
//                e.setLocation(new Vector2(MathUtils.random(200) - 100, MathUtils.random(200) - 100));
//                Statics.entities.add(e);
            }
        });

        openBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                long time = System.currentTimeMillis();
                openingTime = time;
                System.out.println("Select a random reward from opening this");
                Statics.prefs.putLong("last-box-opened", time);
                Statics.prefs.flush();
            }
        });

//        add(table);
//        add(addFemale).pad(5);
//        add(addMale).pad(5);
        add(openBox);
        pack();
    }

    public void update(){
        if(System.currentTimeMillis() > openingTime + delay){
            openBox.setDisabled(false);
            openBox.setText("Open Box");
        }else{
            openBox.setDisabled(true);
            openBox.setText((TimeUnit.MILLISECONDS.toSeconds(openingTime - System.currentTimeMillis() + delay) + "s left"));
        }
    }
}
