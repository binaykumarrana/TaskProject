package com.binay.taskproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binay.taskproject.R;

import butterknife.ButterKnife;

/**
 * Created by Binay on 12/03/17.
 */

public class FundFragment extends Fragment {
    private static FundFragment instance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fund_fragment, container, false);
        return view;
    }

    public static FundFragment getInstance() {

        instance = new FundFragment();

        return instance;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
