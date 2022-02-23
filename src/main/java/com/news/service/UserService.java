package com.news.service;


import com.news.entity.User;

import java.sql.SQLException;

/**
 * 业务层
 * UserService用户接口类
 */
public interface UserService {

    //登录的操作
    public  User doLogin(User user) throws SQLException;
}
