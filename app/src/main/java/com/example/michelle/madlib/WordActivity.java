package com.example.michelle.madlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;

public class WordActivity extends AppCompatActivity {

    static final String STORY = "story";
    protected Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        Bundle extras = getIntent().getExtras();
        story = (Story) extras.getSerializable(STORY);

        if (story != null) {
            // Restore value of members from saved state
            TextView wordCounter = (TextView)findViewById(R.id.TextViewWordCounter);
            wordCounter.setText("Nog 5");
        } else {
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
            finish();
        }
    }

    public void ok(View view) {
        Intent intent = new Intent(WordActivity.this, WordActivity.class);
        startActivity(intent);
        finish();
    }
}
