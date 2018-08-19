package com.jza_lbz.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.dao.CategoryDao;
import com.jza_lbz.dao.impl.CategoryDaoimpl;
import com.jza_lbz.domain.Category;
import com.jza_lbz.domain.CategoryPageBook;
import com.jza_lbz.service.CategoryService;

public class CategoryServiceimpl implements CategoryService {

	CategoryDao categoryDao=new CategoryDaoimpl();
	@Override
	public List<Category> category() throws SQLException {
		return categoryDao.findAllCategory();
		
	}
	public CategoryPageBook findCategoryPageBook(CategoryPageBook categoryPageBook) throws SQLException{
		int pageNow=categoryPageBook.getPageNow();
		int pageSize=1;
		if (pageNow==0) {
			pageNow=1;
		}
		categoryPageBook.setPageNow(pageNow); 
		categoryPageBook.setPageSize(pageSize);
		categoryPageBook.setBooks(categoryDao.findCategoryPageBook(categoryPageBook.getCategory_id(), categoryPageBook.getPageNow(), categoryPageBook.getPageSize()));
		categoryPageBook.setBookCount(categoryDao.findCategoryBookCount(categoryPageBook.getCategory_id()));
		categoryPageBook.setPageTotal((int) Math.ceil(categoryDao.findCategoryBookCount(categoryPageBook.getCategory_id())*1.0/categoryPageBook.getPageSize()));
		return categoryPageBook;
	}

}
