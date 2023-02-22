package com.example.extend.service.impl;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;

import com.extend.bean.Employee;
import com.extend.bean.Finalresponse;
import com.extend.repository.EmployeeRepository;
import com.extendservice.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestEmployeeServiceMockito {
	//@InjectMocks
	@Mock
	private EmployeeServiceImpl employeeService;
	//private EmployeeRepository employeeRepository;
	@Test
	@DisplayName("insert the employee object to database")
	public void EmployeeInsert() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("prasad");
		employee.setPhonenumber("9182216267");
		employee.setPassword("Prasad@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(employeeService.insertEmployee(any(Employee.class))).thenReturn(expected);
		Finalresponse actual = employeeService.insertEmployee(employee);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the employee object to database")
	public void EmployeeUpdate() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("sai");
		employee.setPhonenumber("7845129875");
		employee.setPassword("Sai@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(employeeService.updateEmployee(any(Employee.class))).thenReturn(expected);
		Finalresponse actual = employeeService.updateEmployee(employee);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the employee object to database")
	public void EmployeeDelete() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("prasad");
		employee.setPhonenumber("9182216267");
		employee.setPassword("Prasad@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(employeeService.deleteRecordById(1)).thenReturn(expected);
		Finalresponse actual = employeeService.deleteRecordById(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the employee object to database")
	public void EmployeeGetAll() {
		Employee employee = new Employee();
		employee.setEmployee_id(2);
		employee.setEmployee_name("keshav");
		employee.setPhonenumber("9876542586");
		employee.setPassword("Keshav@1");
		
		Employee employee1 = new Employee();
		employee1.setEmployee_id(3);
		employee1.setEmployee_name("kushal");
		employee1.setPhonenumber("1234567891");
		employee1.setPassword("Kushal@1");
		
		List<Employee> employeelist = new ArrayList<>();
		employeelist.add(employee);
		employeelist.add(employee1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was GetAll");
		when(employeeService.getAllEmployee()).thenReturn(expected);
		Finalresponse actual = employeeService.getAllEmployee();
		assertThat(expected).isEqualTo(actual);
	}
}

