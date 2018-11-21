package com.hbck.learnsystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "note.db";   //数据库名字
    public static final String TABLE_NAME = "tb_user";


    //本版号
    private static final int VERSION = 1;


    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //删除表
        db.execSQL("drop table if exists " + TABLE_NAME);
        //创建表
        String sql = "CREATE TABLE " + TABLE_NAME +
                "(_id integer primary key autoincrement,phone text,password text, nick text, image text,sex char(10))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}