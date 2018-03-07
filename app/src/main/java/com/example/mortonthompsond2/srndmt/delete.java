package com.example.mortonthompsond2.srndmt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        final EditText editText=(EditText)findViewById(R.id.del);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String a= editText.getText().toString();
               try {
                   user user = new user(getApplication());
                   user.delete(a);
                   Toast.makeText(getApplication(), "Deleted", Toast.LENGTH_SHORT).show();
               }
               catch (Exception e)
               {
                   e.printStackTrace();
               }
            }
        });
    }
}
