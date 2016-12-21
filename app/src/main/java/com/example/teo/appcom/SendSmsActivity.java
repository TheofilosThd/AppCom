package com.example.teo.appcom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SendSmsActivity extends AppCompatActivity {

    private String sms;
    private String phone_string;
    public EditText phone_number;
    private ImageButton final_send_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        getSupportActionBar().setTitle("");

        Bundle bundle = getIntent().getExtras();
        sms = bundle.getString("sms");

        LinearLayout dynamicalContacts = (LinearLayout) findViewById(R.id.spaceForTexts);


        ImageButton[] contact = new ImageButton[6];
        TextView[] contactt = new TextView[6];
        String[] number = {"11", "22", "33", "44" ,"55", "66"};
        String[] name = {"ΕΠΑΦΗ 1", "ΕΠΑΦΗ 2", "ΕΠΑΦΗ 3", "ΕΠΑΦΗ 4" ,"ΕΠΑΦΗ 5", "ΕΠΑΦΗ 6"};
        int[] pic = new int[] { R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6 };



        for (int i = 0; i < 6; i++){
            contact[i] = new ImageButton(this);
            contactt[i] = new TextView(this);
            TextView nline = new TextView(this);
            contactt[i].setText(name[i]);
            contactt[i].setTextSize(30);
            contactt[i].setGravity(Gravity.CENTER);
            contact[i].setImageResource(pic[i]);
            contact[i].setBackgroundColor(0x0000FF10);
            nline.setText(" \n");
            dynamicalContacts.addView(contact[i]);
            dynamicalContacts.addView(contactt[i]);
            dynamicalContacts.addView(nline);
            clickBtn(contact[i], number[i]);
        }


    }

    protected void sendSMSMessage(String tel) {
        String number = tel;
        Log.i("Send SMS", "");


        try {
            android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
            smsManager.sendTextMessage(tel, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again."+sms+tel, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void clickBtn(ImageButton btn, final String tel) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage(tel);
            }
        });
    }

}
