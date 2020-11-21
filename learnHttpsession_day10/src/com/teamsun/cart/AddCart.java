package com.teamsun.cart;

import com.teamsun.entity.Book;
import com.teamsun.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddCart extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //����id�õ���
        String id = request.getParameter("id");
        Book book = DBUtil.findBookById(id);
        //�õ�session����
        HttpSession session = request.getSession();

        //��session��ȡ��list�����ﳵ��
        List<Book> list = (List<Book>)session.getAttribute("cart");
        if(list==null){
            list = new ArrayList<Book>();
        }
        list.add(book);

        session.setAttribute("cart", list);//��list�Żص�session����

        out.print("����ɹ���");
        String url = request.getContextPath()+"/servlet/showAllBooksServlet";
        //response.setHeader("refresh", "2;url="+response.encodeURL(url));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
