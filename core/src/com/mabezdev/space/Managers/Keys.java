package com.mabezdev.space.Managers;

/**
 * Created by user on 29/11/2014.
 */
public class Keys {

    private static boolean[] keys;
    private static boolean[] pkeys;
    private final static int NUM_KEYS = 7;
    public final static int A = 0;
    public final static int S = 1;
    public final static int D = 2;
    public final static int W = 3;
    public final static int SPACE = 4;
    public final static int SHIFT = 5;
    public final static int ESC = 6;
    public Keys(){

    }

    public static void update(){
        for(int i =0;i<NUM_KEYS;i++){
            pkeys[i] = keys[i];
        }
    }

    public static void setKeyState(int k,boolean b){
        keys[k]= b;
    }




    public static boolean isDown(int k){

        return keys[k];

    }
    public static boolean isPressed(int k){
        return !pkeys[k] && keys[k];
    }

}
