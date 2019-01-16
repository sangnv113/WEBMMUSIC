package com.example.WebProject.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category2")
public class Category2 implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Column(name = "cid", nullable = false)
	private int id;
	@Column(name = "category", nullable = false)
	private String category;
	@Column(name = "idcp", nullable = false)
	private int idcp;

	
	/*@OneToMany(mappedBy = "id")
	private Collection<Guitar> guitars;*/
	
	public int getIdcp() {
		return idcp;
	}
	public void setIdcp(int idcp) {
		this.idcp = idcp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
