package com.example.doctorcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {
    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        pay= findViewById(R.id.buy_button);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(
                    View view) {
                Intent checkout=new Intent(PaymentActivity.this, CheckoutActivity.class);
                startActivity(checkout);
            }
        });
    }
}