package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo07 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A:��Ҫ��Ǯ��");
        System.out.println("B:�Ҳ��У������ҿ��Ը�����˭��");
        /*//���߿ͻ���Ҫ���¶����µ���Դ
		resp.setStatus(302);
		//���������Ҫȥ�����ĸ�URL
		resp.setHeader("location", "/servlet/demo80");*/

        //�����ض���
        resp.sendRedirect("/servlet/demo08");
        System.out.println("A: ��ȥ��");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
