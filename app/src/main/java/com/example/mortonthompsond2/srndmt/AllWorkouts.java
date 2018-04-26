package com.example.mortonthompsond2.srndmt;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class AllWorkouts extends Fragment {

    ImageView workoutImage;
    //TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_allworkouts, container, false);

        //Declare all objects to be accessed later
        Button showVideoBtn = (Button) rootView.findViewById(R.id.showVideoBtn);
        Button addToPreferences = (Button) rootView.findViewById(R.id.addBtn);
        TextView name = (TextView) rootView.findViewById(R.id.txtViewGuest);
        Intent intent = getActivity().getIntent();
        String username = intent.getStringExtra("username");
        workoutImage = (ImageView) rootView.findViewById(R.id.workoutImage);
        final String youtube = "Youtube URL: www.youtube.com/watch?v=";
        name.setText(username);

        //Fill array of workouts from preferences -- Dummy Information will be filled for now
        String[] workoutNames = {"Chest: Bench Press","Chest: Cable Flyes", "Back: Close Grip Rows", "Back: Wide Grip Rows", "Back: Delt Flys", "Legs: Squats", "Legs: Leg Press"};
        //Create spinner and array adapter to fill spinner with workoutNames array
        final Spinner spWorkouts = (Spinner) rootView.findViewById(R.id.spWorkouts);

        ArrayAdapter<String> aaWorkouts = new ArrayAdapter<String>(getContext(),   android.R.layout.simple_spinner_item, workoutNames);
        aaWorkouts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spWorkouts.setAdapter(aaWorkouts);

        //Whenever spinner value is changed
        spWorkouts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    Context context = workoutImage.getContext();
                    if(spWorkouts.getSelectedItem().equals("Chest: Bench Press")) {
                        int id = context.getResources().getIdentifier("bench_press", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Chest: Cable Flyes")) {
                        int id = context.getResources().getIdentifier("cable_flyes", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Back: Close Grip Rows")) {
                        int id = context.getResources().getIdentifier("back_closegrip_rows", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Back: Wide Grip Rows")) {
                        int id = context.getResources().getIdentifier("back_widegrip_rows", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Back: Delt Flys")) {
                        int id = context.getResources().getIdentifier("back_delt_flyes", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Legs: Squats")) {
                        int id = context.getResources().getIdentifier("legs_squats", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                    if(spWorkouts.getSelectedItem().equals("Legs: Leg Press")) {
                        int id = context.getResources().getIdentifier("legs_legpress", "drawable",
                                context.getPackageName());
                        workoutImage.setImageResource(id);
                        workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        //Toast.makeText(getBaseContext(), "Spinner Change Works", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    //If there is an error, create toast
                    Toast.makeText(getContext(), "Error in Spinner Change", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        showVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spWorkouts.getSelectedItem().equals("Chest: Bench Press")) {
                    String ytc = "9l9guSIjnZY";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ytc)));
                }
                if(spWorkouts.getSelectedItem().equals("Chest: Cable Flyes")) {
                    String ytc = "UP8XGKt4-1c";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ytc)));
                }
            }
        });
        addToPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add Code here to reflect change in UserProfile class
            }
        });
        return rootView;
    }
}
