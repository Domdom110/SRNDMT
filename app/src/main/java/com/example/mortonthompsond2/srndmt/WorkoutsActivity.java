package com.example.mortonthompsond2.srndmt;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ryan on 2/27/18.
 */

public class WorkoutsActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.workouts_fragment, container, false);
        //https://developer.android.com/reference/android/support/constraint/ConstraintSet.html
        //Documentation for Constraint Sets
        ConstraintSet mConstraintSet1 = new ConstraintSet(); //create the constraint set
        ConstraintLayout mConstraintLayout = (ConstraintLayout) myView.findViewById(R.id.constraints); //cache the Constraint Layout

        //mConstraintSet1.addToVerticalChain();

        //This is where we will populate the Activity with images based on the number needed, provided from the database
        //10 is a placeholder
        for(int i=0;i<10;i++) {
            ImageView image = new ImageView(getContext());
            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80,60));
            image.setMaxHeight(20);
            image.setMaxWidth(20);
            image.setBackgroundResource(R.drawable.ic_launcher_foreground);
            //Adds the view to the layout
            mConstraintLayout.addView(image);
        }




        return inflater.inflate(R.layout.workouts_fragment, container, false);
    }
}
