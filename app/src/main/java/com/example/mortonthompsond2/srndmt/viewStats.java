package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class viewStats extends AppCompatActivity
{
    TextView viewStats;
    String text;
    ProgressBar progressDaily;
    ProgressBar progressWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);

        viewStats = (TextView) findViewById(R.id.tvViewStats);
        progressDaily = (ProgressBar) findViewById(R.id.progressBar);
        progressWeek = (ProgressBar) findViewById(R.id.progressBar2);

        final statsDatabase db = new statsDatabase(this);

        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log = "\nDate: " + c.getFirstName() + "\nRepetitions: " + c.getLastName() + "\nAmount Of Weight: " + c.getEmail() + "\nNotes: " + c.getUserName()  + "\n                    ====== \n" ;
            text = text + log;


        }

        progressWeek.setProgress(2);
        progressDaily.setProgress(5);

        viewStats.setText(text);

    }
}
