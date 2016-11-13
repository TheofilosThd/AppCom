package com.example.teo.appcom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class favContacts extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_contacts2);


        LinearLayout dynamicalContacts = (LinearLayout) findViewById(R.id.spaceForTexts);

        


        final ImageButton contact1 = new ImageButton(this);
        final TextView contact1t = new TextView(this);
        contact1t.setText("Γιοκας μου");
        contact1t.setGravity(Gravity.CENTER);
        contact1.setImageResource(R.drawable.person1);
        contact1.setBackgroundColor(0x0000FF10);
        dynamicalContacts.addView(contact1);
        dynamicalContacts.addView(contact1t);
        clickBtn(contact1, "11");

        final ImageButton contact2 = new ImageButton(this);
        final TextView contact2t = new TextView(this);
        contact2t.setText("Κορουλα μου");
        contact2t.setGravity(Gravity.CENTER);
        contact2.setImageResource(R.drawable.person2);
        contact2.setBackgroundColor(0x0000FF10);
        dynamicalContacts.addView(contact2);
        dynamicalContacts.addView(contact2t);
        clickBtn(contact2, "22");

        final ImageButton contact3 = new ImageButton(this);
        final TextView contact3t = new TextView(this);
        contact3t.setText("Γαμπρος");
        contact3t.setGravity(Gravity.CENTER);
        contact3.setImageResource(R.drawable.person3);
        contact3.setBackgroundColor(0x0000FF14);
        dynamicalContacts.addView(contact3);
        dynamicalContacts.addView(contact3t);
        clickBtn(contact3, "33");

        final ImageButton contact4 = new ImageButton(this);
        final TextView contact4t = new TextView(this);
        contact4t.setText("Εγγονος");
        contact4t.setGravity(Gravity.CENTER);
        contact4.setImageResource(R.drawable.person4);
        contact4.setBackgroundColor(0x0000FF16);
        dynamicalContacts.addView(contact4);
        dynamicalContacts.addView(contact4t);
        clickBtn(contact4, "44");

        final ImageButton contact5 = new ImageButton(this);
        final TextView contact5t = new TextView(this);
        contact5t.setText("Εγγονη");
        contact5t.setGravity(Gravity.CENTER);
        contact5.setImageResource(R.drawable.person5);
        contact5.setBackgroundColor(0x0000FF1);
        dynamicalContacts.addView(contact5);
        dynamicalContacts.addView(contact5t);
        clickBtn(contact5, "55");

        final ImageButton contact6 = new ImageButton(this);
        final TextView contact6t = new TextView(this);
        contact6t.setText("Γιος 'watch up'");
        contact6t.setGravity(Gravity.CENTER);
        contact6.setImageResource(R.drawable.person6);
        contact6.setBackgroundColor(0x0000FF10);
        dynamicalContacts.addView(contact6);
        dynamicalContacts.addView(contact6t);
        clickBtn(contact6, "66");
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


