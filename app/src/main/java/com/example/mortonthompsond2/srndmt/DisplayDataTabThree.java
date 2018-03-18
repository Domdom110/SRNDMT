package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayDataTabThree extends AppCompatActivity {
    TextView updated;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_tab_three);

        updated = (TextView) findViewById(R.id.updatedtab3);

        final DatabaseHelperTabThree db = new DatabaseHelperTabThree(this);

        List<contact> contacts = db.getAllContacts();

        for(contact c : contacts)
        {
            String log = "First :" + c.getFirstName() + ", Last :" + c.getLastName() + ", Email :" + c.getEmail() + ", User :" + c.getUserName()  + "\n" ;
            text = text + log;
        }

        updated.setText(text);
    }
}
