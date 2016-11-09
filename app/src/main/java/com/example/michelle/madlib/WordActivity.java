package com.example.michelle.madlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

import static com.example.michelle.madlib.R.id.editText;

public class WordActivity extends AppCompatActivity {

    static final String STORY = "story";
    protected Story story;

    static final String[] supportMessages = {"You are doing great!", "Keep on going", "Good job!",
            "You are the best", "Amazing", "Don't give up"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        // get story from intent
        Bundle extras = getIntent().getExtras();
        story = (Story) extras.getSerializable(STORY);
        if (story != null) {
            // Go to story activity
            if (story.getPlaceholderCount() != story.getPlaceholderRemainingCount()) {
                Random rand = new Random();
                Toast.makeText(this, supportMessages[rand.nextInt(supportMessages.length)], Toast.LENGTH_SHORT).show();
            }
            if (story.getPlaceholderRemainingCount() <= 0) {
                Intent intent = new Intent(this, StoryActivity.class);
                intent.putExtra(STORY, story);
                startActivity(intent);
                finish();
            }
        } else {
            Toast.makeText(this, "I'm sorry, the author is still busy writing stories...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
            finish();
        }

        // TextView object that holds amount of words to go
        TextView wordCounter = (TextView)findViewById(R.id.TextViewWordCounter);
        if(story.getPlaceholderRemainingCount() > 1) {
            wordCounter.setText(story.getPlaceholderRemainingCount() + " words left!");
        } else {
            wordCounter.setText("Almost there! Enter the last word to finish your story...");
        }

        // Sets the hint of the EditText to the placeholder
        ((EditText) findViewById(R.id.editText)).setHint(story.getNextPlaceholder().toLowerCase());
    }

    // Called when the user presses the "ok" button
    public void ok(View view) {
        // get filled in word
        String text = ((EditText)findViewById(R.id.editText)).getText().toString();

        // check if filled in field is not empty
        if (text.length() > 0) {
            story.fillInPlaceholder(text);
            Intent intent = new Intent(WordActivity.this, WordActivity.class);
            intent.putExtra(STORY, story);
            startActivity(intent);
            finish();
        } else {
            // shows message when text is not filled in
            Toast.makeText(this, "Please fill in a word", Toast.LENGTH_SHORT).show();
        }
    }
}
