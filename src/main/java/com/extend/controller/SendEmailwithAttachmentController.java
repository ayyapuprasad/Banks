package com.extend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.SendEmail;
import com.extendservice.impl.EmailSender;

@RestController
public class SendEmailwithAttachmentController {

	@Autowired
	private EmailSender emailsender;

	@PostMapping("/sendEmailWithAttchment")
	public String sendEmailWithAttachment(@RequestBody SendEmail email) {
		return emailsender.sendEmailWithAttachment(email);
	}
	//@PostMapping("/SendEmail")
		//public String toSendEmail(@RequestBody SendEmail sendemail) {
		//return emailsender.sendEmail(sendemail.getToemail(), sendemail.getSubject(),sendemail.getBody());
}


	
