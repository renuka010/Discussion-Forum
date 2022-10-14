package com.odforum.forum.repo;

import com.odforum.forum.entity.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails details);
	
}
