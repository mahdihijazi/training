package com.training.listviewsample3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsAdapter extends BaseAdapter {
    Contact[] contacts;
    LayoutInflater layoutInflater;

    public ContactsAdapter(Context context, Contact[] contacts){
        layoutInflater = LayoutInflater.from(context);
        this.contacts = contacts;

    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Object getItem(int position) {
        return contacts[position];
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

}
