package com.jza_lbz.dao;

import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Category;

public interface CategoryDao {
	/**
	 * 查找全部类别
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAllCategory() throws SQLException;
	/**
	 * 按类型查找分页图书
	 * @param category_id
	 * @param pageNow
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findCategoryPageBook(String category_id,int pageNow,int pageSize) throws SQLException;
	
	public int findCategoryBookCount(String category_id) throws NumberFormatException, SQLException;
}
