package com.jza_lbz.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import com.jza_lbz.domain.Category;
import com.jza_lbz.domain.PageBook;
import com.jza_lbz.service.BookService;
import com.jza_lbz.service.CategoryService;
import com.jza_lbz.service.impl.BookServiceimpl;
import com.jza_lbz.service.impl.CategoryServiceimpl;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String categoryId = request.getParameter("category_id");
		PageBook pbForm=new PageBook();	
		try {
			BeanUtils.populate(pbForm, request.getParameterMap());
			if (categoryId!=null&&!"".equals(categoryId)) {
				
				request.getRequestDispatcher("/CategorBookServlet?"+categoryId+"&"+pbForm.getPageNow()+"").forward(request, response);
				return;
			}
			BookService bs=new BookServiceimpl();
			CategoryService cs=new CategoryServiceimpl();
			List<Category> categorys=cs.category();
			
			PageBook pb = bs.booksShow(pbForm);
			request.getSession().setAttribute("categorys", categorys);
			request.setAttribute("pageBook", pb);
			request.getRequestDispatcher("/Main").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


}
