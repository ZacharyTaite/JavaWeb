package com.teamsun.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo05 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String str = "aaaaa";

        System.out.println("A:我想办事");
        System.out.println("B:我办不了，但我可以找人帮你办");

        //将非表单的数据添加到request的域中
        request.setAttribute("s", str);
        //将请求转发到demo6中
        //request.getRequestDispatcher("/servlet/demo6").forward(request, response);
        //注：请求转发不能跳转到其它应用
        //request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
        //使用重定向
        //response.sendRedirect(request.getContextPath()+"/servlet/demo6");
        //可以跳转到其它应用
        //response.sendRedirect("http://www.baidu.com");
        System.out.println("B:事办完了");

        //请求包含
        request.getRequestDispatcher("/servlet/demoR06").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
