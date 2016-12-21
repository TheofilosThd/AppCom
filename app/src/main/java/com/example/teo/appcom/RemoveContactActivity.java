package com.example.teo.appcom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_contact);

        getSupportActionBar().setTitle("");

        ListView lv = (ListView) findViewById(R.id.remove_contacts);

        final String[] contacts = new String[]{"ΕΠΑΦΗ 1", "ΕΠΑΦΗ 2", "ΕΠΑΦΗ 3", "ΕΠΑΦΗ 4" ,"ΕΠΑΦΗ 5", "ΕΠΑΦΗ 6"};

        final List<String> contacts_list = new ArrayList<String>(Arrays.asList(contacts));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, contacts_list);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int item = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(RemoveContactActivity.this);
                builder.setTitle("Διαγραφή επαφής :");
                builder.setMessage("Να γίνει διαγραφή της επαφής "+contacts_list.get(item)+" ?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Ναι",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //dialog.cancel();
                                arrayAdapter.remove(contacts[item]);

                            }
                        });

                builder.setNegativeButton(
                        "Όχι",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder.create();
                alert11.show();



            }
        });
    }
}
