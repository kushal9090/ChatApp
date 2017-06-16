package com.kushal.chatapp.ui.chatscreen.commonadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kusha on 6/16/2017.
 */

public class ViewPagerAdapter  extends FragmentPagerAdapter{

    private List<Fragment> mFragments;
    private List<String> mTitles;

public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments, List<String> titles){
    super(fm);
    mFragments = fragments;
    mTitles = titles;


}

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();

    }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
}
