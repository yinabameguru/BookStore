package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.User;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;
import com.jza_lbz.utils.ManagerThreadLocal;

public class OrderSubmitServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user=(User) request.getSession().getAttribute("user");
		OrderService orderService=new OrderServiceimpl();
		try {
			orderService.CreateOrder(user);
			response.sendRedirect("CreateOrderSuccess");
		} catch (SQLException e) {
			ManagerThreadLocal.rollback();
			ManagerThreadLocal.remove();
			e.printStackTrace();
			request.getRequestDispatcher("/Error").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
