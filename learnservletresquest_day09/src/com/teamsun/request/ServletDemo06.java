package com.teamsun.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo06 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("��������ܰ�");
        //��request�����е��Ƴ�
        //request.removeAttribute("s");
        //��request�����л�ȡs��ֵ
        String s = (String) request.getAttribute("s");
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
