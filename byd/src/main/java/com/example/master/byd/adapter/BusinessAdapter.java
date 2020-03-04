package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.activity.SellActivity;
import com.example.master.byd.bean.UserBLYW;

import java.util.ArrayList;
import java.util.List;

/**
 * @author byd
 * @date 2019/5/18 12:18
 */
public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.ViewHolder> {
    Context mContext;

    private LayoutInflater inflater;
    List<UserBLYW.DataBean> mList = new ArrayList<>();

    public BusinessAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.business_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserBLYW.DataBean dataBean = mList.get(i);
        viewHolder.mYwlxmc.setText(dataBean.getYwlxmc());
        viewHolder.mQlr.setText("权利人：" + dataBean.getQlr());
        if (TextUtils.isEmpty(dataBean.getSlbh())) {
            viewHolder.mSlbh.setText("流水号：");
        } else {
            viewHolder.mSlbh.setText("流水号：" + dataBean.getSlbh());
        }

        viewHolder.mSqsj.setText("" + dataBean.getSqsj());
        viewHolder.mZl.setText("" + dataBean.getZl());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, CheckActivity.class);
                Intent intent = new Intent(mContext, SellActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        String blzt = dataBean.getBlzt();
        String mblzt = null;
        if (blzt.equals("0")) {
            mblzt = "未提交";
        } else if (blzt.equals("1")) {
            mblzt = "已受理";
        } else if (blzt.equals("2")) {
            mblzt = "不予受理";
        } else if (blzt.equals("3")) {
            mblzt = "需补正";
        } else if (blzt.equals("4")) {
            mblzt = "已办结";
        } else if (blzt.equals("5")) {
            mblzt = "已撤回";
        } else if (blzt.equals("6")) {
            mblzt = "已通过";
        } else if (blzt.equals("7")) {
            mblzt = "撤销中";
        } else if (blzt.equals("8")) {
            mblzt = "撤销成功";
        } else if (blzt.equals("9")) {
            mblzt = "已预约";
        }
        viewHolder.mZt.setText(mblzt);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addAll(List<UserBLYW.DataBean> dataX) {
        if (dataX != null) {
            mList.clear();
            mList.addAll(dataX);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mYwlxmc, mQlr, mSlbh, mSqsj, mZl, mZt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mYwlxmc = itemView.findViewById(R.id.ywlxmc);
            mQlr = itemView.findViewById(R.id.qlr);
            mSlbh = itemView.findViewById(R.id.slbh);
            mSqsj = itemView.findViewById(R.id.sqsj);
            mZl = itemView.findViewById(R.id.zl);
            mZt = itemView.findViewById(R.id.zt);

        }
    }
}
