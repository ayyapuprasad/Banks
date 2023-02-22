package com.extendrepository.impl;

import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Employee;
import com.extend.repository.EmployeeRepository;

import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.io.SerialException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private static final Object otp = null;
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public Employee insertEmployee(Employee employee) {
		Query query = entityManager.createNativeQuery("insert into employee values(?,?,?,?)");
		query.setParameter(1, employee.getEmployee_id());
		query.setParameter(2, employee.getEmployee_name());
		query.setParameter(3, employee.getPhonenumber());
		query.setParameter(4, employee.getPassword());
		int Rec = query.executeUpdate();
		return employee;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		Query query = entityManager.createNativeQuery("update employee set employee_name=?,phonenumber=?,password=? where employee_id=?");
		query.setParameter(4, employee.getEmployee_id());
		query.setParameter(1, employee.getEmployee_name());
		query.setParameter(2, employee.getPhonenumber());
		query.setParameter(3, employee.getPassword());
		int Rec = query.executeUpdate();
		if (Rec > 0) {
		}
		return employee;
	}

	@Override
	@Transactional
	public Employee deleteRecordById(int employee_id) {
		Employee employee = new Employee();
		Query query = entityManager.createNativeQuery("delete from employee where employee_id =?");
		query.setParameter(1, employee_id);
		int Rec = query.executeUpdate();
		return employee;
	}

	@Override
	public List<Object[]> getAllEmployee() {
		Query query = entityManager.createNativeQuery("select* from employee");
		List<Object[]> employee = query.getResultList();
		return employee;
	}

	@Override
	public List<Object[]> Login(String phonenumber, String password) {
		Query query = entityManager.createNativeQuery("select * from employee where phonenumber = ? and password=?");
		query.setParameter(1, phonenumber);
		query.setParameter(2, password);
		List<Object[]> employee = null;
		try {
			employee = query.getResultList();
		} catch (NoResultException ex) {
			System.out.println(ex);
		}
		return employee;
	}

	@Override
	public List<Object> phonenumber() {
		Query query = entityManager.createNativeQuery("select phonenumber from employee");
		List<Object> userList = null;
		try {
			userList = query.getResultList();
		} catch (NoResultException e) {
			e.getMessage();
		}
		return userList;
	}

	@Override
	public List<Object> password() {
		Query query = entityManager.createNativeQuery("select password from employee");
		List<Object> userList = null;
		try {
			userList = query.getResultList();
		} catch (NoResultException e) {
			e.getMessage();
		}
		return userList;
	}

	@Override
	public String checkUserIsPerentByPhonenumber(String phonenumber) {
		Query query = entityManager.createNativeQuery("select password from employee where phonenumber=?");
		query.setParameter(1, phonenumber);
		String password = null;
		try {
			password = (String) query.getSingleResult();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return password;
	}

	@Override
	@jakarta.transaction.Transactional
	public String updateotp(String otp, String phonenumber, java.util.Date otpdate) {
		Query query = entityManager
				.createNativeQuery("update employee set otp=?,otpexpiredtime=? where  phonenumber=?");
		query.setParameter(1, otp);
		query.setParameter(3, phonenumber);
		query.setParameter(2, otpdate);
		try {
			query.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "verification is done";
	}

	@Override
	public String verficationotp(String otp, String phonenumber) {
		Query query = entityManager.createNativeQuery("select * from employee where otp=? and phonenumber=?");
		query.setParameter(1, otp);
		query.setParameter(2, phonenumber);
		try {
			query.getSingleResult();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "verification is done";
	}

	@Override
	public Date toGetDBOtpTime(String phonenumber) {
		Query query = entityManager.createNativeQuery("select otpexpiredtime from employee where phonenumber=?");
		query.setParameter(1, phonenumber);
		Date otp = null;
		try {
			otp = (Date) query.getSingleResult();
		} catch (InputMismatchException e) {
			e.getMessage();
		}
		return otp;
	}

	@Override
	@Transactional
	public Employee insertEmployeeFile(Employee employee) {
		Query query = entityManager.createNativeQuery(
				"insert into employee(employee_id,employee_name,phonenumber,password,otp,imagefile)values(?,?,?,?,?,?)");
		query.setParameter(1, employee.getEmployee_id());
		query.setParameter(2, employee.getEmployee_name());
		query.setParameter(3, employee.getPhonenumber());
		query.setParameter(4, employee.getPassword());
		query.setParameter(5, employee.getOtp());
		query.setParameter(6,employee.getImagefile());
		int recordInserted = 0;
		try {
			byte[] byteImage = employee.getImagefile().getBytes();

			Blob blobImage = new SerialBlob(byteImage);
			query.setParameter(6, blobImage);
			recordInserted = query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (recordInserted == 1) {
			return employee;
		} else
			return null;
	}
}
