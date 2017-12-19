package com.example.ztz.myguanzhongwang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ztz.myguanzhongwang.R;

/**
 * Created by ztz on 2017/12/16.
 */

public class WoFbFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gl_wofabufragment_layout, null, false);
        return view;
    }
}
