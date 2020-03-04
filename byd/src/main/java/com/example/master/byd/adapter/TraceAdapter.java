package com.example.master.byd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.MyJDBean;

import java.util.List;

/**
 * 进度查询-结果
 * @author byd
 * @date 2019/5/21 12:00
 */
public class TraceAdapter extends RecyclerView.Adapter<TraceAdapter.TraceViewHolder> {

    private static final int TYPE_CURR = 0; //当前
    private static final int TYPE_NORMAL = 1; //历史记录
    private Context mContext;
    private List<MyJDBean.DataBean.SpgcBean> mList;
    private LayoutInflater inflater;

    public TraceAdapter(Context mContext, List<MyJDBean.DataBean.SpgcBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public TraceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TraceViewHolder(inflater.inflate(R.layout.item_trace, parent, false));
    }

    @Override
    public void onBindViewHolder(TraceViewHolder holder, int position) {
        //设置相关数据
//        int type = trace.getType();
//        if (type == TYPE_CURR) {
//            holder.acceptStationTv.setTextColor(mContext.getResources().getColor(R.color.color_c03));
//            holder.acceptStatuTv.setTextColor(mContext.getResources().getColor(R.color.color_c03));
//            holder.dotIv.setImageResource(R.drawable.dot_red);
//        } else if (type == TYPE_NORMAL) {
//            holder.acceptStationTv.setTextColor(mContext.getResources().getColor(R.color.color_6));
//            holder.acceptStatuTv.setTextColor(mContext.getResources().getColor(R.color.color_6));
//            holder.dotIv.setImageResource(R.drawable.dot_black);
//        }
//        holder.acceptDataTv.setText(trace.getAcceptData());
//        holder.acceptTimeTv.setText(trace.getAcceptTime());
//        holder.acceptStatuTv.setText(trace.getStatu());
//        holder.acceptStationTv.setText(trace.getAcceptStation());
        MyJDBean.DataBean.SpgcBean spgcBean = mList.get(position);
        holder.blsj.setText(spgcBean.getBlsj());
        holder.bljd.setText(spgcBean.getBljd());
        if (position == mList.size() - 1) {
            //最后一条数据，隐藏时间轴的竖线和水平的分割线
            holder.timeLineView.setVisibility(View.INVISIBLE);
            holder.dividerLineView.setVisibility(View.INVISIBLE);
        }
        if (position==0){
            holder.dotIv.setImageResource(R.drawable.dot_red);

        }
    }


    public class TraceViewHolder extends RecyclerView.ViewHolder {

        private TextView blsj;  //接收时间
        private TextView bljd;  //接收状态

        private ImageView dotIv; //当前位置
        private View dividerLineView; //时间轴的竖线
        private View timeLineView; //水平的分割线


        public TraceViewHolder(View itemView) {
            super(itemView);
            blsj = (TextView) itemView.findViewById(R.id.blsj);
            bljd = (TextView) itemView.findViewById(R.id.bljd);
            dotIv = (ImageView) itemView.findViewById(R.id.dot_iv);
            dividerLineView = itemView.findViewById(R.id.divider_line_view);
            timeLineView = itemView.findViewById(R.id.time_line_view);
        }
    }
}
