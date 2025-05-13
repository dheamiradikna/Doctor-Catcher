package com.example.doctorcatcher;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AppointmenView extends AppCompatActivity {
    private ListView lv;
   // private Button back,btnsearch;
   // private EditText etsearch;
    //private AppointmentDb db;
    AppointmentDb ADb = new AppointmentDb(this);
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmen_view);

       // back= findViewById(R.id.back);
        lv= findViewById(R.id.lv);
       // btnsearch= findViewById(R.id.btnsearch);
        //etsearch= findViewById(R.id.etsearch);
        arrayList = new ArrayList();
        Cursor data =  ADb.viewData();
        // db =new AppointmentDb(this);




        //etsearch.setText(getIntent().getStringExtra("input"));




        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(), "Nothing in DB", Toast.LENGTH_LONG).show();
        }
        else{
           // if(etsearch.getText().toString().matches("")){
                while(data.moveToNext()) {
                   //int i = 1;

                    arrayList.add("------------------------------------------------------------ ");
                    //arrayList.add("Doctor : "+(i));
                    arrayList.add("Doctor Id: "+data.getString(1));
                    arrayList.add("Doctor Name: "+data.getString(2));
                    arrayList.add("Time Free: "+data.getString(3));
                    arrayList.add("Date: "+data.getString(4));
                    arrayList.add("Location: "+data.getString(5));
                    //i++;


                    ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
                    lv.setAdapter(arrayAdapter);}}

         /*   else
            { Cursor search = ADb.searchData(etsearch.getText().toString());
                while(search.moveToNext()) {
                    //inside this activity, I will save what I got from helper class inside an array
                    //  arrayList.add(data.getString(0));
                    arrayList.add(search.getString(1));
                    arrayList.add(search.getString(2));
                    arrayList.add(search.getString(3));
                    arrayList.add(search.getString(4));
                    arrayList.add(search.getString(5));

                    // I can use adapter to display the array in a listview.
                    ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
                    lv.setAdapter(arrayAdapter);}
            }
        }*/


        /*btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent search = new Intent(AppointmenView.this, search.class);
                //startActivity(search);

                Cursor search = ADb.searchData(etsearch.getText().toString());
                ADb.searchData(etsearch.getText().toString());
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
    }
}

