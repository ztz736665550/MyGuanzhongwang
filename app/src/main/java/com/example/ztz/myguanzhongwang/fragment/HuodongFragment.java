package com.example.ztz.myguanzhongwang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ztz.myguanzhongwang.QuanguoActivity;
import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.activity.SousuoActivity;
import com.example.ztz.myguanzhongwang.adapter.TabFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/15.
 */

public class HuodongFragment extends Fragment {
    @BindView(R.id.tablayout_hd)
    TabLayout tablayoutHd;
    @BindView(R.id.viewpager_hd)
    ViewPager viewpagerHd;
    Unbinder unbinder;
    @BindView(R.id.hg_quanguo)
    TextView hgQuanguo;
    @BindView(R.id.hd_sousuo)
    ImageView hdSousuo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huodongfragment_layout, null, false);
        unbinder = ButterKnife.bind(this, view);
        //全部综艺娱乐财经访谈文化旅游青少科教养生保健公益
        tablayoutHd.addTab(tablayoutHd.newTab().setText("全部"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("综艺娱乐"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("财经访谈"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("文化旅游"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("青少科教"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("养生保健"));
        tablayoutHd.addTab(tablayoutHd.newTab().setText("公益"));

        TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(getChildFragmentManager());
        viewpagerHd.setAdapter(tabFragmentPagerAdapter);
        tablayoutHd.setupWithViewPager(viewpagerHd);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * 点击搜索跳转搜索页面
         */
        hdSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SousuoActivity.class));
            }
        });
        /**
         * 全国
         */
        hgQuanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),QuanguoActivity.class));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
