package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eth_nick on 1/25/2018.
 */

public class login extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        // DONT RETURN RIGHT AWAY
        final View myView = inflater.inflate(R.layout.login_fragment, container, false);

        final Button btnLogin = (Button) myView.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            //public static final String EXTRA_MESSAGE = "com.example.mortonthompsond2.srndmt.MESSAGE";
            @Override
            public void onClick(View v) {

                EditText etUsername = (EditText) myView.findViewById(R.id.etUsername);
                String username = (etUsername.getText().toString());

                EditText etPassword = (EditText) myView.findViewById(R.id.etPassword);
                String password = (etPassword.getText().toString());

                //if(username.isEmpty() || password.isEmpty()){
                  //Toast.makeText(getContext(), "Please enter a valid username and password", Toast.LENGTH_LONG).show();
                //} else {
                   //Toast.makeText(getContext(), "Enter User Account -->", Toast.LENGTH_LONG).show();
                //}

                //Intent workoutIntent = new Intent(getContext(), WorkoutsActivity.class);
                //String name = etUsername.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE ,name);
                //startActivity(workoutIntent);

            }
        });

        return myView;
    }
}
