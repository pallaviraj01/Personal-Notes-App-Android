package com.zeroone.personalnotes;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
//
//    private final List<Note_Model> notes;
//
//    public NoteAdapter(List<Note_Model> notes) {
//        this.notes = notes;
//    }
//
//    @NonNull
//    @Override
//    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
//        return new NoteViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
//        Note_Model note = notes.get(position);
//        holder.titleTextView.setText(note.getTitle());
//        holder.contentTextView.setText(note.getContent());
//        holder.dateTimeTextView.setText(note.getDateTime()); // Set date and time
//    }
//
//    @Override
//    public int getItemCount() {
//        return notes.size();
//    }
//
//    public static class NoteViewHolder extends RecyclerView.ViewHolder {
//        TextView titleTextView;
//        TextView contentTextView;
//        TextView dateTimeTextView;
//
//        NoteViewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.noteTitle);
//            contentTextView = itemView.findViewById(R.id.noteContent);
//            dateTimeTextView = itemView.findViewById(R.id.noteDateTime); // Initialize date and time TextView
//        }
//    }
//}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
//
//    private final List<Note_Model> notes;
//    private final OnNoteClickListener listener;
//
//    public NoteAdapter(List<Note_Model> notes, OnNoteClickListener listener) {
//        this.notes = notes;
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
//        return new NoteViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
//        Note_Model note = notes.get(position);
//        holder.titleTextView.setText(note.getTitle());
//        holder.contentTextView.setText(note.getContent());
//        holder.dateTimeTextView.setText(note.getDateTime()); // Set date and time
//
//        holder.itemView.setOnClickListener(v -> listener.onNoteClick(note));
//    }
//
//    @Override
//    public int getItemCount() {
//        return notes.size();
//    }
//
//    public static class NoteViewHolder extends RecyclerView.ViewHolder {
//        TextView titleTextView;
//        TextView contentTextView;
//        TextView dateTimeTextView;
//
//        NoteViewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.note_title);
//            contentTextView = itemView.findViewById(R.id.note_content);
//            dateTimeTextView = itemView.findViewById(R.id.noteDateTime); // Initialize date and time TextView
//        }
//    }
//
//    public interface OnNoteClickListener {
//        void onNoteClick(Note_Model note);
//    }
//}


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private final List<Note_Model> notes;
    private final OnNoteClickListener listener;

    public NoteAdapter(List<Note_Model> notes, OnNoteClickListener listener) {
        this.notes = notes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note_Model note = notes.get(position);
        holder.titleTextView.setText(note.getTitle());
        holder.contentTextView.setText(note.getContent());
        holder.dateTimeTextView.setText(note.getDateTime()); // Set date and time

        holder.itemView.setOnClickListener(v -> listener.onNoteClick(note));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentTextView;
        TextView dateTimeTextView;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.note_title);
            contentTextView = itemView.findViewById(R.id.note_content);
            dateTimeTextView = itemView.findViewById(R.id.noteDateTime); // Initialize date and time TextView
        }
    }

    public interface OnNoteClickListener {
        void onNoteClick(Note_Model note);
    }
}
