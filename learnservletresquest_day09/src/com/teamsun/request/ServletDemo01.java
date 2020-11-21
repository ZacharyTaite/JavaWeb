package com.teamsun.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo01 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(request.getMethod());//  GET
        System.out.println(request.getRequestURL()); // http://localhost:8080/day09_01_HttpServletRequest/servlet/demo1
        System.out.println(request.getRequestURI()); //   /day09_01_HttpServletRequest/servlet/demo1
        System.out.println(request.getContextPath()); //  /day09_01_HttpServletRequest
        System.out.println(request.getQueryString()); //  username=tom
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
