package com.github.GitC0der.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        setContentView(R.layout.activity_greeting);
        TextView textView = findViewById(R.id.greetingMessage);
        textView.setText("Welcome " + username);
    }
}