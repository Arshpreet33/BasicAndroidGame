package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEditEmail extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdate, btnUpdateCancel;
    EditText txtInfoEmail;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_editemail);

        btnUpdate = findViewById(R.id.btnUpdateEmail);
        btnUpdateCancel = findViewById(R.id.btnCancelUpdateEmail);
        txtInfoEmail = findViewById(R.id.txtInfoEmail);

        btnUpdate.setOnClickListener(this);
        btnUpdateCancel.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        txtInfoEmail.setText(sp.getString(MyVariables.keyRegisterEmail, MyVariables.keyRegisterEmailDefault));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateEmail:
                btnUpdateClick();
                break;
            case R.id.btnCancelUpdateEmail:
                btnUpdateCancelClick();
                break;
            default:
                break;
        }
    }

    private void btnUpdateClick() {
        editor = sp.edit();
        editor.putString(MyVariables.keyRegisterEmail, txtInfoEmail.getText().toString());
        editor.apply();
        GoBackToInfoPage();
    }


    private void btnUpdateCancelClick() {
        GoBackToInfoPage();
    }

    private void GoBackToInfoPage() {
        startActivity(MyVariables.Arsh(ActivityEditEmail.this, ActivityInfo.class));
    }
}
