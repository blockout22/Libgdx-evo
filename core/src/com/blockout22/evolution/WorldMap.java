package com.blockout22.evolution;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldMap {

    //store tiles and location of tiles

//    private Array<MapTile> tiles = new Array<MapTile>();
    private MapTile[][] tileMap = new MapTile[100][100];

    private MapTileGrass grass;

    public WorldMap() {
        for(int x = 0; x < tileMap.length; x++){
            for(int y = 0; y < tileMap[x].length; y++){
                if(Math.random() < 0.5f){
                    tileMap[x][y] = new MapTileGrass(x, y);
                }else{
                    tileMap[x][y] = new MapTileDirt(x, y);
                }
            }
        }

//        int t = 50;
//        for (int i = -t; i < t; i++) {
//            for (int j = -t; j < t; j++) {
//                if (r.nextFloat() < 0.5f) {
//                    System.out.println("Adding tile");
////                    tiles.add(new MapTileGrass(i, j));
//                    tiles.add(new MapTileGrass(i, j));
//                } else {
////                    tiles.add(new MapTileDirt(i, j));
//                    tiles.add(new MapTileDirt(i, j));
//                }
//            }
//        }

    }

    public int getMapXSize(){
        return tileMap.length;
    }

    public int getMapYSize()
    {
        return tileMap[0].length;
    }

    public void render(SpriteBatch batch) {
        int tilecount = 0;
        int tileX = 0;
        int tileY = 0;
        tileX = (int) Math.floor(Statics.camera.position.x / MapTile.getGridSize());
        tileY = (int)Math.floor(Statics.camera.position.y / MapTile.getGridSize());
        for (int x = tileMap.length - 1; x >= 0; x--) {
            for(int y = tileMap[x].length - 1; y >= 0; y--) {
                MapTile t = tileMap[x][y];
                if (Statics.camera.frustum.boundsInFrustum(t.getBoundingBox())) {
                    if (t.getGridX() == tileX && t.getGridY() == tileY) {
                        batch.setColor(Color.GRAY);
                    } else {
                        batch.setColor(Statics.defaultColor);
                    }
//                    System.out.println("Drawing " + x + " : "+ y + " : " + tileMap[x][y].transform);
                    Statics.batchRenderTextureTransform(batch, t);
                    tilecount++;
                }
            }
        }
    }
}
