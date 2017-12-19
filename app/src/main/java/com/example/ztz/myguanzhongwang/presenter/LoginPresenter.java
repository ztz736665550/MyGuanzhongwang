package com.example.ztz.myguanzhongwang.presenter;

import com.example.ztz.myguanzhongwang.activity.LoginActivity;
import com.example.ztz.myguanzhongwang.bean.LoginBean;
import com.example.ztz.myguanzhongwang.model.LoginModel;
import com.example.ztz.myguanzhongwang.model.LoginModelCallBack;
import com.example.ztz.myguanzhongwang.view.LoginViewCallBack;

/**
 * Created by ztz on 2017/12/16.
 */

public class LoginPresenter {

    private LoginViewCallBack loginViewCallBack;
    private final LoginModel loginModel;

    public LoginPresenter(LoginViewCallBack loginViewCallBack) {
        this.loginViewCallBack = loginViewCallBack;
        this.loginModel = new LoginModel();
    }

    public void getData(String phone, String mima) {
        loginModel.getData(phone,mima, new LoginModelCallBack() {
            @Override
            public void Success(LoginBean loginBean) {
                loginViewCallBack.Success(loginBean);
            }

            @Override
            public void failed(String e) {
                loginViewCallBack.failed(e);
            }
        });
    }
}
