package com.festlist.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl  implements EmailSender{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String to, String subject, String content) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setTo(to);
			helper.setReplyTo("test46004@gmail.com");
			helper.setFrom("test46004@gmail.com");
			helper.setSubject(subject);
			helper.setText(content, true);
			
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		javaMailSender.send(mimeMessage);
	}
	

}
