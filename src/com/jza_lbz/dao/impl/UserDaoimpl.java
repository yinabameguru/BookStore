package com.jza_lbz.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jza_lbz.dao.UserDao;
import com.jza_lbz.domain.User;
import com.jza_lbz.utils.C3P0Util;


public class UserDaoimpl implements UserDao {

	@Override
	public User findUserByName(String username) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from users where username=?";
		return qr.query(sql, new BeanHandler<User>(User.class), username);
	}	

	@Override
	public User AddUser(String uuid,User user) throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String cellphone="";
		String mobilephone="";
		String address="";
		String cellphoneValue="";
		String mobilephoneValue="";
		String addressValueString="";
		if (!"".equals(user.getCellphone())) {
			cellphone=",cellphone";
			cellphoneValue=",'"+user.getCellphone()+"'";
		}
		if (!"".equals(user.getMobilephone())) {
			mobilephone=",mobilephone";
			mobilephoneValue=",'"+user.getMobilephone()+"'";
		}
		if (!"".equals(user.getAddress())) {
			address=",address";
			mobilephoneValue=",'"+user.getAddress()+"'";
		}
		String sql="insert into users(id,username,password,email"+cellphone+mobilephone+address+") values(?,?,?,?"+cellphoneValue+mobilephoneValue+addressValueString+")";
		qr.update(sql, uuid,user.getUsername(),user.getPassword(),user.getEmail());
		user.setId(uuid);
		return user;
	}
	
	@Override
	public boolean checkUserByName(String username) throws SQLException {
		boolean b=false;
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from users where username=?";
		Object[] arr = qr.query(sql, new ArrayHandler(),username);
		if (arr!=null) {
			b=true;
		}
		return b;
	}

	@Override
	public boolean checkUserByEmail(String email) throws SQLException {
		boolean b=false;
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from users where email=?";
		Object[] arr=qr.query(sql, new ArrayHandler(),email);
		if (arr!=null) {
			b=true;
		}
		return b;
	}
	
	
	
}
