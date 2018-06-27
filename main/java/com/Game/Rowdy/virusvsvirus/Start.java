package com.Game.Rowdy.virusvsvirus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

public class Start extends Activity {

    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Handler handler = new Handler();
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.m1), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.m2), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.m3), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.m4), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.m5), 350);
        animation.setOneShot(true);
        im=(ImageView) findViewById(R.id.imageView);
        im.setBackgroundDrawable(animation);
        // start the animation!
        animation.start();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(getInf())
                    startActivity(new Intent(Start.this, SelPlayer.class).putExtra("rate",true));
                else
                    startActivity(new Intent(Start.this, Instruction.class));
                finish();
            }
        },1150);
    }
    public boolean getInf()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("checked", MODE_PRIVATE);
        return sharedPrefs.getBoolean("info", false);
    }
}
