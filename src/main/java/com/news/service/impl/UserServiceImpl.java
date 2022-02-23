package com.news.service.impl;


import com.news.dao.impl.UserDaoImpl;
import com.news.entity.User;
import com.news.service.UserService;
import com.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 业务层
 * UserService用户服务实现类
 */
public class UserServiceImpl implements UserService {

    //业务层用户登录的功能操作
    public  User doLogin(User user) throws SQLException{
        Connection connection = null;
        User u = null;
        try {
            //获取连接对象
            connection = DataBaseUtil.getConnection();
            //创建UserDaoImpl是实现类
            UserDaoImpl userDao = new UserDaoImpl(connection);
            //调用查询用户的方法,传入用户名和密码
            u = userDao.findUser(user.getUname(), user.getUpwd());
            return u;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }finally {
            DataBaseUtil.close(connection);
        }
    }
}
