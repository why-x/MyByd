package com.example.master.byd.frg;


import android.support.v4.app.Fragment;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends BaseFragment {


    @Override
    public String getPageName() {
        return "工作台";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void initView() {

    }

}
