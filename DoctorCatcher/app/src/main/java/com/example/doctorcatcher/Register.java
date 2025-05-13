package com.example.doctorcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText etUsername, etPassword, etConPassword;
    private  EditText etFullName, etNRIC, etDOB, etPhone, etEmail,etAddress;
    private EditText etPolicyName, etPolicyPhone, etPolicyRelation;
    private Button btnRegister;
    private DatabaseHelper db;
    private DatabaseReference df;
    private Firebase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.setTitle("Register");
        Toast.makeText(Register.this, "Firebase connection success", Toast.LENGTH_SHORT).show();

        etUsername = findViewById(R.id.etUsernameReg);
        etPassword = findViewById(R.id.etPasswordReg);
        etConPassword = findViewById(R.id.etConPasswordReg);

        etFullName = findViewById(R.id.etFulNameReg);
        etNRIC = findViewById(R.id.etNRICReg);
        etDOB = findViewById(R.id.etDOBReg);
        etPhone = findViewById(R.id.etPhoneReg);
        etEmail = findViewById(R.id.etEmailReg);
        etAddress = findViewById(R.id.etAddressReg);

        etPolicyName = findViewById(R.id.etPolicyNameReg);
        etPolicyPhone = findViewById(R.id.etPolicyPhoneReg);
        etPolicyRelation = findViewById(R.id.etPolicyRelationReg);

        db = new DatabaseHelper(this);
        fb = new Firebase();
        df = FirebaseDatabase.getInstance().getReference().child("UserInformation");

        btnRegister = findViewById(R.id.btnSubmitReg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = etUsername.getText().toString();
                String sPassword = etPassword.getText().toString();
                String sCPassword = etConPassword.getText().toString();

                String sFullName = etFullName.getText().toString();
                String sNRIC = etNRIC.getText().toString();
                String sDOB = etDOB.getText().toString();
                String sPhone = etPhone.getText().toString();
                String sEmail = etEmail.getText().toString();
                String sAddress = etAddress.getText().toString();

                String sPolicyName = etPolicyName.getText().toString();
                String sPolicyPhone = etPolicyPhone.getText().toString();
                String sPolicyRelation = etPolicyRelation.getText().toString();


                if (sUsername.equals("")||sPassword.equals("")||sCPassword.equals("")||sFullName.equals("")||sNRIC.equals("")||sDOB.equals("")||sPhone.equals("")||sEmail.equals("")||sAddress.equals("")||sPolicyName.equals("")||sPolicyPhone.equals("")||sPolicyRelation.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill all the empty space", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (sPassword.equals(sCPassword))
                    {
                        Boolean checkUsername = db.checkUsername(sUsername);
                        if (checkUsername == true)
                        {
                            Boolean insert = db.insert(sFullName,sNRIC,sUsername,sPassword,sDOB,sPhone,sEmail,sAddress,sPolicyName,sPolicyPhone,sPolicyRelation);

                            fb.setFullName(etFullName.getText().toString().trim());
                            fb.setNRIC(etNRIC.getText().toString().trim());
                            fb.setUsername(etUsername.getText().toString().trim());
                            fb.setPassword(etPassword.getText().toString().trim());
                            fb.setDOB(etDOB.getText().toString().trim());
                            fb.setPhone(etPhone.getText().toString().trim());
                            fb.setEmail(etEmail.getText().toString().trim());
                            fb.setAddress(etAddress.getText().toString().trim());

                            fb.setPolicyName(etPolicyName.getText().toString().trim());
                            fb.setPolicyPhone(etPolicyPhone.getText().toString().trim());
                            fb.setPolicyRelation(etPolicyRelation.getText().toString().trim());

                            df.child(etUsername.getText().toString()).setValue(fb);

                            if (insert == true)
                            {
                                Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(), "Data has been inserted", Toast.LENGTH_SHORT).show();

                                Intent main = new Intent(Register.this, MainActivity.class);
                                startActivity(main);

                                etUsername.setText("");
                                etPassword.setText("");
                                etConPassword.setText("");
                                etFullName.setText("");
                                etNRIC.setText("");
                                etDOB.setText("");
                                etPhone.setText("");
                                etEmail.setText("");
                                etAddress.setText("");
                                etPolicyName.setText("");
                                etPolicyPhone.setText("");
                                etPolicyRelation.setText("");
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Username already exist!",Toast.LENGTH_SHORT).show();

                            etUsername.setText("");
                            etPassword.setText("");
                            etConPassword.setText("");
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error: Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}