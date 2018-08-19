package com.jza_lbz.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jza_lbz.domain.Category;
import com.jza_lbz.domain.CategoryPageBook;
import com.jza_lbz.service.CategoryService;
import com.jza_lbz.service.impl.CategoryServiceimpl;

public class CategorBookServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		CategoryPageBook cpbForm=new CategoryPageBook();
		try {    
			BeanUtils.populate(cpbForm, request.getParameterMap());
			CategoryService cs=new CategoryServiceimpl();
			CategoryPageBook cpb = cs.findCategoryPageBook(cpbForm);
			List<Category> categorys=cs.category();
			request.setAttribute("categorys", categorys);
			request.setAttribute("pageBook", cpb);
			request.getRequestDispatcher("Main").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
