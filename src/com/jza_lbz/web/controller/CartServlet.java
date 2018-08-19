package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;

public class CartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user==null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		String user_id=user.getId();
		OrderService os=new OrderServiceimpl();

			List<Orderitem> orderitems;
			try {
				orderitems = os.CartShow(user_id);
				request.setAttribute("orderitems", orderitems);
				request.getRequestDispatcher("/Cart").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
