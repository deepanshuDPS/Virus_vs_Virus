package com.Game.Rowdy.virusvsvirus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class SetPlayer extends Activity implements View.OnTouchListener{

    EditText p1,p2,p3,p4;
    ImageView i3,i4;
    boolean t=false,th=false,f=false,fv=false;
    int player;
    MediaPlayer click;
    RelativeLayout back;
    String dnames[]={"Blue-V","Red-V","Green-V","Yellow-V"};
    TableLayout set;
    Button setandplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_player);
        player=getIntent().getIntExtra("players",0);
        setandplay=(Button) findViewById(R.id.play);
        p1=(EditText) findViewById(R.id.p1);
        p2=(EditText) findViewById(R.id.p2);
        p3=(EditText) findViewById(R.id.p3);
        p4=(EditText) findViewById(R.id.p4);
        i3=(ImageView) findViewById(R.id.i3);
        i4=(ImageView) findViewById(R.id.i4);
        back=(RelativeLayout) findViewById(R.id.namesback);
        set=(TableLayout) findViewById(R.id.setplayer);
        click=MediaPlayer.create(getApplicationContext(), R.raw.click);
        p1.setOnTouchListener(this);
        p2.setOnTouchListener(this);
        p3.setOnTouchListener(this);
        p4.setOnTouchListener(this);
        switch (player)
        {
            case 2:
                p3.setVisibility(View.GONE);
                p4.setVisibility(View.GONE);
                i3.setVisibility(View.GONE);
                i4.setVisibility(View.GONE);
                break;
            case 3:
                p4.setVisibility(View.GONE);
                i4.setVisibility(View.GONE);
                break;
        }
        set.setVisibility(View.GONE);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        set.startAnimation(in);
        set.setVisibility(View.VISIBLE);
    }
    public void play(View v)
    {
        if(getsound())
            click.start();
        String names[]=new String[4];
        switch (player)
        {
            case 2:
                names[0]=p1.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[1]=p2.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                if(!(names[0].equalsIgnoreCase(""))&&!(names[1].equalsIgnoreCase("")))
                {
                    if(!names[0].equalsIgnoreCase(names[1]))
                    {startActivity(new Intent(SetPlayer.this, TwoPlayer.class).putExtra("pnames",names));
                        finish();}
                    else
                        Toast.makeText(getApplicationContext(),"Please Enter different Player names",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //generate toast
                    Toast.makeText(getApplicationContext(),"Please Enter all Player names",Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                names[0]=p1.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[1]=p2.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[2]=p3.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                if(!(names[0].equalsIgnoreCase(""))&&!(names[1].equalsIgnoreCase(""))&&!(names[2].equalsIgnoreCase("")))
                {
                    if(!names[0].equalsIgnoreCase(names[1]) &&!names[1].equalsIgnoreCase(names[2]) && !names[0].equalsIgnoreCase(names[2]))
                    {startActivity(new Intent(SetPlayer.this, ThreePlayer.class).putExtra("pnames",names));
                        finish();}
                    else
                        Toast.makeText(getApplicationContext(),"Please Enter different Player names",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //generate toast
                    Toast.makeText(getApplicationContext(),"Please Enter all Player names",Toast.LENGTH_LONG).show();

                }
                break;
            case 4:
                names[0]=p1.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[1]=p2.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[2]=p3.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                names[3]=p4.getText().toString().replaceAll("(\\r|\\n|\\r\\n|\\s)+", "");
                if(!(names[0].equalsIgnoreCase(""))&&!(names[1].equalsIgnoreCase(""))&&!(names[2].equalsIgnoreCase(""))&&!(names[3].equalsIgnoreCase("")))
                {
                    if(!names[0].equalsIgnoreCase(names[1]) &&!names[1].equalsIgnoreCase(names[2]) && !names[2].equalsIgnoreCase(names[3])&&!names[0].equalsIgnoreCase(names[2]) &&!names[0].equalsIgnoreCase(names[3]) && !names[1].equalsIgnoreCase(names[3]))
                    {  startActivity(new Intent(SetPlayer.this, FourPlayer.class).putExtra("pnames",names));
                        finish();}
                    else
                        Toast.makeText(getApplicationContext(),"Please Enter different Player names",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //generate toast
                    Toast.makeText(getApplicationContext(),"Please Enter all Player names",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    public void splay(View v)
    {
        if(getsound())
            click.start();
        if(player==2)
            startActivity(new Intent(SetPlayer.this, TwoPlayer.class).putExtra("pnames",dnames));
        else if(player==3)
            startActivity(new Intent(SetPlayer.this, ThreePlayer.class).putExtra("pnames",dnames));
        else if(player==4)
            startActivity(new Intent(SetPlayer.this, FourPlayer.class).putExtra("pnames",dnames));
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
        startActivity(new Intent(SetPlayer.this,SelPlayer.class).putExtra("rate",false));
        finish();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v==p1)
        {
            back.setBackgroundResource(R.drawable.backgroundb);
            t=true;
        }
        else if(v==p2) {
            back.setBackgroundResource(R.drawable.backgroundr);
            th=true;
        }
        else if(v==p3) {
            back.setBackgroundResource(R.drawable.backgroundg);
            f=true;
        }
        else if(v==p4) {
            back.setBackgroundResource(R.drawable.backgroundy);
            fv=true;
        }
        if(player==2 && t && th || player==3 && t && th && f || player==4 && t && th && f && fv){
            Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            setandplay.startAnimation(in);
            setandplay.setVisibility(View.VISIBLE);
        }
        return false;
    }
}
