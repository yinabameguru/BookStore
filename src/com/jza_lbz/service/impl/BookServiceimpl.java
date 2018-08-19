package com.jza_lbz.service.impl;

import java.sql.SQLException;

import com.jza_lbz.dao.BookDao;
import com.jza_lbz.dao.impl.BookDaoimpl;
import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.PageBook;
import com.jza_lbz.service.BookService;

public class BookServiceimpl implements BookService {

	BookDao bookDao=new BookDaoimpl();
	@Override
	public PageBook booksShow(PageBook pbForm) throws SQLException {
		int pageNow=0;
		int pageSize=3;
		if (pbForm.getPageNow()==0) {
			pageNow=1;
		}else {
			pageNow=pbForm.getPageNow();
		}
		pbForm.setPageNow(pageNow);
		pbForm.setPageSize(pageSize);
		pbForm.setBooks(bookDao.findPageBook(pageNow, pageSize));
		pbForm.setBookCount(bookDao.findBookCount());
		pbForm.setPageTotal((int) Math.ceil(bookDao.findBookCount()*1.0/pageSize));
		return pbForm;
	}
	@Override
	public Book bookShow(String id) throws SQLException {
		return bookDao.findBookByid(id);
	}

}
