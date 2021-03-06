package com.mabezdev.space.Managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mabezdev.space.GameStates.BaseState;
import com.mabezdev.space.GameStates.MenuState;
import com.mabezdev.space.GameStates.PlayState;

/**
 * Created by user on 29/11/2014.
 */
public class GameStateManager {

    public final static int PLAY = 0;
    public final static int MENU = 1;
    private int current;
    private BaseState currentState;
    private OrthographicCamera cam;
    public static ResourceManager resourceManager;

    public GameStateManager(OrthographicCamera cam){
        this.cam = cam;
        //initialize resource manager
        resourceManager = new ResourceManager();
        resourceManager.TTFLoader("orangejuice2.ttf",12,"Orange");
        setState(PLAY);
    }

    public void setState(int s){
        if(s==PLAY){
            current = s;
            currentState = new PlayState(this);
        }
        if(s==MENU){
            current = s;
            currentState = new MenuState(this);
        }


    }
    public OrthographicCamera getCam(){
        return cam;
    }

    public void update(float dt){
        currentState.update(dt);
        currentState.handleInput();
    }

    public void draw(){
        currentState.render();
    }
}
