package com.jza_lbz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Orderinfo;
import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;

public interface OrderDao {
	/**
	 * 查询购物车里 所有商品1
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public List<Orderinfo> findAllCartInInfo(String user_id) throws SQLException;
	/**
	 * 查询购物车里 所有商品2
	 * @param orderinfo
	 * @return
	 * @throws SQLException
	 */
	public Orderitem findAllCartInItem(Orderinfo orderinfo) throws SQLException;
	/**
	 * 根据id查询书籍
	 * @param book_id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookByBookId(String book_id) throws SQLException;
	/**
	 * 订单列表中添加购物车
	 * @param book
	 * @param user
	 * @throws SQLException
	 */
	public void creatCartAddOrderinfo(Book book,User user,Orderinfo orderinfo) throws SQLException;
	/**
	 * 订单项中添加购物车
	 * @param book
	 * @param orderinfo
	 * @throws SQLException
	 */
	public void creatCartAddOrderitem(Book book,Orderinfo orderinfo) throws SQLException;
	/**
	 * 查询info中的购物车
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public List<Orderinfo> findCartInInfo(String user_id) throws SQLException;
	/**
	 * 查询item中的购物车
	 * @param orderinfo
	 * @return
	 * @throws SQLException
	 */
	public Orderitem findCartInItem(Orderinfo orderinfo) throws SQLException;
	/**
	 * 添加购物车
	 * @param orderitem
	 * @throws SQLException
	 */
	public void addCartnub(Orderitem orderitem) throws SQLException;
	/**
	 * 查找订单列表
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Orderinfo> findOrder(User user) throws SQLException;
	/**
	 * 查找订单项
	 * @param orderinfo
	 * @return
	 * @throws SQLException
	 */
	public List<Orderitem> findOrderitem(Orderinfo orderinfo) throws SQLException;
	/**
	 * 创建新的空订单
	 * @param uuid
	 * @param user
	 * @param createTime
	 * @return
	 * @throws SQLException
	 */
	public void CreateOrder(String uuid,User user,String createTime) throws SQLException;
	/**
	 * 查询购物车商品的item_id
	 * @param connection
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Orderitem> findOrderitemId(User user) throws SQLException;
	/**
	 * 更新订单项
	 * @param connection
	 * @param orderitems
	 * @param orderInfo_id
	 * @throws SQLException
	 */
	public void updateOrderitem(List<Orderitem> orderitems,String newOrderInfo_id) throws SQLException;
	/**
	 * 删除info中的购物车部分
	 * @param connection
	 * @param user
	 * @param count
	 * @throws SQLException
	 */
	public void deleteCartOtderinfo(User user,int count) throws SQLException;
	/**
	 * 更新订单info
	 * @param orderinfo_id
	 * @param orderinfoNum
	 * @param orderInfoPrice
	 * @throws SQLException
	 */
	public void updateOrderinfo(String orderinfo_id,int orderinfoNum,double orderinfoPrice) throws SQLException;
	/**
	 * 查询订单项
	 * @param orderinfo_id
	 * @return
	 * @throws SQLException
	 */
	public List<Orderitem> findOrderitems(String orderinfo_id) throws SQLException;
}


























