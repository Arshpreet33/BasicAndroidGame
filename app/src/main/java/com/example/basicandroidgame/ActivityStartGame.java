package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ActivityStartGame extends AppCompatActivity implements View.OnClickListener {

    Button btnStart;
    Switch switchMode;

    boolean isModeEasy = true;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_startgame);

        btnStart = findViewById(R.id.btnStartGame);
        switchMode = findViewById(R.id.switchMode);

        btnStart.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchModeCheckedChange(isChecked);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartGame:
                btnStartGameClick();
                break;
            default:
                break;
        }
    }

    private void switchModeCheckedChange(boolean isChecked) {
        if (isChecked) {
            switchMode.setText("EASY");
            isModeEasy = true;
        } else {
            switchMode.setText("HARD");
            isModeEasy = false;
        }
    }

    private void btnStartGameClick() {

        editor = sp.edit();

        editor.putBoolean(MyVariables.keyGameMode, isModeEasy);
        editor.apply();

        startActivity(MyVariables.Arsh(ActivityStartGame.this, ActivityPlayGame.class));
    }
}
