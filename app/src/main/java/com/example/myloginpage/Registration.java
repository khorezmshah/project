package com.example.myloginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    private EditText userName, email, phone, password, confirmPassword;
    private Button buttonCreate;
    private TextView login;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpass);
        buttonCreate = findViewById(R.id.button);
        login = findViewById(R.id.login);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login_page.class);
                startActivity(intent);
                finish();
            }
        });
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userNameValue = userName.getText().toString();
                String emailValue = email.getText().toString();
                String phoneValue = phone.getText().toString();
                String passwordValue = password.getText().toString();
                String confirmPasswordValue = confirmPassword.getText().toString();

                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
                } else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        if (!userNameValue.isEmpty()) {
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("userName", userNameValue);
                            editor.putString("email", emailValue);
                            editor.putString("phone", phoneValue);
                            editor.putString("password", passwordValue);
                            editor.putString("confirmPassword", confirmPasswordValue);
                            editor.apply();

                            Intent intent = new Intent(Registration.this, Login_page.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(Registration.this, "User registered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Registration.this, "Enter value in the fields!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}