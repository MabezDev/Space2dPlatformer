package com.mabezdev.space.GameStates;

import com.badlogic.gdx.maps.tiled.TiledMap;
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
    OrthogonalTiledMapRenderer otmr;
    private float unitScale = 1/32.0f;
    private final static int viewWidth = 10;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        player = new Player(100,100);
        tileMap = loadMap();
        gsm.getCam().setToOrtho(false,viewWidth,8);
        otmr = new OrthogonalTiledMapRenderer(tileMap,unitScale);
        otmr.setView(gsm.getCam());


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
        // update the cam position to follow player
        //gsm.getCam().translate(Player.getX);
        //might have to do the same for otmr (following)
          otmr.render();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void onDispose() {

    }
}
