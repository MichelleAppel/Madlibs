package com.example.michelle.madlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

    public void ok(View view) {
        Intent intent = new Intent(WordActivity.this, WordActivity.class);
        startActivity(intent);
        finish();
    }
}
