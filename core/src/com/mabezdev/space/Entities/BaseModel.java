package com.mabezdev.space.Entities;

/**
 * Created by user on 29/11/2014.
 */
public abstract class BaseModel {

    public final static int DEFAULT_MOVESPEED = 5;

    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int maxSpeed;

    public int getX(){ return x; }
    public int getY(){ return y; }


}
