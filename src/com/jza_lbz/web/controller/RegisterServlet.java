package com.jza_lbz.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jza_lbz.domain.User;
import com.jza_lbz.exception.UsersException;
import com.jza_lbz.service.UserService;
import com.jza_lbz.service.impl.UserServiceimpl;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String repassword=request.getParameter("repassword");
		User userForm=new User();
		try {
			BeanUtils.populate(userForm, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		UserService us=new UserServiceimpl();
		try {
			User user=us.Register(userForm, repassword);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/MainServlet").forward(request, response);
		} catch (UsersException e) {
			request.setAttribute("register_msg", e.getMessage());
			request.setAttribute("userForm", userForm);
			request.getRequestDispatcher("/Register").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*FormUser fu=new FormUser();
		try {
			BeanUtils.populate(fu, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!fu.valuedate()) {
			request.setAttribute("fu", fu);
			request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		User user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserService us=new UserServiceimpl();
			us.findUserByName(user.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
