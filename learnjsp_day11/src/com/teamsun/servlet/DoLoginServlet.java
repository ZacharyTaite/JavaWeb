package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        //处理业务逻辑
        if("tom".equals(userName)&&"123".equals(pwd)){
            request.getSession().setAttribute("name", userName);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            //response.sendRedirect(request.getContextPath()+"/login.jsp");
            request.setAttribute("msg", "用户名或密码不正确！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
