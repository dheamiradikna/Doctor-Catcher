package com.example.doctorcatcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Appointmentlist extends AppCompatActivity {


    private Button add,del,update,view;
    private EditText id,name,date,time,location;

    AppointmentDb ADb = new AppointmentDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentlist);

        add=findViewById(R.id.add);
        del=findViewById(R.id.del);
        view=findViewById(R.id.view);
        update=findViewById(R.id.update);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        time=findViewById(R.id.time);
        date=findViewById(R.id.date);
        location=findViewById(R.id.location);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().matches("") & !name.getText().toString().matches("") & !date.getText().toString().matches("") & !time.getText().toString().matches("")&!location.getText().toString().matches("") ) {

                    Boolean isSaved = ADb.savdData(id.getText().toString(), name.getText().toString(), time.getText().toString() , date.getText().toString(), location.getText().toString());
                    if (isSaved == true) {
                        Toast.makeText(getApplicationContext(), "Data is inserted", Toast.LENGTH_LONG).show();
                        id.setText("");
                        name.setText("");
                        date.setText("");
                        time.setText("");
                        location.setText("");
                    } else
                        Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getApplicationContext(), "Please enter a valid input", Toast.LENGTH_LONG).show();
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent view = new Intent(Appointmentlist.this, AppointmenView.class);
                startActivity(view);

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().matches("") ) {

                    Boolean isDeleted = ADb.delData(id.getText().toString(), name.getText().toString(), date.getText().toString(), time.getText().toString(), location.getText().toString());

                    if (isDeleted == true) {
                        Toast.makeText(getApplicationContext(), "Data is Deleted", Toast.LENGTH_LONG).show();
                        id.setText("");
                    } else
                        Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_LONG).show();

            }else
            {
                Toast.makeText(getApplicationContext(), "Please enter a valid input", Toast.LENGTH_LONG).show();
            }


        }});

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().matches("") & !name.getText().toString().matches("") & !date.getText().toString().matches("") & !time.getText().toString().matches("") & !location.getText().toString().matches("")) {

                Boolean isEdited = ADb.editData((id.getText().toString()), name.getText().toString(), time.getText().toString() , date.getText().toString(), location.getText().toString());

                if (isEdited == true) {

                    Toast.makeText(getApplicationContext(), "Data is Updated", Toast.LENGTH_LONG).show();
                    id.setText("");
                    name.setText("");
                    date.setText("");
                    time.setText("");
                    location.setText("");
                } else

                    Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_LONG).show();

                }else
                {
                    Toast.makeText(getApplicationContext(), "Please enter a valid input", Toast.LENGTH_LONG).show();
                }
            }});
    }

}
