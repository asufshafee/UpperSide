package com.app.upperside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView=(ImageView)findViewById(R.id.background);
//        Animation mAnimation = new AlphaAnimation(1, 0);
//        mAnimation.setDuration(100);
//        mAnimation.setInterpolator(new LinearInterpolator());
//        mAnimation.setRepeatCount(Animation.INFINITE);
//        mAnimation.setRepeatMode(Animation.REVERSE);
//        imageView.startAnimation(mAnimation);


        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getApplicationContext(),HomePage.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
