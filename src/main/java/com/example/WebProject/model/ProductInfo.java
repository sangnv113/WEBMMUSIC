package com.example.WebProject.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductInfo {
	
	public ProductInfo(int id, String name, String category, int rate, String gia, int soluong, int giamgia, String giasaugiam) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.rate = rate;
		this.gia = gia;
		this.soluong = soluong;
		this.giamgia=giamgia;
		this.giasaugiam=giasaugiam;
	}
	public ProductInfo(int id, String name, String datepr, String category, String producer, String color, int rate,
			int soluong, String gia, int luotdanhgia, int giamgia) {
		super();
		this.id = id;
		this.name = name;
		this.datepr = datepr;
		this.category = category;
		this.producer = producer;
		this.color = color;
		this.rate = rate;
		this.soluong = soluong;
		this.gia = gia;
		this.luotdanhgia = luotdanhgia;
		this.giamgia = giamgia;
	}
	public ProductInfo(int id, String name,  String category,  String category2, String producer, String color, int rate,
			int soluong, String gia, int luotdanhgia, int giamgia, String giasaugiam) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.category2 = category2;
		this.producer = producer;
		this.color = color;
		this.rate = rate;
		this.soluong = soluong;
		this.gia = gia;
		this.luotdanhgia = luotdanhgia;
		this.giamgia=giamgia;
		this.giasaugiam=giasaugiam;
	
	}
	public ProductInfo(int id, String name,  String category, String category2, String producer, String color, int rate,
			int soluong, String gia, int luotdanhgia, int giamgia, String giasaugiam, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.category2=category2;
		this.producer = producer;
		this.color = color;
		this.rate = rate;
		this.soluong = soluong;
		this.gia = gia;
		this.luotdanhgia = luotdanhgia;
		this.giamgia=giamgia;
		this.giasaugiam=giasaugiam;
		this.visits=visits;
	}
	public ProductInfo() {
		super();
	}
	  private boolean valid;
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	private int id;
	private String name;
	private String  datepr;
	public ProductInfo(int id, String category, String producer, String color, int rate, int luotdanhgia,
			MultipartFile fileData) {
		super();
		this.id = id;
		this.category = category;
		this.producer = producer;
		this.color = color;
		this.rate = rate;
		this.luotdanhgia = luotdanhgia;
		FileData = fileData;
	}
	private String category; 
	private String category2; 
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	private String producer;
	private String color;
	private int rate;
	private int soluong;
	private String gia;
	private int luotdanhgia;
	private int giamgia;
	private String giasaugiam;
	 private MultipartFile FileData;
	 private int visits;
	
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public MultipartFile getFileData() {
		return FileData;
	}
	public void setFileData(MultipartFile fileData) {
		FileData = fileData;
	}
	public String getGiasaugiam() {
		return giasaugiam;
	}
	public void setGiasaugiam(String giasaugiam) {
		this.giasaugiam = giasaugiam;
	}
	public int getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}
	public int getLuotdanhgia() {
		return luotdanhgia;
	}
	public void setLuotdanhgia(int luotdanhgia) {
		this.luotdanhgia = luotdanhgia;
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
	public String getDatepr() {
		return datepr;
	}
	public void setDatepr(String datepr) {
		this.datepr = datepr;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
}
