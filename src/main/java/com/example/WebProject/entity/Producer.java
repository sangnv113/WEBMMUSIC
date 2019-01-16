package com.example.WebProject.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, name = "pid", nullable = false)
	private int pid;
	@Column(name = "Producer", nullable = false)
	private String name;
	@Column(name = "idpr", nullable = false)
	private int idpr;
	public int getIdpr() {
		return idpr;
	}
	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
