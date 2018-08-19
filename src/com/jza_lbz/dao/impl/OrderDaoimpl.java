package com.jza_lbz.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jza_lbz.dao.OrderDao;
import com.jza_lbz.domain.Book;
import com.jza_lbz.domain.Orderinfo;
import com.jza_lbz.domain.Orderitem;
import com.jza_lbz.domain.User;
import com.jza_lbz.utils.C3P0Util;
import com.jza_lbz.utils.ManagerThreadLocal;

public class OrderDaoimpl implements OrderDao {

	@Override
	public List<Orderinfo> findAllCartInInfo(String user_id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT id FROM orderinfo WHERE user_id=? AND STATUS=0";
		return qr.query(sql, new BeanListHandler<Orderinfo>(Orderinfo.class),user_id);
	}

	@Override
	public Book findBookByBookId(String book_id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from book where id=?";
		return qr.query(sql, new BeanHandler<Book>(Book.class),book_id);
	}

	@Override
	public void creatCartAddOrderinfo(Book book,User user,Orderinfo orderinfo) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="insert into orderinfo values (?,?,1,?,0,?)";
		qr.update(sql,orderinfo.getId(),orderinfo.getOrderId(),book.getPrice(),user.getId());
	}

	@Override
	public void creatCartAddOrderitem(Book book,Orderinfo orderinfo) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="insert into orderitem values(uuid(),1,?,?,?)";
		qr.update(sql, book.getPrice(),orderinfo.getId(),book.getId());
	}

	@Override
	public List<Orderinfo> findCartInInfo(String user_id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT * FROM orderinfo WHERE user_id=? AND STATUS =0";
		return qr.query(sql, new BeanListHandler<Orderinfo>(Orderinfo.class),user_id);
	}

	@Override
	public Orderitem findCartInItem(Orderinfo orderinfo) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT * FROM orderitem WHERE orderinfo_id=?";
		return qr.query(sql, new BeanHandler<Orderitem>(Orderitem.class),orderinfo.getId());
	}

	@Override
	public void addCartnub(Orderitem orderitem) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="update orderitem set num=?,price=price+? where orderInfo_id=? and book_id=?";
		qr.update(sql,(orderitem.getNum()+1),orderitem.getPrice(),orderitem.getOrderinfo_id(),orderitem.getBook_id());	
	}

	@Override
	public Orderitem findAllCartInItem(Orderinfo orderinfo) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT * FROM orderitem WHERE orderInfo_id=?";
		return qr.query(sql, new BeanHandler<Orderitem>(Orderitem.class),orderinfo.getId());
	}

	@Override
	public List<Orderinfo> findOrder(User user) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from orderinfo where user_id=? and status=1 or status=2 or status=3 or status=4";
		return qr.query(sql, new BeanListHandler<Orderinfo>(Orderinfo.class),user.getId());
	}

	@Override
	public List<Orderitem> findOrderitem(Orderinfo orderinfo) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from orderitem where orderInfo_id=?";
		return qr.query(sql, new BeanListHandler<Orderitem>(Orderitem.class),orderinfo.getId());
	}

	@Override
	public void CreateOrder(String uuid, User user, String createTime) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="insert into orderinfo(id,orderId,status,user_id) values(?,?,1,?)";
		 qr.update(ManagerThreadLocal.getConnection(),sql,uuid,createTime,user.getId());
		
	}

	@Override
	public List<Orderitem> findOrderitemId(User user) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="SELECT orderitem.id,orderitem.num,orderitem.price FROM orderinfo,orderitem WHERE orderinfo.id=orderitem.orderInfo_id AND orderinfo.user_id=? AND orderinfo.status=0";
		return qr.query(ManagerThreadLocal.getConnection(), sql, new BeanListHandler<Orderitem>(Orderitem.class),user.getId());
	}

	@Override
	public void updateOrderitem(List<Orderitem> orderitems,String orderInfo_id) throws SQLException {
		QueryRunner qr=new QueryRunner();
		Object[][] params=new Object[orderitems.size()][];
		for (int i = 0; i < params.length; i++) {
			params[i]=new Object[]{orderInfo_id,orderitems.get(i).getId()};
		}
		String sql="update orderitem set orderInfo_id=? where id=?";
		qr.batch(ManagerThreadLocal.getConnection(), sql, params);
	}

	@Override
	public void deleteCartOtderinfo(User user,int count) throws SQLException {
		QueryRunner qr=new QueryRunner();
		Object[][] params=new Object[count][];
		for (int i = 0; i < params.length; i++) {
			params[i]=new Object[]{user.getId()};
		}
		String sql="delete from orderinfo where user_id=? and status=0";
		qr.batch(ManagerThreadLocal.getConnection(), sql, params);
		
	}

	@Override
	public void updateOrderinfo(String orderinfo_id,int orderinfoNum, double orderinfoPrice) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update orderinfo set num=?,price=? where id=?";
		qr.update(ManagerThreadLocal.getConnection(), sql, orderinfoNum,orderinfoPrice,orderinfo_id);
		
	}

	@Override
	public List<Orderitem> findOrderitems(String orderinfo_id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT orderitem.num,orderitem.price,orderitem.book_id FROM orderinfo,orderitem WHERE orderinfo.id=orderitem.orderInfo_id AND orderinfo.id=?";
		return qr.query(sql, new BeanListHandler<Orderitem>(Orderitem.class),orderinfo_id);
	}

}
