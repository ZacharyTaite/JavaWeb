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
        /*response.setIntHeader("refresh", 1);//����1����ˢ��һ��

		Random r = new Random();

		response.getWriter().write(r.nextInt()+"");*/

        response.getWriter().write("ע��ɹ���3����������ҳ");
        //����3������ת
        response.setHeader("refresh", "3;url=/servlet/demo06");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
