package com.example.ztz.myguanzhongwang.model;

import com.example.ztz.myguanzhongwang.bean.GuanliBean;

/**
 * Created by ztz on 2017/12/16.
 */

public interface GuanliModelCallBack {
    void success(GuanliBean guanliBean);
    void failed(String e);
}
