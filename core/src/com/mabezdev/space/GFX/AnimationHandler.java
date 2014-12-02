package com.mabezdev.space.GFX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by user on 01/12/2014.
 */
public class AnimationHandler {

    private static final int        FRAME_COLS = 2;         // #1
    private static final int        FRAME_ROWS = 1;         // #2
    private static final int        WALKING = 1;
    Animation walkAnimation;
    Texture walkSheet;              // #4
    TextureRegion[]                 walkFrames;             // #5
    SpriteBatch spriteBatch;            // #6
    TextureRegion currentFrame;
    private float x;
    private float y;
    private int currentAnimation;
    private float stateTime = 0f;                                       // #8

    public AnimationHandler(){
            // #11
        spriteBatch = new SpriteBatch();                // #12


    }

    public void load(String asset){
        walkSheet = new Texture(Gdx.files.internal(asset)); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,32,64);              // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.5f, walkFrames);
    }

    public void update(float dt){
        stateTime += dt;
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, x, y);             // #17
        spriteBatch.end();
    }

    public void setPosition(float x,float y){
        this.x = x;
        this.y = y;
    }

}
