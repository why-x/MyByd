package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.master.byd.R;
import com.example.master.byd.activity.NewsDetailsActivity;
import com.example.master.byd.bean.News;

import java.util.List;

/**
 * @author byd
 * @date 2019/5/18 13:20
 */
public class Homere1Adapter extends RecyclerView.Adapter<Homere1Adapter.ViewHolder> {
    Context mContext;
    private LayoutInflater inflater;

    List<News.DataBean> mList;

    public Homere1Adapter(Context context, List<News.DataBean> list) {
        mContext = context;
        mList = list;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.homere1, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.image.setImageResource(R.drawable.photo);
        final News.DataBean dataBean = mList.get(i);
        Glide.with(mContext)
                .load(dataBean.getImgPath())
                .error(R.drawable.photo)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(viewHolder.image);
        Log.i("tag", "+++++++++++++++" + dataBean.getImgPath());
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.type.setText(dataBean.getType());
        String createTime = dataBean.getCreateTime();
        String time = createTime.substring(0, 10);
        viewHolder.time.setText(time);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewsDetailsActivity.class);
                intent.putExtra("id", dataBean.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAll(List<News.DataBean> data1) {
        if (data1 != null) {
            mList.clear();
            mList.addAll(data1);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

                ImageView image;
//        SimpleDraweeView image;

        TextView title, type, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);
            time = itemView.findViewById(R.id.time);
        }
    }
}
