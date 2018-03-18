package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataTabTwo extends AppCompatActivity {
    EditText firstName, lastName, email, userName, password;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_tab_two);

        firstName = (EditText) findViewById(R.id.firstnametabtwo);
        lastName = (EditText) findViewById(R.id.lastnametabtwo);
        email = (EditText) findViewById(R.id.emailtabtwo);
        userName = (EditText) findViewById(R.id.usernametabtwo);
        password = (EditText) findViewById(R.id.passwordtabtwo);

        update = (Button) findViewById(R.id.updatetabtwo);
        final DatabaseHelperTabTwo db = new DatabaseHelperTabTwo(this);
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
            }
        });
    }
}
