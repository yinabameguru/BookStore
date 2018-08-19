package com.jza_lbz.service;

import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.domain.Category;
import com.jza_lbz.domain.CategoryPageBook;

public interface CategoryService {
	/**
	 * 分类&查询
	 * @return
	 * @throws SQLException
	 */
	public List<Category> category() throws SQLException;
	/**
	 * 按分类查询每页书籍
	 * @param categoryPageBook
	 * @return
	 * @throws SQLException
	 */
	public CategoryPageBook findCategoryPageBook(CategoryPageBook categoryPageBook) throws SQLException;
}
