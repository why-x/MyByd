package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.activity.DetailsActivity;
import com.example.master.byd.bean.BsznL;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务指南
 * @author byd
 * @date 2019/5/18 12:18
 */
public class NoMoveAdapter extends RecyclerView.Adapter<NoMoveAdapter.ViewHolder>{
    Context mContext;
    private LayoutInflater inflater;
    List<BsznL.DataBean> mList=new ArrayList<>();

    public NoMoveAdapter(Context context) {
        mContext = context;
        inflater=LayoutInflater.from(mContext);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.renomove,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final BsznL.DataBean dataBean = mList.get(i);
        viewHolder.bszn.setText(dataBean.getYwlxmc()+"("+dataBean.getYwdlmc()+")");



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("id",dataBean.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAll(List<BsznL.DataBean> data1) {
        if (data1!=null){
            mList.clear();
            mList.addAll(data1);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bszn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bszn=itemView.findViewById(R.id.itemtext);

        }
    }
}
