package com.example.teo.appcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class addContact extends AppCompatActivity {

    private TextView name_input;
    private TextView tel_input;
    String name_string;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);




        tel_input = (TextView) findViewById(R.id.telephone_input);
        name_input = (TextView) findViewById(R.id.tel_input);








        name_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_string+="0";
                name_input.setText(name_string);
            }
        });

    }


}
