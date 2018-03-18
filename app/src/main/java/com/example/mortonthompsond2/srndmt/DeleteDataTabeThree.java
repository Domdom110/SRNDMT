package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteDataTabeThree extends AppCompatActivity {
    EditText first_name;
    Button dataDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data_tabe_three);

        first_name = (EditText) findViewById(R.id.deleteDatatabthree);
        dataDelete = (Button) findViewById(R.id.delete_datatabthree);

        final DatabaseHelperTabThree db = new DatabaseHelperTabThree(getApplicationContext());
        dataDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteContact(first_name.getText().toString());
                Toast.makeText(getApplication(), "Deleted", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
