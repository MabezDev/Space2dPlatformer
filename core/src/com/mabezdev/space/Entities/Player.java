package com.mabezdev.space.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mabezdev.space.GFX.AnimationHandler;

/**
 * Created by user on 29/11/2014.
 */
public class Player extends BaseModel {

    private boolean isJumping;
    private boolean isShooting;
    private boolean isFalling;
    private boolean isIdle;
    private int currentHealth;
    private int maxHealth;
    private boolean isRight;
    private boolean isLeft;
    private AnimationStates currentState;
    AnimationHandler Handler;
    private static final float jumpAcceleration = 5.0f;
    private static final float jumpFinalAcceleration = 3.0f;
    ShapeRenderer sr;


    public Player(float xi, float yi){
        dx = 0;
        dy = 0;
        x = xi;
        y = yi;
        isIdle = true;
        this.setRight(false);
        this.setLeft(false);
        this.setJumping(false);
        this.setShooting(false);
        this.setFalling(false);
        maxSpeed = DEFAULT_MOVESPEED;
        currentState = AnimationStates.IDLE;
        //Handler = new AnimationHandler();
        //Handler.load("tempplayersheet.png");

        sr = new ShapeRenderer();
    }


    @Override
    public void update(float dt) {///movement worki
        //update animation and move image position to follow body
        //Handler.update(dt);
        //Handler.setPosition(this.x,this.y);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.rect(this.x,this.y,32,64);
        sr.end();
        //handle body movements
        if(this.isRight == true && this.isLeft==false){
            setAnimationState(AnimationStates.WAlKING);
            dx = 10;


        }
        if(this.isLeft == true && this.isRight == false){
            dx = -10;
            setAnimationState(AnimationStates.WAlKING);
        }
        if(this.isLeft == false && this.isRight == false ||this.isLeft == true && this.isRight == true){
            dx=0;
            setAnimationState(AnimationStates.IDLE);
        }
        if(this.isJumping == true) {
            dy += jumpAcceleration * dt;

            if(dy > jumpFinalAcceleration){

                dy = 0;
                this.isJumping = false;
                //this.isFalling = true;
            }

        }



        //actual change of pos
        x += dx * dt;
        y += dy * dt;
        System.out.println(x);
        System.out.println(y);
    }







    /*
    ANIMATION METHODS
     */

    //the states of animation
    public enum AnimationStates{
        IDLE,
        WAlKING,
        JUMP,
        ROCKET,
        FALLING,
        SHOOTING,
    }


    public void setAnimationState(AnimationStates a){//need to fill switch as we get more animations
        currentState = a;
        switch (currentState){
            case WAlKING :

        }
    }


    public AnimationStates getCurrentState(){
        return currentState;
    }

    /*
    PLAYER SIDE METHODS
     */

    public boolean isDead(){
        return currentHealth<maxHealth;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    public void Shoot(){
        isShooting = true;
        setAnimationState(AnimationStates.SHOOTING);
        // the actually bullet will be created on the level and held in a ArrayList container
    }

    public int getPercentageHealth(){
        return (currentHealth/maxHealth)*100;
    }

    public boolean Right(){
        return isRight;
    }

    public void setRight(boolean b){
        isRight = b;
    }

    public boolean Left(){
        return isLeft;
    }

    public void setLeft(boolean b){
        isLeft = b;
    }

    public void setJumping(boolean b) {
        isJumping = b;
    }
    public boolean Jumping(){
        return isJumping;
    }

    public void setFalling(boolean b) {
        isFalling = b;
    }
    public boolean Falling(){
        return isFalling;
    }

    public void setIdle(boolean b) {
        isIdle = b;
    }
    public boolean Idle(){
        return isIdle;
    }

    public void setShooting(boolean b) {
        isShooting = b;
    }
    public boolean Shooting(){
        return isShooting;
    }


}
