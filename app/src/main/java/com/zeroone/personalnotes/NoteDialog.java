package com.zeroone.personalnotes;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
//
//public class NoteDialog extends DialogFragment {
//
//    private Note_Model note;
//    private NoteDatabaseHelper databaseHelper;
//
//    private EditText titleEditText;
//    private EditText contentEditText;
//    private ImageButton editButton;
//    private ImageButton saveButton;
//
//    private boolean isEditMode = false;
//
//    public NoteDialog(Context context, Note_Model note) {
//        this.note = note;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        databaseHelper = new NoteDatabaseHelper(requireContext());
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.dialog_note, container, false);
//
//        titleEditText = rootView.findViewById(R.id.editTitle);
//        contentEditText = rootView.findViewById(R.id.editContent);
//        TextView dateTimeTextView = rootView.findViewById(R.id.noteDateTime);
//        editButton = rootView.findViewById(R.id.editButton);
//        ImageButton deleteButton = rootView.findViewById(R.id.deleteButton);
//        saveButton = rootView.findViewById(R.id.saveButton);
//
//        // Set initial values
//        titleEditText.setText(note.getTitle());
//        contentEditText.setText(note.getContent());
//        dateTimeTextView.setText(note.getDateTime());
//
//        editButton.setOnClickListener(v -> toggleEditMode());
//
//        deleteButton.setOnClickListener(v -> {
//            databaseHelper.deleteNote(note.getId());
//            dismiss();
//        });
//
//        saveButton.setOnClickListener(v -> {
//            String newTitle = titleEditText.getText().toString().trim();
//            String newContent = contentEditText.getText().toString().trim();
//
//            if (!TextUtils.isEmpty(newTitle) && !TextUtils.isEmpty(newContent)) {
//                note.setTitle(newTitle);
//                note.setContent(newContent);
//                databaseHelper.updateNote(note.getId(), newTitle, newContent);
//                dismiss();
//            } else {
//                Toast.makeText(requireContext(), "Please enter title and content", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        toggleEditMode(); // Ensure correct mode on opening
//
//        return rootView;
//    }
//
//    private void toggleEditMode() {
//        isEditMode = !isEditMode;
//
//        if (isEditMode) {
//            titleEditText.setFocusableInTouchMode(true);
//            contentEditText.setFocusableInTouchMode(true);
//            saveButton.setVisibility(View.VISIBLE);
//            editButton.setImageResource(R.drawable.check); // Change icon to a check mark
//        } else {
//            titleEditText.setFocusable(false);
//            contentEditText.setFocusable(false);
//            saveButton.setVisibility(View.GONE);
//            editButton.setImageResource(R.drawable.editicon); // Change icon to edit pencil
//        }
//    }
//
//    @Override
//    public void onDismiss(@NonNull DialogInterface dialog) {
//        super.onDismiss(dialog);
//        // Handle any cleanup or actions when the dialog is dismissed
//    }
//}



public class NoteDialog extends DialogFragment {

    private Note_Model note;
    private NoteDatabaseHelper databaseHelper;
    private EditText titleEditText;
    private EditText contentEditText;
    private ImageButton editButton;
    private ImageButton saveButton;
    private ImageButton deleteButton;
    private NoteChangeListener noteChangeListener;

    public NoteDialog(Context context, Note_Model note, NoteChangeListener noteChangeListener) {
        this.note = note;
        this.noteChangeListener = noteChangeListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new NoteDatabaseHelper(requireContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_note, container, false);

        titleEditText = rootView.findViewById(R.id.editTitle);
        contentEditText = rootView.findViewById(R.id.editContent);
        TextView dateTimeTextView = rootView.findViewById(R.id.noteDateTime);
        editButton = rootView.findViewById(R.id.editButton);
        deleteButton = rootView.findViewById(R.id.deleteButton);
        saveButton = rootView.findViewById(R.id.saveButton);

        // Set initial values
        titleEditText.setText(note.getTitle());
        contentEditText.setText(note.getContent());
        dateTimeTextView.setText(note.getDateTime());

        // Disable editing initially
        titleEditText.setFocusable(false);
        contentEditText.setFocusable(false);

        // Set listeners
        editButton.setOnClickListener(v -> enableEditing());
        deleteButton.setOnClickListener(v -> {
            databaseHelper.deleteNote(note.getId());
            noteChangeListener.onNoteChanged();
            dismiss();
        });
        saveButton.setOnClickListener(v -> saveNoteChanges());

        return rootView;
    }

    private void enableEditing() {
        titleEditText.setFocusableInTouchMode(true);
        contentEditText.setFocusableInTouchMode(true);
        saveButton.setVisibility(View.VISIBLE);
        editButton.setVisibility(View.GONE);
    }

    private void saveNoteChanges() {
        String newTitle = titleEditText.getText().toString().trim();
        String newContent = contentEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(newTitle) && !TextUtils.isEmpty(newContent)) {
            note.setTitle(newTitle);
            note.setContent(newContent);
            databaseHelper.updateNote(note.getId(), newTitle, newContent);
            noteChangeListener.onNoteChanged();
            dismiss();
        } else {
            Toast.makeText(requireContext(), "Please enter title and content", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        // Handle any cleanup or actions when the dialog is dismissed
    }

    public interface NoteChangeListener {
        void onNoteChanged();
    }
}

