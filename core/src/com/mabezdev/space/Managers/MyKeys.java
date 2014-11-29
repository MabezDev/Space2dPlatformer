package com.mabezdev.space.Managers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by user on 29/11/2014.
 */
public class MyKeys implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        if(keycode== Input.Keys.W){
            Keys.setKeyState(Keys.W,true);
        }
        if(keycode== Input.Keys.A){
            Keys.setKeyState(Keys.A,true);
        }
        if(keycode== Input.Keys.S){
            Keys.setKeyState(Keys.S,true);
        }
        if(keycode== Input.Keys.D){
            Keys.setKeyState(Keys.D,true);
        }
        if(keycode== Input.Keys.SPACE){
            Keys.setKeyState(Keys.SPACE,true);
        }
        if(keycode== Input.Keys.SHIFT_LEFT || keycode == Input.Keys.SHIFT_RIGHT){
            Keys.setKeyState(Keys.SHIFT,true);
        }
        if(keycode == Input.Keys.ESCAPE){
            Keys.setKeyState(Keys.ESCAPE,true);
        }



        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode== Input.Keys.W){
            Keys.setKeyState(Keys.W,false);
        }
        if(keycode== Input.Keys.A){
            Keys.setKeyState(Keys.A,false);
        }
        if(keycode== Input.Keys.S){
            Keys.setKeyState(Keys.S,false);
        }
        if(keycode== Input.Keys.D){
            Keys.setKeyState(Keys.D,false);
        }
        if(keycode== Input.Keys.SPACE){
            Keys.setKeyState(Keys.SPACE,false);
        }
        if(keycode== Input.Keys.SHIFT_LEFT || keycode== Input.Keys.SHIFT_RIGHT){
            Keys.setKeyState(Keys.SHIFT,false);
        }
        if(keycode ==  Input.Keys.ESCAPE){
            Keys.setKeyState(Keys.ESCAPE,false);
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
