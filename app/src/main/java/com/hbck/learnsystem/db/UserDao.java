package com.hbck.learnsystem.db;

import com.hbck.learnsystem.bean.User;

/**
 * @Date 2018-11-20.
 */
public interface UserDao {

    /**
     * 插入
     *
     * @param user
     */
    public int insert(User user);

    /**
     * 更新
     *
     * @param user
     */
    public void update(User user);

    /**
     * 查询
     *
     * @param phone
     * @return
     */
    public User selectByPhone(String phone);
    /**
     * 登录
     *
     * @param phone
     * @return
     */
    public User login(String phone,String password);

}
