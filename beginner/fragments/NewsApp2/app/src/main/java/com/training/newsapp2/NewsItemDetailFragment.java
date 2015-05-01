package com.training.newsapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class NewsItemDetailFragment extends Fragment {


    public static final String ARG_ITEM = "item";


    private Article mItem;


    public NewsItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            mItem = getArguments().getParcelable(ARG_ITEM);
        }

        ((AppCompatActivity) getActivity()).setTitle(mItem.title);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newsitem_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.newsitem_detail);
            textView.setText(mItem.content);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.newsitem_image);
            imageView.setImageResource(mItem.imageResId);

        }

        return rootView;
    }
}
