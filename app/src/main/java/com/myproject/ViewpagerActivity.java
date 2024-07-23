package com.myproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewpagerActivity extends AppCompatActivity {

    ViewPager pager;
    TextView tab1, tab2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        pager = findViewById(R.id.container);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        pager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager()));
    }


    public void tabClickListener(View view) {
        if (view.getId() == R.id.tab1) {
            tab1.setBackgroundColor(Color.RED);
            tab2.setBackgroundColor(Color.WHITE);
            pager.setCurrentItem(0);

        } else {
            tab2.setBackgroundColor(Color.RED);
            tab1.setBackgroundColor(Color.WHITE);
            pager.setCurrentItem(1);
        }
    }

    public class ViewpagerAdapter extends FragmentPagerAdapter {

        public ViewpagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new TopFragment();
            }
            return new BottomFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
