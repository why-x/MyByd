package com.example.master.byd.frg;


import android.support.v4.app.Fragment;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class InquiryFragment extends BaseFragment {

    @Override
    public String getPageName() {
        return "询单报价";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inquiry;
    }

    @Override
    protected void initView() {

    }

}
