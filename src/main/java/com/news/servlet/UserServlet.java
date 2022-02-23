package com.news.servlet;

import com.news.entity.User;
import com.news.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserServlet implements Servlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //新建ServiceImpl对象
        UserServiceImpl userService = new UserServiceImpl();

        //获取表单提交信息
        String username =  servletRequest.getParameter("uname");
        String password =  servletRequest.getParameter("upwd");

        //检验
//        System.out.println(username);
//        System.out.println(password);

        //新建一个用户
        User user = new User();
        //传递参数
        user.setUpwd(password);
        user.setUname(username);



        try {
            User u = userService.doLogin(user);
//            System.out.println(u);
            servletRequest.setAttribute("User",u);
            if(u != null){

                servletRequest.getRequestDispatcher("newspages/admin.jsp").forward(servletRequest,servletResponse);
            }
            else{
                servletRequest.getRequestDispatcher("error.jsp").forward(servletRequest,servletResponse);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
