package com.example.master.byd.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.security.rp.RPSDK;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.AddParentAdapter;
import com.example.master.byd.bean.GetTokenResponse;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.User;
import com.example.master.byd.bean.WhthinG;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.WhthinGPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class WhthinActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.integration)
    LinearLayout mIntegration;
    @BindView(R.id.one2)
    TextView mOne2;
    @BindView(R.id.tu1)
    LinearLayout mTu1;
    @BindView(R.id.tu)
    LinearLayout mTu;
    @BindView(R.id.search)
    TextView mSearch;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.idnumber)
    EditText mIdnumber;
    @BindView(R.id.parentre)
    RecyclerView mParentre;
    private Dialog dialog;
    WhthinGPresenter mWhthinGPresenter = new WhthinGPresenter(new WhthinGCall());
    List<User> mlist = new ArrayList<>();
    List<User> mparentlist = new ArrayList<>();
    private AddParentAdapter mAddParentAdapter;
    boolean flag;
    private ProgressDialog mProgressDialog;
    private SharedPreferences mShare;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_whthin;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("查档服务");
        mShare = MyApp.getShare();
        myonclick();
        dialog = new Dialog(this, R.style.DialogTheme);
        mTu.setBackground(getResources().getDrawable(R.drawable.blueback));
        mIntegration.setBackgroundColor(Color.WHITE);

    }

    private void myonclick() {
        //家庭
        mIntegration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntegration.setBackground(getResources().getDrawable(R.drawable.blueback));
                mTu.setBackgroundColor(Color.WHITE);
//                mTu.setBackground(getResources().getDrawable(R.drawable.blueback));
//                mIntegration.setBackgroundColor(Color.WHITE);
                mOne2.setVisibility(View.VISIBLE);
                mTu1.setVisibility(View.GONE);
                mParentre.setVisibility(View.VISIBLE);
                flag = true;
            }
        });
        //个人
        mTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTu.setBackground(getResources().getDrawable(R.drawable.blueback));
                mIntegration.setBackgroundColor(Color.WHITE);
                mTu1.setVisibility(View.VISIBLE);
                mOne2.setVisibility(View.GONE);
                mParentre.setVisibility(View.GONE);
                flag = false;
            }
        });
        //添加家庭成员
        mOne2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.adddialog, null);
                dialog.setContentView(view1);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                getshoud(1);
                final EditText addname = view1.findViewById(R.id.addname);
                final EditText addzjh = view1.findViewById(R.id.addzjh);
                //取消
                TextView mcancle = view1.findViewById(R.id.cancle);
                mcancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //添加
                TextView maddpar = view1.findViewById(R.id.addpar);
                maddpar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String mname = addname.getText().toString();
                        String midnumber = addzjh.getText().toString();


                        mparentlist.add(new User(mname, midnumber));


                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
                        mParentre.setLayoutManager(linearLayoutManager);

                        mAddParentAdapter = new AddParentAdapter(MyApp.getContext(), mparentlist);
                        mParentre.setAdapter(mAddParentAdapter);


                        Toast.makeText(WhthinActivity.this, "添加成功！！！", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
//开始查询
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mname = mName.getText().toString();
                String midnumber = mIdnumber.getText().toString();

                if (!MyApp.getShare().getBoolean("zai", false)) {
                    intent(LoginActivity.class);

                } else {
//                    mydialog();
//                    String sfsmrz = MyApp.getShare().getString("sfsmrz", "");
//                    if (sfsmrz.equals("是")) {
//                        ToastUtils.showShort("已实名认证");
//                    } else{
//
//                    }

                mlist.clear();
                if (!TextUtils.isEmpty(mname)&&!TextUtils.isEmpty(midnumber)){
                    mlist.add(new User(mname, midnumber));
                }
                if (flag){
                    //家庭
                    if (mparentlist.size()>0) {
                        mydialog();
                    }else{
                        ToastUtils.showShort("请添加家庭成员");
                    }
                }else{
                    //个人
                    if (mlist.size()>0) {
                        mydialog();
                    }else{
                        ToastUtils.showShort("姓名或身份证不能为空");
                    }
                }

                }
            }
        });

    }

    private void chad() {
        View view1 = View.inflate(MyApp.getContext(), R.layout.hintdialog, null);
        dialog.setContentView(view1);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
        getshoud(2);
        //取消
        TextView mcancle = view1.findViewById(R.id.cancle);
        mcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        //确定
        TextView msure = view1.findViewById(R.id.sure);
        msure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    mWhthinGPresenter.reqeust(GsonUtils.toJson(mparentlist));
                } else {
                    mWhthinGPresenter.reqeust(GsonUtils.toJson(mlist));
                }
                mProgressDialog = ProgressDialog.show(BaseActivity.getForegroundActivity(), "提示", "Loading");
                mProgressDialog.setCanceledOnTouchOutside(true);
                dialog.dismiss();
            }
        });
    }

    private void getshoud(int bottom) {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        if (bottom == 1) {
            p.height = (int) (d.getHeight() * 0.33);
        } else {
            p.height = (int) (d.getHeight() * 0.25);

        }
        dialogWindow.setAttributes(p);
    }

    @Override
    protected void destoryData() {

    }


    private class WhthinGCall implements DataCall<Result<WhthinG>> {
        @Override
        public void success(Result<WhthinG> data) {

            WhthinG.DataBean data1 = data.getMapResult().getData();
            if (data1 != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("whthin", data1);
                intent(Whthin2Activity.class, bundle);
            } else {
                ToastUtils.showShort("没有查询到数据");

            }
            mProgressDialog.dismiss();

        }

        @Override
        public void fail(ApiException e) {
            mProgressDialog.dismiss();
            ToastUtils.showShort("查询失败");
        }
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
                String sfsmrz = MyApp.getShare().getString("sfsmrz", "");
                if (sfsmrz.equals("是")) {
                    ToastUtils.showShort("已认证");
                    chad();
                } else {
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
                }


                dialog.dismiss();
            }
        });
    }
    private void getshoud() {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height = (int) (d.getHeight() * 0.24);

        dialogWindow.setAttributes(p);
    }

    private void renzheng(final GetTokenResponse token) {
        RPSDK.start(token.getToken(), this,
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
                                    mShow = ProgressDialog.show(WhthinActivity.this, "提示", "正在加载", false);
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

}
