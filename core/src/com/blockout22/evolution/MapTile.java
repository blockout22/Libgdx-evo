package com.blockout22.evolution;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public abstract class MapTile extends TexturedObject{

    private int gridX;
    private int gridY;
    private static int gridSize = 50;
    private BoundingBox boundingBox;

    public MapTile(Sprite sprite, int gridX, int gridY) {
        super(sprite);
        this.gridX = gridX;
        this.gridY = gridY;
        this.transform.position.set(gridX * gridSize, gridY * gridSize);
        this.transform.size.set(gridSize, gridSize);
        this.boundingBox = new BoundingBox(new Vector3(this.transform.position.x, this.transform.position.y, 0), new Vector3((this.transform.position.x + this.transform.size.x) * this.transform.scale.x, (this.transform.position.y + this.transform.size.y) * this.transform.scale.y, 0));
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public static int getGridSize() {
        return gridSize;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
