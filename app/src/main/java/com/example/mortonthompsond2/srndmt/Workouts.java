package com.example.mortonthompsond2.srndmt;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by mortonthompsond2 on 2/12/2018.
 */

public class Workouts extends Fragment{

    // Labels table name
    public static final String TABLE = "Workouts";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_type = "type";
    public static final String KEY_description = "description";

    // property help us to keep data
    public int workouts_ID;
    public String name;
    public String type;
    public String description;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        // DON"T RETURN RIGHT AWAY
        final View myView = inflater.inflate(R.layout.login_fragment, container, false);

        Button btnView = (Button) myView.findViewById(R.id.btnView);
        final RadioGroup rgMuscles = (RadioGroup) myView.findViewById(R.id.rgMuscles);
        final ImageView ivWorkout = (ImageView) myView.findViewById(R.id.ivWorkout);

        final Spinner spWorkouts = (Spinner) myView.findViewById(R.id.spWorkouts);

        btnView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int radioMuscle_id = rgMuscles.getCheckedRadioButtonId();

                if (radioMuscle_id == -1) {
                    Toast.makeText(getContext(), "Please select your meal choice", Toast.LENGTH_LONG).show();
                }
                else {

                    RadioButton muscleGroup = (RadioButton) myView.findViewById(radioMuscle_id);
                    int muscleIndex = rgMuscles.indexOfChild(muscleGroup);

                    if (muscleIndex == 0) {

                    }
                    if (muscleIndex == 1) {

                    }
                    if (muscleIndex == 2) {

                    }
                    if (muscleIndex == 3) {

                    }
                    if (muscleIndex == 4) {

                    }
                    if (muscleIndex == 5) {

                    }
                }
            }
        });

        return myView;
    }
}
