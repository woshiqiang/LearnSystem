package com.hbck.learnsystem.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hbck.learnsystem.R;
import com.hbck.learnsystem.fragment.HomeFragment;
import com.hbck.learnsystem.fragment.MeFragment;
import com.hbck.learnsystem.fragment.OrderFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_main;
    private RadioButton rb_home;
    private RadioButton rb_msg;
    private RadioButton rb_me;
    private RadioGroup rgMain;

    private Fragment[] fragments;
    private int index;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_msg = (RadioButton) findViewById(R.id.rb_msg);
        rb_me = (RadioButton) findViewById(R.id.rb_me);
        rgMain = (RadioGroup) findViewById(R.id.rg_main);


        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        index = 0;
                        break;
                    case R.id.rb_msg:
                        index = 1;
                        break;
                    case R.id.rb_me:
                        index = 2;
                        break;
                }

                showFragment(index);
            }
        });

        fragments = new Fragment[]{new HomeFragment(), new OrderFragment(),new MeFragment()};
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragments[0])
                .add(R.id.fl_main, fragments[1]).hide(fragments[1]).show(fragments[0]).commit();
    }

    /**
     * 切换fragment
     *
     * @param index：0-2
     */
    public void showFragment(int index) {
        if (currentIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fl_main, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }

        currentIndex = index;
    }
}
