package com.example.ztz.myguanzhongwang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.fragment.GuanliFragment;
import com.example.ztz.myguanzhongwang.fragment.HuodongFragment;
import com.example.ztz.myguanzhongwang.fragment.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.radio_btn_huodong)
    RadioButton radioBtnHuodong;
    @BindView(R.id.radio_btn_fabu)
    RadioButton radioBtnFabu;
    @BindView(R.id.radio_btn_guanli)
    RadioButton radioBtnGuanli;
    @BindView(R.id.radio_btn_my)
    RadioButton radioBtnMy;
    private HuodongFragment huodongFragment;
    //private FabuFragment fabuFragment;
    private GuanliFragment guanliFragment;
    private MyFragment myFragment;
    private Fragment mFragment;//当前显示的Fragment
    private boolean a = false;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initFragment();
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        huodongFragment = new HuodongFragment();
        //fabuFragment = new FabuFragment();
        guanliFragment = new GuanliFragment();
        myFragment = new MyFragment();

        Intent intent = getIntent();
        a = intent.getBooleanExtra("reg",a);
        if (a){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.framelayout,myFragment).commit();
            mFragment = myFragment;
        }else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.framelayout,huodongFragment).commit();
            mFragment = huodongFragment;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_btn_huodong :
                radioBtnHuodong.setChecked(true);
                radioBtnFabu.setChecked(false);
                radioBtnGuanli.setChecked(false);
                radioBtnMy.setChecked(false);
                switchFragment(huodongFragment);
                break;
            case R.id.radio_btn_fabu :
                /*radioBtnHuodong.setChecked(false);
                radioBtnFabu.setChecked(true);
                radioBtnGuanli.setChecked(false);
                radioBtnMy.setChecked(false);
                switchFragment(fabuFragment);*/
                radioBtnFabu.setChecked(false);
                startActivity(new Intent(HomeActivity.this,FabuActivity.class));
                break;
            case R.id.radio_btn_guanli :
                radioBtnHuodong.setChecked(false);
                radioBtnFabu.setChecked(false);
                radioBtnGuanli.setChecked(true);
                radioBtnMy.setChecked(false);
                switchFragment(guanliFragment);
                break;
            case R.id.radio_btn_my :
                radioBtnHuodong.setChecked(false);
                radioBtnFabu.setChecked(false);
                radioBtnGuanli.setChecked(false);
                radioBtnMy.setChecked(true);
                switchFragment(myFragment);
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.framelayout,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }
}
