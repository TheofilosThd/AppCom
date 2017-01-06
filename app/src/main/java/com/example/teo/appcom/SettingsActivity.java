package com.example.teo.appcom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Teo on 12/20/2016.
 */

public class SettingsActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            getSupportActionBar().setTitle("Ρυθμίσεις");

            ListView lv = (ListView) findViewById(R.id.set_items);

            String[] settings = new String[] {
                    "Προσθήκη Επαφής",
                    "Αφαίρεση Επαφής",
                    "Επεξεργασία λίστας φαρμάκων",
                    "Τόπος Διαμονής",
                    "Ρυθμίσεις ήχου",
                    "Ορισμός συγγενή έκ. ανάγκης"
            };

            final List<String> settings_list = new ArrayList<String>(Arrays.asList(settings));

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, settings_list);

            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if( i==0){
                        Intent intent = new Intent(SettingsActivity.this, AddContactActivity.class);
                        startActivity(intent);
                    } if(i==1){
                        Intent intent = new Intent(SettingsActivity.this,RemoveContactActivity.class);
                        startActivity(intent);
                    }if(i==2){
                        Intent intent = new Intent(SettingsActivity.this,MedSetActivity.class);
                        startActivity(intent);
                    }if(i==3){
                        Intent intent = new Intent(SettingsActivity.this,HomeLocActivity.class);
                        startActivity(intent);
                    }
                    if(i==4){
                        Intent intent = new Intent(SettingsActivity.this,SoundSetActivity.class);
                        startActivity(intent);
                    }
                    if(i==5){
                        Intent intent = new Intent(SettingsActivity.this,FamilyMemTelActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
}
