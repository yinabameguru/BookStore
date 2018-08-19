package com.jza_lbz.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.beanutils.BeanUtils;

import com.jza_lbz.domain.User;
import com.jza_lbz.exception.UsersException;
import com.jza_lbz.service.UserService;
import com.jza_lbz.service.impl.UserServiceimpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String codeForm = request.getParameter("codeForm");
		User userForm=new User();
		try {
			BeanUtils.populate(userForm, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String code = (String) request.getSession().getAttribute("code");
		if (!code.equals(codeForm)) {
			request.setAttribute("username", userForm.getUsername());
			request.setAttribute("login_msg", "验证码错误！！！");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}else {
			UserService us=new UserServiceimpl();
			User user=null;
			try {
				user = us.Login(userForm);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (UsersException e) {
				request.setAttribute("username", userForm.getUsername());
				request.setAttribute("login_msg", e.getMessage());
				request.getRequestDispatcher("/Login").forward(request, response);
				return;
			}
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/MainServlet").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
