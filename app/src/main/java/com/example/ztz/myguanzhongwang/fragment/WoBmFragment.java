package com.example.ztz.myguanzhongwang.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.activity.LoginActivity;
import com.example.ztz.myguanzhongwang.adapter.TabFragmentPagerAdapter;
import com.example.ztz.myguanzhongwang.adapter.WoBMFragemntPgerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import static android.content.Context.MODE_APPEND;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/16.
 */

public class WoBmFragment extends Fragment {

    SharedPreferences sp;
    private WoBMFragemntPgerAdapter tabFragmentPagerAdapter;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sp = getActivity().getSharedPreferences("qq", MODE_APPEND);
        boolean b = sp.getBoolean("b", false);
        if (b){
            View view = inflater.inflate(R.layout.gl_wobaomingfragment_layout, container, false);
            TabLayout glBmTablayout = view.findViewById(R.id.gl_bm_tablayout);
            ViewPager glBmViewpager = view.findViewById(R.id.gl_bm_viewpager);
            glBmTablayout.addTab(glBmTablayout.newTab().setText("待审核"));
            glBmTablayout.addTab(glBmTablayout.newTab().setText("待支付"));
            glBmTablayout.addTab(glBmTablayout.newTab().setText("待参加"));
            glBmTablayout.addTab(glBmTablayout.newTab().setText("已完成"));

            tabFragmentPagerAdapter = new WoBMFragemntPgerAdapter(getChildFragmentManager());
            glBmViewpager.setAdapter(tabFragmentPagerAdapter);
            glBmTablayout.setupWithViewPager(glBmViewpager);
            return view;
        }else{
            View view = inflater.inflate(R.layout.weidenglu_guanli_layout, container, false);
            Button guanli_denglu = view.findViewById(R.id.guanli_denglu);
            //点击登录按钮登录到登录按钮
            guanli_denglu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            });
            return view;
        }
    }

}
