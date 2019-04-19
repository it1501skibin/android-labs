package com.skibin.lab10;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView clockImageView = findViewById(R.id.clock);
        Animation clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);

        ImageView hourImageView = findViewById(R.id.hour_hand);
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
        hourImageView.startAnimation(hourTurnAnimation);

        ImageView spaceshipImageView = findViewById(R.id.spaceship);
        Animation spaceshipFlyAnimation = AnimationUtils.loadAnimation(this, R.anim.spaceship_fly);
        spaceshipImageView.startAnimation(spaceshipFlyAnimation);

        ImageView star1ImageView = findViewById(R.id.star1);
        ImageView star2ImageView = findViewById(R.id.star2);
        ImageView star3ImageView = findViewById(R.id.star3);
        Animation starBlinkAnimation = AnimationUtils.loadAnimation(this, R.anim.star_blink);
        star1ImageView.startAnimation(starBlinkAnimation);
        star2ImageView.startAnimation(starBlinkAnimation);
        star3ImageView.startAnimation(starBlinkAnimation);

        ImageView birdImageView = findViewById(R.id.bird);
        Animation birdAnim = AnimationUtils.loadAnimation(this, R.anim.bird_anim);
        birdImageView.startAnimation(birdAnim);

        ImageView moonImageView = findViewById(R.id.moon);
        moonImageView.setBackgroundResource(R.drawable.moon_anim);
        AnimationDrawable moonAnim = (AnimationDrawable) moonImageView.getBackground();
        moonAnim.start();
    }
}
