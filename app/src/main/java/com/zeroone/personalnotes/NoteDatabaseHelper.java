package com.zeroone.personalnotes;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//public class NoteDatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "notes.db";
//    private static final int DATABASE_VERSION = 2;
//
//    // Table name and column names
//    public static final String TABLE_NOTES = "notes";
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_TITLE = "title";
//    public static final String COLUMN_CONTENT = "content";
//    public static final String COLUMN_DATE_TIME = "date_time";
//
//    // SQL query to create the notes table
//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + TABLE_NOTES + " (" +
//                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    COLUMN_TITLE + " TEXT," +
//                    COLUMN_CONTENT + " TEXT," +
//                    COLUMN_DATE_TIME + " TEXT)";
//
//    public NoteDatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(SQL_CREATE_ENTRIES);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop existing table if it exists
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
//        // Create table again
//        onCreate(db);
//    }
//
//    public long insertNote(String title, String content) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, title);
//        values.put(COLUMN_CONTENT, content);
//        // Add current date and time to ContentValues
//        String dateTime = getCurrentDateTime();
//        values.put(COLUMN_DATE_TIME, dateTime);
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId = db.insert(TABLE_NOTES, null, values);
//
//        db.close(); // Close the database connection
//
//        return newRowId;
//    }
//
//    public void updateNote(int id, String title, String content) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, title);
//        values.put(COLUMN_CONTENT, content);
//        db.update(TABLE_NOTES, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//    }
//
//    public List<Note_Model> getAllNotes() {
//        List<Note_Model> notes = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] projection = {
//                COLUMN_ID,
//                COLUMN_TITLE,
//                COLUMN_CONTENT,
//                COLUMN_DATE_TIME
//        };
//
//        String sortOrder = COLUMN_DATE_TIME + " DESC";
//
//        Cursor cursor = db.query(
//                TABLE_NOTES,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//        );
//
//        while (cursor.moveToNext()) {
//            long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
//            String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
//            String content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT));
//            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_TIME));
//            Note_Model note = new Note_Model(id, title, content, dateTime);
//            notes.add(note);
//        }
//        cursor.close();
//        db.close();
//        return notes;
//    }
//
//    private String getCurrentDateTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        return sdf.format(new Date());
//    }
//
//    public void deleteNote(int id) {
//
//    }
//}



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 2;

    // Table name and column names
    public static final String TABLE_NOTES = "notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_DATE_TIME = "date_time";

    // SQL query to create the notes table
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_CONTENT + " TEXT," +
                    COLUMN_DATE_TIME + " TEXT)";

    public NoteDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        // Create table again
        onCreate(db);
    }

    public long insertNote(String title, String content) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_CONTENT, content);
        // Add current date and time to ContentValues
        String dateTime = getCurrentDateTime();
        values.put(COLUMN_DATE_TIME, dateTime);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NOTES, null, values);

        db.close(); // Close the database connection

        return newRowId;
    }

    public void updateNote(long id, String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_CONTENT, content);
        db.update(TABLE_NOTES, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Note_Model> getAllNotes() {
        List<Note_Model> notes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_CONTENT,
                COLUMN_DATE_TIME
        };

        String sortOrder = COLUMN_DATE_TIME + " DESC";

        Cursor cursor = db.query(
                TABLE_NOTES,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT));
            String dateTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_TIME));
            Note_Model note = new Note_Model(id, title, content, dateTime);
            notes.add(note);
        }
        cursor.close();
        db.close();
        return notes;
    }

    public void deleteNote(long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NOTES, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }
}

