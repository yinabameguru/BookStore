package com.jza_lbz.domain;

import java.io.Serializable;
import java.util.List;

public class Orderinfo implements Serializable{
	private String id;
	private String orderId;
	private int num;
	private double price;
	private String status;
	private String user_id;
	private List<Orderitem> orderitems;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<Orderitem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
