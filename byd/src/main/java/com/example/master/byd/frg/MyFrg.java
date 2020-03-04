package com.example.master.byd.frg;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.security.rp.RPSDK;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.activity.BusinessActivity;
import com.example.master.byd.activity.CertificationActivity;
import com.example.master.byd.activity.EquityActivity;
import com.example.master.byd.activity.LoginActivity;
import com.example.master.byd.activity.MySetActivity;
import com.example.master.byd.adapter.CustomExpandableListView;
import com.example.master.byd.adapter.MyExpandableListView;
import com.example.master.byd.bean.GetTokenResponse;
import com.example.master.byd.bean.MyYwlx;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.UserInfo;
import com.example.master.byd.core.BaseFragment;
import com.example.master.byd.presenter.AllowMyYwlxPresenter;
import com.example.master.byd.presenter.UserInfoByIdPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author byd
 * @date 2019/5/17 16:51
 */
public class MyFrg extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.textView3)
    TextView mTextView3;
    @BindView(R.id.textView4)
    TextView mTextView4;
    @BindView(R.id.imageView4)
    ImageView mImageView4;
    @BindView(R.id.textView5)
    TextView mTextView5;
    @BindView(R.id.textView7)
    TextView mTextView7;
    @BindView(R.id.textView6)
    TextView mTextView6;
    @BindView(R.id.view1)
    View mView1;
    @BindView(R.id.view2)
    View mView2;
    @BindView(R.id.image7)
    ImageView mImage7;

    @BindView(R.id.btn1)
    TextView btn1;
    @BindView(R.id.btn2)
    TextView btn2;
    @BindView(R.id.expandableListView)
    CustomExpandableListView expandableListView;
    @BindView(R.id.loginName)
    TextView mLoginName;
    Unbinder unbinder;
    @BindView(R.id.right)
    ImageView mRight;
    @BindView(R.id.approve)
    LinearLayout mApprove;
    @BindView(R.id.right2)
    ImageView mRight2;
    @BindView(R.id.equity)
    LinearLayout mEquity;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.chanqnmu)
    TextView mChanqnmu;
    Unbinder unbinder1;
    private List<MyYwlx.DataBean> groups = new ArrayList<>();

    private MyExpandableListView mMyExpandableListView;
    private AllowMyYwlxPresenter mAllowMyYwlxPresenter;
    private SharedPreferences mShare;
    private Dialog dialog;
    private String mSetid;


    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_frg;
    }

    @Override
    public void onResume() {
        super.onResume();
        initzai();
    }

    @Override
    protected void initView() {
        mShare = MyApp.getShare();
        mAllowMyYwlxPresenter = new AllowMyYwlxPresenter(new AllowMyYwlx());
        mAllowMyYwlxPresenter.reqeust("1", "1");

        myrefresh();


        dialog = new Dialog(getContext(), R.style.DialogTheme);

        clickthis();

        // 及时办理
        mMyExpandableListView = new MyExpandableListView(MyApp.getContext(), groups);

        expandableListView.setAdapter(mMyExpandableListView);
        expandableListView.setGroupIndicator(null);

        for (int i = 0; i < mMyExpandableListView.getGroupCount(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                TextView childAt = (TextView) ((LinearLayout) v).getChildAt(1);//获得点击列表中TextView的值，需要强转一下，否则找不到getChildAt方法
//                Toast.makeText(getBaseContext(), "点击了 "+childAt.getText()+" 列表", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void myrefresh() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mUserInfoByIdPresenter.reqeust(mSetid);
                mAllowMyYwlxPresenter.reqeust("1", "1");
                mRefreshLayout.finishRefresh();

            }
        });

    }

    private UserInfoByIdPresenter mUserInfoByIdPresenter;

    private void initzai() {

        boolean zai = MyApp.getShare().getBoolean("zai", false);
        if (!zai) {
            mTextView3.setText("未登录");
            mTextView5.setText("未设置昵称");
            mLoginName.setText("");
            mImageView4.setImageResource(R.drawable.head);
        } else if(MyApp.getShare().getBoolean("yi",false)){
            mUserInfoByIdPresenter = new UserInfoByIdPresenter(new UserInfoCall());
            mSetid = MyApp.getShare().getString("id", "");
            mUserInfoByIdPresenter.reqeust(mSetid);
        }
//            String realName = mShare.getString("realName", "未登录");
//            String nc = mShare.getString("nc", "未设置昵称");
//            String loginName = mShare.getString("loginName", "150******34");
//            String tx = mShare.getString("tx", "");
//            int chanqnum = mShare.getInt("chanqnum", 0);
//            if (TextUtils.isEmpty(tx)) {
//                mImageView4.setImageResource(R.drawable.head);
//            } else {
////                mImageView4.setImageURI(Uri.parse(tx));
//                Glide.with(getContext())
//                        .load(tx)
//                        .error(R.drawable.head)
//                        .diskCacheStrategy(DiskCacheStrategy.NONE)
//                        .into(mImageView4);
//            }
//            mLoginName.setText(loginName);
//            mTextView3.setText(realName);
//            if (chanqnum > 0) {
//                mChanqnmu.setVisibility(View.VISIBLE);
//                mChanqnmu.setText(chanqnum + "");
//            }
//            if (TextUtils.isEmpty(nc)) {
//                mTextView5.setText("未设置昵称");
//            } else {
//                mTextView5.setText(nc);
//            }
//        }
    }

    private void clickthis() {
        mTextView4.setOnClickListener(this);
        mImage7.setOnClickListener(this);
        mTextView7.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView5.setOnClickListener(this);
        mImageView4.setOnClickListener(this);
        myonclick();
    }

    private void myonclick() {
        //认证
        mApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mShare.getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {

                    String sfsmrz = MyApp.getShare().getString("sfsmrz", "");
                    if (sfsmrz.equals("是")) {
                        ToastUtils.showShort("已实名认证");
                    } else
                        mydialog();
                }
            }
        });
////        认证
//        mRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!mShare.getBoolean("zai", false)) {
//                    intent(LoginActivity.class);
//
//                } else {
//                    mydialog();
//                }
//            }
//        });
//        我的产权
        mEquity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mShare.getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {
                    intent(EquityActivity.class);

                }
//                intent(EquityActivity.class);
            }
        });
//        我的产权
        mRight2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mShare.getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {
                    intent(EquityActivity.class);

                }
            }
        });

    }

    private void mydialog() {
        View view1 = View.inflate(MyApp.getContext(), R.layout.attestationdialog, null);
        dialog.setContentView(view1);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
        getshoud();
        //取消
        TextView mcancle = view1.findViewById(R.id.cancle);
        mcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView bcertification = view1.findViewById(R.id.bcertification);
        bcertification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), CertificationActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        TextView zcertification = view1.findViewById(R.id.zcertification);
        zcertification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String sfsmrz = MyApp.getShare().getString("sfsmrz", "");
//                if (sfsmrz.equals("是")) {
//                    ToastUtils.showShort("已认证");
//                } else {
                    OkHttpUtils.get().url(NetWorkManager.BASE_URL + "/realEstate/app/token/getVerifyTokenByUserinfo?name=" + mShare.getString("realName", "") + "&idnumber=" + mShare.getString("sfzhm", ""))
                            .build().execute(new Callback<Result<GetTokenResponse>>() {
                        @Override
                        public Result<GetTokenResponse> parseNetworkResponse(Response response, int id) throws Exception {
                            return GsonUtils.fromJson(response.body().string(), GsonUtils.getType(Result.class, GetTokenResponse.class));
                        }

                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(Result<GetTokenResponse> response, int id) {
                            if (response.isSuccess()) {

                                renzheng(response.getMapResult());
                            }

                        }
                    });
//                }


                dialog.dismiss();
            }
        });
    }

    private void renzheng(final GetTokenResponse token) {
        RPSDK.start(token.getToken(), getContext(),
                new RPSDK.RPCompletedListener() {
                    @Override
                    public void onAuditResult(RPSDK.AUDIT audit, String s, String s1) {
//                        Toast.makeText(getContext(), audit + "", Toast.LENGTH_SHORT).show();
                        if (audit == RPSDK.AUDIT.AUDIT_PASS) { //认证通过
                            OkHttpUtils.get().url(NetWorkManager.BASE_URL + "/realEstate/app/user/certification?userId="
                                    + mShare.getString("id", "") + "&realName="
                                    + mShare.getString("realName", "")
                                    + "&sfzhm=" + mShare.getString("sfzhm", "") + "&biz=" + token.getBiz() + "&ticketId=" + token.getTicketId())
                                    .build().execute(new Callback<Result>() {

                                private ProgressDialog mShow;

                                @Override
                                public void onBefore(Request request, int id) {
                                    super.onBefore(request, id);
                                    mShow = ProgressDialog.show(getContext(), "提示", "正在加载", false);
                                }

                                @Override
                                public Result parseNetworkResponse(Response response, int id) throws Exception {
                                    return GsonUtils.fromJson(response.body().string(), Result.class);
                                }

                                @Override
                                public void onError(Call call, Exception e, int id) {

                                }

                                @Override
                                public void onResponse(Result response, int id) {
                                    if (response != null && response.isSuccess()) {

                                        ToastUtils.showLong("认证成功");
                                        MyApp.getShare().edit().putString("sfsmrz", "是").commit();
                                    }

                                }

                                @Override
                                public void onAfter(int id) {
                                    super.onAfter(id);
                                    mShow.dismiss();
                                }
                            });
                        } else if (audit == RPSDK.AUDIT.AUDIT_FAIL) { //认证不通过
                        } else if (audit == RPSDK.AUDIT.AUDIT_IN_AUDIT) { //认证中，通常不会出现，只有在认证审核系统内部出现超时，未在限定时间内返回认证结果时出现。此时提示用户系统处理中，稍后查看认证结果即可。
                        } else if (audit == RPSDK.AUDIT.AUDIT_NOT) { //未认证，用户取消
                        } else if (audit == RPSDK.AUDIT.AUDIT_EXCEPTION) { //系统异常
                        }
                    }

                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView3:
//                intent(MySetActivity.class);

                judgezai();
                break;
            case R.id.textView4:
                judgezai();
                break;
            case R.id.textView5:
                judgezai();
                break;
            case R.id.imageView4:
                judgezai();
                break;
            case R.id.textView7:
//                intent(BusinessActivity.class);

                if (!mShare.getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {
                    intent(BusinessActivity.class);

                }
                break;
            case R.id.image7:
                if (!mShare.getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {
                    intent(BusinessActivity.class);

                }
                break;
            case R.id.btn1:
                //业务办理 - 查询我能办理的业务列表（即时办结）
                mAllowMyYwlxPresenter.reqeust("1", "1");

                mView1.setVisibility(View.VISIBLE);
                mView2.setVisibility(View.GONE);
                mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshLayout) {
                        mAllowMyYwlxPresenter.reqeust("1", "1");

                        mRefreshLayout.finishRefresh();

                    }
                });
                break;
            case R.id.btn2:
                mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshLayout) {
                        mAllowMyYwlxPresenter.reqeust("1", "2");

                        mRefreshLayout.finishRefresh();

                    }
                });
                //业务办理 - 查询我能办理的业务列表（现场办结）
                mAllowMyYwlxPresenter.reqeust("1", "2");

                mView2.setVisibility(View.VISIBLE);
                mView1.setVisibility(View.GONE);

                break;
        }
    }

    private void judgezai() {
        boolean zai = mShare.getBoolean("zai", false);

        if (!zai) {
            intent(LoginActivity.class);
        } else {
            Log.i("tag", "judgezai: " + zai);

            intent(MySetActivity.class);
        }
    }

    private void getshoud() {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getActivity().getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height = (int) (d.getHeight() * 0.24);

        dialogWindow.setAttributes(p);
    }

    private class UserInfoCall implements DataCall<Result<UserInfo>> {
        @Override
        public void success(Result<UserInfo> data) {
            UserInfo.DataBean data1 = data.getMapResult().getData();
            mTextView3.setText(data1.getRealName());
            if (TextUtils.isEmpty(data1.getNc())) {
                mTextView5.setText("未设置昵称");

            } else {
                mTextView5.setText(data1.getNc());
            }
            mLoginName.setText(data1.getLoginName());
            Glide.with(getActivity())
                    .load(data1.getTx())
                    .error(R.drawable.head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(mImageView4);

//            mData1 = data.getMapResult().getData();
//            if (mData1.getNc() == null) {
//                mNc.setText("未设置");
//
//            } else {
//                mNc.setText(mData1.getNc());
//
//            }
//            Glide.with(getActivity())
//                    .load(mData1.getTx())
//                    .error(R.drawable.head)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
//                    .into(mTx);
//
//            UserInfoManager.setUserInfo(data.getMapResult());
//            SharedPreferences.Editor edit = mShare.edit();
//            edit.putString("id",mData1.getId());//id
//            edit.putString("realName", mData1.getRealName());//姓名
//            edit.putString("loginName", mData1.getLoginName());//手机号
//            edit.putString("tx", mData1.getTx());//头像
//            edit.putString("nc", mData1.getNc());//昵称
//            edit.putString("sfzhm", mData1.getSfzhm());//身份证号
//
//            edit.commit();
//            edit.putString()
//            String realName = mShare.getString("realName", "未登录");
//            String nc = mShare.getString("nc", "未设置昵称");
//            String loginName = mShare.getString("loginName", "150******34");
//            String tx = mShare.getString("tx", "");

        }

        @Override
        public void fail(ApiException e) {

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }


    private class AllowMyYwlx implements DataCall<Result<MyYwlx>> {
        @Override
        public void success(Result<MyYwlx> data) {
            List<MyYwlx.DataBean> data1 = data.getMapResult().getData();
            mMyExpandableListView.addAll(data1);
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
