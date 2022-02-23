package com.news.util;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class DataBaseUtil {

    //数据库驱动字符串
    public static String driver = configManager.getProperty("driver");
    //链接Url字符串
    public static String url = configManager.getProperty("url");
    //数据库用户名
    public static String user = configManager.getProperty("username");
    //数据库用户密码
    public static String password = configManager.getProperty("password");

    //  加载驱动管理器

        static  {
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
    /**
     * 获取数据库连接对象
     */
    public static Connection getConnection(){
        //通过驱动管理器获取连接
        Connection conn = null;
        try {
              conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    // 关闭资源
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        close(rs);
        close(stmt);
        close(conn);
    }
    public static void close(ResultSet rs) {
        try {
            if(rs !=null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Statement rs) {
        try {
            if(rs !=null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Connection rs) {
        try {
            if(rs !=null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
