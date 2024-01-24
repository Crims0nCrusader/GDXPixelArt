package com.bhms.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bhms.gdxintro.gfx.assets.Tile;
import com.bhms.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;

	int x, y;


	int[][] worldIntArray = {{1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		 				  	 {1, 1, 1, 1, 1, 0, 6, 5, 5,11, 9, 8, 7, 0, 5, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						     {1, 1, 1, 1, 1, 1, 0, 0,11, 6, 6, 0, 0, 5, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 1, 1, 0,11,11, 0, 0,11, 5, 5,11, 3, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			   				 {1, 1, 1, 1, 1, 1, 0, 0,11,11, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						     {1, 1, 1, 1, 1, 1, 1, 0, 0, 0,11, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			                 {1, 1, 1, 0, 0, 0, 0, 0,10,10, 9, 6, 5, 0, 5, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						  	 {1, 1, 1, 0, 6, 5, 5, 6, 0,10, 9, 7, 6, 0, 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 1, 0, 9, 8, 9, 6, 0, 9, 7,11, 0,11, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 1, 4, 0, 5, 6, 8,11, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 1, 4, 0,10, 9, 0, 9,11, 6, 5, 6, 8, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 4, 0, 0,10, 8, 0, 8, 7, 3, 2, 3, 7, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 	 {1, 1, 1, 4, 0, 5, 6,11, 0,10,11, 9, 3, 9,11, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 	 {1, 1, 1, 4, 2, 0, 7, 8, 8, 0, 9,11, 6,11, 0, 9, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 4, 2, 0, 5, 6,11, 0,11,10, 8,10, 0,11, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 4, 2, 0,10, 9, 8, 0, 0, 6, 9, 6, 0, 9, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 4, 3, 2, 4, 0, 0, 0,10, 9, 0, 5, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 4, 2, 3, 4, 4, 4, 0,10, 9, 9, 0, 9, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 4, 2, 3, 4, 4, 0,10, 9, 8, 7, 0, 7, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 4, 2, 3, 4, 4, 0, 8,11, 5, 5, 0, 5, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							 {1, 1, 1, 4, 3, 4, 4, 0,11, 6, 9, 8, 7, 0, 7, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 	 {12,12,12,12, 4, 4,12, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12,12,12,12,12,12,12,12,12,12},
							 {12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12}};
							//c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c,
	 /*

	int[][] worldIntArray = new int[12][20];
	*/
	@Override
	public void create () {
		batch = new SpriteBatch();



		x = 0;
		y = 0;
	}
	/*
	private void setRandomArray() {
		for(int r = 0; r < worldIntArray.length; r++) {
			for(int c = 0; c < worldIntArray[r].length; c++) {
				worldIntArray[r][c] = MathUtils.random(4);
			}
		}
	}
*/
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < worldIntArray.length; r++) {
			for(int c = 0; c < worldIntArray[r].length; c++) {
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(worldIntArray[r][c]).getTexture(), c* Tile.ON_SCREEN_DEFAULT_WIDTH, Gdx.graphics.getHeight() - Tile.ON_SCREEN_DEFAULT_HEIGHT - (r*Tile.ON_SCREEN_DEFAULT_HEIGHT));
			}

		}

		batch.end();
		/*
		for(int r = 0; r < Gdx.graphics.getHeight(); r+=64) {
			for(int c = 0; c < Gdx.graphics.getWidth(); c+=64) {
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(x++).getTexture(), c, r);
			if(x > 4) {
				x = 0;
			}

			}

		}
	/*

		batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(1).getTexture(), 128, 64);
		batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(2).getTexture(), 192, 64);
		batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(3).getTexture(), 450, 64);
		batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(4).getTexture(), 350, 64);
		batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(5).getTexture(), 500, 64);



		checkInput();
	}
	public void checkInput() {
		/*
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			y += 10;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			y -= 10;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			x += 10;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			x -= 10;
		}

		System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());

		x = Gdx.input.getX() - img.getWidth()/2;
		y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2;


		if(x < (Gdx.input.getX() - img.getWidth()/2)) {
			x+=10;
		}
		if(x > (Gdx.input.getX() - img.getWidth()/2)) {
			x-=10;
		}
		if(y > (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
			y-=10;
		}
		if(y < (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
			y+=10;
		}
		*/

	}

	@Override
	public void dispose () {
		batch.dispose();

	}
}
