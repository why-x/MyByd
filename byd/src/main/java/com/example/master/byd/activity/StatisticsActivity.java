package com.example.master.byd.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.frg.DaysFragment;
import com.example.master.byd.frg.MonthFragment;
import com.example.master.byd.frg.WeekFragment;

import butterknife.BindView;

public class StatisticsActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.radio1)
    RadioButton mRadio1;
    @BindView(R.id.radio2)
    RadioButton mRadio2;
    @BindView(R.id.radio3)
    RadioButton mRadio3;
    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;
    private DaysFragment mDaysFragment;
    private WeekFragment mWeekFragment;
    private MonthFragment mMonthFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_statistics;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("统计信息");

        mDaysFragment = new DaysFragment();
        mWeekFragment = new WeekFragment();
        mMonthFragment = new MonthFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.framel, mDaysFragment);
        fragmentTransaction.add(R.id.framel, mWeekFragment);
        fragmentTransaction.add(R.id.framel, mMonthFragment);
        fragmentTransaction.hide(mWeekFragment);
        fragmentTransaction.hide(mMonthFragment);
        fragmentTransaction.commit();
        myonclick();


    }

    private void myonclick() {
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.hide(mDaysFragment);
                fragmentTransaction.hide(mWeekFragment);
                fragmentTransaction.hide(mMonthFragment);
                switch (i) {
                    case R.id.radio1:
                        fragmentTransaction.show(mDaysFragment);
                        break;
                    case R.id.radio2:
                        fragmentTransaction.show(mWeekFragment);

                        break;
                    case R.id.radio3:
                        fragmentTransaction.show(mMonthFragment);

                        break;
                }
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    protected void destoryData() {

    }


}
