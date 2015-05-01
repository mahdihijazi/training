package com.training.newsapp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class NewsListActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        if (findViewById(R.id.newsitem_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        getSupportActionBar().setTitle(getString(R.string.app_name));

    }

    public void articleSelected(Article article) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(NewsItemDetailFragment.ARG_ITEM, article);
            NewsItemDetailFragment fragment = new NewsItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.newsitem_detail_container, fragment)
                    .commit();

        } else {
            Intent intent = new Intent(NewsListActivity.this, NewsItemDetailActivity.class);
            intent.putExtra(NewsItemDetailFragment.ARG_ITEM, article);
            startActivity(intent);
        }

    }

}
