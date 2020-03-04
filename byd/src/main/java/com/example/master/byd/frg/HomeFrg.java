package com.example.master.byd.frg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.activity.HomeActivity;
import com.example.master.byd.activity.InspectionActivity;
import com.example.master.byd.activity.PayFActivity;
import com.example.master.byd.activity.ProgressActivity;
import com.example.master.byd.activity.ScanActivity;
import com.example.master.byd.activity.WhthinActivity;
import com.example.master.byd.adapter.Homere1Adapter;
import com.example.master.byd.adapter.Homere2Adapter;
import com.example.master.byd.bean.About;
import com.example.master.byd.bean.Banners;
import com.example.master.byd.bean.News;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseFragment;
import com.example.master.byd.presenter.AboutPresenter;
import com.example.master.byd.presenter.BannersPresenter;
import com.example.master.byd.presenter.NewsPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author byd
 * @date 2019/5/17 16:50
 */
public class HomeFrg extends BaseFragment {

    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.imageView3)
    ImageView mImageView3;
    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.recyclerView2)
    RecyclerView mRecyclerView2;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.salesman)
    LinearLayout mSalesman;
    @BindView(R.id.progress)
    LinearLayout mProgress;
    @BindView(R.id.whthin)
    LinearLayout mWhthin;
    @BindView(R.id.pay)
    LinearLayout mPay;
    InputMethodManager manager;//输入法管理器
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private Homere2Adapter mHomere2Adapter;
    List<About.DataBean> myList = new ArrayList();
    List<News.DataBean> newsList = new ArrayList();
    private List<Integer> mList;
    private List<String> mBannerlist;
    private Homere1Adapter mHomere1Adapter;
    private BannersPresenter mBannersPresenter;
    private NewsPresenter mNewsPresenter;
    private AboutPresenter mAboutPresenter;


    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_frg;
    }

    @Override
    protected void initView() {
        mRefreshLayout.setEnableRefresh(true);//启用刷新
//        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        qingqiu();
        myrefresh();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //最新资讯
        mHomere1Adapter = new Homere1Adapter(MyApp.getContext(), newsList);
        mRecyclerView.setAdapter(mHomere1Adapter);
        //关于我们
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));
        mHomere2Adapter = new Homere2Adapter(MyApp.getContext(), myList);

        mRecyclerView2.setAdapter(mHomere2Adapter);
        mRecyclerView2.addItemDecoration(new HorizontalDividerItemDecoration.Builder(MyApp.getContext())
                .color(Color.parseColor("#64f0f0f0"))  //颜色
                .size(2)        //大小
                .margin(0, 2)    //距离
                .build());


        // 设置数据
        myonclik();
//        initPermission();



    }

    private void qingqiu() {
        mBannersPresenter = new BannersPresenter(new BannerCall());
        mNewsPresenter = new NewsPresenter(new NewsCall());
        mAboutPresenter = new AboutPresenter(new AboutCall());
        mBannersPresenter.reqeust();
        mNewsPresenter.reqeust();
        mAboutPresenter.reqeust();
    }

    private void myrefresh() {
        //刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mBannersPresenter.reqeust();
                mNewsPresenter.reqeust();
                mAboutPresenter.reqeust();
                refreshlayout.finishRefresh();
            }
        });
    }

    private void setBanner() {
        mList = new ArrayList<>();
        mList.add(R.drawable.banx);
        mList.add(R.drawable.ban1);
        mList.add(R.drawable.ban7);
        mList.add(R.drawable.banx3);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
//                imageView.setImageResource((Integer) path);
                Glide.with(context)
                        .load(path)
                        .error(R.drawable.banx)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(imageView);
            }
//                Glide.with(context).load((Integer) path).into(imageView);

        });
        mBanner.setImages(mBannerlist);
        mBanner.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRefreshLayout.finishRefresh();
    }

    private void myonclik() {
        //查验 搜索
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
        //业务办理
        mSalesman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(onButtonClick!=null){
//                    onButtonClick.onClick(mSalesman);
//                }


                //获取Fragment的管理器
//                FragmentManager fragmentManager=getFragmentManager();
//                //开启fragment的事物,在这个对象里进行fragment的增删替换等操作。
//                FragmentTransaction ft=fragmentManager.beginTransaction();
//                //跳转到fragment，第一个参数为所要替换的位置id，第二个参数是替换后的fragment
//                ft.replace(R.layout.home_frg,new MyFrg());
//                //提交事物
//                ft.commit();
//                getFragmentManager()
//                        .beginTransaction()
//                        .addToBackStack(null)  //将当前fragment加入到返回栈中
//                        .replace(R.id.container, new MyFrg()).commit();
//                intent(SellActivity.class);

//                zai = MyApp.getShare().getBoolean("zai", false);
//                //判断是否已经登录
//                if (!zai) {
//                    Toast.makeText(MyApp.getContext(),"请登录",Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(MyApp.getContext(),LoginActivity.class);
//                    startActivity(intent);
//                } else {
//                    intent(SellActivity.class);
//
//                }
                ((HomeActivity) getActivity()).tiao();

            }
        });
        //查档服务
        mWhthin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), WhthinActivity.class);
                startActivity(intent);
            }
        });
        //进度查询
        mProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), ProgressActivity.class);
                startActivity(intent);
            }
        });
        //在线缴费
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), PayFActivity.class);
                startActivity(intent);
            }
        });

//        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                /*隐藏软键盘*/
//                InputMethodManager inputMethodManager = (InputMethodManager) v
//                        .getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (inputMethodManager.isActive()) {
//                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
//                }
//
//                /*判断是否是“搜索”键*/
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    String key = mEditText.getText().toString().trim();
//                    Intent intent = new Intent(MyApp.getContext(), InspectionActivity.class);
//                    startActivity(intent);
//                    return true;
//                }
//
//                Intent intent = new Intent(MyApp.getContext(), InspectionActivity.class);
//                startActivity(intent);
//                mEditText.setText("");
//                return false;
//            }
//        });

        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
        //二维码
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ScanActivity.class);
            }
        });
    }

    private class AboutCall implements DataCall<Result<About>> {
        @Override
        public void success(Result<About> data) {
            List<About.DataBean> data1 = data.getMapResult().getData();
            mHomere2Adapter.addAll(data1);
        }

        @Override
        public void fail(ApiException e) {
        }
    }

    private class BannerCall implements DataCall<Result<Banners>> {
        @Override
        public void success(Result<Banners> data) {
            List<Banners.DataBean> data1 = data.getMapResult().getData();
//            Toast.makeText(MyApp.getContext(), data.getMapResult().getData().size() + "------------", Toast.LENGTH_SHORT).show();

            mBannerlist = new ArrayList<>();
            for (int i = 0; i < data1.size(); i++) {
                String imgPath = data1.get(i).getIMG_PATH();
                Log.i("tag", "+++++" + imgPath);
                mBannerlist.add(imgPath);
            }
            setBanner();
        }

        @Override
        public void fail(ApiException e) {
        }
    }

    private class NewsCall implements DataCall<Result<News>> {
        @Override
        public void success(Result<News> data) {
//            Toast.makeText(MyApp.getContext(), data.getMapResult().getData().toString(), Toast.LENGTH_SHORT).show();
            List<News.DataBean> data1 = data.getMapResult().getData();
            if (data1.size() > 3) {
                data1 = data1.subList(0, 4);
            }
            mHomere1Adapter.addAll(data1);
        }

        @Override
        public void fail(ApiException e) {
        }
    }
}
