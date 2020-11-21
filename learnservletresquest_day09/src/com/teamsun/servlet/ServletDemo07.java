package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo07 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A:我要借钱！");
        System.out.println("B:我不有，但是我可以告诉你谁有");
        /*//告诉客户端要重新定向新的资源
		resp.setStatus(302);
		//告诉浏览器要去访问哪个URL
		resp.setHeader("location", "/servlet/demo80");*/

        //请求重定向
        resp.sendRedirect("/servlet/demo08");
        System.out.println("A: 我去了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
