
package com.example.WebProject.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "cartlineinfo")
public class CartLineInfoView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(
	        fetch = FetchType.LAZY)
	    @NotFound(
	        action = NotFoundAction.IGNORE)
	@JoinColumn(name = "idc",referencedColumnName = "id")
	private CartInfo cartinfo;
	@Id
	@ManyToOne(
	        fetch = FetchType.LAZY)
	    @NotFound(
	        action = NotFoundAction.IGNORE)
	@JoinColumn(name = "idpr",referencedColumnName = "id")
	private Products product;
	
	
	@Column(name = "num", nullable = false)
	private int num;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	public CartLineInfoView() {
		super();
	}
	
	public CartLineInfoView(CartInfo cartinfo, Products product, int num, int amount) {
		super();
		this.cartinfo = cartinfo;
		this.product = product;
		this.num = num;
		this.amount = amount;
	}

	public CartInfo getCartinfo() {
		return cartinfo;
	}
	public void setCartinfo(CartInfo cartinfo) {
		this.cartinfo = cartinfo;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
