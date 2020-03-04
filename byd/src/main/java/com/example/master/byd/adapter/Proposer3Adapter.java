package com.example.master.byd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.byd.R;

/**
 * 买方信息
 * @author byd
 * @date 2019/5/18 12:18
 */
public class Proposer3Adapter extends RecyclerView.Adapter<Proposer3Adapter.ViewHolder>{
    Context mContext;
    private LayoutInflater inflater;


    public Proposer3Adapter(Context context) {
        mContext = context;
        inflater=LayoutInflater.from(mContext);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.proposer3_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, CheckActivity.class);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
