package com.jza_lbz.dao;


import java.sql.SQLException;

import com.jza_lbz.domain.User;


public interface UserDao {	
	/**
	 * 根据名称查询用户信息
	 * @return
	 * @throws SQLException 
	 */
	public User findUserByName(String username) throws SQLException;
	/**
	 * 添加用户
	 * @return
	 * @throws SQLException 
	 */
	public User AddUser(String uuid, User user) throws SQLException;
	/**
	 * check用户是否存在
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkUserByName(String username) throws SQLException;
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkUserByEmail(String email) throws SQLException;
	
	
}
