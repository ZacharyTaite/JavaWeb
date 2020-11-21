package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo05 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*response.setIntHeader("refresh", 1);//设置1秒钟刷新一次

		Random r = new Random();

		response.getWriter().write(r.nextInt()+"");*/

        response.getWriter().write("注册成功！3秒钟跳到主页");
        //设置3秒钟跳转
        response.setHeader("refresh", "3;url=/servlet/demo06");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
