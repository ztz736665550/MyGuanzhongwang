package com.example.ztz.myguanzhongwang.model;

import com.example.ztz.myguanzhongwang.bean.ShouyeBean;

/**
 * Created by ztz on 2017/12/15.
 */

public interface TabRecyclerModelCallBack {
    void success(ShouyeBean shouyeBean);
    void failed(String e);
}
