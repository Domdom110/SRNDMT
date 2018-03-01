package com.example.mortonthompsond2.srndmt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

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

        return myView;
    }
}
