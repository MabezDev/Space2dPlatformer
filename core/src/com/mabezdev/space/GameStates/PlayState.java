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
    private float unitScale = 1/32.0f;
    private final static int viewWidth = 10;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        tileMap = loadMap();
        gsm.getCam().setToOrtho(false,viewWidth,8);//set to view wisth later
        player = new Player(gsm.getCam().position.x+1,gsm.getCam().position.y+1);
        SpriteBatch batch = new SpriteBatch();
        batch.setProjectionMatrix(gsm.getCam().combined);
        otmr = new OrthogonalTiledMapRenderer(tileMap,unitScale,batch);
        otmr.setView(gsm.getCam());

        //gsm.getCam().update();


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
        gsm.getCam().position.x = player.getX();
        gsm.getCam().position.y = player.getY();
        gsm.getCam().update();
    }

    @Override
    public void render() {///follow cam buggy
        // update the cam position to follow player
        //gsm.getCam().translate(Player.getX);
        //might have to do the same for otmr (following)
        otmr.setView(gsm.getCam());
        otmr.render();


    }

    @Override
    public void handleInput() {//movement now working for left and right strafing
            if(Keys.isDown(Keys.D)){
                player.setRight(true);
                System.out.print("Right");
            }else if(Keys.isDown(Keys.A)) {
                player.setLeft(true);
                System.out.println("LEft");
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
