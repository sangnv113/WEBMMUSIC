
package com.example.WebProject.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "commentrate")
public class CommentRate implements Serializable {

	private static final long serialVersionUID = 1L;

	/*@Id
	@ManyToOne
	@JoinColumn(name = "phone")
	private Customer custommer;
	@Id
	@ManyToOne
	@JoinColumn(name = "idpr")
	private Products product;*/
	@EmbeddedId
	private CommentRateIndentity id;
	
	@Column(name = "rate", nullable = true)
	int rate;
	@Column(name = "comment", nullable = true)
	private String comment;
	@Column(name = "date", nullable = true)
	private String date;
	
	/*@Column(name = "phone", nullable = true)
	private String phone; */
	
	public CommentRate() {
		super();
	}
	
	public CommentRate(CommentRateIndentity id, int rate, String comment) {
		super();
		this.id = id;
		this.rate = rate;
		this.comment = comment;
	}

	public CommentRate(CommentRateIndentity id, int rate, String comment, String date) {
		super();
		this.id = id;
		this.rate = rate;
		this.comment = comment;
		this.date = date;
	}

	public CommentRateIndentity getId() {
		return id;
	}

	public void setId(CommentRateIndentity id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
