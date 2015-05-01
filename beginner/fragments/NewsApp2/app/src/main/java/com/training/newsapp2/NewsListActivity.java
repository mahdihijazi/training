package com.training.newsapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, NewsListFragment.newInstance())
                    .commit();
        }
    }

    public void articleSelected(Article article) {
        Intent intent = new Intent(NewsListActivity.this, NewsItemDetailActivity.class);
        intent.putExtra(NewsItemDetailFragment.ARG_ITEM, article);
        startActivity(intent);
    }

}
