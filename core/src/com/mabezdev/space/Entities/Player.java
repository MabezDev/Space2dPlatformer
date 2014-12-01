package com.mabezdev.space.Entities;

/**
 * Created by user on 29/11/2014.
 */
public class Player extends BaseModel {

    private boolean isJumping;
    private boolean isShooting;
    private boolean isFalling;
    private int currentHealth;
    private int maxHealth;
    private AnimationStates currentState;

    public enum AnimationStates{
        IDLE,
        WAlKING,
        JUMP,
        ROCKET,
        FALLING,
        SHOOTING,
    }

    public Player(int xi, int yi){
        dx = 0;
        dy = 0;
        x = xi;
        y = yi;
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



}
