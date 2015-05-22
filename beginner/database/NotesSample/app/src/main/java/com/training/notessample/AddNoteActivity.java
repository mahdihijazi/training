package com.training.notessample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class AddNoteActivity extends AppCompatActivity {
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editText = (EditText) findViewById(R.id.note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                Note note = new Note(editText.getText().toString());
                new InsertTask().execute(note);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private class InsertTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... values) {
            DatabaseHandler.getInstance(AddNoteActivity.this)
                    .addNote(values[0]);

            return (null);
        }

        @Override
        public void onPostExecute(Void arg0) {
            finish();

        }
    }
}
