package com.binay.taskproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.binay.taskproject.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LandingActivity extends Activity {

    @InjectView(R.id.taskOneButton)
    Button taskOneButton;
    @InjectView(R.id.taskTwoButton)
    Button taskTwoButton;
    @InjectView(R.id.activity_landing)
    RelativeLayout activityLanding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.taskOneButton)
    public void funcTaskOne() {
        startActivity(new Intent(LandingActivity.this, TaskOneActivity.class));
    }

    @OnClick(R.id.taskTwoButton)
    public void funcTaskTwo() {
        startActivity(new Intent(LandingActivity.this, TaskTwoActivity.class));
    }
}
