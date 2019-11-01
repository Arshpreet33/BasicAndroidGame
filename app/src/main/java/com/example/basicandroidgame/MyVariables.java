package com.example.basicandroidgame;

import android.content.Context;
import android.content.Intent;

public class MyVariables {

    public static final String cacheFile = "cacheAndroidGame";
    public static final int numberChances = 60;

    public static final String keyHighScore = "keyHighScore";
    public static final int keyHighScoreDefault = 0;

    public static final String keyCurrentScore = "keyCurrentScore";
    public static final int keyCurrentScoreDefault = 0;

    public static final String keyGameMode = "keyHighScore";
    public static final boolean keyGameModeDefault = true;

    public static final String keyOverallHighScore = "keyHighScore";
    public static final int keyOverallHighScoreDefault = 0;

    public static final String keyGameIntMode = "keyHighScore";
    public static final int keyGameIntModeDefault = 1;

    public static final String keyRegisterName = "keyRegisterName";
    public static final String keyRegisterNameDefault = "";

    public static final String keyRegisterEmail = "keyRegisterEmail";
    public static final String keyRegisterEmailDefault = "";

    public static final String keyRegisterPassword = "keyRegisterPassword";
    public static final String keyRegisterPasswordDefault = "";

    public static final String keyRegisteredUsers = "keyRegisteredUsers";
    public static final int keyRegisteredUsersDefault = 0;

    public static int randomNum(int maxNum) {
        return (int) (Math.random() * maxNum + 1);
    }

    //  --- My Own Secret ---
    public static Intent Arsh(Context packageContext, Class<?> cls) {
        return new Intent(packageContext, cls);
    }
}
