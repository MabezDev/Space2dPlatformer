package com.mabezdev.space.Entities;

/**
 * Created by user on 29/11/2014.
 */
public abstract class BaseModel {

    public final static int DEFAULT_MOVESPEED = 5;

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;
    protected int maxSpeed;

    public float getX(){ return x; }
    public float getY(){ return y; }

    public abstract void update(float dt);

}
