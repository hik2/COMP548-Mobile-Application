package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GearGalleryActivity extends AppCompatActivity {
    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_viewpager);

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.viewPager);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(FragmentViewPager.newInstance(getString(R.string.text_gearvr_controller), R.drawable.gearvr_controller_3_2));
        fList.add(FragmentViewPager.newInstance(getString(R.string.text_gearvr_phones), R.drawable.gearvr_phones_3_2));
        fList.add(FragmentViewPager.newInstance(getString(R.string.text_gearvr_inside), R.drawable.gearvr_inside_3_2));
        return fList;
    }

    private class MyPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragments;
        private int[] mResources;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments){
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position){
            return this.fragments.get(position);
        }

        @Override
        public int getCount(){
            return this.fragments.size();
        }
    }
}
