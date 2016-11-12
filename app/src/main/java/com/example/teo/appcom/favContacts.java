package com.example.teo.appcom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;

public class favContacts extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_contacts2);


        LinearLayout dynamicalContacts = (LinearLayout) findViewById(R.id.spaceForTexts);



        final Button contact1 = new Button(this);
        contact1.setText("Αγαπημενος γιος");
        dynamicalContacts.addView(contact1);
        clickBtn(contact1, "11");
        final Button contact2 = new Button(this);
        contact2.setText("Αγαπημενος γιος2");
        dynamicalContacts.addView(contact2);
        clickBtn(contact2, "22");
        final Button contact3 = new Button(this);
        contact3.setText("Αγαπημενη κορη");
        dynamicalContacts.addView(contact3);
        clickBtn(contact3, "33");
        final Button contact4 = new Button(this);
        contact4.setText("Αγαπημενος κορη2");
        dynamicalContacts.addView(contact4);
        clickBtn(contact4, "44");
        final Button contact5 = new Button(this);
        contact5.setText("Εγγονος");
        dynamicalContacts.addView(contact5);
        clickBtn(contact5, "55");
        final Button contact6 = new Button(this);
        contact6.setText("Εγγονη");
        dynamicalContacts.addView(contact6);
        clickBtn(contact6, "66");
    }

    public void makeCall(String telephone) {
        String number = telephone;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    public void clickBtn(Button btn, final String tel) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCall(tel);
            }
        });
    }



    }


