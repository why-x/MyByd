package com.example.master.byd.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.master.byd.R;

import java.util.ArrayList;

/**
 * spinner
 * @author byd
 * @date 2019/5/21 14:49
 */

public class MyAdapter implements SpinnerAdapter {

    private ArrayList<String> list;
    private Context context;

    public MyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView== null){
            holder= new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.spinner_item,null);
            holder.textView= convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(list.get(position));
        return convertView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView== null){
            holder= new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.spinner_item,null);
            holder.textView= convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(list.get(position));
        return convertView;
    }

    private class ViewHolder{
        TextView textView;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}