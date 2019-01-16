package com.example.WebProject.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Column(name = "coid", nullable = false)
	private int id;
	@Column(name = "Color", nullable = false)
	private String name;
	/*@OneToMany(mappedBy = "id")
	private Collection<Guitar> guitars;*/
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
	

	
	
	
	
	
	
	
}
