package com.hbck.learnsystem.db.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hbck.learnsystem.bean.User;
import com.hbck.learnsystem.db.SQLiteHelper;
import com.hbck.learnsystem.db.UserDao;

/**
 * @Date 2018-11-20.
 */
public class UserDaoImpl implements UserDao {

    private SQLiteHelper dbHelper;

    public UserDaoImpl(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    @Override
    public int insert(User user) {
        User isExists = selectByPhone(user.getPhone());
        if (isExists != null) {
            return -1;
        }
        String sql = "insert into " + SQLiteHelper.TABLE_NAME + "(phone, password)values(?,?)";
        Object[] args = {user.getPhone(), user.getPassword()};
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(sql, args);
        db.close();
        return 1;
    }

    @Override
    public void update(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "update " + SQLiteHelper.TABLE_NAME + " set nick = ?,image = ?, sex = ? where _id = ?";
        Object[] args = {user.getNick(), user.getImage(), user.getSex(), user.getId()};
        db.execSQL(sql, args);
        db.close();
    }

    @Override
    public User selectByPhone(String phone) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from " + SQLiteHelper.TABLE_NAME + " where phone = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{phone});

        User user = null;
        if (cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            user.setPhone(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
            user.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
            user.setImage(cursor.getString(cursor.getColumnIndexOrThrow("image")));
            user.setNick(cursor.getString(cursor.getColumnIndexOrThrow("nick")));

        }
        cursor.close();
        db.close();

        return user;
    }

    @Override
    public User login(String phone, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from " + SQLiteHelper.TABLE_NAME + " where phone = ? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[]{phone, password});

        User user = null;
        if (cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            user.setPhone(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
            user.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
            user.setImage(cursor.getString(cursor.getColumnIndexOrThrow("image")));
            user.setNick(cursor.getString(cursor.getColumnIndexOrThrow("nick")));

        }
        cursor.close();
        db.close();
        return user;
    }
}
