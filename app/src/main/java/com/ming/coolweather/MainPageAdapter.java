package com.ming.coolweather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by llm on 2017/9/30.
 */

public class MainPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPageAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=fragmentList.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList == null? 0:fragmentList.size();
    }
}
