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

public class signuptab extends Fragment
{
    Button signUpuser,signUpmanager;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.signuptab, container, false);

        signUpuser = (Button) rootView.findViewById(R.id.userSignup);
        signUpmanager = (Button) rootView.findViewById(R.id.managerSignup);

        signUpuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SignUPUser.class);
                startActivity(intent);
            }
        });

        signUpmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SignUPManager.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}