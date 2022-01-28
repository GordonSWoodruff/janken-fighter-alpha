package com.jankenfighteralpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMail {
	@Autowired
	private JavaMailSender emailSender;
	
	public void send(String toEmail,String subject,String message) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(toEmail);
		email.setSubject(subject);
		email.setText(message);
		
		emailSender.send(email);
	}
}
