package com.jza_lbz.service;

import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Orderinfo;
import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;
import com.jza_lbz.exception.OrderException;

public interface OrderService {

	/**
	 * 购物车战士
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public List<Orderitem> CartShow(String user_id) throws SQLException;
	/**
	 * 添加购物车
	 * @param user
	 * @param book
	 * @throws SQLException
	 * @throws OrderException
	 */
	public void AddCart(User user,Book book) throws SQLException, OrderException; 
	/**
	 * 订单生成
	 * @param user
	 * @throws SQLException
	 */
	public void CreateOrder(User user) throws SQLException;
	/**
	 * 订单列表战士
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Orderinfo> OrderInfoShow(User user) throws SQLException;
	/**
	 * 订单详情战士
	 * @param orderinfo_id
	 * @return
	 * @throws SQLException
	 */
	public List<Orderitem> orderitemShow(String orderinfo_id) throws SQLException;
}
