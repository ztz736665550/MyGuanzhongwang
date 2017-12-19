package com.example.ztz.myguanzhongwang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuanguoActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_CITY = 0;
    @BindView(R.id.quanguo_text)
    TextView quanguoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanguo);
        ButterKnife.bind(this);
        //启动
        startActivityForResult(new Intent(QuanguoActivity.this, CityPickerActivity.class),
                REQUEST_CODE_PICK_CITY);    }

    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                quanguoText.setText("当前选择：" + city);
            }
        }
    }
}
