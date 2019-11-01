package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEditName extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdate, btnUpdateCancel;
    EditText txtInfoName;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_editname);

        btnUpdate = findViewById(R.id.btnUpdateName);
        btnUpdateCancel = findViewById(R.id.btnCancelUpdateName);
        txtInfoName = findViewById(R.id.txtInfoName);

        btnUpdate.setOnClickListener(this);
        btnUpdateCancel.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        txtInfoName.setText(sp.getString(MyVariables.keyRegisterName, MyVariables.keyRegisterNameDefault));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateName:
                btnUpdateClick();
                break;
            case R.id.btnCancelUpdateName:
                btnUpdateCancelClick();
                break;
            default:
                break;
        }
    }

    private void btnUpdateClick() {
        editor = sp.edit();
        editor.putString(MyVariables.keyRegisterName, txtInfoName.getText().toString());
        editor.apply();

        GoBackToInfoPage();
    }


    private void btnUpdateCancelClick() {
        GoBackToInfoPage();
    }

    private void GoBackToInfoPage() {
        startActivity(MyVariables.Arsh(ActivityEditName.this, ActivityInfo.class));
    }
}
