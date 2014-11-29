package com.mabezdev.space.GameStates;

import com.mabezdev.space.Managers.GameStateManager;
import com.mabezdev.space.Managers.Keys;

/**
 * Created by user on 29/11/2014.
 */
public class MenuState extends BaseState {
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void onCreation() {
        System.out.println("Were Here");
    }

    @Override
    public void update(float dt) {
            handleInput();
    }

    @Override
    public void render() {

    }

    @Override
    public void handleInput() {
            if(Keys.isDown(Keys.SPACE)){
                System.out.println("isDown");
            }

    }

    @Override
    public void onDispose() {

    }
}
