package com.mabezdev.space.GameStates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mabezdev.space.Entities.Player;
import com.mabezdev.space.Managers.GameStateManager;
import com.mabezdev.space.Managers.Keys;

/**
 * Created by user on 29/11/2014.
 */

public class PlayState extends BaseState {

    private Player player;
    private TiledMap tileMap;
    OrthogonalTiledMapRenderer otmr;
    private float unitScale = 1/32.0f;//32 as its 32px tile size
    private final static int viewWidth = 10;
    SpriteBatch batch;

    public PlayState(GameStateManager gsm) {
        super(gsm);


        gsm.getCam().setToOrtho(false, 15, 15);//set to view wisth later

        player = new Player(gsm.getCam().viewportWidth/2,gsm.getCam().viewportHeight/2);
        batch = new SpriteBatch();
        tileMap = loadMap();
        otmr = new OrthogonalTiledMapRenderer(tileMap,unitScale,batch);




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
        player.update(dt);


    }

    @Override
    public void render() {

        batch.setProjectionMatrix(gsm.getCam().combined);
        gsm.getCam().position.set(player.getX(),player.getY(),0);

        gsm.getCam().update();
        otmr.setView(gsm.getCam());
        otmr.render();










    }

    @Override
    public void handleInput() {//movement now working for left and right strafing
        if(Keys.isDown(Keys.D)){
            player.setRight(true);
        }else if(Keys.isDown(Keys.A)) {
            player.setLeft(true);
        } else if(Keys.isDown(Keys.SPACE)) {
            player.setJumping(true);
        } else{
            player.setLeft(false);
            player.setRight(false);
            player.setJumping(false);
        }
    }

    @Override
    public void onDispose() {

    }
}
