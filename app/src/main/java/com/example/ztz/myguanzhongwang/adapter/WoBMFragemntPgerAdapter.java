package com.example.ztz.myguanzhongwang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ztz.myguanzhongwang.fragment.TabFragment;
import com.example.ztz.myguanzhongwang.fragment.WoBMTabFragment;

/**
 * Created by ztz on 2017/12/16.
 */

public class WoBMFragemntPgerAdapter extends FragmentPagerAdapter {
    private static final String[] mTitles = {"待审核", "待支付", "待参加", "已完成"};

    public WoBMFragemntPgerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return WoBMTabFragment.newInstance(mTitles[position]);
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
