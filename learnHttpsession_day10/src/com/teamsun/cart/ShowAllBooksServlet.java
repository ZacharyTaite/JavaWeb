package com.teamsun.cart;

import com.teamsun.entity.Book;
import com.teamsun.pool.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShowAllBooksServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getSession();

        out.print("����վ�����º��飺<br/>");
        Map<String, Book> books = DBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            String url = request.getContextPath()+"/servlet/addCart?id="+book.getKey();
            out.print("<a href='"+response.encodeURL(url)+"' >"+book.getValue().getName()+"</a><br/>");
        }
        String url2 = request.getContextPath()+"/servlet/showCart";
        out.print("<a href='"+response.encodeURL(url2)+"'>�鿴���ﳵ</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
