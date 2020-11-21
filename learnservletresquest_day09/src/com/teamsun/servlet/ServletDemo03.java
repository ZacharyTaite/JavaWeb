package com.teamsun.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class ServletDemo03 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/√¿≈Æ.jpg");
        FileInputStream inputStream = new FileInputStream(path);
        ServletOutputStream outputStream = resp.getOutputStream();
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        filename = URLEncoder.encode(filename, "UTF-8");
        resp.setHeader("content-disposition", "attachment;filename="+filename);
        resp.setHeader("content-type", "image/jpeg");

        int len = 1;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        outputStream.close();
        inputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
