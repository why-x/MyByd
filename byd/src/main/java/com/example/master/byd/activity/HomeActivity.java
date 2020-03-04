package com.example.master.byd.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.frg.CarFrg;
import com.example.master.byd.frg.ClassFrg;
import com.example.master.byd.frg.HomeFrg;
import com.example.master.byd.frg.MyFrg;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.fl)
    FrameLayout mFl;


    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    private HomeFrg mHomeFrg;
    private ClassFrg mClassFrg;
    private CarFrg mCarFrg;
    private MyFrg mMyFrg;
    private FragmentTransaction mFragmentTransaction;
    private BottomNavigationView mNavigation1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    public void tiao(){
        FragmentTransaction afragmentTransaction = getSupportFragmentManager().beginTransaction();
        afragmentTransaction = getSupportFragmentManager().beginTransaction();
        afragmentTransaction.hide(mHomeFrg);
        afragmentTransaction.show(mMyFrg).commit();
        mNavigation1.setSelectedItemId(R.id.navigation_my);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mNavigation1 = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigation1.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        navigation.setItemIconTintList(null);//除去自带效果

        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mHomeFrg = new HomeFrg();
        mClassFrg = new ClassFrg();
        mCarFrg = new CarFrg();
        mMyFrg = new MyFrg();

        mFragmentTransaction.add(R.id.fl, mHomeFrg);
        mFragmentTransaction.add(R.id.fl, mClassFrg);
        mFragmentTransaction.add(R.id.fl, mCarFrg);
        mFragmentTransaction.add(R.id.fl, mMyFrg);
        mFragmentTransaction.hide(mClassFrg);
        mFragmentTransaction.hide(mCarFrg);
        mFragmentTransaction.hide(mMyFrg);
        mFragmentTransaction.commit();

//
//        mHomeFrg.setOnButtonClick(new HomeFrg.OnButtonClick() {
//
//            @Override
//            public void onClick(View view) {
////                //切换到TwoFragment
////                getSupportFragmentManager().beginTransaction()
////                        //替换为TwoFragment
////                        .replace(R.id.fl, mMyFrg)
////                        .commit();
//
//            }
//        });
        this.closeSwipeBack();
    }


    @Override
    protected void destoryData() {

    }

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction afragmentTransaction = getSupportFragmentManager().beginTransaction();
            afragmentTransaction = getSupportFragmentManager().beginTransaction();
            afragmentTransaction.hide(mHomeFrg);
            afragmentTransaction.hide(mClassFrg);
            afragmentTransaction.hide(mCarFrg);
            afragmentTransaction.hide(mMyFrg);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    afragmentTransaction.show(mHomeFrg).commit();
                    return true;

                case R.id.navigation_class:
                    afragmentTransaction.show(mClassFrg).commit();
                    return true;

                case R.id.navigation_car:
                    afragmentTransaction.show(mCarFrg).commit();
                    return true;

                case R.id.navigation_my:
                    afragmentTransaction.show(mMyFrg).commit();
                    return true;

            }

            return false;
        }
    };

}
