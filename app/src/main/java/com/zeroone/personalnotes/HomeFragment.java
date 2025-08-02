package com.zeroone.personalnotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

//public class HomeFragment extends Fragment implements NoteAdapter.OnNoteClickListener {
//
//    private NoteAdapter noteAdapter;
//    private List<Note_Model> noteList;
//    private NoteDatabaseHelper dbHelper;
//
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Initialize database helper
//        dbHelper = new NoteDatabaseHelper(requireContext());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.activity_main, container, false);
//
//        // Set the title for the fragment
//        requireActivity().setTitle(R.string.homepage);
//
//        // Initialize RecyclerView
//        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
//
//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_spacing);
//        recyclerView.addItemDecoration(new ItemOffsetDecoration(spacingInPixels));
//
//        // Initialize note list and adapter
//        noteList = new ArrayList<>();
//        noteAdapter = new NoteAdapter(noteList, this);
//        recyclerView.setAdapter(noteAdapter);
//
//        // Load notes from SQLite
//        loadNotes();
//
//        // Floating action button to add a new note
//        FloatingActionButton fab = rootView.findViewById(R.id.fab);
//        fab.setOnClickListener(view -> {
//            // Handle the click event to add a new note.
//            // Open NoteActivity to add a new note
//            startActivity(new Intent(getActivity(), NoteActivity.class));
//        });
//
//        return rootView;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        loadNotes(); // Reload notes when fragment resumes
//    }
//
//    private void loadNotes() {
//        // Clear existing list
//        noteList.clear();
//
//        // Gets the data repository in read mode
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                NoteDatabaseHelper.COLUMN_ID,
//                NoteDatabaseHelper.COLUMN_TITLE,
//                NoteDatabaseHelper.COLUMN_CONTENT,
//                NoteDatabaseHelper.COLUMN_DATE_TIME
//        };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder = NoteDatabaseHelper.COLUMN_DATE_TIME + " DESC";
//
//        Cursor cursor = db.query(
//                NoteDatabaseHelper.TABLE_NOTES,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                null,              // The columns for the WHERE clause
//                null,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//        while (cursor.moveToNext()) {
//            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_ID));
//            String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_TITLE));
//            String content = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_CONTENT));
//            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_DATE_TIME)); // Retrieve date and time
//
//            // Create Note_Model object and add to list
//            Note_Model note = new Note_Model(itemId, title, content, dateTime);
//            noteList.add(note);
//        }
//        cursor.close();
//        dbHelper.close();
//
//        // Notify adapter about data changes
//        noteAdapter.notifyDataSetChanged();
//    }
//
//
//    @Override
//    public void onNoteClick(Note_Model note) {
//        // Handle click on a note (open dialog or other actions)
//        NoteDialog noteDialog = new NoteDialog(requireContext(), note);
//        noteDialog.show(getParentFragmentManager(), "note_dialog");
//    }
//}


//public class HomeFragment extends Fragment implements NoteAdapter.OnNoteClickListener {
//
//    private NoteAdapter noteAdapter;
//    private List<Note_Model> noteList;
//    private NoteDatabaseHelper dbHelper;
//
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Initialize database helper
//        dbHelper = new NoteDatabaseHelper(requireContext());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.activity_main, container, false);
//
//        // Set the title for the fragment
//        requireActivity().setTitle(R.string.homepage);
//
//        // Initialize RecyclerView
//        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
//
//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_spacing);
//        recyclerView.addItemDecoration(new ItemOffsetDecoration(spacingInPixels));
//
//        // Initialize note list and adapter
//        noteList = new ArrayList<>();
//        noteAdapter = new NoteAdapter(noteList, this);
//        recyclerView.setAdapter(noteAdapter);
//
//        // Load notes from SQLite
//        loadNotes();
//
//        // Floating action button to add a new note
//        FloatingActionButton fab = rootView.findViewById(R.id.fab);
//        fab.setOnClickListener(view -> {
//            // Handle the click event to add a new note.
//            // Open NoteActivity to add a new note
//            startActivity(new Intent(getActivity(), NoteActivity.class));
//        });
//
//        return rootView;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        loadNotes(); // Reload notes when fragment resumes
//    }
//
//    private void loadNotes() {
//        // Get the existing note IDs to detect changes
//        List<Long> existingNoteIds = new ArrayList<>();
//        for (Note_Model note : noteList) {
//            existingNoteIds.add(note.getId());
//        }
//
//        // Gets the data repository in read mode
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                NoteDatabaseHelper.COLUMN_ID,
//                NoteDatabaseHelper.COLUMN_TITLE,
//                NoteDatabaseHelper.COLUMN_CONTENT,
//                NoteDatabaseHelper.COLUMN_DATE_TIME
//        };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder = NoteDatabaseHelper.COLUMN_DATE_TIME + " DESC";
//
//        Cursor cursor = db.query(
//                NoteDatabaseHelper.TABLE_NOTES,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                null,              // The columns for the WHERE clause
//                null,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//        List<Note_Model> newNotes = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_ID));
//            String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_TITLE));
//            String content = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_CONTENT));
//            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_DATE_TIME)); // Retrieve date and time
//
//            // Create Note_Model object and add to new notes list
//            Note_Model note = new Note_Model(itemId, title, content, dateTime);
//            newNotes.add(note);
//        }
//        cursor.close();
//        dbHelper.close();
//
//        // Detect changes and notify the adapter accordingly
//        detectChanges(existingNoteIds, newNotes);
//
//        // Update the note list
//        noteList.clear();
//        noteList.addAll(newNotes);
//    }
//
//    private void detectChanges(List<Long> existingNoteIds, List<Note_Model> newNotes) {
//        List<Long> newNoteIds = new ArrayList<>();
//        for (Note_Model note : newNotes) {
//            newNoteIds.add(note.getId());
//        }
//
//        // Find notes that were removed
//        for (int i = existingNoteIds.size() - 1; i >= 0; i--) {
//            long id = existingNoteIds.get(i);
//            if (!newNoteIds.contains(id)) {
//                noteAdapter.notifyItemRemoved(i);
//            }
//        }
//
//        // Find notes that were added or changed
//        for (int i = 0; i < newNotes.size(); i++) {
//            Note_Model newNote = newNotes.get(i);
//            if (!existingNoteIds.contains(newNote.getId())) {
//                noteAdapter.notifyItemInserted(i);
//            } else {
//                int oldIndex = existingNoteIds.indexOf(newNote.getId());
//                if (!newNote.equals(noteList.get(oldIndex))) {
//                    noteAdapter.notifyItemChanged(i);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onNoteClick(Note_Model note) {
//        // Handle click on a note (open dialog or other actions)
//        NoteDialog noteDialog = new NoteDialog(requireContext(), note);
//        noteDialog.show(getParentFragmentManager(), "note_dialog");
//    }
//}


public class HomeFragment extends Fragment implements NoteAdapter.OnNoteClickListener {

    private NoteAdapter noteAdapter;
    private List<Note_Model> noteList;
    private NoteDatabaseHelper dbHelper;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize database helper
        dbHelper = new NoteDatabaseHelper(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        // Set the title for the fragment
        requireActivity().setTitle(R.string.homepage);

        // Initialize RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_spacing);
        recyclerView.addItemDecoration(new ItemOffsetDecoration(spacingInPixels));

        // Initialize note list and adapter
        noteList = new ArrayList<>();
        noteAdapter = new NoteAdapter(noteList, this);
        recyclerView.setAdapter(noteAdapter);

        // Load notes from SQLite
        loadNotes();

        // Floating action button to add a new note
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // Handle the click event to add a new note.
            // Open NoteActivity to add a new note
            startActivity(new Intent(getActivity(), NoteActivity.class));
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadNotes(); // Reload notes when fragment resumes
    }

    private void loadNotes() {
        // Get the existing note IDs to detect changes
        List<Long> existingNoteIds = new ArrayList<>();
        for (Note_Model note : noteList) {
            existingNoteIds.add(note.getId());
        }

        // Gets the data repository in read mode
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                NoteDatabaseHelper.COLUMN_ID,
                NoteDatabaseHelper.COLUMN_TITLE,
                NoteDatabaseHelper.COLUMN_CONTENT,
                NoteDatabaseHelper.COLUMN_DATE_TIME
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = NoteDatabaseHelper.COLUMN_DATE_TIME + " DESC";

        Cursor cursor = db.query(
                NoteDatabaseHelper.TABLE_NOTES,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List<Note_Model> newNotes = new ArrayList<>();
        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_CONTENT));
            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_DATE_TIME)); // Retrieve date and time

            // Create Note_Model object and add to new notes list
            Note_Model note = new Note_Model(itemId, title, content, dateTime);
            newNotes.add(note);
        }
        cursor.close();
        dbHelper.close();

        // Detect changes and notify the adapter accordingly
        detectChanges(existingNoteIds, newNotes);

        // Update the note list
        noteList.clear();
        noteList.addAll(newNotes);
        noteAdapter.notifyDataSetChanged();
    }

    private void detectChanges(List<Long> existingNoteIds, List<Note_Model> newNotes) {
        List<Long> newNoteIds = new ArrayList<>();
        for (Note_Model note : newNotes) {
            newNoteIds.add(note.getId());
        }

        // Find notes that were removed
        for (int i = existingNoteIds.size() - 1; i >= 0; i--) {
            long id = existingNoteIds.get(i);
            if (!newNoteIds.contains(id)) {
                noteAdapter.notifyItemRemoved(i);
            }
        }

        // Find notes that were added or changed
        for (int i = 0; i < newNotes.size(); i++) {
            Note_Model newNote = newNotes.get(i);
            if (!existingNoteIds.contains(newNote.getId())) {
                noteAdapter.notifyItemInserted(i);
            } else {
                int oldIndex = existingNoteIds.indexOf(newNote.getId());
                if (!newNote.equals(noteList.get(oldIndex))) {
                    noteAdapter.notifyItemChanged(i);
                }
            }
        }
    }

    @Override
    public void onNoteClick(Note_Model note) {
        // Handle click on a note (open dialog or other actions)
        NoteDialog noteDialog = new NoteDialog(requireContext(), note, this::onNoteChanged);
        noteDialog.show(getParentFragmentManager(), "note_dialog");
    }

    private void onNoteChanged() {
        loadNotes();
    }
}




