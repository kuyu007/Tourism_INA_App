package com.example.mysubmission_tourism_ina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void MessageToMe(View view) {

   Toast.makeText(Profile.this, "You sent a message", Toast.LENGTH_SHORT).show();
        }


    }

