package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final EditText editText=(EditText)findViewById(R.id.id);
        final EditText editText2=(EditText)findViewById(R.id.name);
        Button butto=(Button)findViewById(R.id.update);
        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= editText.getText().toString();
                String name= editText2.getText().toString();

                try {
                    user user = new user(getApplication());
                    user.update(id,name);
                    Toast.makeText(getApplication(), "Updated", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        });

    }
}
