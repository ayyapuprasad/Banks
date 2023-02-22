package com.extendservice.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.extend.bean.SendEmail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	//public String sendEmail(String toEmail,String subject,String body) throws MessagingException {
		//SimpleMailMessage message = new SimpleMailMessage();
		//message.setFrom("ayyapuprasad207@gmail.com");
		//message.setTo(toEmail);
		//message.setText(body);
		//message.setSubject(subject);
		//try {
			//javaMailSender.send(message);
			
		//} catch (Exception e) {
			// TODO: handle exception
			
		//}
		
	 @Value("${spring.mail.username}") private String sender;
	
	public String sendEmailWithAttachment(SendEmail email) {
		 MimeMessage mimeMessage
         = javaMailSender.createMimeMessage();
     MimeMessageHelper mimeMessageHelper;

     try {
         mimeMessageHelper
             = new MimeMessageHelper(mimeMessage, true);
         mimeMessageHelper.setFrom(sender);
         mimeMessageHelper.setTo(email.getToemail());
         System.out.println("hello");
       mimeMessageHelper.setText(email.getBody());
         System.out.println("hey");
         mimeMessageHelper.setSubject(email.getSubject());
         FileSystemResource file
             = new FileSystemResource(
                 new File(email.getAttachment()));
         mimeMessageHelper.addAttachment(
             file.getFilename(), file);
         javaMailSender.send(mimeMessage);
         return "Mail sent Successfully";
     }
     catch (MessagingException e) {
         return "Error while sending mail!!!";
     }
	}

}