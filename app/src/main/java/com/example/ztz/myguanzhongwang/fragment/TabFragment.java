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
import com.example.ztz.myguanzhongwang.adapter.recyclerviewHdAdapter;
import com.example.ztz.myguanzhongwang.adapter.recyclerviewZYAdapter;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;
import com.example.ztz.myguanzhongwang.presenter.TabRecycelerPresenter;
import com.example.ztz.myguanzhongwang.view.TabRecyclerCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/15.
 */

public class TabFragment extends Fragment implements TabRecyclerCallBack {

    public static final String PAGE_TITLE = "PAGE_TITLE";
    Unbinder unbinder;
    @BindView(R.id.recyclerview_hd)
    RecyclerView recyclerviewHd;
    private String title;
    private RecyclerView recyclerview_hd_zy;

    public static TabFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(PAGE_TITLE, title);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(PAGE_TITLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        View view2 = inflater.inflate(R.layout.tabfragmentzy_layout, container, false);
        recyclerview_hd_zy = view2.findViewById(R.id.recyclerview_hd_zy);
        TabRecycelerPresenter tabRecycelerPresenter = new TabRecycelerPresenter(this);
        tabRecycelerPresenter.getData();
        if (title.equals("全部")) {
            recyclerivew();
        } else if (title.equals("综艺娱乐")) {
            recyclerviewZy();
            return view2;
        } else if (title.equals("财经访谈")) {
            recyclerivew();
        } else if (title.equals("文化旅游")) {
            recyclerivew();
        } else if (title.equals("青少科教")) {
            recyclerivew();
        } else if (title.equals("养生保健")) {
            recyclerivew();
        } else if (title.equals("公益")) {
            recyclerivew();
        }
        return view;
    }

    public void recyclerivew() {
        recyclerviewHd.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerviewHd.addItemDecoration(new DividerItemDecoration(getContext(), 1));
    }
    public void recyclerviewZy(){
        recyclerview_hd_zy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerview_hd_zy.addItemDecoration(new DividerItemDecoration(getContext(), 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * @param shouyeBean
     */
    @Override
    public void success(ShouyeBean shouyeBean) {
        if (shouyeBean != null) {
            List<ShouyeBean.DataBean.ComicsBean> list = shouyeBean.getData().getComics();
            recyclerviewHdAdapter recyclerviewHdAdapter = new recyclerviewHdAdapter(getActivity(), list);
            recyclerviewHd.setAdapter(recyclerviewHdAdapter);

            recyclerviewZYAdapter recyclerviewZYAdapter = new recyclerviewZYAdapter(getActivity(), list);
            recyclerview_hd_zy.setAdapter(recyclerviewZYAdapter);
        }
    }

    @Override
    public void failed(String e) {
        //Log.i("------", "failed: " + e.toString());
    }
}
