package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.User;
import com.jza_lbz.exception.OrderException;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;

public class AddCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String book_id = request.getParameter("book_id");
		Book book=new Book();
		book.setId(book_id);
		OrderService os=new OrderServiceimpl();
		try {
			os.AddCart(user, book);
			response.sendRedirect("AddCartSuccess");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (OrderException e) {
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
