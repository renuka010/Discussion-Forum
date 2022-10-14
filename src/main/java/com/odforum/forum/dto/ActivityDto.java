package com.odforum.forum.dto;

import java.util.Date;

public class ActivityDto implements Comparable<ActivityDto>{

	@Override
	public int compareTo(ActivityDto o) {
		return o.dated.compareTo(this.dated);
	}
	
	private Long quesId;
	private String title;
	private String body;
	private Date dated;
	
	public Long getQuesId() {
		return quesId;
	}
	public void setQuesId(Long quesId) {
		this.quesId = quesId;
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
	
}
