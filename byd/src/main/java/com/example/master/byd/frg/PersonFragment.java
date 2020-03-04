package com.example.master.byd.frg;


import android.support.v4.app.Fragment;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment {

    @Override
    public String getPageName() {
        return "个人中心";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initView() {

    }

}
