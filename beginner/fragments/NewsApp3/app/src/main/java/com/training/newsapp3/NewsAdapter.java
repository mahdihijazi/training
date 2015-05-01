package com.training.newsapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mahdi on 5/1/15.
 */
public class NewsAdapter extends BaseAdapter {
    private ArrayList<Article> articles = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public NewsAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Article getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return articles.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.row, parent, false);
        } else {
            view = convertView;
        }

        Article article = getItem(position);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(article.title);

        return view;
    }
}
