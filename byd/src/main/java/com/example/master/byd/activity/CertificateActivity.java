package com.example.master.byd.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.GsonUtils;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.bean.MyRealEstate;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.ZhengshuInfoResponse;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.frg.CellFragment;
import com.example.master.byd.frg.CertificateFragment;
import com.example.master.byd.frg.HomeFragment;
import com.example.master.byd.frg.PlaceFragment;
import com.example.master.byd.frg.SiteFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class CertificateActivity extends BaseActivity {
    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;

    @BindView(R.id.radio1)
    RadioButton mRadio1;
    @BindView(R.id.radio2)
    RadioButton mRadio2;
    @BindView(R.id.radio3)
    RadioButton mRadio3;
    //    @BindView(R.id.radio4)
//    RadioButton mRadio4;
//    @BindView(R.id.radio5)
//    RadioButton mRadio5;
    @BindView(R.id.framel)
    FrameLayout mFramel;
    private HomeFragment mHomeFragment;
    private CertificateFragment mCertificateFragment;
    private CellFragment mCellFragment;
    private PlaceFragment mPlaceFragment;
    private SiteFragment mSiteFragment;
    private MyRealEstate.DataBean mData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_certificate;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSet.setText("证书信息");

        mData = (MyRealEstate.DataBean) getIntent().getSerializableExtra("data");
        mHomeFragment = new HomeFragment();
        mCertificateFragment = new CertificateFragment();
        mCellFragment = new CellFragment();
//        mPlaceFragment = new PlaceFragment();
//        mSiteFragment = new SiteFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.framel, mHomeFragment);
        fragmentTransaction.add(R.id.framel, mCertificateFragment);
        fragmentTransaction.add(R.id.framel, mCellFragment);
//        fragmentTransaction.add(R.id.framel, mPlaceFragment);
//        fragmentTransaction.add(R.id.framel, mSiteFragment);
        fragmentTransaction.hide(mCertificateFragment);
        fragmentTransaction.hide(mCellFragment);
//        fragmentTransaction.hide(mPlaceFragment);
//        fragmentTransaction.hide(mSiteFragment);
        fragmentTransaction.commit();

        myonclick();

        performRequest();

    }

    private void performRequest() {
        String zs = null;
        int zsnum = MyApp.getShare().getInt("zsnum", 1);
        if (zsnum == 1) {
            if (mData != null) {
                zs = "http://47.110.150.232:9999/realEstate/app/cx/getUserEC?name=" + mData.getQlr() + "&idnumber=" + mData.getZjh() + "&zsh=" + mData.getZs() + "&cxlx=zs";
            }
        }else if (zsnum==2){
            zs="http://47.110.150.232:9999/realEstate/app/yw/getUserEC?slbh=201900020611&cxlx=zs&bdcdyh=371602111013GB00002F00311163";
        }
        OkHttpUtils.get().url(zs)
                .build().execute(new Callback<Result<ZhengshuInfoResponse>>() {

            private ProgressDialog mShow;

            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
                mShow = ProgressDialog.show(CertificateActivity.this, "提示", "正在加载", false, false);
            }

            @Override
            public Result<ZhengshuInfoResponse> parseNetworkResponse(Response response, int id) throws Exception {
                return GsonUtils.fromJson(response.body().string(), GsonUtils.getType(Result.class, ZhengshuInfoResponse.class));
            }

            @Override
            public void onError(Call call, Exception e, int id) {

                Log.e("tag", "onError: ", e);
            }

            @Override
            public void onResponse(Result<ZhengshuInfoResponse> response, int id) {

                mCertificateFragment.setData(response.getMapResult().getData().getDzzs());
                mCellFragment.setData(response.getMapResult().getData().getDy());

            }

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
                mShow.dismiss();
            }
        });
    }

    private void myonclick() {

        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.hide(mHomeFragment);
                fragmentTransaction.hide(mCertificateFragment);
                fragmentTransaction.hide(mCellFragment);
//                fragmentTransaction.hide(mPlaceFragment);
//                fragmentTransaction.hide(mSiteFragment);
                switch (i) {
                    case R.id.radio1:
                        fragmentTransaction.show(mHomeFragment);
                        break;
                    case R.id.radio2:
                        fragmentTransaction.show(mCertificateFragment);

                        break;
                    case R.id.radio3:
                        fragmentTransaction.show(mCellFragment);

                        break;
//                    case R.id.radio4:
//                        fragmentTransaction.show(mPlaceFragment);
//
//                        break;
//                    case R.id.radio5:
//                        fragmentTransaction.show(mSiteFragment);
//
//                        break;

                }
                fragmentTransaction.commit();

            }
        });

    }

    @Override
    protected void destoryData() {

//        EncodeUtils.base64Encode(ImageUtils.bitmap2Bytes("",Bitmap.CompressFormat.JPEG))

    }

}
