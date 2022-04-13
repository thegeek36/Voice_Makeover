package com.priyanshu.voicemakeover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    LottieAnimationView animation ;
    TextView name , work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        animation = findViewById(R.id.animationView);
        name = findViewById(R.id.name);
        work = findViewById(R.id.work);

//        animation.animate().translationY(-1600).setDuration(1000).setStartDelay(2000);
//        name.animate().translationX(1600).setDuration(1000).setStartDelay(2000);
//        work.animate().translationX(1600).setDuration(1000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2500);
    }
}