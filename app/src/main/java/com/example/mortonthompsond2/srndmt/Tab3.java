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

public class Tab3 extends Fragment
{
    EditText Name, type, description, address;
    Button insert,delete,display,update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);
        Name = (EditText) rootView.findViewById(R.id.nametab3);
        type = (EditText) rootView.findViewById(R.id.Typetab3);
        description = (EditText) rootView.findViewById(R.id.Descriptiontab3);
        address = (EditText) rootView.findViewById(R.id.addresstab3);

        insert = (Button) rootView.findViewById(R.id.inserttab3);
        delete = (Button) rootView.findViewById(R.id.Deletetab3);
        display = (Button) rootView.findViewById(R.id.viewtab3);
        update = (Button) rootView.findViewById(R.id.updatetab3);

        final DatabaseHelperTabThree db = new DatabaseHelperTabThree(getContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.addContact(new contact(Name.getText().toString(),type.getText().toString(),description.getText().toString(),address.getText().toString()));
                Toast.makeText(getContext(),"Successfully Inserted", Toast.LENGTH_SHORT).show();

                Name.setText("");
                type.setText("");
                description.setText("");
                address.setText("");


            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DisplayDataTabThree.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DeleteDataTabeThree.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),UpdateDataTabThree.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
