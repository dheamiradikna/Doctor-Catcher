package com.example.doctorcatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyInformation extends AppCompatActivity {

    private DatabaseHelper db;
    private TextView userOutput, pwdOutput;
    private TextView userFullName, userNRIC, userDOB, userPhoneNo, userEmail, userAddress;
    private TextView userPName, userPPhone, userPRelation;
    private Button btnEdit, btnSave, btnDelete, btnUpload, btnSelect;

    private DatabaseReference df;
    private Firebase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);

        db = new DatabaseHelper(this);
        this.setTitle("My Information");

        fb = new Firebase();
        df = FirebaseDatabase.getInstance().getReference().child("UserInformation");

        userOutput = findViewById(R.id.etOUser);
        pwdOutput = findViewById(R.id.etOPass);

        userFullName = findViewById(R.id.etOFullName);
        userNRIC = findViewById(R.id.etONRIC);
        userDOB = findViewById(R.id.etODOB);
        userPhoneNo = findViewById(R.id.etONoPhone);
        userEmail = findViewById(R.id.etOEmail);
        userAddress = findViewById(R.id.etOAddress);

        userPName = findViewById(R.id.etOPName);
        userPPhone = findViewById(R.id.etOPPhoneNo);
        userPRelation = findViewById(R.id.etOPRelation);

        btnEdit = findViewById(R.id.btnEdit);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpload = findViewById(R.id.btnUpload);
        btnSelect = findViewById(R.id.btnSelect);

        userOutput.setText(getIntent().getStringExtra("user"));

        String users = userOutput.getText().toString();


        Cursor data =  db.sessions(users);

        userFullName.setText(data.getString(0));
        userNRIC.setText(data.getString(1));
        pwdOutput.setText(data.getString(3));
        userDOB.setText(data.getString(4));
        userPhoneNo.setText(data.getString(5));
        userEmail.setText(data.getString(6));
        userAddress.setText(data.getString(7));
        userPName.setText(data.getString(8));
        userPPhone.setText(data.getString(9));
        userPRelation.setText(data.getString(10));


        /*
        df = FirebaseDatabase.getInstance().getReference().child("UserInformation").child(users);
        df.addValueEventListener(new ValueEventListener()

        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sUsername = snapshot.child("username").getValue().toString();
                String sPassword = snapshot.child("password").getValue().toString();


                String sFullName = snapshot.child("fullName").getValue().toString();
                String sNRIC = snapshot.child("nric").getValue().toString();
                String sDOB = snapshot.child("dob").getValue().toString();
                String sPhone = snapshot.child("phone").getValue().toString();
                String sEmail = snapshot.child("email").getValue().toString();
                String sAddress = snapshot.child("address").getValue().toString();

                String sPolicyName = snapshot.child("policyName").getValue().toString();
                String sPolicyPhone = snapshot.child("policyPhone").getValue().toString();
                String sPolicyRelation = snapshot.child("policyRelation").getValue().toString();

                userOutput.setText(sUsername);
                pwdOutput.setText(sPassword);

                userFullName.setText(sFullName);
                userNRIC.setText(sNRIC);
                userDOB.setText(sDOB);
                userPhoneNo.setText(sPhone);
                userEmail.setText(sEmail);
                userAddress.setText(sAddress);

                userPName.setText(sPolicyName);
                userPPhone.setText(sPolicyPhone);
                userPRelation.setText(sPolicyRelation);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         */


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnSave.setEnabled(true);
                btnDelete.setEnabled(true);
                btnUpload.setEnabled(true);
                btnEdit.setEnabled(false);
                btnSelect.setEnabled(true);

                userFullName.setEnabled(true);
                userNRIC.setEnabled(true);
                pwdOutput.setEnabled(true);
                userDOB.setEnabled(true);
                userPhoneNo.setEnabled(true);
                userEmail.setEnabled(true);
                userAddress.setEnabled(true);

                userPName.setEnabled(true);
                userPPhone.setEnabled(true);
                userPRelation.setEnabled(true);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String users = userOutput.getText().toString();
                String password = pwdOutput.getText().toString();

                String fullname = userFullName.getText().toString();
                String NRIC = userNRIC.getText().toString();
                String DOB = userDOB.getText().toString();
                String PhoneNo = userPhoneNo.getText().toString();
                String Email = userEmail.getText().toString();
                String Address = userAddress.getText().toString();

                String PolicyName = userPName.getText().toString();
                String PolicyPhone = userPPhone.getText().toString();
                String PolicyRelation = userPRelation.getText().toString();



                if (password.equals("")||fullname.equals("")||NRIC.equals("")||DOB.equals("")||PhoneNo.equals("")||Email.equals("")||Address.equals("")||PolicyName.equals("")||PolicyPhone.equals("")||PolicyRelation.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill all the empty space before update", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    fb = new Firebase();
                    df = FirebaseDatabase.getInstance().getReference().child("UserInformation");

                    fb.setUsername(users);
                    fb.setFullName(fullname);
                    fb.setNRIC(NRIC);
                    fb.setPassword(password);
                    fb.setDOB(DOB);
                    fb.setPhone(PhoneNo);
                    fb.setEmail(Email);
                    fb.setAddress(Address);

                    fb.setPolicyName(PolicyName);
                    fb.setPolicyPhone(PolicyPhone);
                    fb.setPolicyRelation(PolicyRelation);

                    df.child(users).setValue(fb); // Firebase Update

                    Cursor data =  db.update(users,password,fullname,NRIC,DOB,PhoneNo,Email,Address,PolicyName,PolicyPhone,PolicyRelation); //SQLite Update

                    Toast.makeText(getApplicationContext(),"Account has been updated!",Toast.LENGTH_SHORT).show();
                    Intent menu = new Intent(MyInformation.this, menu.class);
                    menu.putExtra("username", userOutput.getText().toString());
                    startActivity(menu);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = userOutput.getText().toString();
                Cursor data =  db.delete(users);
                deleteUser(users);

                Toast.makeText(getApplicationContext(),"Account has been deleted!",Toast.LENGTH_SHORT).show();

                Intent main = new Intent(MyInformation.this, MainActivity.class);
                startActivity(main);
            }
        });
    }

    private void deleteUser(String users)
    {
        DatabaseReference deleteUser = FirebaseDatabase.getInstance().getReference("UserInformation").child(users);
        deleteUser.removeValue();
    }

}
