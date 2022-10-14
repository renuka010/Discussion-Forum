package com.odforum.forum.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String userId;
	private String title;
	private String body;
	
	private Date dated;
	
	public Questions() {}
	
	public Questions(Long id, String userId, String title, String body, Date dated) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.dated = dated;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	
	@Override
	public String toString() {
		return "Questions [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + ", dated=" + dated
				+ "]";
	}
	
}
