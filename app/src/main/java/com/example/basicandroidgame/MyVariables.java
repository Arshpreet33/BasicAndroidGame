package com.example.basicandroidgame;

import android.graphics.Color;

public class MyVariables {

    public static final String cacheFile = "cacheAndroidGame";

    public static final String highScoreKey = "keyHighScore";
    public static final int highScoreKeyDefault = 0;

    public static int randomNum(int maxNum) {
        return (int) (Math.random() * maxNum + 1);
    }
}
