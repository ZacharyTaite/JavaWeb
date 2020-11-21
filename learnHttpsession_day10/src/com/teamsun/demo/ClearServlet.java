package com.teamsun.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //����һ��Cookie����
        Cookie ck = new Cookie("lastAccessTime", "");
        ck.setPath("/");//Ҫ���ñ�ɾ��Cookie��path��������ܻ�ɾ�����
        ck.setMaxAge(0);//�൱��ɾ��
        response.addCookie(ck);//��ckд�ؿͻ��˻���
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
