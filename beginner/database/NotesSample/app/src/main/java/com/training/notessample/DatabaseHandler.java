package com.training.notessample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "notes_db";
	private static final String TABLE_NOTES = "notes";
	private static final String KEY_ID = "_id";
	private static final String KEY_BODY = "body";

	private static DatabaseHandler instance;

	public synchronized static DatabaseHandler getInstance(Context context) {
		if (instance == null) {
			instance = new DatabaseHandler(context.getApplicationContext());
		}
		return instance;
	}

	private DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_BODY + " TEXT" + ")";
		db.execSQL(CREATE_NOTES_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);

		// Create tables again
		onCreate(db);
	}

	void addNote(Note note) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_BODY, note.getBody()); // note body

		// Inserting Row
		db.insert(TABLE_NOTES, null, values);
		db.close(); // Closing database connection
	}

	Note getNote(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_NOTES,
				new String[] { KEY_ID, KEY_BODY }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		int idColumnIndex = cursor.getColumnIndex(KEY_ID);
		int bodyColumndIndex = cursor.getColumnIndex(KEY_BODY);

		Note note = new Note(cursor.getInt(idColumnIndex),
				cursor.getString(bodyColumndIndex));

		return note;
	}

	public List<Note> getAllNotes() {
		List<Note> notesList = new ArrayList<Note>();
		String selectQuery = "SELECT  * FROM " + TABLE_NOTES;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		int idColumnIndex = cursor.getColumnIndex(KEY_ID);
		int bodyColumnIndex = cursor.getColumnIndex(KEY_BODY);

		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(idColumnIndex);
				String body = cursor.getString(bodyColumnIndex);
				Note note = new Note(id, body);

				notesList.add(note);
			} while (cursor.moveToNext());
		}

		return notesList;
	}

	public int updateNote(Note note) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_BODY, note.getBody());

		return db.update(TABLE_NOTES, values, KEY_ID + " = ?",
				new String[] { String.valueOf(note.getId()) });
	}

	public void deleteNote(Note note) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NOTES, KEY_ID + " = ?",
				new String[] { String.valueOf(note.getId()) });
		db.close();
	}

	public int getNotesCount() {
		String countQuery = "SELECT  * FROM " + TABLE_NOTES;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		return cursor.getCount();
	}

}