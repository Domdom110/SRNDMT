package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = (TextView) findViewById(R.id.name);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        name.setText(username);
    }
}
