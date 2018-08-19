package com.jza_lbz.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.jza_lbz.dao.OrderDao;
import com.jza_lbz.dao.impl.OrderDaoimpl;
import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;
import com.jza_lbz.service.OrderService;
import com.jza_lbz.service.impl.OrderServiceimpl;


public class OrderTest {
	OrderDao orderDao=new OrderDaoimpl();
	OrderService orderService=new OrderServiceimpl();
	@Test
	public void daoCreateOrder() {
		String uuid = UUID.randomUUID().toString();
		User user = new User();
		user.setId("4de88180-cf9f-421a-9331-c3fa484dca2c");
		String createTime = uuid;
		try {
			orderDao.CreateOrder(uuid, user, createTime); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void daoFindOrderitemId() {
		User user = new User();
		user.setId("4de88180-cf9f-421a-9331-c3fa484dca2c");
		List<Orderitem> orderitems=new ArrayList<Orderitem>();
		try {
			orderitems=orderDao.findOrderitemId(user);
			for(Orderitem orderitem:orderitems)
			{
				System.out.println(orderitem.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void daoUpdateOrderitem(){
		String orderInfo_id="0cf5864c-e676-4bd2-aa2b-a4c69fe06b97";
		List<Orderitem> orderitems=new ArrayList<Orderitem>();
		Orderitem orderitem1=new Orderitem();
		Orderitem orderitem2=new Orderitem();
		orderitem1.setId("1");
		orderitem2.setId("2");
		orderitems.add(orderitem1);
		orderitems.add(orderitem2);
		try {
			orderDao.updateOrderitem(orderitems, orderInfo_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void daoDeleteCartOtderinfo(){
		User user = new User();
		user.setId("4de88180-cf9f-421a-9331-c3fa484dca2c");
		try {
			orderDao.deleteCartOtderinfo(user, 3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void serviceCreateOrder(){
		User user = new User();
		user.setId("4de88180-cf9f-421a-9331-c3fa484dca2c");
		try {
			orderService.CreateOrder(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void daoUpdateOrderinfo(){
		try {
			orderDao.updateOrderinfo("36fd2f77-f108-493c-b839-fe01304914b4", 3, 100.0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void serviceOrderitemShow(){
		try {
			List<Orderitem> orderitems = orderService.orderitemShow("3ad7efca-1c8d-46ad-ad87-13285962e80b");
			for(Orderitem orderitem:orderitems)
			{
				System.out.println(orderitem.getNum());
				System.out.println(orderitem.getPrice());
				System.out.println(orderitem.getBook().getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


















