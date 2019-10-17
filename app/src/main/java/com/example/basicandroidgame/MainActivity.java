package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Button btnStart;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        btnStart = findViewById(R.id.btnStartGame);
        switch1 = findViewById(R.id.switch1);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartGame:
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
