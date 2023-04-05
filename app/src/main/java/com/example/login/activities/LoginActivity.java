package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.db.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText username, pwd;
    private Button loginBtn;
    private TextView goToRegister;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        databaseHelper = new DatabaseHelper(this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataValidation();
                loginUser();

            }
        });

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    void initViews() {
        username = findViewById(R.id.emailLogin);
        pwd = findViewById(R.id.search_location_editxt);
        loginBtn = findViewById(R.id.btnlogin);
        goToRegister = findViewById(R.id.goToReg);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    void dataValidation() {

        if (!isEmail(username)) {
            username.setError("Enter valid email!");
        }
        if (isEmpty(pwd)) {
            pwd.setError("Password is required!");
        }

    }

    public  void loginUser(){

        String email = username.getText().toString();
        String password = pwd.getText().toString();

        if(databaseHelper.checkEmailPassword(email,password)){
            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        }else{
            Toast.makeText(LoginActivity.this, "User not found, Click Signup!", Toast.LENGTH_SHORT).show();
        }



    }


}