package com.example.mysubmission_tourism_ina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main_Menu_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu__dashboard);

        findViewById(R.id.btn_profil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Menu_Dashboard.this, Profile.class));
            }
        });
        findViewById(R.id.btn_idntourism).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Menu_Dashboard.this, MainActivity.class));
            }
        });
    }
}
