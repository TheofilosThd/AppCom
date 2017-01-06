package com.example.teo.appcom;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class SoundSetActivity extends AppCompatActivity {

    ToggleButton sound_btn;

    private TextView dateTime ;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_set);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
        // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);

        sound_btn = (ToggleButton) findViewById(R.id.sound_btn);

        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        sound_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_btn.isChecked()==false){
                    AudioManager audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
                    audioManager.setRingerMode(audioManager.RINGER_MODE_SILENT);
                    System.out.println("mute");

                }
            }
        });


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
