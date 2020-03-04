package com.example.master.byd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.People;

import java.util.ArrayList;
import java.util.List;

/**
 * 买方信息
 *
 * @author byd
 * @date 2019/5/18 12:18
 */
public class AdvProposerAdapter extends RecyclerView.Adapter<AdvProposerAdapter.ViewHolder> {
    Context mContext;
    private LayoutInflater inflater;
    List<People> mList = new ArrayList<>();
    private int mflag;

    public AdvProposerAdapter(Context context, int flag) {
        mContext = context;
        mflag = flag;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.proposer_adv_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (mflag == 1) {
            viewHolder.delete.setVisibility(View.INVISIBLE);
            viewHolder.update.setVisibility(View.INVISIBLE);
        }else if (mflag==0){
            viewHolder.delete.setVisibility(View.VISIBLE);
            viewHolder.update.setVisibility(View.VISIBLE);
        }
//        viewHolder.name.setText(mList.get(i).getName());
//        viewHolder.zjh.setText(mList.get(i).getSfznum());
//        viewHolder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOnDeleListener.onDelete(mList.get(i).getSfznum());
//                mList.remove(i);
//                notifyDataSetChanged();
//            }
//        });
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(mContext, CheckActivity.class);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
//        return mList.size();
        return 2;
    }

    public void addAll(List<People> peopleList) {
        if (peopleList != null) {
            mList = peopleList;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, zjh, update;
        ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            zjh = itemView.findViewById(R.id.zjh);
            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);
        }
    }

    private OnDeleListener mOnDeleListener;

    public void setOnDeleListener(OnDeleListener ondelet) {
        this.mOnDeleListener = ondelet;
    }

    public interface OnDeleListener {
        void onDelete(String zjh);
    }

    private OnUpdateListener mOnUpdateistener;

    public void setOnUpdateListener(OnUpdateListener onupdate) {
        this.mOnUpdateistener = onupdate;
    }

    public interface OnUpdateListener {
        void onUpdate(String zjh);
    }


}
