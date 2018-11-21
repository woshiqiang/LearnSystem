package com.hbck.learnsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.learnsystem.R;
import com.hbck.learnsystem.bean.User;
import com.hbck.learnsystem.db.UserDao;
import com.hbck.learnsystem.db.impl.UserDaoImpl;
import com.hbck.learnsystem.util.Constants;
import com.hbck.learnsystem.util.SpUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private TextView toolbar_right;
    private Toolbar toolbar;
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();

    }

    private void initData() {
        title.setText("登录");
        String username = SpUtil.getString(Constants.USERNAME);
        String password = SpUtil.getString(Constants.PASSWORD);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            et_username.setText(username);
            et_password.setText(password);
            btn_login.performClick();
        }
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        toolbar_right = (TextView) findViewById(R.id.toolbar_right);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                submit();
                break;
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void submit() {
        // validate
        String username = et_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }


        UserDao userDao = new UserDaoImpl(this);
        User user = userDao.login(username, password);
        if (user == null) {
            Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }


    }
}
