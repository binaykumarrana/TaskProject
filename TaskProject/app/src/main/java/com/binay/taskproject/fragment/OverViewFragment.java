package com.binay.taskproject.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.binay.taskproject.R;
import com.binay.taskproject.activity.TaskTwoActivity;
import com.binay.taskproject.interfaces.UpdateInvestment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Binay on 12/03/17.
 */

public class OverViewFragment extends Fragment implements UpdateInvestment {
    private static OverViewFragment instance;
    @InjectView(R.id.projectAmountTextView)
    TextView projectAmountTextView;
    @InjectView(R.id.amountTextView)
    TextView amountTextView;
    @InjectView(R.id.totalInvestmentTextView)
    TextView totalInvestmentTextView;
    @InjectView(R.id.totalInvestmentAmountTextView)
    TextView totalInvestmentAmountTextView;
    @InjectView(R.id.leftContainerLinearLayout)
    LinearLayout leftContainerLinearLayout;
    @InjectView(R.id.goodCaseTextView)
    TextView goodCaseTextView;
    @InjectView(R.id.goodCaseAmountTextView)
    TextView goodCaseAmountTextView;
    @InjectView(R.id.centerContainerLinearLayout)
    LinearLayout centerContainerLinearLayout;
    @InjectView(R.id.badCaseTextView)
    TextView badCaseTextView;
    @InjectView(R.id.badCaseAmountTextView)
    TextView badCaseAmountTextView;
    @InjectView(R.id.rightContainerLinearLayout)
    LinearLayout rightContainerLinearLayout;
    @InjectView(R.id.topCardView)
    CardView topCardView;
    @InjectView(R.id.rowRelativeLayout)
    RelativeLayout rowRelativeLayout;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_overview_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    public static OverViewFragment getInstance() {

        instance = new OverViewFragment();

        return instance;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = getActivity();
        ((TaskTwoActivity) context).updateInvestment = (UpdateInvestment) this;
    }

    @Override
    public void methodUpdateInvestment(double amount) {
        amountTextView.setText(context.getResources().getString(R.string.rs) + " " + amount);
    }
}
