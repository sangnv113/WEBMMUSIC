package com.example.WebProject.model;

public class CommentModel {
	private int id;
	private int idpr;
	private String comment;
	private String date;
	private int note;
	

	public CommentModel(int id, String comment, String date, String name, String phone ,int note) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
		this.name = name;
		this.phone = phone;
		this.note=note;
	}
	
	public CommentModel(int id, int idpr, String comment, String date, int note, String name, String phone, String nameProduct) {
		super();
		this.id = id;
		this.idpr = idpr;
		this.comment = comment;
		this.date = date;
		this.note = note;
		this.name = name;
		this.phone = phone;
		this.nameProduct = nameProduct;
	}

	private String name;// name user
	private String nameProduct;
	private String phone;
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getIdpr() {
		return idpr;
	}
	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public CommentModel() {
		super();
	}
	public CommentModel(int id) {
		super();
		this.id = id;
	}
}
