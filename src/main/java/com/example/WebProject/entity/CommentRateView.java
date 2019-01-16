
package com.example.WebProject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentrate")
public class CommentRateView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "phone")
	private Customer custommer;
	@Id
	@ManyToOne
	@JoinColumn(name = "idpr")
	private Products product;
	
	
	@Column(name = "rate", nullable = true)
	int rate;
	@Column(name = "comment", nullable = true)
	private String comment;
	@Column(name = "date", nullable = true)
	private Date date;
	public CommentRateView() {
		super();
	}
	public Customer getCustommer() {
		return custommer;
	}
	public void setCustommer(Customer custommer) {
		this.custommer = custommer;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
