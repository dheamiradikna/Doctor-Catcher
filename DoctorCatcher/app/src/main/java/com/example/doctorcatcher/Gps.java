package com.example.doctorcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Gps extends AppCompatActivity {
    private ListView lv;
    String name[]= {"Dr. Halim Nor","Ummu Roihan","Gambang Health Clinic","Clinic Azzahra Gambang","Clinic Azzahra Kuantan","Clinic Al-Amin Sdn Bhd"};
    Integer img[]={R.drawable.halim,R.drawable.ummuroihan,R.drawable.c,R.drawable.a,R.drawable.azzahra,R.drawable.alamin};
    String latitude[]={"3.5492611","3.489954","3.707529","3.706278","3.795643","3.807114" };
    String longitude[]={"103.382063","103.393158","103.108910","103.097236","103.251307","103.328224"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        lv=findViewById(R.id.lv);

        this.setTitle("List of Appointment Location");

        GpsAdapter adapter = new GpsAdapter(Gps.this, name,img,latitude,longitude);
        //GpsAdapter adapter = new GpsAdapter(Gps.this, name,img);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name1 = (String) lv.getItemAtPosition(position);
                // String latitude1 = (String) lv.getItemAtPosition(null,null,position,null);
                // String  longitude1 = (String) lv.getItemAtPosition(position);
                // Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+latitude1+","+longitude1));
                //Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.5492611,103.382063"));

                // startActivity(intent);
                // Toast.makeText(Gps.this,name1,Toast.LENGTH_LONG).show();
                Toast.makeText(Gps.this,"Opening "+name1,Toast.LENGTH_LONG).show();

                if(position==0)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.5492611,103.382063"));
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.489954,103.393158"));
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.707529,103.108910"));
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.706278,103.097236"));
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.795643,103.251307"));
                    startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:3.807114,103.328224"));
                    startActivity(intent);
                }
            }
        });
    }
}
