package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    EditText firstName, lastName, email, userName, password;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        update = (Button) findViewById(R.id.update);
        final DatabaseHelper db = new DatabaseHelper(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.updateContact(firstName.getText().toString(),
                        lastName.getText().toString(),
                        email.getText().toString(),
                        userName.getText().toString(),
                        password.getText().toString());

                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                userName.setText("");
                password.setText("");

                finish();
            }
        });
    }
}