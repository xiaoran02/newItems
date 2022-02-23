package com.news.dao;


import com.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库增删改查统一操作
public class BaseDao {
    private Connection conn;

    public BaseDao(Connection conn){
        this.conn = conn;
    }

    //增删改操作,影响记录数,条数返回int类型
    protected int executeUpdate(String sql, Object... params){
        PreparedStatement ps = null;
        int rs = 0;
        try {
            //通过连接对象获取执行sql语句对象
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            //  执行sql语句
              rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DataBaseUtil.close(ps);
        }
        return rs;
    }

    //查询操作select

    /**
     *  查询结果集,返回resultSet
     * @param sql
     * @param params
     * @return
     */
    public ResultSet excuteQuery(String sql,Object... params) throws Exception{
        ResultSet rs = null;
        try {
            //通过连接对象调用执行sql对象
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            //调用执行查询语句的方法
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return  rs;
    }
}
