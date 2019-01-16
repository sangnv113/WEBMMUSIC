package com.example.WebProject.model;

public class Product {
	
	public Product() {
		
	}
	private int id;
	private int idct;
	private String name;
	private String category; 
	private String producer;
	private String color;
	
	private int giasaugiam;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdct() {
		return idct;
	}
	public void setIdct(int idct) {
		this.idct = idct;
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
	
	public int getGiasaugiam() {
		return giasaugiam;
	}
	public void setGiasaugiam(int giasaugiam) {
		this.giasaugiam = giasaugiam;
	}

	
}
