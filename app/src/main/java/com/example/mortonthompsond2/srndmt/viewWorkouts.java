package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class viewWorkouts extends AppCompatActivity
{
    TextView view_workouts;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workouts);

        view_workouts = (TextView) findViewById(R.id.displayWorkouts);

        final DatabaseHelperPrefWorkouts db = new DatabaseHelperPrefWorkouts(this);

        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log = "\n" + "Name: " + c.getFirstName() + "\nDescription: " + c.getEmail() + "\n ======" ;
            text = text + log;
        }

        view_workouts.setText(text);
    }
}
