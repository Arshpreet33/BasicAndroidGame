package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPlayGame extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop, btn1, btn2, btn3, btn4;
    TextView lblScore, lblHighScore, lblTime;

    int score = 0, highScore = 0;
    int num = -1, time;

    int color1 = Color.GRAY;
    int color2 = Color.GRAY;
    int color3 = Color.GRAY;
    int color4 = Color.GRAY;

    boolean isBackgroundThread;
    boolean isModeEasy;

    Thread thread;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_playgame);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        lblScore = findViewById(R.id.lblScore);
        lblHighScore = findViewById(R.id.lblHighScore);
        lblTime = findViewById(R.id.lblTime);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        highScore = sp.getInt(MyVariables.keyHighScore, MyVariables.keyHighScoreDefault);
        lblHighScore.setText(Integer.toString(highScore));

        isModeEasy = sp.getInt(MyVariables.keyGameIntMode, MyVariables.keyGameIntModeDefault) == 1 ? true : false;

        time = MyVariables.numberChances;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                btnStartClick();
                break;
            case R.id.btnStop:
                btnStopClick();
                break;
            case R.id.btn1:
                btn1Click();
                break;
            case R.id.btn2:
                btn2Click();
                break;
            case R.id.btn3:
                btn3Click();
                break;
            case R.id.btn4:
                btn4Click();
                break;
            default:
                break;
        }
    }

    private void btnStartClick() {
        isBackgroundThread = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                backgroundRefresh();
            }
        });
        thread.start();
    }

    private void backgroundRefresh() {
        for (int i = MyVariables.numberChances; i > 0; i--) {
            if (!isBackgroundThread) break;

            int nextNum;
            do {
                nextNum = MyVariables.randomNum(4);
            }
            while (nextNum == num);

            num = nextNum;

            time = i;
            changeColor(num);
        }
        if (isBackgroundThread) stopGame();
    }

    private void stopGame() {
        saveHighScore();

        startActivity(MyVariables.Arsh(ActivityPlayGame.this, ActivityGameResult.class));
    }

    private void changeColor(int num2) {

        resetColorVariables(Color.RED);

        switch (num2) {
            case 1:
                color1 = Color.GREEN;
                break;
            case 2:
                color2 = Color.GREEN;
                break;
            case 3:
                color3 = Color.GREEN;
                break;
            case 4:
                color4 = Color.GREEN;
                break;
            default:
                break;
        }

        setBtnColors();

    }

    private void resetColorVariables(int color) {
        color1 = color;
        color2 = color;
        color3 = color;
        color4 = color;
    }

    private void setBtnColors() {
        try {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btn1.setBackgroundColor(color1);
                    btn2.setBackgroundColor(color2);
                    btn3.setBackgroundColor(color3);
                    btn4.setBackgroundColor(color4);
                    lblTime.setText(time + " Chances");
                }
            });

            if (isModeEasy) {
                Thread.sleep(800);
            } else {
                Thread.sleep(400);
            }
        } catch (Exception e) {
        }
    }

    private void btnStopClick() {
        stopGame();
    }

    private void btn1Click() {
        btnClicks(((ColorDrawable) btn1.getBackground()).getColor());
    }

    private void btn2Click() {
        btnClicks(((ColorDrawable) btn2.getBackground()).getColor());
    }

    private void btn3Click() {
        btnClicks(((ColorDrawable) btn3.getBackground()).getColor());
    }

    private void btn4Click() {
        btnClicks(((ColorDrawable) btn4.getBackground()).getColor());
    }

    private void btnClicks(int color) {
        if (num >= 0) {
            if (color == Color.GREEN) {
                score++;
            } else {
                score--;
            }
        }
        updateScore();
    }

    private void updateScore() {
        lblScore.setText(Integer.toString(score));
    }

    private void saveHighScore() {

        isBackgroundThread = false;

        editor = sp.edit();

        if (score > highScore) {
            highScore = score;
            editor.putInt(MyVariables.keyHighScore, highScore);
        }

        editor.putInt(MyVariables.keyCurrentScore, score);
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveHighScore();
    }
}
