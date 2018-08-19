package com.jza_lbz.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		Connection connection=threadLocal.get();
		if (connection==null) {
			connection=C3P0Util.getConnection();
			threadLocal.set(connection);
		}
		return connection;
	}
	
	public static void start() {
		Connection connection=getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void remove() {
		try {
			getConnection().close();
			threadLocal.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
