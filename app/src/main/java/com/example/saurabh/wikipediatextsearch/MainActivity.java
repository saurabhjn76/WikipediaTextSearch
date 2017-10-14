package com.example.saurabh.wikipediatextsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText)findViewById(R.id.etID);
    }
    public void btnSubmit_Onclick(View v)
    {
        String data= etID.getText().toString();
    }

}
