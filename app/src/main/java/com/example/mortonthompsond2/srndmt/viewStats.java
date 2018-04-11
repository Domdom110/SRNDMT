package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class viewStats extends AppCompatActivity
{
    TextView viewStats;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);

        viewStats = (TextView) findViewById(R.id.tvViewStats);

        final statsDatabase db = new statsDatabase(this);

        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log = "\nDate: " + c.getFirstName() + "\nRepetitions: " + c.getLastName() + "\nAmount Of Weight: " + c.getEmail() + "\nNotes: " + c.getUserName()  + "\n                    ====== \n" ;
            text = text + log;
        }

        viewStats.setText(text);
    }
}
