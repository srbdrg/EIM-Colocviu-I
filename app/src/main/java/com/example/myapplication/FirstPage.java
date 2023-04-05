package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstPage extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    EditText first_edit_text;
    EditText second_edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        // take instances of things
        button1 = (Button) findViewById(R.id.button_show);
        button2 = (Button) findViewById(R.id.save);
        button3 = (Button) findViewById(R.id.cancel);
        first_edit_text = (EditText) findViewById(R.id.edittext1);
        second_edit_text = (EditText) findViewById(R.id.edittext2);

        //set  initial values

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("LEFT_COUNT")) {
                first_edit_text.setText(savedInstanceState.getString("LEFT_COUNT"));
            } else {
                first_edit_text.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("RIGHT_COUNT")) {
                second_edit_text.setText(savedInstanceState.getString("RIGHT_COUNT"));
            } else {
                second_edit_text.setText(String.valueOf(0));
            }
        } else {
            first_edit_text.setText(String.valueOf(0));
            second_edit_text.setText(String.valueOf(0));
        }


        // on click listeners
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SecondPage.class);
            int numberOfClicks = Integer.parseInt(first_edit_text.getText().toString()) +
                    Integer.parseInt(second_edit_text.getText().toString());
            intent.putExtra("NUMBER_OF_CLICKS", numberOfClicks);
            startActivityForResult(intent, 2);
        });

        button2.setOnClickListener(view -> {
            //increments first edittext
            int leftNumberOfClicks = Integer.parseInt(first_edit_text.getText().toString());
            leftNumberOfClicks++;
            first_edit_text.setText(String.valueOf(leftNumberOfClicks));
        });

        button3.setOnClickListener(view -> {
            //increments second edittext
            int rightNumberOfClicks = Integer.parseInt(second_edit_text.getText().toString());
            rightNumberOfClicks++;
            second_edit_text.setText(String.valueOf(rightNumberOfClicks));
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("LEFT_COUNT", first_edit_text.getText().toString());
        savedInstanceState.putString("RIGHT_COUNT", second_edit_text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("LEFT_COUNT")) {
            first_edit_text.setText(savedInstanceState.getString("LEFT_COUNT"));
        } else {
            first_edit_text.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("RIGHT_COUNT")) {
            second_edit_text.setText(savedInstanceState.getString("RIGHT_COUNT"));
        } else {
            second_edit_text.setText(String.valueOf(0));
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 2) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}