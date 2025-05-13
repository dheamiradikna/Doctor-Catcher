package com.example.doctorcatcher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class CheckoutActivity extends AppCompatActivity {
    private static final int TEZ_REQUEST_CODE = 123;
    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    private Button cardcheckout;
    private ImageButton googlepay, closebutton;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        cardcheckout = (Button) findViewById(R.id.pay_with_card_button);
        googlepay = (ImageButton) findViewById(R.id.pay_with_google_button);
        closebutton = (ImageButton) findViewById(R.id.close_sheet_button);

        cardcheckout.setOnClickListener(view -> {
            Intent checkout = new Intent(CheckoutActivity.this, CardActivity.class);
            startActivity(checkout);
        });

        googlepay.setOnClickListener(v -> {
            Uri uri =
                    new Uri.Builder()
                            .scheme("upi")
                            .authority("pay")
                            .appendQueryParameter("pa", "test@maybank")
                            .appendQueryParameter("pn", "Checkout Appointment")
                            .appendQueryParameter("mc", "6427263")
                            .appendQueryParameter("tr", "005273891763")
                            .appendQueryParameter("tn", "Are you sure ?")
                            .appendQueryParameter("am", "20")
                            .appendQueryParameter("cu", "RM")
                            .appendQueryParameter("url", "https.googlepay.com")
                            .build();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME);
            startActivityForResult(intent, TEZ_REQUEST_CODE);
        });

        closebutton.setOnClickListener(view -> {
            Intent close = new Intent(CheckoutActivity.this, menu.class);
            startActivity(close);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            Log.d("result", Objects.requireNonNull(data.getStringExtra("Status")));
        }
    }


}