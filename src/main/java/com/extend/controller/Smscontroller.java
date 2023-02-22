package com.extend.controller;
import java.util.HashMap; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.Authentication;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.twilio.type.PhoneNumber;
@RestController
public class Smscontroller {
	
	private final String sid ="AC0266231497d0f4b2d37854b22ad77ebd";
	private final String auth="2f0f402a8faa188ef745c8c29190637a";
	
	public String generateOTP() {
		int randomPin = (int)((Math.random()*900000)+100000);
		String otpNum = String.valueOf(randomPin);
		return "Your OTP Number is"+otpNum;
	}
	

	

	@GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {
        Twilio.init(sid, auth);
        Message.creator(new com.twilio.type.PhoneNumber("+91 9182216267"), new com.twilio.type.PhoneNumber("+18307456524"), generateOTP()).create();
        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
	}
	}
	