package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPManager extends AppCompatActivity
{
    EditText firstName_manager, lastName_manager, email_manager, userName_manager, password_manager,validationCode;
    Button signup_manager;
    String code = "Manager";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upmanager);

        firstName_manager = (EditText) findViewById(R.id.firstname_manager);
        lastName_manager = (EditText) findViewById(R.id.lastname_manager);
        email_manager = (EditText) findViewById(R.id.email_manager);
        userName_manager = (EditText) findViewById(R.id.username_manager);
        password_manager = (EditText) findViewById(R.id.password_manager);
        validationCode = (EditText) findViewById(R.id.managerCode);

        signup_manager = (Button) findViewById(R.id.signup_manager);

        final DatabaseHelperTabTwo db = new DatabaseHelperTabTwo(this);

        signup_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationCode.getText().toString().equals(code))
                {
                    db.addContact(new contact(firstName_manager.getText().toString(),lastName_manager.getText().toString(),
                            email_manager.getText().toString(),userName_manager.getText().toString(),
                            password_manager.getText().toString()));
                    Toast.makeText(SignUPManager.this,"Successfully Signed Up", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignUPManager.this,"Error... Wrong CODE", Toast.LENGTH_SHORT).show();
                }

                firstName_manager.setText("");
                lastName_manager.setText("");
                email_manager.setText("");
                userName_manager.setText("");
                password_manager.setText("");
                validationCode.setText("");
            }
        });
    }
}
