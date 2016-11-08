package com.example.michelle.madlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class WelcomeScreen extends AppCompatActivity {

    static final String STORY = "story";
    protected Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    // Called when the user presses the "Get started" button
    public void start(View view) {
        // Make a story object
        story = read_story("madlib0_simple");

        // Go to next activity
        Intent intent = new Intent(this, WordActivity.class);
        intent.putExtra(STORY, story);
        startActivity(intent);
    }

    // gets input stream from story file
    public Story read_story(String filename) {
        Story story = null;
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(filename + ".txt");
            story = new Story(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        return story;
    }
}
