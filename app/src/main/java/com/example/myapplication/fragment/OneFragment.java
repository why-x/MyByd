package com.example.myapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.CertificateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends PagerFragment {


    private RecyclerView recyclerview;
    private CertificateAdapter certificateAdapter;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        recyclerview = view.findViewById(R.id.rv);
//        List<String> certificatelist = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            certificatelist.add("第" + i + "条");
//        }
//        certificateAdapter = new CertificateAdapter(getContext(), certificatelist);
//        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerview.setAdapter(certificateAdapter);
//        certificateAdapter.notifyDataSetChanged();
        return view;
    }
}
