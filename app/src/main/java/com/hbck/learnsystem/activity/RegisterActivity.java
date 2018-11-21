package com.hbck.learnsystem.activity;

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

/**
 * 注册
 *
 * @Date 2018-11-19.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private TextView toolbar_right;
    private Toolbar toolbar;
    private EditText et_username;
    private EditText et_password;
    private EditText et_password2;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }


    private void initView() {
        title = (TextView) findViewById(R.id.title);
        toolbar_right = (TextView) findViewById(R.id.toolbar_right);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText) findViewById(R.id.et_password2);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);

        title.setText("注册");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                submit();
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
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String password2 = et_password2.getText().toString().trim();
        if (!password.equals(password2)) {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }


        User user = new User();
        user.setPhone(username);
        user.setPassword(password);
        UserDao userDao = new UserDaoImpl(this);
        int count = userDao.insert(user);
        if (count == -1) {
            Toast.makeText(this, "已注册", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
