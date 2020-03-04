package com.example.master.byd.frg;


import android.support.v4.app.Fragment;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteFragment extends BaseFragment {


    @Override
    public String getPageName() {
        return "现场";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_site;
    }

    @Override
    protected void initView() {

    }

}
