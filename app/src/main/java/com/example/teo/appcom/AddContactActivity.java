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

public class AddContactActivity extends AppCompatActivity {


    Button save_btn;
    EditText name_text,lastname_text,tel_text;

    private TextView dateTime ;

    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
        // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);

        save_btn = (Button) findViewById(R.id.save_btn);
        name_text = (EditText) findViewById(R.id.name_text);
        lastname_text = (EditText) findViewById(R.id.lastname_text);
        tel_text = (EditText) findViewById(R.id.tel_text);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name_text.getText().length() ==0 || lastname_text.getText().length() == 0 || tel_text.getText().length() ==0){
                    messageError();
                }else{
                    messageOk();
                    finish();
                }
            }
        });


    }

    public void messageOk(){
        Toast.makeText(AddContactActivity.this, "Η επαφή προστέθηκε επιτυχώς.",
                Toast.LENGTH_LONG).show();
    }

    public void messageError(){
        Toast.makeText(AddContactActivity.this, "Παρακαλώ συμπληρώστε όλα τα πεδία.",
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
