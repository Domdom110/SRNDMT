package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mortonthompsond2 on 3/19/2018.
 */

public class signintab extends Fragment
{
    Button signInuser,signInmanager, guest;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.signintab, container, false);

        signInuser = (Button) rootView.findViewById(R.id.userSignin);
        signInmanager = (Button) rootView.findViewById(R.id.managerSignin);
        guest = (Button) rootView.findViewById(R.id.btnGuest);

        signInuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SignINUser.class);
                startActivity(intent);
            }
        });

        signInmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SignINManager.class);
                startActivity(intent);
            }
        });

        guest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AllWorkouts.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}