package com.example.ztz.myguanzhongwang.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.activity.LoginActivity;
import com.example.ztz.myguanzhongwang.activity.ShezhiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_APPEND;


/**
 * Created by ztz on 2017/12/15.
 */

public class MyFragment extends Fragment {

    private TextView my_login;
    SharedPreferences sp;
    private TextView my_login_a;
    private ImageView my_shezhi;
    private ImageView my_shezhi_a;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sp = getActivity().getSharedPreferences("qq", MODE_APPEND);
        boolean b = sp.getBoolean("b", false);
        if (b) {
            View view = inflater.inflate(R.layout.myfragmentloginsuccess, null, false);
            my_login_a = view.findViewById(R.id.my_login_a);
            my_shezhi_a = view.findViewById(R.id.my_shezhi_a);
            inita();
            return view;
        } else {
            //这是没有登录时的
            View view = inflater.inflate(R.layout.myfragment_layout, null, false);
            my_login = view.findViewById(R.id.my_login);
            my_shezhi = view.findViewById(R.id.my_shezhi);
            init();
            return view;
        }
    }
    public void inita(){
        /**
         * 登录按钮
         */
        /*my_login_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到登录页面
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });*/
        my_shezhi_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到设置页面
                startActivity(new Intent(getActivity(), ShezhiActivity.class));
                //getActivity().finish();
            }
        });
    }
    public void init(){
        /**
         * 登录按钮
         */
        my_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到登录页面
                startActivity(new Intent(getActivity(), LoginActivity.class));
                //getActivity().finish();
            }
        });

        /*my_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到设置页面
                startActivity(new Intent(getActivity(), ShezhiActivity.class));
            }
        });*/
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
