
package com.example.WebProject.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "cartlineinfo")
public class CartLineInfo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CartLineInfoIndentity id;
	
	
	@Column(name = "num", nullable = false)
	private int num;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	public CartLineInfo() {
		super();
	}
	

	public CartLineInfo(CartLineInfoIndentity id, int num, int amount) {
		super();
		this.id = id;
		this.num = num;
		this.amount = amount;
	}


	public CartLineInfoIndentity getId() {
		return id;
	}


	public void setId(CartLineInfoIndentity id) {
		this.id = id;
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
