package com.jza_lbz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jza_lbz.dao.CategoryDao;
import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Category;
import com.jza_lbz.utils.C3P0Util;

public class CategoryDaoimpl implements CategoryDao {

	@Override
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from category";
		return  qr.query(sql,new BeanListHandler<Category>(Category.class));
		
	}

	@Override
	public List<Book> findCategoryPageBook(String category_id,int pageNow,int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from book where category_id=? limit "+(pageNow-1)*pageSize+","+pageSize;
		return qr.query(sql,new BeanListHandler<Book>(Book.class),category_id);
	}

	@Override
	public int findCategoryBookCount(String category_id) throws NumberFormatException, SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select count(*) from book where category_id=?";
		return Integer.parseInt(qr.query(sql,new ScalarHandler(1),category_id).toString());
	}

}
