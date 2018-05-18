package com.blockout22.evolution.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.blockout22.evolution.Statics;
import com.kotcrab.vis.ui.widget.VisProgressBar;
import com.kotcrab.vis.ui.widget.VisWindow;

public class ProgressWindow extends VisWindow {

    private Stage stage;
    private Table table;
    private VisProgressBar progressBar;

    public ProgressWindow(String title) {
        super(title);
        setCenterOnAdd(true);
        stage = new Stage(Statics.viewport);

        table = new Table();
        progressBar = new VisProgressBar(0, 1, 0.1f, false);

        table.add(progressBar).pad(5);
        add(table).pad(5);
        stage.addActor(this);
        pack();
    }

    public void setShowing(boolean showing, boolean center){
        if(center){
            centerWindow();
        }else{
            setPosition(0, 0);
        }
        if(showing){
            System.out.println("Drawing");
            stage.draw();
        }
    }

    public void setProgress(float value){
        progressBar.setValue(value);
    }

    public void dispose()
    {
        stage.dispose();
    }
}
