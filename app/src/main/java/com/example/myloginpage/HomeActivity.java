package com.example.myloginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logOut = findViewById(R.id.logout);
        Button delete = findViewById(R.id.delete);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("checked", "false");
                editor.apply();

                Intent intent = new Intent(HomeActivity.this, Login_page.class);
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();

                Intent intentToLogin = new Intent(HomeActivity.this, Login_page.class);
                startActivity(intentToLogin);
                finish();
            }
        });
    }
}