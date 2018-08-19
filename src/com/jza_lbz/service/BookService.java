package com.jza_lbz.service;

import java.sql.SQLException;

import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.PageBook;

public interface BookService {
	/**
	 * 每页书籍信息
	 * @param pageNow
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public PageBook booksShow(PageBook pbForm) throws SQLException;
	/**
	 * 书籍详细信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book bookShow(String id) throws SQLException;
}
