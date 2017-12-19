package com.example.ztz.myguanzhongwang.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ztz.myguanzhongwang.MainActivity;
import com.example.ztz.myguanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShezhiActivity extends AppCompatActivity {

    @BindView(R.id.shezhi_guanbi)
    ImageView shezhiGuanbi;
    @BindView(R.id.shezhi_btn_tuichu)
    Button shezhiBtnTuichu;
    SharedPreferences sp;
    @SuppressLint("WrongConstant")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        ButterKnife.bind(this);
        sp = ShezhiActivity.this.getSharedPreferences("qq", MODE_APPEND);
        shezhiGuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**
         * 当点击按钮是进行退出
         */
        shezhiBtnTuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("b", false);
                edit.commit();

                Intent intent = new Intent(ShezhiActivity.this, HomeActivity.class);
                intent.putExtra("reg", true);
                startActivity(intent);
                //finish();
            }
        });
    }
}
