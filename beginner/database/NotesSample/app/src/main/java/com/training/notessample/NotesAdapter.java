package com.training.notessample;

import java.util.List;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NotesAdapter extends BaseAdapter {
	LayoutInflater inflater;
	List<Note> notes;

	public NotesAdapter(Context context, List<Note> notes) {
		inflater = (LayoutInflater) context
				.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
		this.notes = notes;
	}

	@Override
	public int getCount() {
		return notes.size();
	}

	@Override
	public Object getItem(int position) {
		return notes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return notes.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row, parent, false);

			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.note_body);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Note note = (Note) getItem(position);
		holder.textView.setText(note.getBody());
		return convertView;
	}

	class ViewHolder {
		TextView textView;

	}

}
