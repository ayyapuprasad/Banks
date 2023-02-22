package com.extendservice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.extend.bean.Employee;
import com.extend.bean.Finalresponse;
import com.extend.bean.SendEmail;
import com.extend.config.JWTTokenUtil;
import com.extend.repository.EmployeeRepository;
import com.extend.service.EmployeeService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	@Autowired
	private JavaMailSender javaMailSender;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private final String sid = "AC0266231497d0f4b2d37854b22ad77ebd";
	private final String auth = "2f0f402a8faa188ef745c8c29190637a";
	
	private static final long OTP_VALID_DURATION = 1 * 60 * 1000;  // 1 miniute



	@Override
	public Finalresponse insertEmployee(Employee employee) {
		employeeRepository.insertEmployee(employee);
		logger.info("Insert the Data into DB");
       Object newRecord = employeeRepository.insertEmployee(employee);

		Finalresponse finalresponse = new Finalresponse();
		if (employee != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("One Record was Inserted");
			return finalresponse;
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setErrorMessages("One Record Was Not Recorded");
			return finalresponse;

		}
	}
	

	@Override
	public Finalresponse getAllEmployee() {
		logger.info("GetAll the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		List<Object[]> employee = employeeRepository.getAllEmployee();
		List<Object> employeeList = new ArrayList<>();
		if (employee != null) {
			for (int i = 0; i < employee.size(); i++) {
				Object[] employee1 = employee.get(i);
				Employee employee2 = new Employee();
				Integer id = Integer.parseInt(String.valueOf(employee1[0]));
				employee2.setEmployee_id(i);
				employee2.setEmployee_name(String.valueOf(employee1[1]));
				employee2.setPhonenumber("9182219282");
				employee2.setPassword("Prasad@1");
				employeeList.add(employee2);
			}
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was GetAll");
			finalresponse.setData(employeeList);
			return finalresponse;
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setErrorMessages("one Record was Not Recorded");
			return finalresponse;
		}
	}

	@Override
	public Finalresponse deleteRecordById(int id) {
		employeeRepository.deleteRecordById(id);
		logger.info("Delete the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if (id > 0) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record wad Delete");
			return finalresponse;
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage(" oneRecord was not deleted");
			finalresponse.setErrorMessages("check RoleId Once");
			return finalresponse;
		}
	}

	@Override
	public Finalresponse updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
		logger.info("Update the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if (employee != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was updated");
			return finalresponse;
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was Not Updated");
			finalresponse.setErrorMessages("Check All fields");
			return finalresponse;
		}
	}

	@Override
	public Finalresponse EmployeeLogin(Employee employee) {
		Finalresponse finalresponse = new Finalresponse();
		logger.info("Login::input::employee:" + employee);
		List<Object[]> employees = null;
		List<Object> userList = employeeRepository.phonenumber();
		List<Object> password = employeeRepository.password();
		Object phonenumber = null;
		Object password1 = null;
		for (int i = 0; i < userList.size(); i++) {
			if ((employee.getPhonenumber()).equals(String.valueOf(userList.get(i)))) {
				phonenumber = userList.get(i);
			}
		}
		for (int i = 0; i < password.size(); i++) {
			if (String.valueOf(password.get(i)).equals(employee.getPassword())) {
				password1 = password.get(i);
			}
		}
		if (employee.getPhonenumber().equals(phonenumber)) {
			if (employee.getPassword().equals(password)) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("Employee Login is Successfully");
				Object token = jwtTokenUtil.generateToken(employee);
				finalresponse.setData(token);
				return finalresponse;
			} else {
				finalresponse.setStatus(false);
				finalresponse.setStatusCode("200");
				finalresponse.setErrorMessages("Employee Password is incorrect! and OTP is forwarded to verify");
				return finalresponse;
			}
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("404");
			finalresponse.setErrorMessages("User does not exist!");
			return finalresponse;
		}
	}

	@Override
	public Finalresponse validateToken(String Token, Employee employee) {
		Finalresponse finalresponse = new Finalresponse();
		String userToken = Token.substring(7, Token.length());
		if (employee != null) {
			try {
				boolean value = jwtTokenUtil.validateToken(userToken, employee);
				System.out.println(userToken);
				if (value == true) {
					finalresponse.setStatus(true);
					finalresponse.setStatusCode("200");
					finalresponse.setMessage("Token is vaild");
					return finalresponse;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		finalresponse.setStatus(false);
		finalresponse.setStatusCode("500");
		finalresponse.setMessage("Token is Invalid");
		return finalresponse;
	}

	@Override
	public Finalresponse EmployeeLogin(String phonenumber, String password) {
		logger.info("Login::input::employee::" + phonenumber + ":" + password);
		Finalresponse finalresponse = new Finalresponse();
		String passwordAuthentication = employeeRepository.checkUserIsPerentByPhonenumber(phonenumber);
		if (passwordAuthentication != null) {
			if (passwordAuthentication.equals(password)) {
				try {
					Object employee = employeeRepository.Login(phonenumber, password);
					finalresponse.setStatus(true);
					finalresponse.setStatusCode("200");
					finalresponse.setMessage("Login successful");
					return finalresponse;
				} catch (InputMismatchException e) {
					logger.error("userLoginByMobile:: " + e.getLocalizedMessage());
				}
			} else {
				
				Twilio.init(sid, auth);
				Random random = new Random();
				int randomnumber = random.nextInt(1000000);
				String otp = Integer.toString(randomnumber);
				Message.creator(new com.twilio.type.PhoneNumber("+91 9182216267"),
						new com.twilio.type.PhoneNumber("+18307456524"), otp).create();
				employeeRepository.updateotp(otp, phonenumber, new Date());

				finalresponse.setMessage("incorrect password");
				return finalresponse;
			}
		} else {
			finalresponse.setMessage("user does not exists with this phonenumber");
			return finalresponse;
		}
		return finalresponse;
	}

	@Override
	public Finalresponse verificationotp(String otp, String phonenumber) {
		Finalresponse finalresponse = new Finalresponse();
		String otps = employeeRepository.checkUserIsPerentByPhonenumber(phonenumber);
		if (otps != null) {
			 long currentTimeinMillis = System.currentTimeMillis();
	            Date dbOtpTime = employeeRepository.toGetDBOtpTime(phonenumber);
	            long time = dbOtpTime.getTime();
	            if (time + OTP_VALID_DURATION > currentTimeinMillis) {
			if (otps == otp) {
				Twilio.init(sid, auth);
				Message.creator(new com.twilio.type.PhoneNumber("+91 9182216267"),
						new com.twilio.type.PhoneNumber("+18307456524"), " otp verification is done").create();
				employeeRepository.verficationotp(otps, phonenumber);
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage(" otp verification is done");
				return finalresponse;
			} else {
				finalresponse.setStatus(false);
				finalresponse.setStatusCode("500");
				finalresponse.setMessage(" incorrect Otp");
				return finalresponse;
			}
		}
		finalresponse.setStatus(false);
		finalresponse.setStatusCode("404");
		finalresponse.setMessage("user does not exits with this mobileNumber");
		return finalresponse;
	}
		return finalresponse;
	}
}
