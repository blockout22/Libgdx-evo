package com.blockout22.evolution.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.blockout22.evolution.Statics;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisWindow;

public class Hud extends VisWindow{

    private VisTextButton addFemale, addMale;

    public Hud(String title) {
        super(title, false);
        final Table table = new Table();
        getTitleLabel().setAlignment(Align.center);

        addFemale = new VisTextButton("Add Female");
        addMale = new VisTextButton("Add Male");

        addFemale.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Add Female");
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

        add(table);
        table.add(addFemale).pad(5);
        add(addMale).pad(5);
        pack();
    }
}
