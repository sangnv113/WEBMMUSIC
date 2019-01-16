
package com.example.WebProject.model;



public class CartLineModel {

	private int index;//Only used to delete the shopping cart line
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	public CartLineModel() {
		super();
	}
	  private boolean valid;
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	private int id;// id of product
	private int idc;//id of cart

	private String name;
	
	private String category; 
	private String producer;
	private String color;
	private int soluong;
	private String giasaugiam;
	

	public CartLineModel(int id, String name, String category, String producer, String color, int soluong,
			String giasaugiam) {
		super();
		this.id = id;
			this.name = name;
		this.category = category;
		this.producer = producer;
		this.color = color;
		this.soluong = soluong;
		this.giasaugiam = giasaugiam;
	}
	
	public CartLineModel(int id, int idc, String name, String category, String producer, String color, int soluong,
			String giasaugiam) {
		super();
		this.id = id;
		this.idc = idc;
		this.name = name;
		this.category = category;
		this.producer = producer;
		this.color = color;
		this.soluong = soluong;
		this.giasaugiam = giasaugiam;
	}
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public String getGiasaugiam() {
		return giasaugiam;
	}
	public void setGiasaugiam(String giasaugiam) {
		this.giasaugiam = giasaugiam;
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

	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
