package com.example.WebProject.model;

public class CommentRateInfo {

	private int rate;
	private String comment;
	private String date;
	private String name;
	public CommentRateInfo(int rate, String comment, String date, String name) {
		super();
		this.rate = rate;
		this.comment = comment;
		this.date = date;
		this.name = name;
	}
	public CommentRateInfo() {
		super();
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
	
}
