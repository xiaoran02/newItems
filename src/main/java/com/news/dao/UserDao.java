package com.news.dao;

import com.news.entity.User;

import java.sql.SQLException;

//用户接口
public interface UserDao {

    //查找是否登录成功,用户名,密码,匹配与否
    public User findUser(String uname,String password) throws SQLException;

}
