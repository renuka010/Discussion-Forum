package com.odforum.forum.service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.odforum.forum.entity.EmailDetails;
import com.odforum.forum.repo.EmailService;



@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
    @Value("${spring.mail.username}") private String sender;
    
    public String sendSimpleMail(EmailDetails details)
    {
 
 
            // Creating a simple mail message
    		Random random=new Random();
    		String otp=Integer.toString(random.nextInt(1,1000000));
    		while(otp.length()!=6)
    			otp="0"+otp;
    		
    		details.setMsgBody(otp+details.getMsgBody());
    		
            SimpleMailMessage mailMessage= new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return otp;
    }
 
}
