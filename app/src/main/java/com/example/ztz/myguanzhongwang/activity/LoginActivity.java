package com.example.ztz.myguanzhongwang.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.myguanzhongwang.MainActivity;
import com.example.ztz.myguanzhongwang.R;
import com.example.ztz.myguanzhongwang.bean.LoginBean;
import com.example.ztz.myguanzhongwang.presenter.LoginPresenter;
import com.example.ztz.myguanzhongwang.view.LoginViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginViewCallBack{

    @BindView(R.id.login_guanbi)
    ImageView loginGuanbi;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_mima)
    EditText loginMima;
    @BindView(R.id.login_login)
    TextView loginLogin;
    @BindView(R.id.login_zhuce)
    TextView loginZhuce;
    @BindView(R.id.login_wangji)
    TextView loginWangji;
    private LoginPresenter loginPresenter;
    SharedPreferences sp;
    @SuppressLint("WrongConstant")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        sp = LoginActivity.this.getSharedPreferences("qq", MODE_APPEND);
        loginGuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = loginPhone.getText().toString();
                String mima = loginMima.getText().toString();
                loginPresenter.getData(phone,mima);

            }
        });
    }
    /**
     * @param loginBean
     */
    @Override
    public void Success(LoginBean loginBean) {
        if (loginBean != null) {
            Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            if (loginBean.getMsg().toString().equals("登陆成功")||loginBean.getMsg().length()<=4){
                //登录成功
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("b", true);
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("reg", true);
                startActivity(intent);
                //finish();
            }else{
                //失败
                Toast.makeText(LoginActivity.this,"错",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void failed(String e) {

    }
}
