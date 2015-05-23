package com.training.constantssample;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConstantsFragment extends Fragment implements
        DialogInterface.OnClickListener {
    private DatabaseHelper db = null;
    private CursorAdapter cursorAdapter;
    private ListView listView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        db = new DatabaseHelper(getActivity());
        new LoadCursorTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_constants, container,
                false);
        listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO

                return true;
            }
        });

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        cursorAdapter.getCursor().close();
        db.close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                add();
                return (true);
        }

        return super.onOptionsItemSelected(item);
    }

    private void add() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View addView = inflater.inflate(R.layout.add_edit, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.add_title).setView(addView)
                .setPositiveButton(R.string.ok, this)
                .setNegativeButton(R.string.cancel, null).show();
    }

    public void onClick(DialogInterface di, int whichButton) {
        ContentValues values = new ContentValues(2);
        AlertDialog dlg = (AlertDialog) di;
        EditText title = (EditText) dlg.findViewById(R.id.title);
        EditText value = (EditText) dlg.findViewById(R.id.value);

        values.put(DatabaseHelper.TITLE, title.getText().toString());
        values.put(DatabaseHelper.VALUE, value.getText().toString());

        new InsertTask().execute(values);
    }

    private Cursor doQuery() {
        return (db.getReadableDatabase().rawQuery("SELECT _id, title, value "
                + "FROM constants ORDER BY title", null));
    }

    private class LoadCursorTask extends AsyncTask<Void, Void, Void> {
        private Cursor constantsCursor = null;

        @Override
        protected Void doInBackground(Void... params) {
            constantsCursor = doQuery();
            constantsCursor.getCount();

            return (null);
        }

        @SuppressLint("NewApi")
        @SuppressWarnings("deprecation")
        @Override
        public void onPostExecute(Void arg0) {
            cursorAdapter = new SimpleCursorAdapter(getActivity(),
                    R.layout.row, constantsCursor, new String[]{
                    DatabaseHelper.TITLE, DatabaseHelper.VALUE},
                    new int[]{R.id.title, R.id.value}, 0);


            listView.setAdapter(cursorAdapter);

        }
    }

    private class InsertTask extends AsyncTask<ContentValues, Void, Void> {
        private Cursor constantsCursor = null;

        @Override
        protected Void doInBackground(ContentValues... values) {
            db.getWritableDatabase().insert(DatabaseHelper.TABLE,
                    DatabaseHelper.TITLE, values[0]);

            constantsCursor = doQuery();
            constantsCursor.getCount();

            return (null);
        }

        @Override
        public void onPostExecute(Void arg0) {
            cursorAdapter.changeCursor(constantsCursor);

        }
    }

}
