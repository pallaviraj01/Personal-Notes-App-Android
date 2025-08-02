package com.zeroone.personalnotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {

    private EditText noteTitleEditText;
    private EditText noteContentEditText;
    private NoteDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        // Initialize database helper
        dbHelper = new NoteDatabaseHelper(this);

        // Initialize EditText fields
        noteTitleEditText = findViewById(R.id.noteTitle);
        noteContentEditText = findViewById(R.id.noteContent);

        // Load saved note data if available
        if (savedInstanceState != null) {
            String savedTitle = savedInstanceState.getString("title");
            String savedContent = savedInstanceState.getString("content");
            noteTitleEditText.setText(savedTitle);
            noteContentEditText.setText(savedContent);
        }

        findViewById(R.id.save).setOnClickListener(v -> {
            saveNote();
            finish();
        });

        findViewById(R.id.backButton).setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save note data before configuration changes
        String title = noteTitleEditText.getText().toString();
        String content = noteContentEditText.getText().toString();
        outState.putString("title", title);
        outState.putString("content", content);
    }

    private void saveNote() {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(NoteDatabaseHelper.COLUMN_TITLE, noteTitleEditText.getText().toString());
        values.put(NoteDatabaseHelper.COLUMN_CONTENT, noteContentEditText.getText().toString());

        // Get current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String dateTime = dateFormat.format(new Date());

        // Save note data to database (example)
        NoteDatabaseHelper dbHelper = new NoteDatabaseHelper(this);
        long id = dbHelper.insertNote(noteTitleEditText.getText().toString(),
                noteContentEditText.getText().toString()
        ); // Insert note with date and time


        // Close the database connection
        dbHelper.close();
        Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
