package com.odforum.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

	private String recipient;
    private String msgBody;
    private String subject;
    
	public EmailDetails() {
		super();
		this.recipient=null;
		this.msgBody = " is you OTP for DForum. OTP is valid for 2 minutes.";
		this.subject = "OTP for DForum";
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
    
}
