package com.example.teo.appcom;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MedicineActivity extends AppCompatActivity{

   // ListView list;
    TextView day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        day = (TextView) findViewById(R.id.day);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        day.setText(dayOfTheWeek);

        Random r = new Random();

        int count1 = r.nextInt(4-1)+1;
        int count2 = r.nextInt(4-1)+1;
        int count3 = r.nextInt(4-1)+1;
        int count4 = r.nextInt(4-1)+1;
        int count5 = r.nextInt(4-1)+1;
        int count6 = r.nextInt(4-1)+1;

        String[] meds = {"Χάπι 1     :           Ποσότητα ="+count1, "Χάπι 2     :           Ποσότητα ="+count2, "Χάπι 3     :           Ποσότητα ="+count3, "Χάπι 4     :           Ποσότητα ="+count4, "Χάπι 5     :           Ποσότητα ="+count5, "Χάπι 6     :           Ποσότητα ="+count6};

      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,meds);

        //getListView().setAdapter(adapter);



    }
}
