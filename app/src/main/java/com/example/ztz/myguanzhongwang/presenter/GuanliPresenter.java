package com.example.ztz.myguanzhongwang.presenter;

import com.example.ztz.myguanzhongwang.bean.GuanliBean;
import com.example.ztz.myguanzhongwang.fragment.WoBMTabFragment;
import com.example.ztz.myguanzhongwang.model.GuanliModel;
import com.example.ztz.myguanzhongwang.model.GuanliModelCallBack;
import com.example.ztz.myguanzhongwang.view.GuanliViewCallBack;

/**
 * Created by ztz on 2017/12/16.
 */

public class GuanliPresenter {
    private GuanliViewCallBack guanliViewCallBack;
    private final GuanliModel guanliModel;

    public GuanliPresenter(GuanliViewCallBack guanliViewCallBack) {
        this.guanliViewCallBack = guanliViewCallBack;
        this.guanliModel = new GuanliModel();
    }

    public void getData() {
        guanliModel.getData(new GuanliModelCallBack() {
            @Override
            public void success(GuanliBean guanliBean) {
                guanliViewCallBack.success(guanliBean);
            }

            @Override
            public void failed(String e) {
                guanliViewCallBack.failed(e);
            }
        });
    }
}
