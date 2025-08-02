package com.zeroone.personalnotes.menu_slider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeroone.personalnotes.R;

//public class NoteFragment extends Fragment {
//
//    private EditText noteTitleEditText;
//    private EditText noteContentEditText;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.activity_note, container, false);
//
//        noteTitleEditText = rootView.findViewById(R.id.noteTitle);
//        noteContentEditText = rootView.findViewById(R.id.noteContent);
//
//        // Load saved note data if available
//        if (savedInstanceState != null) {
//            String savedTitle = savedInstanceState.getString("title");
//            String savedContent = savedInstanceState.getString("content");
//            noteTitleEditText.setText(savedTitle);
//            noteContentEditText.setText(savedContent);
//        }
//
//        return rootView;
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        // Save note data before configuration changes
//        String title = noteTitleEditText.getText().toString();
//        String content = noteContentEditText.getText().toString();
//        outState.putString("title", title);
//        outState.putString("content", content);
//    }
//
//    public void saveNote() {
//        // Implement your logic to save the note data permanently here (e.g., to a database)
//        // For demonstration, you can use SharedPreferences or SQLite database to save notes
//    }
//}
