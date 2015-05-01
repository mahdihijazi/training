package com.training.newsapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NewsListFragment extends Fragment {
    NewsAdapter newsAdapter;
    ArrayList<Article> articles;

    public static NewsListFragment newInstance() {
        NewsListFragment fragment = new NewsListFragment();
        return fragment;
    }

    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        articles = new ArrayList<>();
        articles.add(new Article(1, getString(R.string.title1), getString(R.string.body1), R.drawable.news1));
        articles.add(new Article(2, getString(R.string.title2), getString(R.string.body2), R.drawable.news2));
        articles.add(new Article(3, getString(R.string.title3), getString(R.string.body3), R.drawable.news3));

        newsAdapter = new NewsAdapter(getActivity(), articles);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_news_list, container, false);
        ListView listView = (ListView) view.findViewById(R.id.newsListView);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        return view;

    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Article article = (Article) parent.getAdapter().getItem(position);
            NewsListActivity newsListActivity = (NewsListActivity) getActivity();
            newsListActivity.articleSelected(article);
        }
    };


}
