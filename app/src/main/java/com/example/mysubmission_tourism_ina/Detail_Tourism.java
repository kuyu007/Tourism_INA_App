package com.example.mysubmission_tourism_ina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_Tourism extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvLocation;
    private TextView tvDesc;
    private ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__tourism);
        komponen();




        String titleTourism = getIntent().getStringExtra("TITLE");
        String locationTourism = getIntent().getStringExtra("LOCATION");
        String descTourism = getIntent().getStringExtra("DESCRIPTION");

        Glide.with(this)
                .load(getIntent().getStringExtra("IMG"))
                .into(ivImg);

        tvTitle.setText(titleTourism);
        tvLocation.setText(locationTourism);
        tvDesc.setText(descTourism);

    }
    private void komponen(){
        tvTitle = findViewById(R.id.tvjudul_detail);
        tvLocation = findViewById(R.id.tvlokasi_detail);
        tvDesc = findViewById(R.id.tv_desc_detail);
        ivImg = findViewById(R.id.img_detail);
    }
}
