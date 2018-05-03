package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataTabThree extends AppCompatActivity {
    EditText name, type, description, address;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_tab_three);

        name = (EditText) findViewById(R.id.nametab3);
        type = (EditText) findViewById(R.id.Typetab3);
        description = (EditText) findViewById(R.id.Descriptiontab3);
        address = (EditText) findViewById(R.id.addresstab3);

        update = (Button) findViewById(R.id.updatetab3);
        final DatabaseHelperTabThree db = new DatabaseHelperTabThree(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.updateContact(name.getText().toString(),
                        type.getText().toString(),
                        description.getText().toString(),
                        address.getText().toString());

                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();

                name.setText("");
                type.setText("");
                description.setText("");
                address.setText("");

                finish();
            }
        });
    }
}
