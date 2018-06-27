package com.Game.Rowdy.virusvsvirus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instruction extends Activity {

    Button gi,ngi;
    MediaPlayer click;
    boolean i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        gi=(Button) findViewById(R.id.gotit);
        ngi=(Button) findViewById(R.id.notgotit);
        click=MediaPlayer.create(getApplicationContext(), R.raw.click);
        i=getIntent().getBooleanExtra("info",false);
        if(i)
        {
            gi.setVisibility(View.GONE);
            ngi.setVisibility(View.GONE);
        }
    }
    public void gotit(View v)
    {
        SharedPreferences.Editor editor = getSharedPreferences("checked", MODE_PRIVATE).edit();
        editor.putBoolean("info", true);
        editor.commit();
        if(getsound())
            click.start();
        startActivity(new Intent(Instruction.this, SelPlayer.class).putExtra("rate",true));
        finish();
    }
    public void notGotIt(View v)
    {
        if(getsound())
            click.start();
        startActivity(new Intent(Instruction.this, SelPlayer.class));
        finish();

    }
    public boolean getsound()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("checked", MODE_PRIVATE);
        return sharedPrefs.getBoolean("sound", true);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(i) {
            startActivity(new Intent(Instruction.this, SelPlayer.class).putExtra("rate",false));
        }
        finish();
    }
}
