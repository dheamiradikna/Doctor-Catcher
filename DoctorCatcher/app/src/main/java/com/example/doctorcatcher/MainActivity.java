package com.example.doctorcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText etUser, etPassword;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.setTitle("Login");
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        etUser = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        db = new DatabaseHelper(this);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUser.getText().toString();
                String password = etPassword.getText().toString();

                Boolean logincheck = db.logincheck(username,password);

                if (username.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (logincheck==true)
                    {
                        Intent menu = new Intent(MainActivity.this, menu.class);
                        menu.putExtra("username", etUser.getText().toString());
                        startActivity(menu);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(MainActivity.this, Register.class);
                startActivity(reg);
            }
        });




    }
}
