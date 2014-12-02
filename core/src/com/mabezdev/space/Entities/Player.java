package com.mabezdev.space.Entities;

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

    @Override
    public void update(float dt) {///movement buggy
            if(this.isRight){
                dx = 10;

                System.out.println(x);
            }
            if(this.isLeft){
                dx = -10;

                System.out.println(x);

            }



            x += dx *dt;
    }



    public enum AnimationStates{
        IDLE,
        WAlKING,
        JUMP,
        ROCKET,
        FALLING,
        SHOOTING,
    }

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
        maxSpeed = DEFAULT_MOVESPEED;
        currentState = AnimationStates.IDLE;
    }

    /*
    ANIMATION METHODS
     */

    public void setAnimationState(AnimationStates a){
        currentState = a;
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
