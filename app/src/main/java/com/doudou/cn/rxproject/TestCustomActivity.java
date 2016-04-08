package com.doudou.cn.rxproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinliang on 16-4-8.
 */
public class TestCustomActivity extends Activity {
    @Bind(R.id.btn_test)
    TextView btnTest;
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.custom)
    CustomView custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_test)
    public void addProcessData(){

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
