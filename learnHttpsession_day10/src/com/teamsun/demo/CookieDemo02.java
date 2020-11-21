package com.teamsun.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo02 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        for (int i = 0;cookies!=null && i < cookies.length; i++) {
            if("lastAccessTime".equals(cookies[i].getName())){//�жϵ�ǰCookie�е�name�Ƿ�����Ҫ��cookie
                long l = Long.parseLong(cookies[i].getValue());//�������Ҫ��Cookie�����Cookie�е�valueȡ��
                out.write("���������ʱ��Ϊ��"+new Date(l).toLocaleString());//yyyy-MM-dd
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
