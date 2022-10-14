package com.odforum.forum.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long quesId;
	
	private String userId;
	private String body;
	
	private Date dated;
	
	public Answer() {}
	
	public Answer(Long id, Long quesId, String userId, String body, Date dated) {
		super();
		this.id = id;
		this.quesId = quesId;
		this.userId = userId;
		this.body = body;
		this.dated = dated;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuesId() {
		return quesId;
	}
	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
}
