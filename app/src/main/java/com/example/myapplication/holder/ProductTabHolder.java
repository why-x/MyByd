package com.example.myapplication.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;


/**
 * Created by Administrator on 2018/9/5.
 * Description : ProductTabHolder
 */

public class ProductTabHolder extends RecyclerView.ViewHolder {
    public TabLayout tabLayout;

    public ProductTabHolder(View view) {
        super(view);
        tabLayout = view.findViewById(R.id.tablayout);
    }
}
