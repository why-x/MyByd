package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MainAdapter;
import com.example.myapplication.fragment.OneFragment;
import com.example.myapplication.fragment.PagerFragment;
import com.example.myapplication.fragment.ThreeFragment;
import com.example.myapplication.fragment.TwoFragment;
import com.example.myapplication.weight.OutRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.PagerChangeListener{

    private List<String> data = new ArrayList<>();
    private List<PagerFragment> fragments = new ArrayList<>();
    public boolean innerCanScroll = true;
    private VirtualLayoutManager virtualLayoutManager;
    private MainAdapter mainAdapter;
    private PagerFragment currentFragment;

    private float downX ;    //按下时 的X坐标
    private float downY ;    //按下时 的Y坐标
    public OutRecyclerView rv;
    private DelegateAdapter delegateAdapter;
    public boolean isStick=false;
    private RelativeLayout rootView;
    private int yCriticalPoint;
    public static int rvYPosition=-10000;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data.add("推荐");
        data.add("男装");
        data.add("女装");

        rv = (OutRecyclerView)findViewById(R.id.rv);
        rootView = findViewById(R.id.rl_root);
        virtualLayoutManager = new VirtualLayoutManager(this);
        rv.setLayoutManager(virtualLayoutManager);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        rv.setAdapter(delegateAdapter);
        rv.setNestedScrollingEnabled(true);
        //状态栏高度
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            statusBarHeight =getResources().getDimensionPixelSize(resourceId);
        }
        //屏幕高度
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        for (int i = 0; i <data.size() ; i++) {
            fragments.add(PagerFragment.newInstance(data.get(i))) ;
        }
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        fragments.add(threeFragment);
        final float scale = dm.density;
        int i = (int) (54 * scale + 0.5f);
        yCriticalPoint=statusBarHeight+i;
        currentFragment=fragments.get(0);
        mainAdapter = new MainAdapter(this,getSupportFragmentManager(),data, fragments,dm.heightPixels-statusBarHeight-i);
        delegateAdapter.addAdapter(mainAdapter);
        mainAdapter.setPagerChangeListener(this);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public void adjustIntercept(boolean b){
        rv.setNeedIntercept(b);
    }

    @Override
    public void pagerChange(int position) {
        currentFragment=fragments.get(position);
    }

}
