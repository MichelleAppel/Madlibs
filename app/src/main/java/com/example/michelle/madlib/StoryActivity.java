package com.example.michelle.madlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class StoryActivity extends AppCompatActivity {

    static final String STORY = "story";
    protected Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Field where the story is going to be
        TextView textView_story = (TextView)findViewById(R.id.textView_story);

        // Get the story from the Story object and put it in TextView
        Bundle extras = getIntent().getExtras();
        story = (Story) extras.getSerializable(STORY);
        if (story != null) {
            textView_story.setText(story.toString());
        }
    }

    public void restart(View view) {
        // Go to welcome screen activity
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        finish();
    }
}
