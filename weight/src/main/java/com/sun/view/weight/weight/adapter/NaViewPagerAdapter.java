package com.sun.view.weight.weight.adapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NaViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public NaViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public NaViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
