package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondPage extends AppCompatActivity {


    Button ok;
    Button notok;

    EditText edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);


        edit_text = (EditText) findViewById(R.id.edittext);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("NUMBER_OF_CLICKS")) {
            int numberOfClicks = intent.getIntExtra("NUMBER_OF_CLICKS", -1);
            edit_text.setText(String.valueOf(numberOfClicks));
        }

        ok = (Button) findViewById(R.id.ok);
        notok = (Button) findViewById(R.id.notok);

        ok.setOnClickListener(view -> {
            setResult(RESULT_OK);
            finish();
        });

        notok.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}