package com.example.ztz.myguanzhongwang.view;

import com.example.ztz.myguanzhongwang.bean.LoginBean;

/**
 * Created by ztz on 2017/12/16.
 */

public interface LoginViewCallBack {
    void Success(LoginBean loginBean);
    void failed(String e);
}
