package com.example.nizar.my_sportdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    ImageView imageView;
    TextView tvSportDetail, tvdescripDetail;
    public static String EXTRA_PHOTO = "extra_photo";
    public static String EXTRA_SPORT = "extra_sport";
    public static String EXTRA_DESC = "extra_desc";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imgAnimeDetail);
        tvSportDetail = findViewById(R.id.tvSportDetail);
        tvdescripDetail = findViewById(R.id.tvdescripDetail);

        Glide.with(this).load(getIntent().getStringExtra(EXTRA_PHOTO)).into(imageView);
        tvSportDetail.setText(getIntent().getStringExtra(EXTRA_SPORT));
        tvdescripDetail.setText(getIntent().getStringExtra(EXTRA_DESC));

    }
}
