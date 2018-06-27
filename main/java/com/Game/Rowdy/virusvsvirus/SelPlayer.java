package com.Game.Rowdy.virusvsvirus;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class SelPlayer extends Activity implements View.OnClickListener{

    Button two,three,four,soundonoff,share;
    MediaPlayer click;
    TextView gp;
    int pl;
    FullAds fullAds;
    TableLayout sel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sel_player);
        gp=(TextView) findViewById(R.id.gplayed);
        two=(Button) findViewById(R.id.play2);
        three=(Button) findViewById(R.id.play3);
        four=(Button) findViewById(R.id.play4);
        soundonoff=(Button) findViewById(R.id.sound);
        share=(Button) findViewById(R.id.share);
        sel=(TableLayout) findViewById(R.id.selplayer);
        fullAds=new FullAds();
        click=MediaPlayer.create(getApplicationContext(), R.raw.click);
        if(getsound())
            soundonoff.setBackgroundResource(R.drawable.unmute);
        else
            soundonoff.setBackgroundResource(R.drawable.mute);
        gp.setText("GAMES PLAYED : "+getGplayed());
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        sel.setVisibility(View.GONE);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        sel.startAnimation(in);
        sel.setVisibility(View.VISIBLE);
        if(getGplayed()>2 && getLater()&& getIntent().getBooleanExtra("rate",true))
            rateIt();
        else if(getIntent().getBooleanExtra("rate",true))
            fullAds.startAdd(SelPlayer.this);
        if(getGplayed()>3)
            share.setVisibility(View.VISIBLE);
    }
    public void info(View v)
    {
        if(getsound())
            click.start();
        //activity to information
        startActivity(new Intent(SelPlayer.this, Instruction.class).putExtra("info",true));
        finish();
    }
    public void sound(View v)
    {
        SharedPreferences.Editor editor = getSharedPreferences("checked", MODE_PRIVATE).edit();
        if(getsound())
        {
            soundonoff.setBackgroundResource(R.drawable.mute);
            editor.putBoolean("sound",false);
        }
        else
        {
            soundonoff.setBackgroundResource(R.drawable.unmute);
            editor.putBoolean("sound", true);
        }
        editor.commit();
        if(getsound())
            click.start();
    }

    @Override
    public void onClick(View v)
    {
        if(getsound())
            click.start();
        if (v == two)
            pl=2;
        else if (v == three)
            pl=3;
        else if (v == four)
            pl=4;
        startActivity(new Intent(SelPlayer.this, SetPlayer.class).putExtra("players",pl));
        finish();
    }
    public void rateIt()
    {
        final Dialog dialog = new Dialog(SelPlayer.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmbox);
        dialog.setCancelable(false);
        TextView title = (TextView) dialog.findViewById(R.id.title);
        TextView message=(TextView) dialog.findViewById(R.id.message);
        title.setText("RATE IT!");
        message.setText("If you like this game then Rate it!"); // set dialog message
        Button button1=(Button) dialog.findViewById(R.id.button1);
        Button button2=(Button) dialog.findViewById(R.id.button2);
        button1.setText("NOW");
        button2.setText("LATER");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                //path to playstore
                Uri uri = Uri.parse("market://details?id=com.Game.Rowdy.virusvsvirus");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=com.Game.Rowdy.virusvsvirus")));
                }
                SharedPreferences.Editor editor = getSharedPreferences("gplayed", MODE_PRIVATE).edit();
                editor.putBoolean("later", false);
                editor.commit();
                dialog.cancel();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                dialog.cancel();
            }

        });
        dialog.show();

    }
    public boolean getsound()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("checked", MODE_PRIVATE);
        return sharedPrefs.getBoolean("sound", true);
    }

    public long getGplayed()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("gplayed", MODE_PRIVATE);
        return sharedPrefs.getLong("games", 0);
    }
    public boolean getLater()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("gplayed", MODE_PRIVATE);
        return sharedPrefs.getBoolean("later", true);
    }
    public void shareit(View v)
    {
        if(getsound())
            click.start();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Sharing Game Link");
        shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.Game.Rowdy.virusvsvirus");
        startActivity(Intent.createChooser(shareIntent, "Share Game Link"));
        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
