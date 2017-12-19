package com.example.ztz.myguanzhongwang.model;

import com.example.ztz.myguanzhongwang.application.MyApplication;
import com.example.ztz.myguanzhongwang.bean.LoginBean;
import com.example.ztz.myguanzhongwang.okhttp.OkhttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/16.
 */

public class LoginModel {
    public void getData(String phone, String mima, final LoginModelCallBack loginModelCallBack) {
        MyApplication.api1.getlogin(phone,mima)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        loginModelCallBack.Success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        loginModelCallBack.failed(throwable.getMessage());
                    }
                });
    }
}
