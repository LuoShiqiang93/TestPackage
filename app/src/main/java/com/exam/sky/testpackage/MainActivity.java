package com.exam.sky.testpackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity {
    //AppKey:580485f0e0f55a26b0001b5e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置场景类型(普通场景类型)
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }
}
