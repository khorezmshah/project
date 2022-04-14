package com.example.myloginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        String remember = sharedPreferences.getString("checked", "false");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (remember.equals("true")) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, Login_page.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }
}