package com.example.teo.appcom;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class HomeLocActivity extends AppCompatActivity {

    Button save_btn ;
    EditText loc_text;

    private TextView dateTime ;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loc);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
        // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);

        save_btn = (Button) findViewById(R.id.save_btn);
        loc_text =(EditText) findViewById(R.id.loc_text);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loc_text.getText().length()!=0) {
                    messageOk();
                    finish();
                }else{
                    messageError();
                }
            }
        });
    }

    public void messageOk(){
        Toast.makeText(HomeLocActivity.this, "Η διεύθυνση διαμονής άλλαξε επιτυχώς",
                Toast.LENGTH_LONG).show();
    }

    public void messageError(){
        Toast.makeText(HomeLocActivity.this, "Παρακαλώ πλήκτρολογήστε έγκυρη διεύθυνση",
                Toast.LENGTH_LONG).show();
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
