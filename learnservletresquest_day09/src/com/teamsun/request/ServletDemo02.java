package com.teamsun.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletDemo02 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        test1(request);
		test2(request);
        //������name����Ϣͷ
        Enumeration headers = request.getHeaders("accept-language");
        while(headers.hasMoreElements()){
            String e = (String) headers.nextElement();
            System.out.println(e+":"+request.getHeader(e));
        }
    }

    private void test2(HttpServletRequest request) {
        //�������������Ϣͷ��name
        Enumeration names = request.getHeaderNames();

        while(names.hasMoreElements()){
            String e = (String) names.nextElement();
            System.out.println(e+":"+request.getHeader(e));
        }
    }

    private void test1(HttpServletRequest request) {
        //���������Ϣͷ����Ϣ
        String header = request.getHeader("User-Agent");
        System.out.println(header);

        if(header.toLowerCase().contains("msie")){
            System.out.println("��ʹ�õ���IE�����");
        }else if(header.toLowerCase().contains("firefox")){
            System.out.println("��ʹ�õ��ǻ�������");
        }else if(header.toLowerCase().contains("chrome")){
            System.out.println("��ʹ�õ��ǹȸ������");
        }else{
            System.out.println("��ʹ�õ������������");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
