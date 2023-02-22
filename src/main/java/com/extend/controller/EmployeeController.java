package com.extend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.Employee;
import com.extend.bean.Finalresponse;
import com.extend.bean.SendEmail;
import com.extend.service.EmployeeService;
import com.extendservice.impl.EmailSender;
import com.twilio.rest.lookups.v1.PhoneNumber;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class EmployeeController<FinalResponse> {

	@Autowired
	public EmployeeService employeeService;
	@Autowired
	private EmailSender emailsender;

	@GetMapping("/getallemployee")
	public Finalresponse Getemployee() {
		System.out.println("hey");
		return employeeService.getAllEmployee();
	}

	@PutMapping("/updateemployee")
	public Finalresponse updateemployee(@RequestBody @Valid Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@PutMapping(value = "/Saveemployee",  consumes ={MediaType.MULTIPART_FORM_DATA_VALUE })
	public Finalresponse saveemployee( Employee employee) {
		return employeeService.insertEmployee(employee);
	}

	@DeleteMapping("/deleteemployee/{id}")
	public Finalresponse deleteEmployee(@PathVariable int id) {
		return employeeService.deleteRecordById(id);
	}

	@GetMapping("/loginemployee")
	public Finalresponse loginEmployee(@RequestParam("phonenumber")String phonenumber,@RequestParam("password")String password) {	
		return employeeService.EmployeeLogin(phonenumber, password);
		
	}

	/*
	 * @PostMapping("/loginemployee") public Finalresponse
	 * loginEmployee(@RequestBody Employee employee) { return
	 * employeeService.EmployeeLogin(employee); }
	 */

	@GetMapping("/validateemployee")
	public Finalresponse toVerifyToken(@RequestHeader("Authorization") String token, @RequestBody Employee employee) {
		return employeeService.validateToken(token, employee);
	}
	
	@GetMapping("/verificationotp")
	public Finalresponse verificationotp(@RequestParam("otp")String otp,
	 @RequestParam("phonenumber") String phonenumber) {
		return employeeService.verificationotp(otp, phonenumber);
	}
	//@PutMapping(value="/fileOfCertificate", consumes ={ org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE })
		//  public FinalResponse fileOfCertificate(PhoneNumber password){
		//return employeeService.updateEmployee(employee);
	}
//}



