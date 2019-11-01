package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityInfo extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnEditName, btnEditEmail, btnClearHighScore, btnSignOut;
    TextView lblName, lblEmail, lblHighScore;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info);

        btnPlay = findViewById(R.id.btnPlay);
        btnEditName = findViewById(R.id.btnEditName);
        btnEditEmail = findViewById(R.id.btnEditEmail);
        lblName = findViewById(R.id.lblName);
        lblEmail = findViewById(R.id.lblEmail);
        lblHighScore = findViewById(R.id.lblHighScore);
        btnClearHighScore = findViewById(R.id.btnClearHighScore);
        btnSignOut = findViewById(R.id.btnSignOut);

        btnPlay.setOnClickListener(this);
        btnEditName.setOnClickListener(this);
        btnEditEmail.setOnClickListener(this);
        btnEditName.setOnClickListener(this);
        btnClearHighScore.setOnClickListener(this);
        btnSignOut.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        lblName.setText(sp.getString(MyVariables.keyRegisterName, MyVariables.keyRegisterNameDefault));
        lblEmail.setText(sp.getString(MyVariables.keyRegisterEmail, MyVariables.keyRegisterEmail));
        lblHighScore.setText(Integer.toString(sp.getInt(MyVariables.keyHighScore, MyVariables.keyHighScoreDefault)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                btnPlayClick();
                break;
            case R.id.btnSignOut:
                btnSignOutClick();
                break;
            case R.id.btnEditName:
                btnEditNameClick();
                break;
            case R.id.btnEditEmail:
                btnEditEmailClick();
                break;
            case R.id.btnClearHighScore:
                btnClearHighScoreClick();
                break;
            default:
                break;
        }
    }

    private void btnSignOutClick() {
        startActivity(MyVariables.Arsh(ActivityInfo.this, ActivityLogin.class));
    }

    private void btnClearHighScoreClick() {
        editor = sp.edit();
        editor.putInt(MyVariables.keyHighScore, 0);
        editor.apply();

        lblHighScore.setText("0");
    }

    private void btnEditNameClick() {
        startActivity(MyVariables.Arsh(ActivityInfo.this, ActivityEditName.class));
    }

    private void btnEditEmailClick() {
        startActivity(MyVariables.Arsh(ActivityInfo.this, ActivityEditEmail.class));
    }

    private void btnPlayClick() {
        startActivity(MyVariables.Arsh(ActivityInfo.this, ActivityStartGame.class));
    }

}
