package com.jza_lbz.service.impl;


import java.sql.SQLException;


import java.util.UUID;

import com.jza_lbz.dao.UserDao;
import com.jza_lbz.dao.impl.UserDaoimpl;
import com.jza_lbz.domain.User;
import com.jza_lbz.exception.UsersException;
import com.jza_lbz.service.UserService;

public class UserServiceimpl implements UserService {
	public UserDao userDao=new UserDaoimpl();
	@Override
	public User Login(User userForm) throws SQLException,UsersException{
		User user = userDao.findUserByName(userForm.getUsername());	
		if ("".equals(userForm.getUsername())) {
			throw new UsersException("用户名为空！！！");
		}else if (!userForm.getUsername().equals(user.getUsername())) {
			throw new UsersException("用户名错误！！！");
		}else if ("".equals(userForm.getPassword())) {
			throw new UsersException("密码为空！！！");
		}else if (!userForm.getPassword().equals(user.getPassword())) {
			throw new UsersException("密码错误！！！");
		}
		return user;
	}
	@Override
	public User Register(User userForm,String repassword) throws UsersException, SQLException, IllegalArgumentException, IllegalAccessException {
		if ("".equals(userForm.getUsername())) {
			throw new UsersException("用户名不能为空!!!");
		}else if (!userForm.getUsername().matches("^[0-9a-zA-Z\u4e00-\u9fa5_]{3,16}$")) {
			throw new UsersException("用户名为3~16位可以为汉字、数字、字母（大小写）、下划线！！！");
		}else if (userDao.checkUserByName(userForm.getUsername())) {
			throw new UsersException("用户名已存在！！！");
		}else if ("".equals(userForm.getPassword())) {
			throw new UsersException("密码不能为空！！！");
		}else if (!userForm.getPassword().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
			throw new UsersException("密码由6~21字母和数字共同组成！！！");
		}else if (!userForm.getPassword().equals(repassword)) {
			throw new UsersException("两次输入密码不一致！！！");
		}else if ("".equals(userForm.getEmail())) {
			throw new UsersException("邮箱不能为空！！！");
		}else if (!userForm.getEmail().matches("^\\w+([-_.]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,6})+$")) {
			throw new UsersException("邮箱格式不正确！！！");
		}else if (userDao.checkUserByEmail(userForm.getEmail())) {
			throw new UsersException("该邮箱已注册！！！");
		}
		if (!"".equals(userForm.getCellphone())) {
			if (!userForm.getCellphone().matches("^(0[0-9]{2,3}/-)?([2-9][0-9]{6,7})+(/-[0-9]{1,4})?$")) {
				throw new UsersException("电话号码不正确！！！例：8883289");
			}
		}
		if (!"".equals(userForm.getMobilephone())) {
			if (!userForm.getMobilephone().matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")) {
				throw new UsersException("手机号码不正确！！！例：15071393716");
			}
		}
		String uuid=UUID.randomUUID().toString();
		return userDao.AddUser(uuid,userForm);
	}
	
}
