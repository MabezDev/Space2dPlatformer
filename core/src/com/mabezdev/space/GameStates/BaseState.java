package com.mabezdev.space.GameStates;


import com.mabezdev.space.Managers.GameStateManager;

/**
 * Created by user on 29/11/2014.
 */
public abstract class BaseState {
    GameStateManager gsm;

    public BaseState(GameStateManager gsm){
        this.gsm = gsm;
        onCreation();
    }

    public abstract void onCreation();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void handleInput();
    public abstract void onDispose();
}
