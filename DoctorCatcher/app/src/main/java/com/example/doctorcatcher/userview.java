package com.example.doctorcatcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class userview extends AppCompatActivity {

    private Button btnAppointments, btnLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userview);

        this.setTitle("View Appointment Details");

        btnAppointments = findViewById(R.id.btnAppointments);
        btnLocations = findViewById(R.id.btnLocations);

        btnAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(userview.this, AppointmenView.class);
                startActivity(view);
            }
        });

        btnLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location = new Intent(userview.this, GPs2.class);
                startActivity(location);
            }
        });
    }
}