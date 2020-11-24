package com.teamsun.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsun.domain.Book;
import com.teamsun.service.BookServiceImpl;

public class FindBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		BookServiceImpl bs = new BookServiceImpl();
		Book book = bs.findBookById(id);
		
		request.setAttribute("b", book);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
