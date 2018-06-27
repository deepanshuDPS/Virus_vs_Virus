package com.Game.Rowdy.virusvsvirus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;

import java.util.Random;

public class ThreePlayer extends Activity implements View.OnClickListener{

    int i,p,ch,countBox,k;
    TextView pname;
    ImageView picon;
    Button Quit,Undo,Restart;
    String names[]=new String[4];
    Button box[]=new Button[140];
    int u[]=new int[140];
    int a[]=new int[3];
    int numb,n;
    MediaPlayer click,turn,expand;
    boolean ex;
    int ran[][]={{1,2,3},{2,1,3},{3,2,1},{2,3,1},{1,3,2},{3,1,2}};
    Random r;
    RelativeLayout back;
    long gp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_players);
        names=getIntent().getStringArrayExtra("pnames");
        pname=(TextView) findViewById(R.id.playname);
        picon=(ImageView) findViewById(R.id.playicon);
        Quit=(Button) findViewById(R.id.quit);
        Undo=(Button) findViewById(R.id.undo);
        Restart=(Button) findViewById(R.id.rstart);
        back=(RelativeLayout) findViewById(R.id.background);
        click=MediaPlayer.create(getApplicationContext(), R.raw.click);
        turn=MediaPlayer.create(getApplicationContext(), R.raw.turn);
        expand=MediaPlayer.create(getApplicationContext(), R.raw.expand);
        box[0]=(Button) findViewById(R.id.b0);box[1]=(Button) findViewById(R.id.b1);box[2]=(Button) findViewById(R.id.b2);
        box[3]=(Button) findViewById(R.id.b3);box[4]=(Button) findViewById(R.id.b4);box[5]=(Button) findViewById(R.id.b5);
        box[6]=(Button) findViewById(R.id.b6);box[7]=(Button) findViewById(R.id.b7);box[8]=(Button) findViewById(R.id.b8);
        box[9]=(Button) findViewById(R.id.b9);box[10]=(Button) findViewById(R.id.b10);box[11]=(Button) findViewById(R.id.b11);
        box[12]=(Button) findViewById(R.id.b12);box[13]=(Button) findViewById(R.id.b13);box[14]=(Button) findViewById(R.id.b14);
        box[15]=(Button) findViewById(R.id.b15);box[16]=(Button) findViewById(R.id.b16);box[17]=(Button) findViewById(R.id.b17);
        box[18]=(Button) findViewById(R.id.b18);box[19]=(Button) findViewById(R.id.b19);box[20]=(Button) findViewById(R.id.b20);
        box[21]=(Button) findViewById(R.id.b21);box[22]=(Button) findViewById(R.id.b22);box[23]=(Button) findViewById(R.id.b23);
        box[24]=(Button) findViewById(R.id.b24);box[25]=(Button) findViewById(R.id.b25);box[26]=(Button) findViewById(R.id.b26);
        box[27]=(Button) findViewById(R.id.b27);box[28]=(Button) findViewById(R.id.b28);box[29]=(Button) findViewById(R.id.b29);
        box[30]=(Button) findViewById(R.id.b30);box[31]=(Button) findViewById(R.id.b31);box[32]=(Button) findViewById(R.id.b32);
        box[33]=(Button) findViewById(R.id.b33);box[34]=(Button) findViewById(R.id.b34);box[35]=(Button) findViewById(R.id.b35);
        box[36]=(Button) findViewById(R.id.b36);box[37]=(Button) findViewById(R.id.b37);box[38]=(Button) findViewById(R.id.b38);
        box[39]=(Button) findViewById(R.id.b39);box[40]=(Button) findViewById(R.id.b40);box[41]=(Button) findViewById(R.id.b41);
        box[42]=(Button) findViewById(R.id.b42);box[43]=(Button) findViewById(R.id.b43);box[44]=(Button) findViewById(R.id.b44);
        box[45]=(Button) findViewById(R.id.b45);box[46]=(Button) findViewById(R.id.b46);box[47]=(Button) findViewById(R.id.b47);
        box[48]=(Button) findViewById(R.id.b48);box[49]=(Button) findViewById(R.id.b49);box[50]=(Button) findViewById(R.id.b50);
        box[51]=(Button) findViewById(R.id.b51);box[52]=(Button) findViewById(R.id.b52);box[53]=(Button) findViewById(R.id.b53);
        box[54]=(Button) findViewById(R.id.b54);box[55]=(Button) findViewById(R.id.b55);box[56]=(Button) findViewById(R.id.b56);
        box[57]=(Button) findViewById(R.id.b57);box[58]=(Button) findViewById(R.id.b58);box[59]=(Button) findViewById(R.id.b59);
        box[60]=(Button) findViewById(R.id.b60);box[61]=(Button) findViewById(R.id.b61);box[62]=(Button) findViewById(R.id.b62);
        box[63]=(Button) findViewById(R.id.b63);box[64]=(Button) findViewById(R.id.b64);box[65]=(Button) findViewById(R.id.b65);
        box[66]=(Button) findViewById(R.id.b66);box[67]=(Button) findViewById(R.id.b67);box[68]=(Button) findViewById(R.id.b68);
        box[69]=(Button) findViewById(R.id.b69);box[70]=(Button) findViewById(R.id.b70);box[71]=(Button) findViewById(R.id.b71);
        box[72]=(Button) findViewById(R.id.b72);box[73]=(Button) findViewById(R.id.b73);box[74]=(Button) findViewById(R.id.b74);
        box[75]=(Button) findViewById(R.id.b75);box[76]=(Button) findViewById(R.id.b76);box[77]=(Button) findViewById(R.id.b77);
        box[78]=(Button) findViewById(R.id.b78);box[79]=(Button) findViewById(R.id.b79);box[80]=(Button) findViewById(R.id.b80);
        box[81]=(Button) findViewById(R.id.b81);box[82]=(Button) findViewById(R.id.b82);box[83]=(Button) findViewById(R.id.b83);
        box[84]=(Button) findViewById(R.id.b84);box[85]=(Button) findViewById(R.id.b85);box[86]=(Button) findViewById(R.id.b86);
        box[87]=(Button) findViewById(R.id.b87);box[88]=(Button) findViewById(R.id.b88);box[89]=(Button) findViewById(R.id.b89);
        box[90]=(Button) findViewById(R.id.b90);box[91]=(Button) findViewById(R.id.b91);box[92]=(Button) findViewById(R.id.b92);
        box[93]=(Button) findViewById(R.id.b93);box[94]=(Button) findViewById(R.id.b94);box[95]=(Button) findViewById(R.id.b95);
        box[96]=(Button) findViewById(R.id.b96);box[97]=(Button) findViewById(R.id.b97);box[98]=(Button) findViewById(R.id.b98);
        box[99]=(Button) findViewById(R.id.b99);box[100]=(Button) findViewById(R.id.b100);box[101]=(Button) findViewById(R.id.b101);
        box[102]=(Button) findViewById(R.id.b102);box[103]=(Button) findViewById(R.id.b103);box[104]=(Button) findViewById(R.id.b104);
        box[105]=(Button) findViewById(R.id.b105);box[106]=(Button) findViewById(R.id.b106);box[107]=(Button) findViewById(R.id.b107);
        box[108]=(Button) findViewById(R.id.b108);box[109]=(Button) findViewById(R.id.b109);box[110]=(Button) findViewById(R.id.b110);
        box[111]=(Button) findViewById(R.id.b111);box[112]=(Button) findViewById(R.id.b112);box[113]=(Button) findViewById(R.id.b113);
        box[114]=(Button) findViewById(R.id.b114);box[115]=(Button) findViewById(R.id.b115);box[116]=(Button) findViewById(R.id.b116);
        box[117]=(Button) findViewById(R.id.b117);box[118]=(Button) findViewById(R.id.b118);box[119]=(Button) findViewById(R.id.b119);
        box[120]=(Button) findViewById(R.id.b120);box[121]=(Button) findViewById(R.id.b121);box[122]=(Button) findViewById(R.id.b122);
        box[123]=(Button) findViewById(R.id.b123);box[124]=(Button) findViewById(R.id.b124);box[125]=(Button) findViewById(R.id.b125);
        box[126]=(Button) findViewById(R.id.b126);box[127]=(Button) findViewById(R.id.b127);box[128]=(Button) findViewById(R.id.b128);
        box[129]=(Button) findViewById(R.id.b129);box[130]=(Button) findViewById(R.id.b130);box[131]=(Button) findViewById(R.id.b131);
        box[132]=(Button) findViewById(R.id.b132);box[133]=(Button) findViewById(R.id.b133);box[134]=(Button) findViewById(R.id.b134);
        box[135]=(Button) findViewById(R.id.b135);box[136]=(Button) findViewById(R.id.b136);box[137]=(Button) findViewById(R.id.b137);
        box[138]=(Button) findViewById(R.id.b138);box[139]=(Button) findViewById(R.id.b139);
        for(i=0;i<140;i++)
        {
            box[i].setOnClickListener(this);
        }
        Undo.setClickable(false);
        Undo.setBackgroundResource(R.drawable.undoblur);
        Quit.setClickable(false);
        Quit.setBackgroundResource(R.drawable.quitblur);
        Restart.setClickable(false);
        Restart.setBackgroundColor(Color.TRANSPARENT);
        r=new Random();
        int rch=r.nextInt(6);
        a=ran[rch];
        numb=2;n=0;
        ch=a[0];
        colorname(ch);
        countBox=0;
        increament();
    }
    public void quit(View v)
    {
        if(getsound())
            click.start();
        String temp=names[ch-1]+" are you \n really want to quit!";
        final Dialog dialog = new Dialog(ThreePlayer.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmbox);
        dialog.setCancelable(false);
        TextView title = (TextView) dialog.findViewById(R.id.title);
        TextView message=(TextView) dialog.findViewById(R.id.message);
        title.setText("QUIT");
        message.setText(temp); // set dialog message
        Button button1=(Button) dialog.findViewById(R.id.button1);
        Button button2=(Button) dialog.findViewById(R.id.button2);
        button1.setText("QUIT");
        button2.setText("CONTINUE");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                if(numb<2)
                {
                    if(ch==a[0])
                    {
                        // player at index 1 will won the game
                        wonbox(a[1]);
                    }
                    else
                    {
                        // player at index 0 will won the game
                        wonbox(a[0]);
                    }
                    dialog.cancel();
                }
                else
                {
                    //comfirmation for quit
                    if(n==numb)
                    {
                        numb=numb-1;
                        n=0; ch=a[0];
                        colorname(ch);
                    }
                    else
                    {
                        for(int k=n;k<numb;k++)
                        {
                            a[k]=a[k+1];
                        }
                        numb=numb-1;
                        ch=a[n];
                        colorname(ch);
                    }
                    dialog.cancel();
                }
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(getsound())
                    click.start();
                dialog.cancel();}});
        
        dialog.show();

    }
    public void changeplayer()
    {
        if(n!=numb)
        {
            ch=a[n+1];
            n++;
        }
        else
        {
            ch=a[0];
            n=0;
        }
        pname.setText(names[ch-1]);
       colorname(ch);
    }
    public void undo(View v)
    {
        if(getsound())
            click.start();
        //n is pointing index
        //numb is number of index
        if(n!=0)
        {
            ch=a[n-1];
            n--;
        }
        else
        {
            ch=a[numb];
            n=numb;
        }
        colorname(ch);

        for(i=0;i<140;i++)
        {
            box[i].setText(""+u[i]);
            colorit(u[i],i,0);
        }
        countBox--;         //decrement in turns
        Undo.setClickable(false);
        Undo.setBackgroundResource(R.drawable.undoblur);
        if(countBox<3) {
            Quit.setClickable(false);
            Quit.setBackgroundResource(R.drawable.quitblur);
        }
    }
    @Override
    public void onClick(View v)
    {
        try{
             ex=false;
            for (i = 0; i < 140; i++)
            {
                if (v == box[i] && Integer.parseInt(box[i].getText().toString()) == 0)//check box is white or not
                {
                    countBox++; //increment in turns
                    if(countBox>2) {
                        Quit.setClickable(true);
                        Quit.setBackgroundResource(R.drawable.quit);
                        Restart.setClickable(true);
                        Restart.setBackgroundResource(R.drawable.restart);
                    }
                    else
                    {
                        Quit.setClickable(false);
                        Quit.setBackgroundResource(R.drawable.quitblur);
                    }
                    Undo.setClickable(true);
                    Undo.setBackgroundResource(R.drawable.undo);
                    for(k=0;k<140;k++)
                    {    int change=Integer.parseInt(box[k].getText().toString());
                        if(change>10)
                        {box[k].setText(""+(change%10));
                            u[k]=change%10;}
                        else
                            u[k]=change;
                    }
                    colorit(ch,i,0);
                    changeplayer();
                    p = Integer.parseInt(box[i].getText().toString());
                    if ((i % 10 == 0 && i > 10 && i < 120) || (i % 10 == 1 && i > 11 && i < 121)) {
                        if (right(i, p) || up(i, p) || down(i, p))
                        {expfunction(i,p); }
                    } else if ((i % 10 == 9 && i > 19 && i < 129) && (i % 10 == 8 && i > 19 && i < 128)) {
                        if (left(i, p) || up(i, p) || down(i, p))
                        {expfunction(i,p); }
                    } else if ((i > 1 && i < 8) || (i > 11 && i < 18)) {
                        if (left(i, p) || right(i, p) || down(i, p))
                        {expfunction(i,p); }
                    } else if ((i > 131 && i < 138) || (i > 121 && i < 128)) {
                        if (left(i, p) || right(i, p) || up(i, p))
                        {expfunction(i,p); }
                    } else if (i == 0 || i == 1 || i == 10|| i == 11) {
                        if (down(i, p) || right(i, p))
                        {expfunction(i,p); }
                    } else if (i == 9 || i == 8 || i == 18 || i == 19) {
                        if (left(i, p) || down(i, p))
                        {expfunction(i,p); }
                    } else if (i == 130 || i == 120 || i == 131 || i == 121) {
                        if (right(i, p) || up(i, p))
                        {expfunction(i,p); }
                    } else if (i == 139 || i == 138 || i == 129||i == 129) {
                        if (left(i, p) || up(i, p))
                        {expfunction(i,p); }
                    } else {
                        if (left(i, p) || right(i, p) || up(i, p) || down(i, p))
                        {expfunction(i,p); }
                    }
                    if (i>10 && i<129 && i%10!=0 && i%10!=9 && ex==false)
                    {
                        if(leftrightmid(i,p)||updownmid(i,p))
                            expfunction(i,p);
                    }
                    else if ((i%10==0 && i!=0 &&i!=130 )||(i%10==9 && i!=9 &&i!=139 ) && ex==false)
                    {
                        if(updownmid(i,p))
                            expfunction(i,p);
                    }
                    else if((i>0 &&i<9 ||i>130 &&i<139 )&& ex==false)
                    {
                        if(leftrightmid(i,p))
                            expfunction(i,p);
                    }
                    if(ex==false)
                        if(getsound())
                            turn.start();
                    break;
                }
            }

            if(countBox==140)
                checkWin();

        }
        catch(Exception e) {}

    }
    public void expfunction(int in,int pl)
    {
        if(getsound())
            expand.start();
        ex=true;
        expand(in - 10, in + 10, in- 1, in + 1, pl);
    }
    public boolean updownmid(int c,int t)
    {
        if((Integer.parseInt(box[c+10].getText().toString())==t) &&(Integer.parseInt(box[c-10].getText().toString())==t))
            return true;
        else
            return false;
    }
    public boolean leftrightmid(int c,int t)
    {
        if((Integer.parseInt(box[c+1].getText().toString())==t) &&(Integer.parseInt(box[c-1].getText().toString())==t))
            return true;
        else
            return false;
    }
    public boolean right(int c,int t)//check for right 3 boxes
    {   int temp=c+3;
        for(int j=c;j<temp;j++)
        {
            if(Integer.parseInt(box[j].getText().toString())!=t)
                return false;
        }
        return true;
    }
    public boolean left(int c,int t)//check for left 3 boxes
    {
        int temp=c-3;
        for(int j=c;j>temp;j--)
        {
            if(Integer.parseInt(box[j].getText().toString())!=t)
                return false;
        }
        return true;
    }
    public boolean up(int c,int t)//check for upper 3 boxes
    {
        int temp=c-30;
        for(int j=c;j>temp;j=j-10)
        {
            if(Integer.parseInt(box[j].getText().toString())!=t)
                return false;
        }
        return true;
    }
    public boolean down(int c,int t)//check for down 3 boxes
    {
        int temp=c+30;
        for(int j=c;j<temp;j=j+10)
        {
            if(Integer.parseInt(box[j].getText().toString())!=t)
                return false;
        }
        return true;
    }
    public void expand(int u,int d,int l,int r,int cs)//expand the colors
    {   int uc,dc,lc,rc;
        if(u>=0 && u<140)
        {
            uc=Integer.parseInt(box[u].getText().toString());
            if(uc!=0 && uc<10)
            {
                colorit(cs,u,1);
                expand(u-10,u+10,u-1,u+1,cs);
            }
        }
        if(d>=0 && d<140)
        {
            dc=Integer.parseInt(box[d].getText().toString());
            if(dc!=0 && dc<10)
            {
                colorit(cs,d,1);
                expand(d-10,d+10,d-1,d+1,cs);
            }
        }
        if(l%10!=9  && l>=0 && l<140)
        {
            lc = Integer.parseInt(box[l].getText().toString());
            if (lc!=0 && lc<10)
            {
                colorit(cs,l,1);
                expand(l-10,l+10,l-1,l+1,cs);
            }
        }
        if(r%10!=0  && r>=0 && r<140)
        {
            rc=Integer.parseInt(box[r].getText().toString());
            if (rc!=0 && rc<10)
            {
                colorit(cs,r,1);
                expand(r-10,r+10,r-1,r+1,cs);
            }
        }
        return;
    }
    public void colorit(int c,int bx,int checked) //To color the checked boxes again a/c to player chance
    {
        switch(c)
        {
            case 0:
                box[bx].setText("0");
                box[bx].setBackgroundResource(R.drawable.grid);
                break;
            case 1:
                if (checked==0)
                    box[bx].setText("1");
                else
                    box[bx].setText("11");
                box[bx].setBackgroundResource(R.drawable.bbox);
                break;
            case 2:
                if (checked==0)
                    box[bx].setText("2");
                else
                    box[bx].setText("22");
                box[bx].setBackgroundResource(R.drawable.rbox);
                break;
            case 3:
                if (checked==0)
                    box[bx].setText("3");
                else
                    box[bx].setText("33");
                box[bx].setBackgroundResource(R.drawable.gbox);
                break;
        }

    }
    public void colorname(int c)
    {

        switch(c)
        {
            case 1:
                pname.setText(names[c-1]);
                pname.setTextColor(Color.BLUE);
                picon.setBackgroundResource(R.drawable.bturn);
                back.setBackgroundResource(R.drawable.backgroundb);
                break;
            case 2:
                pname.setText(names[c-1]);
                pname.setTextColor(Color.RED);
                picon.setBackgroundResource(R.drawable.rturn);
                back.setBackgroundResource(R.drawable.backgroundr);
                break;
            case 3:
                pname.setText(names[c-1]);
                pname.setTextColor(Color.parseColor("#008000"));
                picon.setBackgroundResource(R.drawable.gturn);
                back.setBackgroundResource(R.drawable.backgroundg);
                break;
        }
    }
    public void wonbox(int won)
    {
        final Dialog dialog = new Dialog(ThreePlayer.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.winbox);
        dialog.setCancelable(false);
        TextView pwon = (TextView) dialog.findViewById(R.id.pwon);
        TextView draw=(TextView) dialog.findViewById(R.id.draw);
        ImageView pwoni=(ImageView) dialog.findViewById(R.id.pwoni);
        switch(won)
        {
            case 0:
                draw.setText("IT'S A TIE");
                pwon.setText("ALL EQUAL");
                pwoni.setBackgroundResource(R.drawable.all);
                break;
            case 1:
                draw.setText("YOU WON");
                pwon.setText(names[won-1]);
                pwoni.setBackgroundResource(R.drawable.bturn);
                break;
            case 2:
                draw.setText("YOU WON");
                pwon.setText(names[won-1]);
                pwoni.setBackgroundResource(R.drawable.rturn);
                break;
            case 3:
                draw.setText("YOU WON");
                pwon.setText(names[won-1]);
                pwoni.setBackgroundResource(R.drawable.gturn);
                break;
        }
        Button exit=(Button) dialog.findViewById(R.id.exit);
        Button restart=(Button) dialog.findViewById(R.id.restart);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                startActivity(new Intent(ThreePlayer.this,SelPlayer.class));
                finish();
            }

        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                if(getsound())
                    click.start();
                dialog.cancel();
                onCreate(null);}});
        
        dialog.show();
    }
    public void checkWin()
    {
        int bl=0,rd=0,gn=0,no;
        for(i=0;i<140;i++)
            {
                no = Integer.parseInt(box[i].getText().toString());
                if (no == 1)
                    bl++;
                else if (no == 2)
                    rd++;
                else
                    gn++;
            }
        if(bl==rd && rd==gn)
            wonbox(0);  //draw
        else {
            if (bl > rd)
            {
                if (bl > gn)
                    wonbox(1);//win bl
                else
                    wonbox(3);//win gn
            }
            else if(rd>gn)
                wonbox(2);//win rd
            else
                wonbox(3);//win gn
            }
    }
    public void restart(View v)
    {
        if(getsound())
            click.start();
        final Dialog dialog = new Dialog(ThreePlayer.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmbox);
        dialog.setCancelable(false);
        TextView title = (TextView) dialog.findViewById(R.id.title);
        TextView message=(TextView) dialog.findViewById(R.id.message);
        title.setText("RESTART GAME");
        message.setText("Are you sure to restart the Game ?"); // set dialog message
        Button button1=(Button) dialog.findViewById(R.id.button1);
        Button button2=(Button) dialog.findViewById(R.id.button2);
        button1.setText("YES");
        button2.setText("NO");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                FullAds fullAds=new FullAds();
                fullAds.startAdd(ThreePlayer.this);
                startActivity(new Intent(ThreePlayer.this,ThreePlayer.class).putExtra("pnames",names));
                dialog.cancel();
                finish();
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(getsound())
                    click.start();
                dialog.cancel();}});
        dialog.show();
    }
    public void onBackPressed()
    {

        final Dialog dialog = new Dialog(ThreePlayer.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmbox);
        dialog.setCancelable(false);
        TextView title = (TextView) dialog.findViewById(R.id.title);
        TextView message=(TextView) dialog.findViewById(R.id.message);
        title.setText("LEAVE GAME");
        message.setText("Are you sure to leave the Game ?"); // set dialog message
        Button button1=(Button) dialog.findViewById(R.id.button1);
        Button button2=(Button) dialog.findViewById(R.id.button2);
        button1.setText("YES");
        button2.setText("NO, CONTINUE");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getsound())
                    click.start();
                if(countBox<3)
                    decreament();
                startActivity(new Intent(ThreePlayer.this,SelPlayer.class));
                finish();
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(getsound())
                    click.start();
                dialog.cancel();}});
        
        dialog.show();
    }
    public void decreament()
    {
        SharedPreferences.Editor editor = getSharedPreferences("gplayed", MODE_PRIVATE).edit();
        gp=getGplayed()-1;
        editor.putLong("games",gp);
        editor.commit();
    }
    public boolean getsound()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("checked", MODE_PRIVATE);
        return sharedPrefs.getBoolean("sound", true);
    }
    public void increament()
    {
        SharedPreferences.Editor editor = getSharedPreferences("gplayed", MODE_PRIVATE).edit();
        gp=getGplayed()+1;
        editor.putLong("games",gp);
        editor.commit();
    }
    public long getGplayed()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("gplayed", MODE_PRIVATE);
        return sharedPrefs.getLong("games", 0);
    }
}