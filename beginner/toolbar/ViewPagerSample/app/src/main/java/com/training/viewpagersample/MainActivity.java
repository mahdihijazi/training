package com.training.viewpagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_OF_PAGES = 10;

    private ViewPager mViewPager;
    private MyFragmentPagerAdapter mMyFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mMyFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
        mViewPager.setAdapter(mMyFragmentPagerAdapter);

    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {

            return PageFragment.newInstance("My Message " + index);
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }
}