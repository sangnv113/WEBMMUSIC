package com.example.WebProject.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentRateIndentity implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "phone")
	private Customer phone;
	@ManyToOne
	@JoinColumn(name = "idpr")
	private Products idpr;
	
	
	public Customer getPhone() {
		return phone;
	}
	public void setPhone(Customer phone) {
		this.phone = phone;
	}
	public Products getIdpr() {
		return idpr;
	}
	public void setIdpr(Products idpr) {
		this.idpr = idpr;
	}
	public CommentRateIndentity() {
		super();
	}
	public CommentRateIndentity(Customer phone, Products idpr) {
		super();
		this.phone = phone;
		this.idpr = idpr;
	}
	
}
