
package com.example.WebProject.entity;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "cartinfo")
public class CartInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private int id;

	public CartInfo() {
		super();
	}

	public CartInfo(int id, Date date, Customer idcustomer, int done, int amount, int num) {
		super();
		this.id = id;
		this.date = date;
		this.idcustomer = idcustomer;
		this.done = done;
		this.amount = amount;
		this.num = num;
	}

	public CartInfo(int id, Date date, int amount, int num, Customer idcustomer, int done) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.num = num;
		this.idcustomer = idcustomer;
		this.done = done;
	}

	@Column(name = "date", nullable = true)
	private Date date;
	@Column(name = "amount", nullable = true)
	private int amount;
	@Column(name = "num", nullable = true)
	private int num;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@ManyToOne
	@JoinColumn(name = "idcustomer", referencedColumnName = "phone")
	private Customer idcustomer;
	@JoinColumn(name = "done", nullable = false)
	private int done;
	/*@ManyToMany
	@JoinTable(name = "cartlineinfo", joinColumns = @JoinColumn(name = "idc", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idpr", referencedColumnName = "id"))
	private Set<Products> products;*/

	@OneToMany(mappedBy = "cartinfo", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@NotFound(action = NotFoundAction.IGNORE)
	private Collection<CartLineInfoView> cartLineInfo;
	
	
	public Collection<CartLineInfoView> getCartLineInfo() {
		return cartLineInfo;
	}

	public void setCartLineInfo(Collection<CartLineInfoView> cartLineInfo) {
		this.cartLineInfo = cartLineInfo;
	}

	public CartInfo(int id, Customer idcustomer, int done) {
		super();
		this.id = id;
		this.idcustomer = idcustomer;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Customer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

}
