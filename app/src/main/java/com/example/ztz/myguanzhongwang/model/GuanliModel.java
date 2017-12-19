package com.example.ztz.myguanzhongwang.model;

import com.example.ztz.myguanzhongwang.bean.GuanliBean;
import com.example.ztz.myguanzhongwang.okhttp.AbstractUiCallBack;
import com.example.ztz.myguanzhongwang.okhttp.OkhttpUtils;

/**
 * Created by ztz on 2017/12/16.
 */

public class GuanliModel {
    public void getData(final GuanliModelCallBack guanliModelCallBack) {
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCatagory", new AbstractUiCallBack<GuanliBean>() {
            @Override
            public void success(GuanliBean guanliBean) {
                guanliModelCallBack.success(guanliBean);
            }

            @Override
            public void failure(Exception e) {
                guanliModelCallBack.failed(e.getMessage());
            }
        });
    }
}
