package com.example.mortonthompsond2.srndmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DisplayDataTabTwo extends AppCompatActivity {
    TextView updated;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_tab_two);

        updated = (TextView) findViewById(R.id.updatedtab2);

        final DatabaseHelperTabTwo db = new DatabaseHelperTabTwo(this);

        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log = "First :" + c.getFirstName() + ", Last :" + c.getLastName() + ", Email :" + c.getEmail() + ", User :" + c.getUserName() + ", Password :" + c.getPassword() + "\n" ;
            text = text + log;
        }

        updated.setText(text);

    }
}
