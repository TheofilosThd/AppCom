package com.example.teo.appcom;

import android.app.ListActivity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;


import static com.example.teo.appcom.R.color.blue;

public class MedicineActivity extends AppCompatActivity{

   // ListView list;
    TextView day;
    Button med1_1,med1_2,med2_1,med2_2,med3_1,med4_1,med4_2,med4_3,med4_4;
    private TextView dateTime ;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
        // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);

        MediaPlayer mPlayer = MediaPlayer.create(MedicineActivity.this, R.raw.med_voice);
        mPlayer.start();

        day = (TextView) findViewById(R.id.day);
        med1_1 = (Button) findViewById(R.id.med1_1);
        med1_2 = (Button) findViewById(R.id.med1_2);
        med2_1 = (Button) findViewById(R.id.med2_1);
        med2_2 = (Button) findViewById(R.id.med2_2);
        med3_1 = (Button) findViewById(R.id.med3_1);
        med4_1 = (Button) findViewById(R.id.med4_1);
        med4_2 = (Button) findViewById(R.id.med4_2);
        med4_3 = (Button) findViewById(R.id.med4_3);
        med4_4 = (Button) findViewById(R.id.med4_4);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        day.setText(dayOfTheWeek);



        med1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeBtnColor(med1_1);
            }

        });

        med1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med1_2);
            }
        });

        med2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med2_1);
            }
        });

        med2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med2_2);
            }
        });

        med3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med3_1);
            }
        });

        med4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med4_1);
            }
        });

        med4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med4_2);
            }
        });

        med4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med4_3);
            }
        });

        med4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnColor(med4_4);
            }
        });

    }

    public void changeBtnColor(Button btn){
        btn.setBackgroundColor(Color.parseColor("#7BE46B"));
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
