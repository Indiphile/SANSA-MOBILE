package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class RegisterActivity extends AppCompatActivity {

    private EditText firstname, lastname, email, pwd, pwd2;
    Button register;
    private TextView backToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataValidation();
            }
        });

    }

    void initViews() {
        firstname = findViewById(R.id.firstnameReg);
        lastname = findViewById(R.id.lastnameReg);
        email = findViewById(R.id.emailReg);
        pwd = findViewById(R.id.passwordReg);
        pwd2 = findViewById(R.id.conformPasswordReg);

        register = (Button) findViewById(R.id.btnRegister);
        backToLogin = findViewById(R.id.alreadyHaveAccount);

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
        if (isEmpty(firstname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(lastname)) {
            lastname.setError("Last name is required!");
        }

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }

    }


}