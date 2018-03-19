package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignINUser extends AppCompatActivity {
    EditText et_username_user, et_password_user;
    Button signInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_inuser);

        final DatabaseHelper db = new DatabaseHelper(this);

        signInUser = (Button) findViewById(R.id.sign_in_user);
        signInUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_username_user = (EditText) findViewById(R.id.username_signin_user);
                final String user_name = et_username_user.getText().toString();
                et_password_user = (EditText) findViewById(R.id.password_signin_user);
                final String password = et_password_user.getText().toString();

                String pass_word = db.searchPassword(user_name);
                if (!user_name.isEmpty() && !password.isEmpty()) {
                    if (password.equals(pass_word)) {
                        Intent intent = new Intent(SignINUser.this, UserProfile.class);
                        Toast.makeText(SignINUser.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
                        intent.putExtra("username",user_name);
                        startActivity(intent);

                        et_username_user.setText("");
                        et_password_user.setText("");
                    } else {
                        Toast.makeText(SignINUser.this, "User name and password don't match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignINUser.this, "Fill Empty Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
