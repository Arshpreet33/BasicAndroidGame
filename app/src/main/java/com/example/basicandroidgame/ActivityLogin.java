package com.example.basicandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText txtEmail, txtPassword;
    TextView lblRegister;

    String email;
    String password;

    Intent intent;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtLoginEmail);
        txtPassword = findViewById(R.id.txtLoginPassword);
        lblRegister = findViewById(R.id.lblRegister);

        btnLogin.setOnClickListener(this);
        lblRegister.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                btnLoginClick();
                break;
            case R.id.lblRegister:
                lblRegisterClick();
                break;
            default:
                break;
        }
    }

    private void btnLoginClick() {
        Login();
    }

    private boolean ValidateUser() {
        email = sp.getString(MyVariables.keyRegisterEmail, MyVariables.keyRegisterEmailDefault);
        password = sp.getString(MyVariables.keyRegisterPassword, MyVariables.keyRegisterPasswordDefault);


        if (email.equals(txtEmail.getText().toString().trim())) {
            if (password.equals(txtPassword.getText().toString().trim())) {
                return true;
            }
        }
        return false;

    }

    private void lblRegisterClick() {
        GoToRegisterPage();
    }

    private void GoToRegisterPage() {
        startActivity(MyVariables.Arsh(ActivityLogin.this, ActivityRegister.class));
    }

    private void Login() {
        if (ValidateUser()) {
            startActivity(MyVariables.Arsh(ActivityLogin.this, ActivityStartGame.class));
        } else {
            DisplayToast("Not a valid user! Please Register if you are a new User.");
        }
    }

    private void DisplayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
