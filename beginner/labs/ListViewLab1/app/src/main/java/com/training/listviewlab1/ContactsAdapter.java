package com.training.listviewlab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends BaseAdapter {
    ArrayList<Contact> contacts;
    LayoutInflater layoutInflater;

    public ContactsAdapter(Context context, ArrayList<Contact> contacts) {
        layoutInflater = LayoutInflater.from(context);
        this.contacts = contacts;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.row, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.picture = (ImageView) view.findViewById(R.id.picture);
            viewHolder.name = (TextView) view.findViewById(R.id.name);

            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        Contact contact = (Contact) getItem(position);
        viewHolder.picture.setImageResource(contact.pictureId);
        viewHolder.name.setText(contact.name);

        return view;

    }

    static class ViewHolder {
        ImageView picture;
        TextView name;

    }

}
