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

@SuppressWarnings("ALL")
public class RegisterActivity extends AppCompatActivity {

    private EditText firstname, lastname, emailInput, pwd, pwd2;
    Button register;
    private TextView backToLogin;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        databaseHelper = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataValidation();
                registerUser();
            }
        });

    }

    void initViews() {
        firstname = findViewById(R.id.firstnameReg);
        lastname = findViewById(R.id.lastnameReg);
        emailInput = findViewById(R.id.emailLogin);
        pwd = findViewById(R.id.passwordLogin);
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

        if (isEmail(emailInput) == false) {
            emailInput.setError("Enter valid email!");
        }

    }

    public void registerUser(){

        String name = firstname.getText().toString();
        String surname = lastname.getText().toString();
        String email = emailInput.getText().toString();
        String password = pwd.getText().toString();
        String confirmPassword = pwd2.getText().toString();

        if(email.equals("")||password.equals("")||confirmPassword.equals(""))
            Toast.makeText(RegisterActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
        else{
            if(password.equals(confirmPassword)){
                Boolean checkUserEmail = databaseHelper.checkEmail(email);
                if(checkUserEmail == false){
                    Boolean insert = databaseHelper.insertData(name, surname, email, password);
                    if(insert == true){
                        Toast.makeText(RegisterActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(RegisterActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(RegisterActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
            }
        }


    }


}