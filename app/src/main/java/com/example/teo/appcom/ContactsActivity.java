package com.example.teo.appcom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContactsActivity extends AppCompatActivity {

    private ImageButton ote_btn;
    private ImageButton taxi_btn;
    private ImageButton home_btn;
    private ImageButton addcnt_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        taxi_btn = (ImageButton) findViewById(R.id.taxi_btn);
        ote_btn = (ImageButton) findViewById(R.id.ote_btn);
        home_btn = (ImageButton) findViewById(R.id.home_btn);
        addcnt_btn = (ImageButton) findViewById(R.id.addcnt_btn);

        clickBtn(taxi_btn, "99999");
        clickBtn(ote_btn, "118888");

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });



        addcnt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(ContactsActivity.this, favContacts.class);
            startActivity(i);
            }
        });
    }

    public void makeCall(String telephone) {
        String number = telephone;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    public void clickBtn(ImageButton btn, final String tel) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCall(tel);
            }
        });
    }



}
