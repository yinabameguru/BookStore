package com.jza_lbz.service;


import java.sql.SQLException;

import com.jza_lbz.domain.User;
import com.jza_lbz.exception.UsersException;

public interface UserService {
	/**
	 * 登录
	 * @param name
	 * @return
	 * @throws SQLException 
	 * @throws UsersException 
	 */
	public User Login(User userForm) throws SQLException, UsersException;
	/**
	 * 
	 * @param userForm
	 * @return
	 * @throws UsersException
	 * @throws SQLException 
	 */
	public User Register(User userForm,String repassword) throws UsersException, SQLException, IllegalArgumentException, IllegalAccessException;
	
}
