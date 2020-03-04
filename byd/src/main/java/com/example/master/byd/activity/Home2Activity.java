package com.example.master.byd.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.frg.HometwoFragment;
import com.example.master.byd.frg.InquiryFragment;
import com.example.master.byd.frg.PersonFragment;
import com.example.master.byd.frg.WorkFragment;

public class Home2Activity extends BaseActivity {


    private HometwoFragment mHometwoFragment;
    private InquiryFragment mInquiryFragment;
    private WorkFragment mWorkFragment;
    private PersonFragment mPersonFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationtwo);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        mHometwoFragment = new HometwoFragment();
        mWorkFragment = new WorkFragment();
        mInquiryFragment = new InquiryFragment();
        mPersonFragment = new PersonFragment();

        fragmentTransaction.add(R.id.fl, mHometwoFragment);
        fragmentTransaction.add(R.id.fl, mWorkFragment);
        fragmentTransaction.add(R.id.fl, mInquiryFragment);
        fragmentTransaction.add(R.id.fl, mPersonFragment);
        fragmentTransaction.hide(mWorkFragment);
        fragmentTransaction.hide(mInquiryFragment);
        fragmentTransaction.hide(mPersonFragment);
        fragmentTransaction.commit();
        this.closeSwipeBack();
    }

    @Override
    protected void destoryData() {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.hide(mHometwoFragment);
            fragmentTransaction.hide(mWorkFragment);
            fragmentTransaction.hide(mInquiryFragment);
            fragmentTransaction.hide(mPersonFragment);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.show(mHometwoFragment).commit();
                    return true;

                case R.id.navigation_class:
                    fragmentTransaction.show(mWorkFragment).commit();
                    return true;

                case R.id.navigation_car:
                    fragmentTransaction.show(mInquiryFragment).commit();
                    return true;

                case R.id.navigation_my:
                    fragmentTransaction.show(mPersonFragment).commit();
                    return true;

            }

            return false;
        }
    };

}
