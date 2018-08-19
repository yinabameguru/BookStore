package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.Orderinfo;
import com.jza_lbz.domain.User;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;

public class OrderInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user==null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		OrderService os=new OrderServiceimpl();
		try {
			List<Orderinfo> orderinfos = os.OrderInfoShow(user);
			request.setAttribute("orderinfos", orderinfos);
			request.getRequestDispatcher("/Orderinfo").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
