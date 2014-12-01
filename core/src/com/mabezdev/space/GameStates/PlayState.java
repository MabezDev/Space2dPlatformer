package com.mabezdev.space.GameStates;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mabezdev.space.Entities.Player;
import com.mabezdev.space.Managers.GameStateManager;

/**
 * Created by user on 29/11/2014.
 */
public class PlayState extends BaseState {

    private Player player;
    private TiledMap tileMap;
    private TiledMapTileSet tiledMapTileSet;
    OrthogonalTiledMapRenderer otmr;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        tileMap = loadMap();
        gsm.getCam().setToOrtho(true,15*32,15*32);
        otmr = new OrthogonalTiledMapRenderer(tileMap,1);
        otmr.setView(gsm.getCam().combined,0,0,gsm.getCam().viewportWidth,gsm.getCam().viewportHeight);

    }

    private TiledMap loadMap() {
        TiledMap t = new TmxMapLoader().load("test.tmx");
        return t;
    }

    @Override
    public void onCreation() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
          otmr.render();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void onDispose() {

    }
}
