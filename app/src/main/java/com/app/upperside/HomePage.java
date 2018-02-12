package com.app.upperside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    customfonts.MyTextView online,offline,moneysaving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setTitle("Money Maker");
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.animationofbuttons);
        online=(customfonts.MyTextView)findViewById(R.id.online);
        offline=(customfonts.MyTextView)findViewById(R.id.offline);
        moneysaving=(customfonts.MyTextView)findViewById(R.id.savingmoney);
        moneysaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),List_Activity.class);
                intent.putExtra("type","money");
                startActivity(intent);
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),List_Activity.class);
                intent.putExtra("type","online");
                startActivity(intent);
            }
        });

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),List_Activity.class);
                intent.putExtra("type","offline");
                startActivity(intent);
            }
        });
//        online.startAnimation(myAnim);
//        offline.startAnimation(myAnim);
//        moneysaving.startAnimation(myAnim);

        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(700);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
//        online.startAnimation(mAnimation);
//        offline.startAnimation(mAnimation);
//        moneysaving.startAnimation(mAnimation);

    }

}
