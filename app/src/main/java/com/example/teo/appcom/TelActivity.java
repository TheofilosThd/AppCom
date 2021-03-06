package com.example.teo.appcom;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class TelActivity extends AppCompatActivity {

    private TextView telephone_input;
    private ImageButton n0_btn,n1_btn,n2_btn,n3_btn,n4_btn,n5_btn,n6_btn,n7_btn,n8_btn,n9_btn;
    private ImageButton call_btn,delete_btn;
    String tel_string="";


    private TextView dateTime ;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);



        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
        // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);

        telephone_input = (TextView) findViewById(R.id.telephone_input);
        n0_btn =(ImageButton) findViewById(R.id.n0_btn);
        n1_btn =(ImageButton) findViewById(R.id.n1_btn);
        n2_btn =(ImageButton) findViewById(R.id.n2_btn);
        n3_btn =(ImageButton) findViewById(R.id.n3_btn);
        n4_btn =(ImageButton) findViewById(R.id.n4_btn);
        n5_btn =(ImageButton) findViewById(R.id.n5_btn);
        n6_btn =(ImageButton) findViewById(R.id.n6_btn);
        n7_btn =(ImageButton) findViewById(R.id.n7_btn);
        n8_btn =(ImageButton) findViewById(R.id.n8_btn);
        n9_btn =(ImageButton) findViewById(R.id.n9_btn);
        call_btn =(ImageButton) findViewById(R.id.call_btn);
        delete_btn = (ImageButton) findViewById(R.id.delete_btn);

        telephone_input.setTypeface(null, Typeface.BOLD_ITALIC);
        telephone_input.setTextSize(53);


        n0_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.zero);
                mPlayer.start();
                tel_string+="0";
                telephone_input.setText(tel_string);

            }
        });

        n1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.one);
                mPlayer.start();
                tel_string+="1";
                telephone_input.setText(tel_string);
            }
        });

        n2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.two);
                mPlayer.start();
                tel_string+="2";
                telephone_input.setText(tel_string);
            }
        });

        n3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.three);
                mPlayer.start();
                tel_string+="3";
                telephone_input.setText(tel_string);
            }
        });

        n4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.four);
                mPlayer.start();
                tel_string+="4";
                telephone_input.setText(tel_string);
            }
        });

        n5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.five);
                mPlayer.start();
                tel_string+="5";
                telephone_input.setText(tel_string);
            }
        });

        n6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.six);
                mPlayer.start();
                tel_string+="6";
                telephone_input.setText(tel_string);
            }
        });

        n7_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.seven);
                mPlayer.start();
                tel_string+="7";
                telephone_input.setText(tel_string);
            }
        });

        n8_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.eight);
                mPlayer.start();
                tel_string+="8";
                telephone_input.setText(tel_string);
            }
        });

        n9_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mPlayer = MediaPlayer.create(TelActivity.this, R.raw.nine);
                mPlayer.start();
                tel_string+="9";
                telephone_input.setText(tel_string);
            }
        });

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+tel_string));
                startActivity(callIntent);
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tel_string.length() !=0) {
                    String temp_string = deleteLast(telephone_input.getText().toString());
                    tel_string=temp_string;
                    telephone_input.setText(temp_string);
                }

            }
        });
    }

    public String deleteLast(String tel){
        if(tel!=null && tel_string!=null)
        {
            tel = tel.substring(0,tel.length()-1);
        }
        return tel;
    }

    Runnable updateTextRunnable=new Runnable(){
        public void run() {
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
            SimpleDateFormat df = new SimpleDateFormat("  dd/MM/yyyy HH:mm ");
            String currentDate = df.format(c.getTime());
            dateTime.setText(currentDate);
            dateTime.setTextSize(25);
            handler.postDelayed(this, 1000);
        }
    };


}
