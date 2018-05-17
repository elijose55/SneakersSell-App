package com.example.gabrielmoura.ace1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;


public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> nFragmentList = new ArrayList<>();
    private final List<String> nFragmentTitleList = new ArrayList<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return nFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return nFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        nFragmentList.add(fragment);
        nFragmentTitleList.add(title);
    }
}
