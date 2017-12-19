package com.example.ztz.myguanzhongwang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ztz.myguanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FabuActivity extends AppCompatActivity {

    @BindView(R.id.fahuodong_fb)
    Button fahuodongFb;
    @BindView(R.id.qidai_fb)
    Button qidaiFb;
    @BindView(R.id.image_guanbi_fb)
    ImageView imageGuanbiFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        ButterKnife.bind(this);
        imageGuanbiFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
