package com.training.notessample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class EditNoteActivity extends AppCompatActivity {
    EditText editText;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editText = (EditText) findViewById(R.id.note);

        int noteId = getIntent().getExtras().getInt(Note.KEY_NOTE_ID);
        new LoadNoteTask().execute(noteId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                new UpdateTask().execute();

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private class LoadNoteTask extends AsyncTask<Integer, Void, Note> {

        @Override
        protected Note doInBackground(Integer... values) {
            note = DatabaseHandler.getInstance(EditNoteActivity.this).getNote(
                    values[0]);

            return note;
        }

        @Override
        public void onPostExecute(Note note) {
            editText.setText(note.getBody());

        }
    }

    private class UpdateTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            note.setBody(editText.getText().toString());
        }

        @Override
        protected Void doInBackground(Void... values) {
            DatabaseHandler.getInstance(EditNoteActivity.this).updateNote(note);

            return null;
        }

        @Override
        public void onPostExecute(Void arg) {
            finish();

        }
    }


}
