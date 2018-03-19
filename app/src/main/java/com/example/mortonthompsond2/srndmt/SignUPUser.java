package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPUser extends AppCompatActivity {
    EditText firstName_signup_user, lastName_signup_user, email_signup_user, userName_signup_user, password_signup_user;
    Button btn_signUP_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upuser);

        firstName_signup_user = (EditText) findViewById(R.id.firstname_sign_up_user);
        lastName_signup_user = (EditText) findViewById(R.id.lastname_sign_up_user);
        email_signup_user = (EditText) findViewById(R.id.email_sign_up_user);
        userName_signup_user = (EditText) findViewById(R.id.username_sign_up_user);
        password_signup_user = (EditText) findViewById(R.id.password_sign_up_user);

        btn_signUP_user = (Button) findViewById(R.id.btn_sign_up_user);

        final DatabaseHelper db = new DatabaseHelper(this);
        btn_signUP_user.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db.addContact(new contact(firstName_signup_user.getText().toString(),lastName_signup_user.getText().toString(),
                        email_signup_user.getText().toString(),userName_signup_user.getText().toString(),
                        password_signup_user.getText().toString()));
                Toast.makeText(SignUPUser.this,"Successfully Signed Up", Toast.LENGTH_SHORT).show();

                firstName_signup_user.setText("");
                lastName_signup_user.setText("");
                email_signup_user.setText("");
                userName_signup_user.setText("");
                password_signup_user.setText("");
            }
        }
        );
    }
}
