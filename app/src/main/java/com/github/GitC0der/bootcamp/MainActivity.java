package com.github.GitC0der.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static EditText greetingEditText;
    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches the button */
    public void transitionToGreetingActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, GreetingActivity.class);

        greetingEditText = findViewById(R.id.mainName);
        String greeting = greetingEditText.getText().toString();

        myIntent.putExtra(USERNAME, greeting);
        MainActivity.this.startActivity(myIntent);
    }
}