package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.activity.CertificateActivity;
import com.example.master.byd.bean.MyRealEstate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author byd
 * @date 2019/5/18 12:18
 */
public class EquityAdapter extends RecyclerView.Adapter<EquityAdapter.ViewHolder> {
    Context mContext;

    private LayoutInflater inflater;
    List<MyRealEstate.DataBean> mList = new ArrayList<>();

    public EquityAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.equity_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final MyRealEstate.DataBean dataBean = mList.get(i);
        viewHolder.mqqh.setText("丘权号：" + dataBean.getQqh());
        viewHolder.mbdcdyh.setText("不动产单元号：" + dataBean.getBdcdyh());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApp.getShare().edit().putInt("zsnum",1).commit();
                Intent intent = new Intent(mContext, CertificateActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                //我的产权集合数据
                bundle.putSerializable("data", (Serializable) dataBean);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAlll(List<MyRealEstate.DataBean> data1) {
        if (data1 != null) {
            mList.clear();
            mList = data1;
            notifyDataSetChanged();
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mqqh, mbdcdyh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mqqh = itemView.findViewById(R.id.qqh);
            mbdcdyh = itemView.findViewById(R.id.bdcdyh);

        }
    }
}
