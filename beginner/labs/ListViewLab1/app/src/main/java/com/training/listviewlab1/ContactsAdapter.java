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
        View view = layoutInflater.inflate(R.layout.row, parent, false);

        ImageView picture = (ImageView) view.findViewById(R.id.picture);
        TextView name = (TextView) view.findViewById(R.id.name);

        Contact contact = (Contact) getItem(position);
        picture.setImageResource(contact.pictureId);
        name.setText(contact.name);

        return view;

    }

    static class ViewHolder {
        ImageView picture;
        TextView name;

    }

}
