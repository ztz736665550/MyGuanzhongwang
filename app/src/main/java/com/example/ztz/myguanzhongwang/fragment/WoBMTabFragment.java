package com.example.ztz.myguanzhongwang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.adapter.WobmRecyclerviewAdapter;
import com.example.ztz.myguanzhongwang.bean.GuanliBean;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;
import com.example.ztz.myguanzhongwang.presenter.GuanliPresenter;
import com.example.ztz.myguanzhongwang.view.GuanliViewCallBack;
import com.example.ztz.myguanzhongwang.view.TabRecyclerCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/16.
 */

public class WoBMTabFragment extends Fragment implements GuanliViewCallBack{
    public static final String PAGE_TITLE = "PAGE_TITLE";
    Unbinder unbinder;
    @BindView(R.id.recyclerview_bm_tab)
    RecyclerView recyclerviewBmTab;
    private String title;

    public static WoBMTabFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(PAGE_TITLE, title);
        WoBMTabFragment woBMTabFragment = new WoBMTabFragment();
        woBMTabFragment.setArguments(bundle);
        return woBMTabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(PAGE_TITLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wobmtabfragmentlayout, container, false);
        unbinder = ButterKnife.bind(this, view);
        recyclerviewBmTab.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerviewBmTab.addItemDecoration(new DividerItemDecoration(getContext(),1));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GuanliPresenter guanliPresenter = new GuanliPresenter(WoBMTabFragment.this);
        guanliPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * @param
     */
    @Override
    public void success(GuanliBean guanliBean) {
        if (guanliBean != null) {
            List<GuanliBean.DataBean> list = guanliBean.getData();
            WobmRecyclerviewAdapter recyclerviewAdapter = new WobmRecyclerviewAdapter(getActivity(),list);
            recyclerviewBmTab.setAdapter(recyclerviewAdapter);
        }
    }

    @Override
    public void failed(String e) {
        Log.i("-----", "failed: "+e.toString());
    }
}
