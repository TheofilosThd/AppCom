package com.example.teo.appcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
        Bundle bundle = getIntent().getExtras();
        sms = bundle.getString("sms");

        phone_number =(EditText)findViewById(R.id.phone_number);
        final_send_btn=(ImageButton) findViewById(R.id.final_send_btn);



        final_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });

    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");


        try {
            android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
            smsManager.sendTextMessage(phone_number.getText().toString(), null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again."+sms+phone_number.getText().toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
