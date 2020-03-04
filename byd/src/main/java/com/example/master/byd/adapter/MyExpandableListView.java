package com.example.master.byd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.activity.LoginActivity;
import com.example.master.byd.activity.SellActivity;
import com.example.master.byd.activity.advance.AdvSellActivity;
import com.example.master.byd.activity.advance.AdvanceDataActivity;
import com.example.master.byd.activity.advance.AdvanceDataZXActivity;
import com.example.master.byd.bean.MyYwlx;

import java.util.List;

/**
 * 为ExpandableListView自定义适配器
 */


public class MyExpandableListView extends BaseExpandableListAdapter {
    Context context;
    private List<MyYwlx.DataBean> groups;
    private LayoutInflater inflate;

    public MyExpandableListView(Context context, List<MyYwlx.DataBean> groups) {
        this.context = context;
        this.groups = groups;
        inflate = LayoutInflater.from(context);
    }

    /*一级列表个数*/
    @Override
    public int getGroupCount() {
        return groups.size();
    }

    /*每个二级列表的个数*/
    @Override
    public int getChildrenCount(int groupPosition) {
//            childs.getList().size()
        return groups.get(groupPosition).getList().size();
    }

    /*一级列表中单个item*/
    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    /*二级列表中单个item*/
    @Override
    public Object getChild(int groupPosition, int childPosition) {
//            childs.getList().get(childPosition)
        return groups.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /*每个item的id是否固定，一般为true*/
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /*#TODO 填充一级列表
     * isExpanded 是否已经展开
     * */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_group, null);
        }
        TextView tv_group = (TextView) convertView.findViewById(R.id.tv_group);
        ImageView iv_group = (ImageView) convertView.findViewById(R.id.iv_group);
        tv_group.setText(groups.get(groupPosition).getYwdl());
//            childs=groups.get(groupPosition).getList();
//            childs=groups.get(groupPosition);
        //控制是否展开图标
        if (isExpanded) {
            iv_group.setImageResource(R.drawable.down);
        } else {
            iv_group.setImageResource(R.drawable.right);
        }
        return convertView;
    }

    /*#TODO 填充二级列表*/
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_child, null);
        }
        final MyYwlx.DataBean.ListBean listBean = groups.get(groupPosition).getList().get(childPosition);

        TextView tv = (TextView) convertView.findViewById(R.id.tv_child);
        tv.setText(listBean.getYwlxmc());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MyApp.getShare().getBoolean("zai", false)) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else {
                    //跳转预告类各个页面
                    String ywlxmc = listBean.getYwlxmc();

                    if (ywlxmc.contains("预告抵押登记")) {
                        Intent intent = new Intent(context, AdvSellActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else if (ywlxmc.contains("预告登记")) {
                        Intent intent = new Intent(context, AdvanceDataActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    } else if (ywlxmc.contains("预告注销")) {
                        Intent intent = new Intent(context, AdvanceDataZXActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    } else {
                        Intent intent = new Intent(context, SellActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }


                }
            }
        });
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!MyApp.getShare().getBoolean("zai", false)) {
//                    Intent intent = new Intent(context, LoginActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                } else {
//                    Intent intent = new Intent(context, SellActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
        return convertView;
    }

    /*二级列表中每个能否被选中，如果有点击事件一定要设为true*/
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void addAll(List<MyYwlx.DataBean> data1) {
//        if ()
        if (data1 != null) {
            groups.clear();
            groups = data1;
            notifyDataSetChanged();
        }
    }
}