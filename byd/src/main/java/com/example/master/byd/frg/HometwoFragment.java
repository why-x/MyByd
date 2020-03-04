package com.example.master.byd.frg;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HometwoFragment extends BaseFragment {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.free)
    RadioButton mFree;
    @BindView(R.id.pay)
    RadioButton mPay;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.radio1)
    RadioButton mRadio1;
    @BindView(R.id.radio2)
    RadioButton mRadio2;
    @BindView(R.id.radio3)
    RadioButton mRadio3;
    @BindView(R.id.one)
    RadioButton mOne;
    @BindView(R.id.three)
    RadioButton mThree;
    @BindView(R.id.week)
    RadioButton mWeek;
    @BindView(R.id.month)
    RadioButton mMonth;
    @BindView(R.id.spinner2)
    Spinner mSpinner2;
    @BindView(R.id.spinner3)
    Spinner mSpinner3;
    @BindView(R.id.pradiogroup)
    RadioGroup mPradiogroup;
    @BindView(R.id.dayradiogroup)
    RadioGroup mDayradiogroup;

    @Override
    public String getPageName() {
        return "首页";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hometwo;
    }

    @Override
    protected void initView() {

        set.setText("发布挂牌信息");

        myonclick();
    }

    private void myonclick() {


        mPradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio1:
                        mRadio1.setTextColor(Color.parseColor("#1890ff"));
                        mRadio2.setTextColor(Color.BLACK);
                        mRadio3.setTextColor(Color.BLACK);
                        break;
                    case R.id.radio2:

                        mRadio1.setTextColor(Color.BLACK);
                        mRadio2.setTextColor(Color.parseColor("#1890ff"));
                        mRadio3.setTextColor(Color.BLACK);
                        break;
                    case R.id.radio3:
                        mRadio1.setTextColor(Color.BLACK);
                        mRadio2.setTextColor(Color.BLACK);
                        mRadio3.setTextColor(Color.parseColor("#1890ff"));
                        break;


                }
            }
        });

        mDayradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.one:
                        mOne.setTextColor(Color.WHITE);
                        mThree.setTextColor(Color.BLACK);
                        mWeek.setTextColor(Color.BLACK);
                        mMonth.setTextColor(Color.BLACK);

                        break;
                    case R.id.three:

                        mOne.setTextColor(Color.BLACK);
                        mThree.setTextColor(Color.WHITE);
                        mWeek.setTextColor(Color.BLACK);
                        mMonth.setTextColor(Color.BLACK);

                        break;
                    case R.id.week:
                        mOne.setTextColor(Color.BLACK);
                        mThree.setTextColor(Color.BLACK);
                        mWeek.setTextColor(Color.WHITE);
                        mMonth.setTextColor(Color.BLACK);

                        break;
                    case R.id.month:
                        mOne.setTextColor(Color.BLACK);
                        mThree.setTextColor(Color.BLACK);
                        mWeek.setTextColor(Color.BLACK);
                        mMonth.setTextColor(Color.WHITE);
                        break;


                }

            }
        });

    }

}
