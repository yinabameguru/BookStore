package com.jza_lbz.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.jza_lbz.dao.OrderDao;
import com.jza_lbz.dao.impl.OrderDaoimpl;
import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Orderinfo;
import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;
import com.jza_lbz.exception.OrderException;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.utils.ManagerThreadLocal;

public class OrderServiceimpl implements OrderService {

	OrderDao orderDao=new OrderDaoimpl();
	@Override
	public List<Orderitem> CartShow(String user_id) throws SQLException {
		List<Orderinfo> orderinfos = orderDao.findAllCartInInfo(user_id);
		List<Orderitem> orderitems = new ArrayList<Orderitem>();
		for(Orderinfo orderinfo:orderinfos)
		{
			orderitems.add(orderDao.findAllCartInItem(orderinfo));
		}
		for(Orderitem orderitem:orderitems)
		{
			orderitem.setBook(orderDao.findBookByBookId(orderitem.getBook_id()));
		}
		return orderitems;
	}
	public void AddCart(User user,Book book) throws SQLException, OrderException {
		if (user==null) {
			throw new OrderException();
		}
		book=orderDao.findBookByBookId(book.getId());
		List<Orderinfo> orderinfos = orderDao.findCartInInfo(user.getId());
		if (orderinfos.size()!=0) {
			List<Orderitem> orderitems = new ArrayList<Orderitem>();
			for(Orderinfo orderinfo:orderinfos)
			{
				orderitems.add(orderDao.findCartInItem(orderinfo));
			}
			if (orderitems.size()!=0) {
				for(Orderitem orderitem:orderitems)
				{
					if (orderitem.getBook_id().equals(book.getId())) {
						orderDao.addCartnub(orderitem);
						return;
					}
				}
			}
		}
		String uuid=UUID.randomUUID().toString();
		Orderinfo orderinfo=new Orderinfo();
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		orderinfo.setId(uuid);
		orderinfo.setOrderId(df.format(day).toString());
		orderDao.creatCartAddOrderinfo(book, user, orderinfo);
		orderDao.creatCartAddOrderitem(book, orderinfo);
	}
	@Override
	public void CreateOrder(User user) throws SQLException {
		
		String uuid=UUID.randomUUID().toString();
		Date createTime=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int orderinfoNum=0;
		float orderinfoPrice=0;
		ManagerThreadLocal.start();
		orderDao.CreateOrder(uuid, user, df.format(createTime).toString());
		List<Orderitem> orderitems=orderDao.findOrderitemId(user);
		orderDao.updateOrderitem(orderitems, uuid);
		orderDao.deleteCartOtderinfo(user, orderitems.size());
		for(Orderitem orderitem:orderitems)
		{
			orderinfoNum +=orderitem.getNum();
			orderinfoPrice +=orderitem.getPrice()*orderitem.getNum();
		}
		orderDao.updateOrderinfo(uuid, orderinfoNum, orderinfoPrice);
		ManagerThreadLocal.commit();
		ManagerThreadLocal.remove();
	}
	@Override
	public List<Orderinfo> OrderInfoShow(User user) throws SQLException {
		return orderDao.findOrder(user);
	}
	@Override
	public List<Orderitem> orderitemShow(String orderinfo_id) throws SQLException {
		List<Orderitem> orderitems = orderDao.findOrderitems(orderinfo_id);
		for(Orderitem orderitem:orderitems)
		{
			orderitem.setBook(orderDao.findBookByBookId(orderitem.getBook_id()));
		}
		return orderitems;
	}
	
}
