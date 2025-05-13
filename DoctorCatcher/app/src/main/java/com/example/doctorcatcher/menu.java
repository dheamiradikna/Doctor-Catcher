package com.example.doctorcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    private Button btnLogout, btnInfo, btnLocation, btnPayment,admin;
    private TextView tvName;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();

        this.setTitle("Main Menu");

        tvName = findViewById(R.id.tvPatientName);
        btnLogout = findViewById(R.id.btnLogout);
        btnInfo = findViewById(R.id.btnInformation);
        btnPayment = findViewById(R.id.btnPayment);
        btnLocation = findViewById(R.id.btnLocation);
        admin = findViewById(R.id.admin);
        img = findViewById(R.id.imageView);

        tvName.setText(getIntent().getStringExtra("username"));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(menu.this, MainActivity.class);
                startActivity(logout);
                Toast.makeText(getApplicationContext(), "Logout successfull!", Toast.LENGTH_SHORT).show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(menu.this, MyInformation.class);
                info.putExtra("user", tvName.getText().toString());
                startActivity(info);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(menu.this, userview.class);
                startActivity(admin);
            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payment = new Intent(menu.this, PaymentActivity.class);
                startActivity(payment);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(menu.this, Appointmentlist.class);
                startActivity(admin);
            }
        });

    }
}
