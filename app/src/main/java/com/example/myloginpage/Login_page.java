package com.example.myloginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_page extends AppCompatActivity {

    SharedPreferences userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        EditText username = findViewById(R.id.name);
        EditText password = findViewById(R.id.parol);
        Button loginBtn = findViewById(R.id.login_btn);
        TextView signUp = findViewById(R.id.signUp);
        CheckBox check = findViewById(R.id.checkbox);

        userInfo = getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        String registeredUsername = userInfo.getString("userName", "");
        String registeredPassword = userInfo.getString("password", "");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                boolean remember = check.isChecked();
                if (remember) {
                    editor.putString("checked", "true");
                    editor.apply();
                }

                if (!usernameValue.isEmpty() && !passwordValue.isEmpty()) {
                    if (usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword)) {
                        Intent intent = new Intent(Login_page.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login_page.this, "Xato kiritdingiz", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login_page.this, "Formani to'ldiring!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}