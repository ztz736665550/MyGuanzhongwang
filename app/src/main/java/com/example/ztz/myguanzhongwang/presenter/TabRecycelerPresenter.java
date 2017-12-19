package com.example.ztz.myguanzhongwang.presenter;

import com.example.ztz.myguanzhongwang.bean.ShouyeBean;
import com.example.ztz.myguanzhongwang.fragment.TabFragment;
import com.example.ztz.myguanzhongwang.model.TabRecyclerModel;
import com.example.ztz.myguanzhongwang.model.TabRecyclerModelCallBack;
import com.example.ztz.myguanzhongwang.view.TabRecyclerCallBack;

/**
 * Created by ztz on 2017/12/15.
 */

public class TabRecycelerPresenter {
    private TabRecyclerCallBack tabRecyclerCallBack;
    private final TabRecyclerModel tabRecyclerModel;

    public TabRecycelerPresenter(TabRecyclerCallBack tabRecyclerCallBack) {
        this.tabRecyclerCallBack = tabRecyclerCallBack;
        tabRecyclerModel = new TabRecyclerModel();
    }

    public void getData() {
        tabRecyclerModel.getData(new TabRecyclerModelCallBack() {
            @Override
            public void success(ShouyeBean shouyeBean) {
                if (shouyeBean != null){
                    tabRecyclerCallBack.success(shouyeBean);
                }
            }

            @Override
            public void failed(String e) {
                tabRecyclerCallBack.failed(e);
            }
        });
    }
}
