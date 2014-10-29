package com.training.listviewsample3;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsAdapter extends BaseAdapter {
	private LayoutInflater layoutInflater;
	private ArrayList<Object> contacts;

	private static final int TYPE_CONTACT = 0;
	private static final int TYPE_SEPARATER = 1;

	public ContactsAdapter(Context context, Object[] items) {
		layoutInflater = (LayoutInflater) context
				.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
		this.contacts = new ArrayList<Object>();
		
		for (int i = 0; i < items.length; i++) {
			this.contacts.add(items[i]);
		}

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		switch (type) {
		case TYPE_CONTACT:
			return getContactView(position, convertView, parent);

		case TYPE_SEPARATER:
			return getSeparatorView(position, convertView, parent);

		default:
			throw new IllegalStateException("Invalid ");

		}
	}

	public View getContactView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.row, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.textView = (TextView) convertView.findViewById(R.id.name);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Contact contact = (Contact) getItem(position);
		holder.imageView.setImageResource(contact.pictureId);
		holder.textView.setText(contact.name);

		return convertView;

	}

	public View getSeparatorView(int position, View convertView,
			ViewGroup parent) {

		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.seperator, null);

		}
		
		Separator separator = (Separator) getItem(position);
		TextView textView = (TextView) convertView.findViewById(R.id.title);
		textView.setText(separator.getTitle());
		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return 2;

	}

	@Override
	public int getItemViewType(int position) {
		Object item = getItem(position);
		if (item instanceof Contact) {
			return TYPE_CONTACT;
		} else if (item instanceof Separator) {
			return TYPE_SEPARATER;

		}
		throw new IllegalStateException("Invalid view type at postion: "
				+ position);

	}

	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public void add(Object item) {
		contacts.add(item);
		
	}

	class ViewHolder {
		ImageView imageView;
		TextView textView;

	}

}
