package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mortonthompsond2.srndmt.R;
import com.example.mortonthompsond2.srndmt.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mortonthompsond2 on 3/6/2018.
 */

public class manager_data extends AppCompatActivity {

    TextView id;
    TextView name;
    TextView contact;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        //contact=(TextView)findViewById(R.id.contact);
        //name=(TextView)findViewById(R.id.name);
        //id=(TextView)findViewById(R.id.id);
        manager obj=new manager(this);
        //id.setText(Integer.toString(db.id));
        //name.setText(db.name);
        //contact.setText(db.contact);
        try {
            lv = (ListView) findViewById(R.id.listview);

            // Instanciating an array list (you don't need to do this,
            // you already have yours).
            List<String> your_array_list = new ArrayList<String>();
            your_array_list.add("foo");
            your_array_list.add("bar");

            // This is the array adapter, it takes the context of the activity as a
            // first parameter, the type of list view as a second parameter and your
            // array as a third parameter.
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    R.layout.item,
                    manager.data);

            lv.setAdapter(arrayAdapter);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
