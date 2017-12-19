package com.example.ztz.myguanzhongwang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ztz.myguanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SousuoActivity extends AppCompatActivity {

    @BindView(R.id.sousuo_guanbi)
    ImageView sousuoGuanbi;
    @BindView(R.id.edit_sousuo)
    EditText editSousuo;
    @BindView(R.id.sousuo_sousuo)
    TextView sousuoSousuo;
    @BindView(R.id.sousuo_recyclerview)
    RecyclerView sousuoRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        ButterKnife.bind(this);

        sousuoRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        sousuoGuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**
         * 点击搜索框拉去搜索矿的数据
         */
        sousuoSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editSousuo.getText().toString();

            }
        });
    }
}
