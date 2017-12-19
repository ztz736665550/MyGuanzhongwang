package com.example.ztz.myguanzhongwang.view;

import com.example.ztz.myguanzhongwang.bean.ShouyeBean;

/**
 * Created by ztz on 2017/12/15.
 */

public interface TabRecyclerCallBack {
    void success(ShouyeBean shouyeBean);
    void failed(String e);
}
