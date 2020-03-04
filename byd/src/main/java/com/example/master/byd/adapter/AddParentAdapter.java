package com.example.master.byd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.User;

import java.util.List;

/**
 * 业务指南
 * @author byd
 * @date 2019/5/18 12:18
 */
public class AddParentAdapter extends RecyclerView.Adapter<AddParentAdapter.ViewHolder>{
    Context mContext;
    List<User> mUsers;
    private LayoutInflater inflater;

    public AddParentAdapter(Context context, List<User> users) {
        mContext = context;
        mUsers = users;
        inflater=LayoutInflater.from(mContext);

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.addparent,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final User user = mUsers.get(i);
        viewHolder.name.setText(user.getName());
        Log.i("tag", "onBindViewHolder: "+user.getName());
        viewHolder.idnumber.setText(user.getIdnumber());
        viewHolder.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsers.remove(i);
                notifyDataSetChanged();
            }
        });
        if (i==mUsers.size()-1){
            viewHolder.xian.setVisibility(View.GONE);
        }


//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, DetailsActivity.class);
//                intent.putExtra("id",dataBean.getId());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

//    public void addAll(List<BsznL.DataBean> data1) {
//        if (data1!=null){
//            mList.clear();
//            mList.addAll(data1);
//            notifyDataSetChanged();
//        }
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idnumber,name,xian;
        ImageView clear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idnumber=itemView.findViewById(R.id.idnumber);
            name=itemView.findViewById(R.id.name);
            xian=itemView.findViewById(R.id.xian);
            clear=itemView.findViewById(R.id.clear);

        }
    }
}
