package com.jza_lbz.dao;

import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.domain.Book;

public interface BookDao {
	/**
	 * 查找每页的书籍信息
	 * @param pageNow
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findPageBook(int pageNow,int pageSize) throws SQLException;
	/**
	 * 查找书籍总数量
	 * @return
	 * @throws SQLException
	 */
	public int findBookCount() throws SQLException;
	/**
	 * 根据id查找图书
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookByid(String id) throws SQLException;
}
