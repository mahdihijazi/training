package com.training.notessdcardsample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Note> notes;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this,
                        EditNoteActivity.class);
                intent.putExtra(Note.KEY_NOTE_ID, (int) id);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                NotesAdapter notesAdapter = (NotesAdapter) listView
                        .getAdapter();
                new DeleteNoteTask().execute((Note) notesAdapter
                        .getItem(position));
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);

                return true;

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();

        new LoadNotesTask().execute();
    }

    private void showLoading() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading");
        progressDialog.show();

    }

    private void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();

        }
    }

    private class LoadNotesTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showLoading();

        }

        @Override
        protected Void doInBackground(Void... params) {
            notes = DatabaseHandler.getInstance(MainActivity.this)
                    .getAllNotes();

            return (null);
        }

        @Override
        public void onPostExecute(Void arg0) {
            NotesAdapter notesAdapter = new NotesAdapter(MainActivity.this,
                    notes);
            listView.setAdapter(notesAdapter);

            hideLoading();
        }
    }

    private class DeleteNoteTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Note... values) {
            DatabaseHandler.getInstance(MainActivity.this)
                    .deleteNote(values[0]);
            notes = DatabaseHandler.getInstance(MainActivity.this)
                    .getAllNotes();

            return null;
        }

        @Override
        public void onPostExecute(Void arg) {
            NotesAdapter notesAdapter = new NotesAdapter(MainActivity.this,
                    notes);
            listView.setAdapter(notesAdapter);
        }
    }



}
