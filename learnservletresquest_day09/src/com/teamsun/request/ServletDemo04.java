package com.teamsun.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取表单数据
        ServletInputStream sis = request.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while((len=sis.read(b))!=-1){
            //System.out.println(new String(new String(b,0,len).getBytes(),"utf-8"));
            System.out.println(new String(b, 0, len, "UTF-8"));
        }

        sis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
