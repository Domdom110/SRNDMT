package com.example.mortonthompsond2.srndmt;

/**
 * Created by mortonthompsond2 on 3/17/2018.
 */
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2 extends Fragment
{
    EditText firstName, lastName, email, userName, password;
    Button insert,delete,display,update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);

        firstName = (EditText) rootView.findViewById(R.id.firstnametab2);
        lastName = (EditText) rootView.findViewById(R.id.lastnametab2);
        email = (EditText) rootView.findViewById(R.id.emailtab2);
        userName = (EditText) rootView.findViewById(R.id.usernametab2);
        password = (EditText) rootView.findViewById(R.id.passwordtab2);

        insert = (Button) rootView.findViewById(R.id.inserttab2);
        delete = (Button) rootView.findViewById(R.id.Deletetab2);
        display = (Button) rootView.findViewById(R.id.viewtab2);
        update = (Button) rootView.findViewById(R.id.updatetab2);

        final DatabaseHelperTabTwo db = new DatabaseHelperTabTwo(getContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.addContact(new contact(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString(),userName.getText().toString(),password.getText().toString()));
                Toast.makeText(getContext(),"Successfully Inserted", Toast.LENGTH_SHORT).show();

                firstName.setText("");
                lastName.setText("");
                email.setText("");
                userName.setText("");
                password.setText("");


            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DisplayDataTabTwo.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DeleteDataTabTwo.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),UpdateDataTabTwo.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
