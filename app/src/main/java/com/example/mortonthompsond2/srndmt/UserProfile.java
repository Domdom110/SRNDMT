package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView name,add_stats,view_stats,view_workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = (TextView) findViewById(R.id.name);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        add_stats = (TextView) findViewById(R.id.addStats);
        view_stats = (TextView) findViewById(R.id.viewStats);
        view_workouts = (TextView) findViewById(R.id.viewWorkouts);

        name.setText(username);

        add_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserProfile.this,addStats.class);
                startActivity(intent);
            }
        });

        view_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserProfile.this,viewStats.class);
                startActivity(intent);
            }
        });

        view_workouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserProfile.this,viewWorkouts.class);
                startActivity(intent);
            }
        });
    }
}
