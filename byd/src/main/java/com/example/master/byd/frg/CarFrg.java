package com.example.master.byd.frg;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.activity.Progress2Activity;
import com.example.master.byd.activity.Progress3Activity;
import com.example.master.byd.bean.MyJDBean;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseFragment;
import com.example.master.byd.presenter.DWMytJDPresenter;
import com.example.master.byd.presenter.MytJDPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.ToastUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * @author byd
 * @date 2019/5/17 16:51
 */
public class CarFrg extends BaseFragment {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.personage)
    LinearLayout mPersonage;
    @BindView(R.id.unit)
    LinearLayout mUnit;
    @BindView(R.id.bnum)
    EditText mBnum;
    @BindView(R.id.personage2)
    EditText mPersonage2;
    @BindView(R.id.unit2)
    EditText mUnit2;

    @BindView(R.id.search)
    TextView mSearch;
    Unbinder unbinder;
    private Dialog dialog;
    String cxlx = "1";

    @Override
    public String getPageName() {
        return "查进度";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.car_frg;
    }

    @Override
    protected void initView() {
        freturn.setVisibility(View.GONE);
        set.setText("进度查询");
        dialog = new Dialog(getActivity(), R.style.DialogTheme);
        mPersonage.setBackground(getResources().getDrawable(R.drawable.blueback));
        mUnit.setBackgroundColor(Color.WHITE);
        myonclick();

    }

    private void myonclick() {
        mPersonage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cxlx = "1";
                mPersonage.setBackground(getResources().getDrawable(R.drawable.blueback));
                mUnit.setBackgroundColor(Color.WHITE);
                mPersonage2.setVisibility(View.VISIBLE);
                mUnit2.setVisibility(View.GONE);
            }
        });
        mUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cxlx = "2";
                mUnit.setBackground(getResources().getDrawable(R.drawable.blueback));
                mPersonage.setBackgroundColor(Color.WHITE);
                mPersonage2.setVisibility(View.GONE);
                mUnit2.setVisibility(View.VISIBLE);
            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bnumText = mBnum.getText().toString();
                String mmPersonage2 = mPersonage2.getText().toString();
                String mmUnit2 = mUnit2.getText().toString();

                MytJDPresenter mytJDPresenter = new MytJDPresenter(new MytJDCall());
                DWMytJDPresenter dwMytJDPresenter = new DWMytJDPresenter(new MytJDCall());
                if (cxlx.equals("1")) {
                    mytJDPresenter.reqeust(cxlx, mmPersonage2, bnumText);
//                mytJDPresenter.reqeust("1", "37230120040427381X", "201600006553");
                } else {
                    dwMytJDPresenter.reqeust(cxlx, bnumText, mmUnit2);
//                    dwMytJDPresenter.reqeust(cxlx, "201600007371", "中国工商银行股份有限公司滨州滨城支行");
                }

            }
        });


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

    private class MytJDCall implements DataCall<Result<MyJDBean>> {
        @Override
        public void success(Result<MyJDBean> data) {
            ToastUtils.showShort(data.getResultMsg());

            MyJDBean.DataBean data1 = data.getMapResult().getData();

            if (data1 != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("progress", data1);
                bundle.putString("cxlx", cxlx);

                intent(Progress3Activity.class, bundle);

            } else {
                intent(Progress2Activity.class);
//                mBnum.setText("");
//                mPersonage2.setText("");
            }
        }

        @Override
        public void fail(ApiException e) {
            intent(Progress2Activity.class);
        }
    }
}
