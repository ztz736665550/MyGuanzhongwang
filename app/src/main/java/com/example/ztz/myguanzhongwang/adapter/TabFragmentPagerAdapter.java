package com.example.ztz.myguanzhongwang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ztz.myguanzhongwang.fragment.TabFragment;

/**
 * Created by ztz on 2017/12/15.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final String[] mTitles = {"全部", "综艺娱乐", "财经访谈", "文化旅游", "青少科教", "养生保健","公益"};
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(mTitles[position]);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
