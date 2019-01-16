package com.example.WebProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma")
public class Ma implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "product", nullable = false)
	private int product;
	
	@Column(name = "comment", nullable = false)
	private int comment;
	@Column(name = "cart", nullable = false)
	private int cart;
	@Column(name = "cartline", nullable = false)
	private int cartline;
	
	public int getCart() {
		return cart;
	}
	public void setCart(int cart) {
		this.cart = cart;
	}
	public int getCartline() {
		return cartline;
	}
	public void setCartline(int cartline) {
		this.cartline = cartline;
	}
	
	@Column(name = "producer", nullable = false)
	private int producer;
	@Column(name = "color", nullable = false)
	private int color;
	
	public int getProducer() {
		return producer;
	}
	public void setProducer(int producer) {
		this.producer = producer;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public Ma(int id, int product) {
		super();
		this.id = id;
		this.product = product;
		
		
	}
	
public Ma(int id, int product,  int producer, 
		int color, int cart, int cartline, int comment) {
		super();
		this.id = id;
		this.product = product;
		this.comment = comment;
		this.producer = producer;
		this.color = color;
		this.cart = cart;
		this.cartline = cartline;
	}
	/*	public Ma(int id, int piano) {
		super();
		this.id = id;
		this.piano = piano;
	}*/

	public Ma() {
		
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	

	
	

	
	
	
	
	
	
	
}
