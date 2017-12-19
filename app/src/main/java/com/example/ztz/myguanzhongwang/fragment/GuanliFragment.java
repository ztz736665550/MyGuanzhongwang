package com.example.ztz.myguanzhongwang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.ztz.myguanzhongwang.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * Created by ztz on 2017/12/15.
 */

public class GuanliFragment extends Fragment {
    @BindView(R.id.btn_erweima_gl)
    Button btnErweimaGl;
    Unbinder unbinder;
    @BindView(R.id.radio_btn_gl_bm)
    RadioButton radioBtnGlBm;
    @BindView(R.id.radio_btn_gl_fb)
    RadioButton radioBtnGlFb;
    @BindView(R.id.frameLayout_gl)
    FrameLayout frameLayout;
    private WoBmFragment woBmFragment;
    private WoFbFragment woFbFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guanlifragment_layout, null, false);
        unbinder = ButterKnife.bind(this, view);
        initFragment();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //点击进行验票
        btnErweimaGl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(getActivity(), data.getAction(), Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_CANCELED) {
            //Toast.makeText(getActivity(),"扫描出错",Toast.LENGTH_SHORT).show();
        }
    }
    public void initFragment(){
        //创建管理页面的fragment
        woBmFragment = new WoBmFragment();
        woFbFragment = new WoFbFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_gl,woBmFragment)
                .commit();
        radioBtnGlBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_gl,woBmFragment)
                        .commit();
            }
        });
        radioBtnGlFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_gl,woFbFragment)
                        .commit();
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
