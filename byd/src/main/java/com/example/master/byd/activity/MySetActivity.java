package com.example.master.byd.activity;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
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

import com.blankj.utilcode.util.GsonUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.UserInfo;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.UpdatePresenter;
import com.example.master.byd.presenter.UserInfoByIdPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;
import com.example.master.byd.uitls.UserInfoManager;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MySetActivity extends BaseActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.jiben)
    LinearLayout mJiben;
    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.exit)
    TextView mExit;
    @BindView(R.id.tx)
    ImageView mTx;
    @BindView(R.id.nc)
    TextView mNc;

    @BindView(R.id.mmnc)
    LinearLayout mMmnc;
    private SharedPreferences mShare;
    private Dialog dialog;
    private Context mContext;
    private AlertDialog profilePictureDialog;
    private static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    private static final String PERMISSION_WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private static final int REQUEST_PERMISSION_CAMERA = 0x001;
    private static final int REQUEST_PERMISSION_WRITE = 0x002;
    private static final int CROP_REQUEST_CODE = 0x003;

    /**
     * 文件相关
     */
    private File captureFile;
    private File rootFile;
    private File cropFile;
    private UpdatePresenter mUpdatePresenter;
    private String mSetid;
    private UserInfo.DataBean mData1;
    private String mNca;
    private UserInfoByIdPresenter mUserInfoByIdPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_set;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mShare = MyApp.getShare();
        mSetid = mShare.getString("id", "");
        mJiben.setOnClickListener(this);
        mFreturn.setOnClickListener(this);
        mExit.setOnClickListener(this);
        mContext = this;
        rootFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/TakePhotoPic");
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        mUserInfoByIdPresenter = new UserInfoByIdPresenter(new UserInfoCall());
//        userInfoByIdPresenter.reqeust("d295b5f7-3e1f-11e9-94c1-0242ac110002");
        mUserInfoByIdPresenter.reqeust(mSetid);
        dialog = new Dialog(MySetActivity.this, R.style.DialogTheme);

        sethead();
        mUpdatePresenter = new UpdatePresenter(new UpdateCall());
        myonclick();

    }

    private void myonclick() {
        mMmnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.ncdialog, null);
                dialog.setContentView(view1);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                getshoud();
                final EditText mmnc = view1.findViewById(R.id.mnc);

                String nc = mData1.getNc();
                if (TextUtils.isEmpty(nc)) {
                    mmnc.setText(nc);
                }
                TextView msure = view1.findViewById(R.id.sure);
                msure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mNca = mmnc.getText().toString();
                        dialog.dismiss();
//                        mNc.setText(mNca);

                        OkHttpUtils.post().url(NetWorkManager.BASE_URL + "/realEstate/app/login/updateUserInfoById")
                                .addParams("id", mSetid)
                                .addParams("nc", mNca).build().execute(new Callback<Result>() {

                            private ProgressDialog mShow;

                            @Override
                            public void onBefore(Request request, int id) {
                                super.onBefore(request, id);
                                mShow = ProgressDialog.show(mContext, "提示", "正在保存", false, false);
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
                                    ToastUtils.showShort(response.getResultMsg());
                                    mUserInfoByIdPresenter.reqeust(mSetid);

                                }

                            }

                            @Override
                            public void onAfter(int id) {
                                super.onAfter(id);
                                mShow.dismiss();
                            }
                        });


                    }
                });
                TextView mcancle = view1.findViewById(R.id.cancle);
                mcancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });


            }
        });
    }

    private void sethead() {
        mTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                bcertification.setText("拍照");
                bcertification.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 拍照
                        if (EasyPermissions.hasPermissions(mContext, PERMISSION_CAMERA, PERMISSION_WRITE)) {
                            takePhoto();
                        } else {
                            EasyPermissions.requestPermissions(MySetActivity.this, "need camera permission", REQUEST_PERMISSION_CAMERA, PERMISSION_CAMERA, PERMISSION_WRITE);
                        }
//                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        intent2.putExtra(MediaStore.EXTRA_OUTPUT,
//                                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
//                        startActivityForResult(intent2, 2);// 采用ForResult打开
                        dialog.dismiss();
                    }
                });
                TextView zcertification = view1.findViewById(R.id.zcertification);
                zcertification.setText("从手机相册选择");
                zcertification.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 相册

                        if (EasyPermissions.hasPermissions(mContext, PERMISSION_WRITE)) {
                            choosePhoto();
                        } else {
                            EasyPermissions.requestPermissions(MySetActivity.this, "need camera permission", REQUEST_PERMISSION_WRITE, PERMISSION_WRITE);
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected void destoryData() {

    }

    //拍照
    private void takePhoto() {
        //用于保存调用相机拍照后所生成的文件
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }
        captureFile = new File(rootFile, "temp.jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本 如果在Android7.0以上,使用FileProvider获取Uri
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(mContext, getPackageName(), captureFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(captureFile));
        }
        startActivityForResult(intent, REQUEST_PERMISSION_CAMERA);
    }

    //从相册选择
    private void choosePhoto() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_PERMISSION_WRITE);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jiben:
                Intent intent = new Intent(this, AppMessActivity.class);
                startActivity(intent);
                break;
            case R.id.freturn:
                finish();
                break;
            case R.id.exit:
                SharedPreferences.Editor edit = mShare.edit();
                edit.putBoolean("zai", false);
                edit.commit();
                finish();
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                break;


        }

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (requestCode == REQUEST_PERMISSION_CAMERA) {
            takePhoto();
        } else if (requestCode == REQUEST_PERMISSION_WRITE) {
            choosePhoto();
        }
    }

    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri uri) {
        cropFile = new File(rootFile, "avatar.jpg");
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cropFile));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_PERMISSION_CAMERA:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(mContext, getPackageName(), captureFile);
                        cropPhoto(contentUri);
                    } else {
                        cropPhoto(Uri.fromFile(captureFile));
                    }
                    break;
                case REQUEST_PERMISSION_WRITE:
                    cropPhoto(data.getData());
                    break;
                case CROP_REQUEST_CODE:
                    saveImage(cropFile.getAbsolutePath());
                    //设置图片

                    Glide.with(MySetActivity.this)
                            .load(BitmapFactory.decodeFile(cropFile.getAbsolutePath()))
                            .error(R.drawable.head)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(mTx);
//                    mTx.setImageBitmap(BitmapFactory.decodeFile(cropFile.getAbsolutePath()));
//                    mUpdatePresenter.reqeust(mSetid, cropFile);


                    OkHttpUtils.post().url(NetWorkManager.BASE_URL + "/realEstate/app/login/updateUserInfoById").addFile("tx", cropFile.getName(), cropFile)
                            .addParams("id", mSetid)
                            .build().execute(new Callback<Result>() {
                        private ProgressDialog mShow;

                        @Override
                        public void onBefore(Request request, int id) {
                            super.onBefore(request, id);
                            mShow = ProgressDialog.show(mContext, "提示", "正在保存", false, false);
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
                                ToastUtils.showShort(response.getResultMsg());
                                mUserInfoByIdPresenter.reqeust(mSetid);
                            }

                        }

                        @Override
                        public void onAfter(int id) {
                            super.onAfter(id);
                            mShow.dismiss();
                        }
                    });


                    break;
                default:
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    /**
     * @param path
     * @return
     */
    public String saveImage(String path) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return null;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        try {
            FileOutputStream fos = new FileOutputStream(cropFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return cropFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private class UserInfoCall implements DataCall<Result<UserInfo>> {
        @Override
        public void success(Result<UserInfo> data) {
            mData1 = data.getMapResult().getData();
            if (mData1.getNc() == null) {
                mNc.setText("未设置");

            } else {
                mNc.setText(mData1.getNc());
//                http://47.110.150.232:9999//tx/81734e062c714c489a1296f29d831567
//                http://47.110.150.232:9999//tx/81734e062c714c489a1296f29d831567
            }
            Glide.with(MySetActivity.this)
                    .load(mData1.getTx())
                    .error(R.drawable.head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(mTx);

            UserInfoManager.setUserInfo(data.getMapResult());
            SharedPreferences.Editor edit = mShare.edit();

            edit.putBoolean("yi",true);
            edit.putString("id",mData1.getId());//id
            edit.putString("realName", mData1.getRealName());//姓名
            edit.putString("loginName", mData1.getLoginName());//手机号
            edit.putString("tx", mData1.getTx());//头像
            edit.putString("nc", mData1.getNc());//昵称
            edit.putString("sfzhm", mData1.getSfzhm());//身份证号

            edit.commit();
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

    private class UpdateCall implements DataCall<Result> {
        @Override
        public void success(Result data) {
            ToastUtils.showShort(data.getResultMsg());


            finish();
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
