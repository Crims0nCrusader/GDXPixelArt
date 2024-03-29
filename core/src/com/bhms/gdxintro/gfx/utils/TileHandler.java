package com.bhms.gdxintro.gfx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bhms.gdxintro.gfx.assets.Tile;
import com.bhms.gdxintro.gfx.assets.WorldTile;

public class TileHandler {

    public static TileHandler tileHandler = null;

    private int spriteOnSheetHeight, spriteOnSheetWidth;

    private String primaryColorSheetPath = "primaryColorSheetUpdated2.png";

    private Array<WorldTile> worldTileArray;

    private TileHandler() {
        worldTileArray = new Array<>();

        spriteOnSheetHeight = Tile.ON_SCREEN_DEFAULT_HEIGHT;
        spriteOnSheetWidth = Tile.ON_SCREEN_DEFAULT_WIDTH;

        Texture tempTexture = new Texture(primaryColorSheetPath);
        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*2, spriteOnSheetHeight*0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "black");
        worldTileArray.add(blackWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*1, spriteOnSheetHeight*0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile whiteWorldTile = new WorldTile(tempRegion, 1, "white");
        worldTileArray.add(whiteWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 2, "red");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*3, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile midRedWorldTile = new WorldTile(tempRegion, 3, "midRed");
        worldTileArray.add(midRedWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*4, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile crimsonWorldTile = new WorldTile(tempRegion, 4, "crimson");
        worldTileArray.add(crimsonWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*5, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile yellowWorldTile = new WorldTile(tempRegion, 5, "yellow");
        worldTileArray.add(yellowWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*6, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile lemonWorldTile = new WorldTile(tempRegion, 6, "lemon");
        worldTileArray.add(lemonWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*1, spriteOnSheetHeight*1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile cloudWorldTile = new WorldTile(tempRegion, 7, "cloud");
        worldTileArray.add(cloudWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*3, spriteOnSheetHeight*1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile grayWorldTile = new WorldTile(tempRegion, 8, "gray");
        worldTileArray.add(grayWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*5, spriteOnSheetHeight*1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile stormyWorldTile = new WorldTile(tempRegion, 9, "stormy");
        worldTileArray.add(stormyWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*7, spriteOnSheetHeight*1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile darkWorldTile = new WorldTile(tempRegion, 10, "dark");
        worldTileArray.add(darkWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*7, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile goldWorldTile = new WorldTile(tempRegion, 11, "gold");
        worldTileArray.add(goldWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*8, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile backgroundWorldTile = new WorldTile(tempRegion, 12, "background");
        worldTileArray.add(backgroundWorldTile);
    }

    public Array<WorldTile> getWorldTileArray() {
        return worldTileArray;
    }

    public static TileHandler getTileHandler() {
        if(tileHandler == null) {
            tileHandler = new TileHandler();
        }
        return tileHandler;
    }
}
