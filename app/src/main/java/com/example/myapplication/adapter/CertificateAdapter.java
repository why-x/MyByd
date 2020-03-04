package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CertificateAdapter extends RecyclerView.Adapter<CertificateAdapter.MyViewHolder> {


    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public CertificateAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txType.setText(mDatas.get(position));
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_certificate, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder { //承载Item视图的子布局
        TextView txType;//证书状态

        public MyViewHolder(View view) {
            super(view);
            txType = view.findViewById(R.id.tx_type);
        }
    }
}


