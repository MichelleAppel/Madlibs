package com.example.michelle.madlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    // Called when the user presses the "Get started" button
    public void start(View view) {
        Intent intent = new Intent(WelcomeScreen.this, WordActivity.class);
        startActivity(intent);
    }

}
