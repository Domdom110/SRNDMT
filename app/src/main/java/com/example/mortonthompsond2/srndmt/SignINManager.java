package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignINManager extends AppCompatActivity {
    EditText et_username_manager, et_password_manager;
    Button signInManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_inmanager);

        final DatabaseHelperTabTwo db = new DatabaseHelperTabTwo(this);

        signInManager = (Button) findViewById(R.id.sign_in_manager);
        signInManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_username_manager = (EditText) findViewById(R.id.username_signin_manager);
                final String user_name = et_username_manager.getText().toString();
                et_password_manager = (EditText) findViewById(R.id.password_signin_manager);
                final String password = et_password_manager.getText().toString();

                String pass_word = db.searchPassword(user_name);
                if (!user_name.isEmpty() && !password.isEmpty()) {
                    if (password.equals(pass_word)) {
                        Intent intent = new Intent(SignINManager.this, MainActivity.class);
                        Toast.makeText(SignINManager.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                        et_username_manager.setText("");
                        et_password_manager.setText("");
                    } else {
                        Toast.makeText(SignINManager.this, "User name and password don't match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignINManager.this, "Fill Empty Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
