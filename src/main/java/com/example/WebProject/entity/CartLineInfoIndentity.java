package com.example.WebProject.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CartLineInfoIndentity implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idc")
	private CartInfo cartinfo;

	@ManyToOne
	@JoinColumn(name = "idpr")
	private Products product;

	public CartLineInfoIndentity() {
		super();
	}

	public CartLineInfoIndentity(CartInfo cartinfo, Products product) {
		super();
		this.cartinfo = cartinfo;
		this.product = product;
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
	
	
	
}
