package com.hbck.learnsystem.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hbck.learnsystem.R;


/**
 * @time 2018-11-14 16:26
 * @类描述：我的
 * @变更记录:
 */
public class MeFragment extends Fragment {



    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initData();
        return view;
    }

    private void initData() {
    }

}
