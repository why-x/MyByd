package com.example.master.byd.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends BaseActivity implements QRCodeView.Delegate {
    ZXingView mZxingview;
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("二维码");
        mZxingview = (ZXingView) findViewById(R.id.zxingview);
        mZxingview.setDelegate(this);

        //动态权限
        String[] p = new String[]{Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(ScanActivity.this, p, 1);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
//        Toast.makeText(ScanActivity.this, result, Toast.LENGTH_LONG).show();
        Toast.makeText(ScanActivity.this, "扫描成功", Toast.LENGTH_LONG).show();
        intent(InspectionActivity.class);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            int result = grantResults[0];
            if (result == PackageManager.PERMISSION_GRANTED) {
                //权限同意
                mZxingview.startSpot();
            } else {
                //权限拒绝
                Toast.makeText(ScanActivity.this, "请同意打开摄像头权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void destoryData() {

    }
}
