package com.hbck.learnsystem.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.hbck.learnsystem.R;


public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        return view;
    }

    @SuppressLint("CheckResult")
    private void initData() {

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
