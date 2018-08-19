package com.jza_lbz.domain;

import java.io.Serializable;


public class Orderitem implements Serializable{
	private String id;
	private int num;
	private double price;
	private String orderinfo_id;
	private Orderinfo orderinfo;
	private String book_id;
	private Book book;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrderinfo_id() {
		return orderinfo_id;
	}
	public void setOrderinfo_id(String orderinfo_id) {
		this.orderinfo_id = orderinfo_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	


	
	
}
