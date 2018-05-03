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
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class AllWorkouts extends Fragment {

    ImageView workoutImage;
    String ytc;
    String text;
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

        final DatabaseHelperTabThree db = new DatabaseHelperTabThree(getContext());
        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log =c.getFirstName() + "\n" + c.getLastName() + "\n" + c.getEmail() + "\n" + c.getUserName()  + "\n ====== \n" ;
            text = text + log;
        }

        //Fill array of workouts from preferences -- Dummy Information will be filled for now
        //String[] workoutNames = {"Chest: Bench Press","Chest: Cable Flyes", "Back: Close Grip Rows", "Back: Wide Grip Rows", "Back: Delt Flys", "Legs: Squats", "Legs: Leg Press"};

        List<String> workoutNames = new LinkedList<>();
        final List<String> imageList = new LinkedList<>();
        final List<String> youtubeList = new LinkedList<>();
        final List<String> descriptionList = new LinkedList<>();

        for(contact c : contacts) {
            workoutNames.add(c.getFirstName());
            imageList.add(c.getUserName());
            youtubeList.add(c.getLastName());
            descriptionList.add(c.getEmail());


            Toast.makeText(getContext(), youtubeList.get(0).toString(), Toast.LENGTH_SHORT).show();
        }

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
                    int index = spWorkouts.getSelectedItemPosition();
                    int id = context.getResources().getIdentifier(imageList.get(index), "drawable",
                            context.getPackageName());
                    workoutImage.setImageResource(id);
                    workoutImage.setScaleType(ImageView.ScaleType.FIT_XY);
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
                /*if(spWorkouts.getSelectedItem().equals("Chest: Bench Press")) {
                    ytc = "9l9guSIjnZY";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ytc)));
                }
                if(spWorkouts.getSelectedItem().equals("Chest: Cable Flyes")) {
                    ytc = "UP8XGKt4-1c";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ytc)));
                }*/
                int index = spWorkouts.getSelectedItemPosition();
                ytc = youtubeList.get(index).toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ytc)));
            }
        });

        //final DatabaseHelperTabThree db = new DatabaseHelperTabThree(getContext());
        final DatabaseHelperPrefWorkouts dbPref = new DatabaseHelperPrefWorkouts(getContext());
        addToPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add Code here to reflect change in UserProfile class
                int index = spWorkouts.getSelectedItemPosition();

                String name = spWorkouts.getSelectedItem().toString();
                String imageFile = imageList.get(index).toString();
                String videoCode = youtubeList.get(index);
                String description = descriptionList.get(index);

                dbPref.addContact(new contact(name,videoCode,description,imageFile));

                        //String name = workoutImage.().toString();
                        Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getContext(),"Updated",Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}
