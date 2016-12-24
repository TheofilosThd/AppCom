package com.example.teo.appcom;


import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private ImageButton tel_btn;
    private ImageButton sms_btn;
    private ImageButton map_btn;
    private ImageButton sos_btn;
    private ImageButton con_btn;
    private ImageButton med_btn;
    private ImageButton set_btn;
    private TextView dateTime ;

    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean flag =true;




        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        dateTime = (TextView) findViewById(R.id.datetime);
        tel_btn = (ImageButton) findViewById(R.id.tel_btn);
        sms_btn = (ImageButton) findViewById(R.id.sms_btn);
        map_btn = (ImageButton) findViewById(R.id.map_btn);
        sos_btn = (ImageButton) findViewById(R.id.torch_btn);
        con_btn = (ImageButton) findViewById(R.id.con_btn);
        med_btn = (ImageButton) findViewById(R.id.med_btn);
        set_btn = (ImageButton) findViewById(R.id.set_btn);


        handler.post(updateTextRunnable);
handler.post(checkBattery);

        // getSupportActionBar().setIcon(R.drawable.setting);

        tel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"));
                startActivity(callIntent);
                */
                Intent i = new Intent(MainActivity.this,TelActivity.class);
                startActivity(i);
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                String uri = "google.navigation:q=%f, %f";
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?f=d&daddr=37.994038, 23.732468"));
                intent.setComponent(new ComponentName("com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity"));
                startActivity(intent);
                */
                String uri = "google.navigation:q=%f, %f";
                Intent navIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String
                        .format(Locale.US, uri, 37.994038, 23.732468)));

                    startActivity(navIntent);

            }
        });

        sos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EmergencyActivity.class);
                startActivity(i);
            }
        });

        sms_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SmsActivity.class);
                startActivity(i);
            }
        });

        con_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,favContacts.class);
                startActivity(i);
            }
        });

        med_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MedicineActivity.class);
                startActivity(i);
            }
        });


        set_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(i);
                return false;
            }
        });

    }
    Runnable updateTextRunnable=new Runnable(){
        public void run() {
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"),Locale.getDefault());
            SimpleDateFormat df = new SimpleDateFormat("  dd/MM/yyyy HH:mm ");
            String currentDate = df.format(c.getTime());
            dateTime.setText(currentDate);
            dateTime.setTextSize(25);
            handler.postDelayed(this, 1000);
        }
    };
    boolean flag =true;

    Runnable checkBattery=new Runnable(){
        public void run() {
            if(getBatteryLevel()==50 && flag ==true){
                MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.low_battery);
                mPlayer.start();
                flag=false;
            }
            handler.postDelayed(this, 10000);
        }
    };


    public int getBatteryLevel(){
        Intent batteryIntent = MainActivity.this.getApplicationContext().registerReceiver(null,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = ((float)level / (float)scale) * 100.0f;

        int bt = (int) batteryPct;

        System.out.println(bt);

        return  bt;
    }


    }

