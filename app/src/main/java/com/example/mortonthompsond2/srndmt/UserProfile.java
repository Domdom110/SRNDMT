package com.example.mortonthompsond2.srndmt;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends Fragment {

    TextView name,add_stats,view_stats,view_workouts;
    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_user_profile, container, false);

        name = (TextView) rootView.findViewById(R.id.name);
        Intent intent = getActivity().getIntent();
        String username = intent.getStringExtra("username");
        logout = (Button) rootView.findViewById(R.id.logout);


        add_stats = (TextView) rootView.findViewById(R.id.addStats);
        view_stats = (TextView) rootView.findViewById(R.id.viewStats);
        view_workouts = (TextView) rootView.findViewById(R.id.viewWorkouts);

        name.setText(username);

        add_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), addStats.class);
                startActivity(intent);
            }
        });

        view_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(),viewStats.class);
                startActivity(intent);
            }
        });

        view_workouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(),viewWorkouts.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignINUser.class);
                startActivity(intent);
            }
        });



        return rootView;
    }
}
