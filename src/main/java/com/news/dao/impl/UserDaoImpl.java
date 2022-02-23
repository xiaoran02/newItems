package com.news.dao.impl;

import com.news.dao.BaseDao;
import com.news.dao.UserDao;
import com.news.entity.User;
import com.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {

    public UserDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public User findUser(String uname, String password) throws SQLException {
        //sql 语句
        String sql = "select * from news_users where uname = ? and upwd = ?";
            ResultSet rs = null;
            User user = null;
        try {
            //调用查询方法,返回查询结果集
            rs = this.excuteQuery(sql, uname, password);
            //判断结果集是否有查询有可取的吓一跳记录,如果有就去取
            if(rs.next()){
                //创建用户类
                user = new User();
                //取出来的数据保存在User类
                user.setUid(rs.getInt("uid"));
                user.setUname(uname);
                user.setUpwd(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(rs);  //关闭资源
        }
        return user;
    }
}
