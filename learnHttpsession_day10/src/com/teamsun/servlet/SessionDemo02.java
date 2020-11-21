package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionDemo02 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //�õ�һ��HttpSession����
        HttpSession session = request.getSession();
        String  name = (String) session.getAttribute("name");
        if(name!=null){
            out.print(name);
        }else{
            out.print("�㲻��ֱ�ӷ��ʴ���Դ��");
        }
        out.print(session.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
