package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityGameResult extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayAgain, btnHome;
    TextView lblScore, lblHighScore;

    int score = 0, highScore = 0;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gameresult);

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnHome = findViewById(R.id.btnHome);
        lblScore = findViewById(R.id.lblScoreResult);
        lblHighScore = findViewById(R.id.lblHighScoreResult);

        btnPlayAgain.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

       highScore = sp.getInt(MyVariables.keyHighScore, MyVariables.keyHighScoreDefault);
       lblHighScore.setText(Integer.toString(highScore));

       score = sp.getInt(MyVariables.keyCurrentScore, MyVariables.keyCurrentScoreDefault);
       lblScore.setText(Integer.toString(score));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayAgain:
                btnPlayAgainClick();
                break;
            case R.id.btnHome:
                btnHomeClick();
                break;
            default:
                break;
        }
    }

    private void btnHomeClick() {
        startActivity(MyVariables.Arsh(ActivityGameResult.this, ActivityStartGame.class));
    }

    private void btnPlayAgainClick() {
        startActivity(MyVariables.Arsh(ActivityGameResult.this, ActivityPlayGame.class));
    }

}
