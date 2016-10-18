package com.example.teo.appcom;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tel_btn = (ImageButton) findViewById(R.id.tel_btn);
        sms_btn = (ImageButton) findViewById(R.id.sms_btn);
        map_btn = (ImageButton) findViewById(R.id.map_btn);
        sos_btn = (ImageButton) findViewById(R.id.torch_btn);
        con_btn = (ImageButton) findViewById(R.id.con_btn);
        med_btn = (ImageButton) findViewById(R.id.med_btn);



        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"),Locale.getDefault());
        SimpleDateFormat df = new SimpleDateFormat("  dd/MM/yyyy HH:mm ");
        String currentDate = df.format(c.getTime());




        getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));


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
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
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
                Intent i = new Intent(MainActivity.this,contacts.class);
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

    }

    }

