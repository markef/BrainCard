package com.markef.braincard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    ImageView logo,background;
    Button lvl1,lvl2,lvl3,lvl4;

    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.iVlogo);
        background = findViewById(R.id.iVbackground);

        lvl1 = findViewById(R.id.bT1);
        lvl2 = findViewById(R.id.bT2);
        lvl3 = findViewById(R.id.bT3);
        lvl4 = findViewById(R.id.bT4);


        Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake3);
        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake4);
        Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake2);
        Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.pulse);
        Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotation);

        lvl2.startAnimation(animation3);
        lvl3.startAnimation(animation1);
        lvl4.startAnimation(animation2);

        logo.startAnimation(animation4);
        background.startAnimation(animation5);

        final MediaPlayer click = MediaPlayer.create(this, R.raw.click);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, level1.class));
            }
        });

        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, level2.class));
            }
        });

        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, level3.class));
            }
        });

        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, level4.class));
            }
        });

    }


}
