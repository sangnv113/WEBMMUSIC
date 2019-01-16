package com.example.WebProject.model;

public class RateModel {
private String phone;
private int rate;
private int id;// id of product
private String comment;
public RateModel(int id) {
	super();
	this.id = id;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public RateModel() {
	super();
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
