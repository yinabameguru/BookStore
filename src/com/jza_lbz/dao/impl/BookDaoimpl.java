package com.jza_lbz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jza_lbz.dao.BookDao;
import com.jza_lbz.domain.Book;
import com.jza_lbz.utils.C3P0Util;

public class BookDaoimpl implements BookDao {

	@Override
	public List<Book> findPageBook(int pageNow, int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from book limit "+((pageNow-1)*pageSize)+","+pageSize;
		return qr.query(sql,new BeanListHandler<Book>(Book.class));
	}

	@Override
	public int findBookCount() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select count(*) from book";
		return Integer.parseInt(qr.query(sql, new ScalarHandler(1)).toString());
	}

	@Override
	public Book findBookByid(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from book where id=?";
		return qr.query(sql, new BeanHandler<Book>(Book.class),id);
	}
	
}
