package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myapplication.R;
import com.example.myapplication.fragment.PagerFragment;
import com.example.myapplication.holder.PageViewHolder;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2018/8/22 0022
 * My email : logisong@163.com
 * The role of this :
 */
public class MainAdapter extends DelegateAdapter.Adapter {

    private FragmentManager fragmentManager;
    private Context context;
    private List<String> titles;
    private int height;
    private PageViewHolder pageViewHolder;
    private PagerAdapter adapter;
    //记录上次展示的tab位置
    private int lastItem;
    private boolean isStick = false;
    private int statusBarHeight;
    private List<PagerFragment> fragments;

    private PagerChangeListener pagerChangeListener;
    private CertificateAdapter certificateAdapter;

    public MainAdapter(Context context, FragmentManager fragmentManager, List<String> titles, List<PagerFragment> fragments, int height) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.height = height;
        this.titles = titles;
        this.fragments = fragments;
    }

    private int TOP_COUNT = 6;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case 0:
//                标题
                viewHolder = new TitleViewHolder(View.inflate(parent.getContext(), R.layout.rv_item_title, null));
                break;
            case 1:
//                banner
                viewHolder = new BannerViewHolder(View.inflate(parent.getContext(), R.layout.rv_item_banner, null));
                break;
            case 2:
//                申报
                viewHolder = new MainViewHolder(View.inflate(parent.getContext(), R.layout.rv_item_normal, null));
                break;
            case 3:
//                证书、产品、生产厂商
                viewHolder = new PageViewHolder(View.inflate(parent.getContext(), R.layout.rv_item_pager, null));
                break;
        }

        //返回布局
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 2:
                MainViewHolder mainViewHolder = (MainViewHolder) holder;
                List<String> certificatelist = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    certificatelist.add("第" + i + "条");
                }
                certificateAdapter = new CertificateAdapter(context, certificatelist);
                mainViewHolder.recyclerview.setLayoutManager(new LinearLayoutManager(context));
                mainViewHolder.recyclerview.setAdapter(certificateAdapter);
                certificateAdapter.notifyDataSetChanged();
                break;
            case 3:
                pageViewHolder = (PageViewHolder) holder;
                if (adapter == null) {
                    adapter = new MainPagerAdapter(fragmentManager, titles, fragments);
                }
                pageViewHolder.mViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                pageViewHolder.tabLayout.setupWithViewPager(pageViewHolder.mViewPager);
                if (lastItem > 0) {
                    pageViewHolder.mViewPager.setCurrentItem(lastItem);
                }
                //RecyclerView嵌套ViewPager会出现高度为0的bug,这里给ViewPager设置的高度为屏幕高度-状态栏高度
                ViewGroup.LayoutParams layoutParams = pageViewHolder.mViewPager.getLayoutParams();
                layoutParams.height = height;
                pageViewHolder.mViewPager.setLayoutParams(layoutParams);
                pageViewHolder.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (pagerChangeListener != null) {
                            pagerChangeListener.pagerChange(position);
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    int itemposition = 0;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                itemposition = 0;
                break;
            case 1:
                itemposition = 1;
                break;
            case 2:
                itemposition = 2;
                break;
            case 3:
                itemposition = 3;
                break;
        }
        return itemposition;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerview;

        public MainViewHolder(View itemView) {
            super(itemView);
            recyclerview = itemView.findViewById(R.id.ry);
        }
    }

    public interface PagerChangeListener {
        void pagerChange(int position);
    }

    public void setPagerChangeListener(PagerChangeListener pagerChangeListener) {
        this.pagerChangeListener = pagerChangeListener;
    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TitleViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.txv);

        }
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        public BannerViewHolder(View view) {
            super(view);
        }
    }
}
