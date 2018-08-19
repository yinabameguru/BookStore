package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.Book;
import com.jza_lbz.service.BookService;
import com.jza_lbz.service.impl.BookServiceimpl;

public class ToBookShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;cherset=utf-8");
		String id = request.getParameter("id");
		BookService bs=new BookServiceimpl();
		try {
			Book book=bs.bookShow(id);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/BookShow").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
