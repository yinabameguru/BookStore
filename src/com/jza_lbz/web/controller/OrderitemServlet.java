package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;

public class OrderitemServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String orderinfo_id = request.getParameter("orderinfo_id");
		OrderService orderService=new OrderServiceimpl();
		try {
			List<Orderitem> orderitems = orderService.orderitemShow(orderinfo_id);
			request.setAttribute("orderitems", orderitems);
			request.getRequestDispatcher("/Orderitem").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
