

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
@Table(name = "comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", nullable = true)
	int id;
	@Column(name = "name", nullable = true)
	private String name;
	
	@Column(name = "phone")
	private String phone;
	@ManyToOne
	@JoinColumn(name = "idpr")
	private Products product;
	@Column(name = "comment", nullable = true)
	private String comment;
	@Column(name = "date", nullable = true)
	private Date date;
	@Column(name = "active")
	private int  note;
	public Comment() {
		super();
	}
	
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Comment(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Comment(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
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
	public Comment(String name, String phone, String comment, int note) {
		super();
		this.name = name;
		this.phone = phone;
		this.comment = comment;
		this.note=note;
	}
	
}