package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ������
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        //����ҵ���߼�
        if("tom".equals(userName)&&"123".equals(pwd)){
            request.getSession().setAttribute("name", userName);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            //response.sendRedirect(request.getContextPath()+"/login.jsp");
            request.setAttribute("msg", "�û��������벻��ȷ��");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
