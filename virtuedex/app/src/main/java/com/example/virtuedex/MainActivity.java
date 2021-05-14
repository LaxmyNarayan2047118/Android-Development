package com.example.virtuedex;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
        private int[] tabIcons= { R.drawable.ic_action_name, R.drawable.ic_action_name1,R.drawable.ic_action_name2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpagerid);

        //setting up the adapter

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new fragmentbook(), "Books");
        viewPagerAdapter.add(new fragmentgames(), "Games");
        viewPagerAdapter.add(new fragmentmovies(), "Movies");

        //Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().

        tabLayout = findViewById(R.id.tablayoutid);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();


}
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

    }
}



