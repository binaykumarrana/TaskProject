package com.binay.taskproject.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.binay.taskproject.R;
import com.binay.taskproject.adapter.RecyclerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TaskOneActivity extends AppCompatActivity {

    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    @InjectView(R.id.header)
    ImageView header;
    @InjectView(R.id.backImageButton)
    ImageButton backImageButton;
    @InjectView(R.id.settingImageButton)
    ImageButton settingImageButton;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    private ArrayList<String> stringArrayList;
    private RecyclerAdapter adapter;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        collapsingToolbar.setTitle(getString(R.string.expand));

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        adapter = new RecyclerAdapter(this, stringArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

    @OnClick(R.id.backImageButton)
    public void funcCloseActivity(){
        finish();
    }
}
