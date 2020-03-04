package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.byd.R;
import com.example.master.byd.bean.About;
import com.example.master.byd.uitls.util.ToastUtils;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * @author byd
 * @date 2019/5/18 13:20
 */
public class Homere2Adapter extends RecyclerView.Adapter<Homere2Adapter.ViewHolder> {
    Context mContext;
    private LayoutInflater inflater;
    List<About.DataBean> mList;

    public Homere2Adapter(Context context, List<About.DataBean> list) {
        mContext = context;
        mList = list;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.homere2, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final About.DataBean dataBean = mList.get(i);
        viewHolder.dwmc.setText(dataBean.getDwmc());
        viewHolder.dwdz.setText(dataBean.getDwdz());
        viewHolder.lxdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到拨号界面，同时传递电话号码
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dataBean.getLxdh()));
                dialIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(dialIntent);
            }
        });
        viewHolder.place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Uri uri = Uri.parse("geo:"+dataBean.getX()+","+dataBean.getY());
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    it.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(it);
                } catch (Exception e) {
                    ToastUtils.showShort("请先安装地图客户端");

                    e.printStackTrace();
                }

//                if (isInstallApk(mContext, "com.autonavi.minimap")) {// 是否安装了高德地图
//                    Uri uri = Uri.parse("amapuri://route/plan/?dlat=" + "目的地lat" + "&dlon=" + "目的地lng" + "&dname=" + "目的地名称" + "&dev=0&t=0");
//                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
////                Intent intent = Intent.getIntent("androidamap://navi?sourceApplication=&poiname="+address+"&lat="
////                        + latitude
////                        + "&lon="
////                        + longtitude + "&dev=0");
////                mContext.startActivity(intent); // 启动调用
//                } else if (isInstallApk(mContext, "com.baidu.BaiduMap")) {// 是否安装了百度地图
//                    Uri uri = Uri.parse("baidumap://map/direction?destination=latlng:" + "目的地lat" + "," + "目的地lng" + "|name:" + "目的地名称" + "&mode=driving");
//                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
////                Intent intent = Intent.getIntent("intent://map/direction?destination=latlng:"
////                        + latitude + ","
////                        + longtitude + "|name:"+address + // 终点
////                        "&mode=driving&" + // 导航路线方式
////                        "region=" + //
////                        "&src=#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
////                mContext.startActivity(intent); // 启动调用
//                } else if (isInstallApk(mContext, "com.tencent.map")) {
//                    Uri uri = Uri.parse("qqmap://map/routeplan?type=drive" + "目的地lat" + "," + "目的地lng" + "|name:" + "目的地名称" + "&mode=driving");
//                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
////                    StringBuffer stringBuffer = new StringBuffer("qqmap://map/routeplan?type=drive");
//////                            .append("&tocoord=").append(endPoint.latitude).append(",").append(endPoint.longitude).append("&to=" + mAddressStr);
////                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
////                    startActivity(intent);
//
//                } else {
//                    ToastUtils.showShort("请先安装地图客户端");
//                    return;
//
//                }

//
//                checkGaodeMap();
//                checkBaiduMap();
//                Uri uri = Uri.parse("amapuri://route/plan/?dlat="+"目的地lat"+"&dlon="+"目的地lng"+"&dname="+"目的地名称"+"&dev=0&t=0");
//                mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
//                Uri uri = Uri.parse("baidumap://map/direction?destination=latlng:"+"目的地lat"+","+ "目的地lng"+"|name:"+"目的地名称"+"&mode=driving");
//                mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
        viewHolder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                Intent intent = new Intent(Intent.ACTION_SENDTO);

//                intent.setData(Uri.parse("mailto:"));

                try {
                    if (TextUtils.isEmpty(dataBean.getEmail())) {
                        ToastUtils.showShort("邮件内容为空，无法发送");
                    } else {
                        Uri uri = Uri.parse("mailto:xxx@abc.com");

                        Intent it = new Intent(Intent.ACTION_VIEW, uri);
                        it.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        it.putExtra(Intent.EXTRA_SUBJECT, dataBean.getEmail()); // 主题
                        mContext.startActivity(it);
                    }

                } catch (Exception e) {
                    ToastUtils.showShort("不支持发送邮件");
                    e.printStackTrace();
                }

//                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_EMAIL, "");
//                intent.setType("text/plain");
////                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//                intent.setClassName("com.android.email","com.android.email.activity.MessageCompose");
//
////                intent.putExtra(Intent.EXTRA_EMAIL, "");
////                intent.setType("text/plain");
////                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//                mContext.startActivity(Intent.createChooser(intent, "分享一下"));
            }
        });
    }


    //跳转到高德地图  double latitude,double longtitude,String address
    private void checkGaodeMap() {
        if (isInstallApk(mContext, "com.autonavi.minimap")) {// 是否安装了高德地图
            Uri uri = Uri.parse("amapuri://route/plan/?dlat=" + "目的地lat" + "&dlon=" + "目的地lng" + "&dname=" + "目的地名称" + "&dev=0&t=0");
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
//                Intent intent = Intent.getIntent("androidamap://navi?sourceApplication=&poiname="+address+"&lat="
//                        + latitude
//                        + "&lon="
//                        + longtitude + "&dev=0");
//                mContext.startActivity(intent); // 启动调用
        } else {// 未安装
            Toast.makeText(mContext, "您尚未安装高德地图", Toast.LENGTH_LONG)
                    .show();
            Uri uri = Uri
                    .parse("market://details?id=com.autonavi.minimap");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            mContext.startActivity(intent);
        }
    }

    //跳转到百度地图  double latitude,double longtitude,String address
    private void checkBaiduMap() {
        if (isInstallApk(mContext, "com.baidu.BaiduMap")) {// 是否安装了百度地图
            Uri uri = Uri.parse("baidumap://map/direction?destination=latlng:" + "目的地lat" + "," + "目的地lng" + "|name:" + "目的地名称" + "&mode=driving");
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
//                Intent intent = Intent.getIntent("intent://map/direction?destination=latlng:"
//                        + latitude + ","
//                        + longtitude + "|name:"+address + // 终点
//                        "&mode=driving&" + // 导航路线方式
//                        "region=" + //
//                        "&src=#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
//                mContext.startActivity(intent); // 启动调用
        } else {// 未安装
            Toast.makeText(mContext, "您尚未安装百度地图", Toast.LENGTH_LONG)
                    .show();
            Uri uri = Uri
                    .parse("market://details?id=com.baidu.BaiduMap");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            mContext.startActivity(intent);
        }
    }

    /**
     * 判断手机中是否安装指定包名的软件
     */
    public static boolean isInstallApk(Context context, String name) {
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            if (packageInfo.packageName.equals(name)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAll(List<About.DataBean> data1) {
        if (data1 != null) {
            mList.clear();
            mList.addAll(data1);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dwmc, dwdz;
        ImageView place, lxdh, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dwmc = itemView.findViewById(R.id.dwmc);
            dwdz = itemView.findViewById(R.id.dwdz);
            lxdh = itemView.findViewById(R.id.lxdh);
            place = itemView.findViewById(R.id.place);
            email = itemView.findViewById(R.id.email);

        }
    }
}
