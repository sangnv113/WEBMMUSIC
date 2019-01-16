
package com.example.WebProject.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private int id;

	public Products() {
		super();
	}

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "datepr", nullable = false)
	private Date datepr;
	@ManyToOne
	@JoinColumn(name = "cid", referencedColumnName = "cid")

	private Category categoryid;
	@ManyToOne
	@JoinColumn(name = "cid2", referencedColumnName = "cid")

	private Category2 category2id;
	
	@OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	public Set<CommentRateView> commentrateview;

	@OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	public Set<Comment> comment;
	
	@OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Collection<CartLineInfoView> cartLineInfo;
	
	

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Set<CommentRateView> getCommentrateview() {
		return commentrateview;
	}

	public void setCommentrateview(Set<CommentRateView> commentrateview) {
		this.commentrateview = commentrateview;
	}

	public Products(int id, String name, Category categoryid, Category2 category2id, Producer producerid, Color colorid,
			int soluong, String gia, int giamgia, String giasaugiam) {
		super();
		this.id = id;
		this.name = name;
		this.categoryid = categoryid;
		this.category2id = category2id;
		this.producerid = producerid;
		this.colorid = colorid;
		this.soluong = soluong;
		this.gia = gia;
		this.giamgia = giamgia;
		this.giasaugiam = giasaugiam;
	}


	public Products(int id, String name, Category categoryid, Category2 category2id, Producer producerid, Color colorid,
			double rate, int soluot, int soluong, String gia, int giamgia, String giasaugiam, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.categoryid = categoryid;
		this.category2id = category2id;
		this.producerid = producerid;
		this.colorid = colorid;
		this.rate = rate;
		this.soluot = soluot;
		this.soluong = soluong;
		this.gia = gia;
		this.giamgia = giamgia;
		this.giasaugiam = giasaugiam;
		this.giasaugiam = giasaugiam;
		this.visits = visits;

	}

	@ManyToOne
	@JoinColumn(name = "pid", referencedColumnName = "pid")
	private Producer producerid;
	@ManyToOne
	@JoinColumn(name = "coid", referencedColumnName = "coid")
	private Color colorid;

	@Lob
	@Column(name = "img", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;

	@Column(name = "Rate", nullable = false)
	private double rate;
	@Column(name = "Soluot", nullable = false)
	private int soluot;
	@Column(name = "Soluong", nullable = false)
	private int soluong;
	@Column(name = "price", nullable = false)
	private String gia;
	@Column(name = "discount", nullable = true)
	private int giamgia;
	@Column(name = "lastprice", nullable = true)
	private String giasaugiam;

	@Column(name = "visits", nullable = false)
	private int visits;

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public int getGiamgia() {
		return giamgia;
	}

	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}

	public String getGiasaugiam() {
		return giasaugiam;
	}

	public void setGiasaugiam(String giasaugiam) {
		this.giasaugiam = giasaugiam;
	}

	public Category2 getCategory2id() {
		return category2id;
	}

	public void setCategory2id(Category2 category2id) {
		this.category2id = category2id;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getSoluot() {
		return soluot;
	}

	public void setSoluot(int soluot) {
		this.soluot = soluot;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public Date getDatepr() {
		return datepr;
	}

	public void setDatepr(Date datepr) {
		this.datepr = datepr;
	}

	public Category getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}

	public Producer getProducerid() {
		return producerid;
	}

	public void setProducerid(Producer producerid) {
		this.producerid = producerid;
	}

	public Color getColorid() {
		return colorid;
	}

	public void setColorid(Color colorid) {
		this.colorid = colorid;
	}

}
