package com.example.master.byd.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.bean.People;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.ShenFenZPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.ToastUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class AddSellActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.add)
    TextView mAdd;
    @BindView(R.id.camera)
    TextView mCamera;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.zjh)
    TextView mZjh;
    @BindView(R.id.dz)
    TextView mDz;
    @BindView(R.id.phoneNumber)
    EditText mPhoneNumber;
    private Context mContext;
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
    private ShenFenZPresenter mShenFenZPresenter;
    private List<People> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_sell;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("添加买方");
        ArrayList<String> list = new ArrayList<>();
        list.add("单独所有");
        mShenFenZPresenter = new ShenFenZPresenter(new ShenFenZCall());

        mContext = this;
        rootFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/TakePhotoPic");
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner.setAdapter(myAdapter);
        myonclick();
    }

    private void myonclick() {
        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("请拍摄证件正面");
                if (EasyPermissions.hasPermissions(mContext, PERMISSION_CAMERA, PERMISSION_WRITE)) {
                    takePhoto();
                } else {
                    EasyPermissions.requestPermissions(AddSellActivity.this, "need camera permission", REQUEST_PERMISSION_CAMERA, PERMISSION_CAMERA, PERMISSION_WRITE);
                }
            }
        });
        //添加
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("peoplelist", (Serializable) mList);

                Intent intent = new Intent(AddSellActivity.this, ProposerActivity.class);
                intent.putExtras(bundle);
                setResult(300,intent);
//                startActivityForResult(intent, 200, bundle);

                finish();
            }
        });

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
//                    saveImage(cropFile.getAbsolutePath());
                    //设置图片

//                    Glide.with(MySetActivity.this)
//                            .load(BitmapFactory.decodeFile(cropFile.getAbsolutePath()))
//                            .error(R.drawable.head)
//                            .diskCacheStrategy(DiskCacheStrategy.ALL)
//                            .into(mTx);
                    Bitmap bitmap = getBitmap(ImageUtils.getBitmap(cropFile));
                    String image = EncodeUtils.base64Encode2String(ImageUtils.bitmap2Bytes(bitmap, Bitmap.CompressFormat.JPEG));

                    mShenFenZPresenter.reqeust("http://yixi.market.alicloudapi.com/ocr/idcard", image, "front");

//                    mTx.setImageBitmap(BitmapFactory.decodeFile(cropFile.getAbsolutePath()));
//                    mUpdatePresenter.reqeust(mSetid, cropFile);
                    break;
                default:
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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

    /**
     * @param path
     * @return
     */
    public String saveImage(String path) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return null;
        }
        Bitmap bitmap = getBitmap(BitmapFactory.decodeFile(path));

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

    private Bitmap getBitmap(Bitmap bitmap) {
        Bitmap compress = ImageUtils.compressBySampleSize(bitmap, 2);
        return compress.getAllocationByteCount() > 200 * 1024 ? getBitmap(compress) : compress;
    }

    @Override
    protected void destoryData() {

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (requestCode == REQUEST_PERMISSION_CAMERA) {
            takePhoto();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }


    private class ShenFenZCall implements DataCall<Result> {
        @Override
        public void success(Result data) {
            ToastUtils.showShort(data.getMsg());
            mName.setText(data.getData().getName());
            mZjh.setText(data.getData().getSfznum());
            mDz.setText(data.getData().getPlace());
            String mphonenum = mPhoneNumber.getText().toString();
            mList.add(new People(data.getData().getName(), data.getData().getSfznum(), data.getData().getPlace(), mphonenum));
        }

        @Override
        public void fail(ApiException e) {
            ToastUtils.showShort("失败了");

        }
    }
}
