package com.teamsun.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContextDemo05 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("��Ҫ����");
        System.out.println("������Ұ첻�ˣ��ҿ��԰������˰�");
        ServletContext servletContext = this.getServletContext();
        servletContext.getRequestDispatcher("/servlet/demo6").forward(req,resp);
        System.out.println("�°�����");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
