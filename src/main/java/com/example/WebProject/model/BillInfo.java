package com.example.WebProject.model;





public class BillInfo {
	private int id;//id
	private String date;
	private String name;
	private String phone;
	private String email;
	private String address;
	private int done;
	private String status;
	private String amount;
	private int num;
	
	public BillInfo() {
		super();
	}
	
	public BillInfo(int id, String name, String phone, String email, String address, int done, String amount,
			int num) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.done = done;
		this.amount = amount;
		this.num = num;
	}

	public BillInfo(int id, String name, String phone, String email, String address, int done
			) {
		super();
		this.id = id;
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.done = done;
		
		
	}
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getProductions() {
		return num;
	}
	public void setProductions(int num) {
		this.num = num;
	}
	
}
