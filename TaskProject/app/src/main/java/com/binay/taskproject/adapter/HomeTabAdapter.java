package com.binay.taskproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.binay.taskproject.fragment.BaseViewPagerFragmentStatAdapter;
import com.binay.taskproject.fragment.FundFragment;
import com.binay.taskproject.fragment.OverViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Binay on 12/03/17.
 */

public class HomeTabAdapter extends BaseViewPagerFragmentStatAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public HomeTabAdapter(FragmentManager manager) {
        super(manager);
    }

    Fragment overView, funds;

    @Override
    public Fragment getFragmentItem(int position) {
        switch (position) {
            case 0:
                if (overView == null) {
                    overView = new OverViewFragment();

                }
                return overView;
            case 1:
                if (funds == null) {
                    funds = new FundFragment();
                }
                return funds;
            default:
                return null;
        }
    }

    @Override
    public void updateFragmentItem(int position, Fragment fragment) {

    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}