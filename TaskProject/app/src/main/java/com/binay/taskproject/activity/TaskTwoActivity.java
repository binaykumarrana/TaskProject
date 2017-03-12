package com.binay.taskproject.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.binay.taskproject.R;
import com.binay.taskproject.adapter.HomeTabAdapter;
import com.binay.taskproject.api.HomeApi;
import com.binay.taskproject.fragment.FundFragment;
import com.binay.taskproject.fragment.OverViewFragment;
import com.binay.taskproject.interfaces.UpdateInvestment;
import com.binay.taskproject.model.Investment;
import com.binay.taskproject.services.ServiceGenerator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TaskTwoActivity extends AppCompatActivity {
    @InjectView(R.id.layoutDots)
    LinearLayout layoutDots;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.backImageButton)
    ImageButton mBackImageButton;
    @InjectView(R.id.settingImageButton)
    ImageButton mSettingImageButton;
    @InjectView(R.id.tabsHomePage)
    TabLayout mTabsHomePage;
    @InjectView(R.id.viewpagerRetirementGoal)
    ViewPager mViewpagerRetirementGoal;
    HomeTabAdapter mHomeTabAdapter;
    Fragment mOverviewFragment, mFundFragment;
    @InjectView(R.id.riskHeadLineTextView)
    TextView riskHeadLineTextView;
    @InjectView(R.id.moderateButton)
    AppCompatButton moderateButton;
    @InjectView(R.id.riskHeadLineOptions)
    RelativeLayout riskHeadLineOptions;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    @InjectView(R.id.equityPerTextView)
    TextView equityPerTextView;
    @InjectView(R.id.equityPerLinearLayout)
    LinearLayout equityPerLinearLayout;
    @InjectView(R.id.riskSeekBar)
    SeekBar riskSeekBar;
    @InjectView(R.id.debtPerTextView)
    TextView debtPerTextView;
    @InjectView(R.id.debtPerLinearLayout)
    LinearLayout debtPerLinearLayout;
    @InjectView(R.id.riskProgressRelativeLayout)
    RelativeLayout riskProgressRelativeLayout;
    @InjectView(R.id.horizontalDividerOne)
    View horizontalDividerOne;
    @InjectView(R.id.monthlyInstallmentTextView)
    TextView monthlyInstallmentTextView;
    @InjectView(R.id.monthlyInvestTextView)
    EditText monthlyInvestTextView;
    @InjectView(R.id.monthlyRelativeContainer)
    RelativeLayout monthlyRelativeContainer;
    @InjectView(R.id.monthlySeekBar)
    SeekBar monthlySeekBar;
    @InjectView(R.id.monthlyBreakup)
    LinearLayout monthlyBreakup;
    @InjectView(R.id.horizontalDividerTwo)
    View horizontalDividerTwo;
    @InjectView(R.id.lumsumInstallmentTextView)
    TextView lumsumInstallmentTextView;
    @InjectView(R.id.lumsumInvestTextView)
    EditText lumsumInvestTextView;
    @InjectView(R.id.lumsumRelativeContainer)
    RelativeLayout lumsumRelativeContainer;
    @InjectView(R.id.lumsumSeekBar)
    SeekBar lumsumSeekBar;
    @InjectView(R.id.lumpsumBreakup)
    LinearLayout lumpsumBreakup;
    @InjectView(R.id.horizontalDividerThree)
    View horizontalDividerThree;
    @InjectView(R.id.timeTextView)
    TextView timeTextView;
    @InjectView(R.id.timeYearInvestTextView)
    TextView timeYearInvestTextView;
    @InjectView(R.id.timeMonthsInvestTextView)
    TextView timeMonthsInvestTextView;
    @InjectView(R.id.runsInvestmentTextView)
    TextView runsInvestmentTextView;
    @InjectView(R.id.timeRelativeContainer)
    RelativeLayout timeRelativeContainer;
    @InjectView(R.id.contactTextView)
    TextView contactTextView;
    @InjectView(R.id.filterLinearContainer)
    LinearLayout filterLinearContainer;
    @InjectView(R.id.lowRiskButton)
    AppCompatButton lowRiskButton;
    @InjectView(R.id.highRiskButton)
    AppCompatButton highRiskButton;
    @InjectView(R.id.yearEditText)
    EditText yearEditText;
    @InjectView(R.id.monthEditText)
    EditText monthEditText;
    @InjectView(R.id.runsYearEditText)
    EditText runsYearEditText;
    @InjectView(R.id.lumsumpSelectedValue)
    TextView lumsumpSelectedValue;
    @InjectView(R.id.saveAsDraftButton)
    Button saveAsDraftButton;
    @InjectView(R.id.saveInvestButton)
    Button saveInvestButton;
    private TextView[] dots;
    private int[] layouts;
    private int riskSelected = 0;
    private ProgressDialog progressDialog;
    public UpdateInvestment updateInvestment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setupViewPager(mViewpagerRetirementGoal);
        mTabsHomePage.setupWithViewPager(mViewpagerRetirementGoal);
        //TODO slides UI to be added
        layouts = new int[]{
                R.layout.layout_overview_fragment,
                R.layout.layout_fund_fragment};

        // adding bottom dots
        addBottomDots(0);
        //TODO slide pager adpater
        mViewpagerRetirementGoal.bringToFront();
        mViewpagerRetirementGoal.addOnPageChangeListener(viewPagerPageChangeListener);

        String mystring = new String("Want to know how much you\nshould save? Use this" + " RETIREMENT TOOL");
        final SpannableStringBuilder sb = new SpannableStringBuilder(mystring);
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.parseColor("#485FCD"));
        sb.setSpan(fcs, 47, mystring.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        final StyleSpan bss = new StyleSpan(Typeface.NORMAL);
        sb.setSpan(bss, 47, mystring.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        SpannableString content = new SpannableString(sb);
        content.setSpan(new UnderlineSpan(), 48, mystring.length(), 0);
        contactTextView.setText(content);

        //TODO risk selection listener
        riskSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 50) {
                    equityPerTextView.setText("50%");
                    debtPerTextView.setText("50%");
                } else if (progress < 50) {
                    equityPerTextView.setText(progress + "%");
                    debtPerTextView.setText(100 - progress + "%");
                } else if (progress > 50) {
                    equityPerTextView.setText(100 - progress + "%");
                    debtPerTextView.setText(progress + "%");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //TODO monthly investment selection listener
        monthlySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                monthlyInvestTextView.setText((progress + 1000) + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //TODO monthly investment selection listener
        lumsumSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lumsumInvestTextView.setText((progress + 30000) + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //TODO initialize progress dialog
        progressDialog = new ProgressDialog(TaskTwoActivity.this);
        progressDialog.setMessage("Saving investment...");
        progressDialog.setCanceledOnTouchOutside(false);
        mViewpagerRetirementGoal.beginFakeDrag();
    }

    //TODO setting up viewpager and number of tabs
    private void setupViewPager(ViewPager viewPager) {
        mHomeTabAdapter = new HomeTabAdapter(getSupportFragmentManager());
        mOverviewFragment = OverViewFragment.getInstance();
        mFundFragment = FundFragment.getInstance();
        mHomeTabAdapter.addFragment(mOverviewFragment, "OVERVIEW");
        mHomeTabAdapter.addFragment(mFundFragment, "FUNDS");
        viewPager.setAdapter(mHomeTabAdapter);
    }

    //TODO slide pager
    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
            } else {
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    //TODO dismiss activity
    @OnClick(R.id.backImageButton)
    public void funcCloseActivity() {
        finish();
    }

    //TODO low risk selected function
    @OnClick(R.id.lowRiskButton)
    public void funcLowRisk() {
        lowRiskButton.setBackgroundResource(R.drawable.selected_button_risk_drawable);
        moderateButton.setBackgroundResource(R.drawable.default_button_background);
        highRiskButton.setBackgroundResource(R.drawable.default_button_background);
        riskSeekBar.setProgress(40);
        riskSelected = 1;
    }

    //TODO moderate risk selected
    @OnClick(R.id.moderateButton)
    public void funcModerate() {
        lowRiskButton.setBackgroundResource(R.drawable.default_button_background);
        moderateButton.setBackgroundResource(R.drawable.selected_button_risk_drawable);
        highRiskButton.setBackgroundResource(R.drawable.default_button_background);
        riskSeekBar.setProgress(80);
        riskSelected = 2;
    }

    //TODO high risk selected
    @OnClick(R.id.highRiskButton)
    public void funcHighRisk() {
        lowRiskButton.setBackgroundResource(R.drawable.default_button_background);
        moderateButton.setBackgroundResource(R.drawable.default_button_background);
        highRiskButton.setBackgroundResource(R.drawable.selected_button_risk_drawable);
        riskSeekBar.setProgress(100);
        riskSelected = 3;
    }

    //TODO save as draft
    @OnClick(R.id.saveAsDraftButton)
    public void funcSaveDraft() {
        saveAsDraftButton.setBackgroundColor(Color.parseColor("#485FCD"));
        saveAsDraftButton.setTextColor(Color.parseColor("#FFFFFF"));
        saveInvestButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
        saveInvestButton.setTextColor(Color.parseColor("#485FCD"));
    }

    //TODO save as draft
    @OnClick(R.id.saveInvestButton)
    public void funcSaveInvest() {
        progressDialog.show();
        saveAsDraftButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
        saveAsDraftButton.setTextColor(Color.parseColor("#485FCD"));
        saveInvestButton.setBackgroundColor(Color.parseColor("#485FCD"));
        saveInvestButton.setTextColor(Color.parseColor("#FFFFFF"));
        HomeApi homeApi = ServiceGenerator.createService(HomeApi.class);
        homeApi.saveInvestment("YXcxNEFDTU4IAUN.cDUcOQYbZQwsLBgbMwQCYwIwfRomFERrEHU3Dw", Integer.parseInt(yearEditText.getText().toString()), "wealth",
                riskSelected, Double.parseDouble(monthlyInvestTextView.getText().toString()), new Callback<Investment>() {
                    @Override
                    public void success(Investment investment, Response response) {
                        //Update investment to top card projected amount
                        if (updateInvestment != null) {
                            updateInvestment.methodUpdateInvestment(investment.getMsg().getTotalInvestment());
                        }
                        progressDialog.dismiss();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                    }
                });


    }
}
