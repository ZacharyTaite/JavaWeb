package com.teamsun.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo01 implements Servlet{

    public ServletDemo01() {
        System.out.println("***********ServletDemo1执行了*********");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("***********init执行了*********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("***********service执行了*********");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("***********destroy执行了*********");
    }
}
