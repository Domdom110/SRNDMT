package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addStats extends AppCompatActivity
{
    EditText add_date, add_repetitions, add_amount, add_notes;
    Button insert_stats;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stats);


        add_date = (EditText) findViewById(R.id.addDate);
        add_repetitions = (EditText) findViewById(R.id.addRepetitions);
        add_amount = (EditText) findViewById(R.id.amountOfWeight);
        add_notes = (EditText) findViewById(R.id.addNotes);

        insert_stats = (Button) findViewById(R.id.btn_add_stats);

        final statsDatabase db = new statsDatabase(getApplicationContext());

        String[] workoutNames = {"Chest: Bench Press","Chest: Cable Flyes", "Back: Close Grip Rows", "Back: Wide Grip Rows", "Back: Delt Flys", "Legs: Squats", "Legs: Leg Press"};
        //Create spinner and array adapter to fill spinner with workoutNames array
        final Spinner spWorkouts = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> aaWorkouts = new ArrayAdapter<String>(getApplicationContext(),   android.R.layout.simple_spinner_item, workoutNames);
        aaWorkouts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spWorkouts.setAdapter(aaWorkouts);

        insert_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.addContact(new contact(add_date.getText().toString(),add_repetitions.getText().toString(),add_amount.getText().toString(),add_notes.getText().toString()));
                Toast.makeText(getApplicationContext(),"Successfully Inserted", Toast.LENGTH_SHORT).show();

                add_date.setText("");
                add_repetitions.setText("");
                add_amount.setText("");
                add_notes.setText("");



            }
        });
    }
}
