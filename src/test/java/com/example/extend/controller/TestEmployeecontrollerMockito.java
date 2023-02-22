package com.example.extend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Employee;
import com.extend.bean.Finalresponse;
import com.extend.controller.EmployeeController;
import com.extendservice.impl.EmployeeServiceImpl;
@ExtendWith(MockitoExtension.class)
public class TestEmployeecontrollerMockito {
	@InjectMocks
	EmployeeController employeecontroller;
	@Mock
	private EmployeeServiceImpl employeeService;
	@Test
	@DisplayName("insert the employee object to database")
	public void EmployeeInsert() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("babu");
		employee.setPhonenumber("9182879547");
		employee.setPassword("Babu@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(employeeService.insertEmployee(employee)).thenReturn(expected);
		Finalresponse actual = employeecontroller.saveemployee(employee);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the employee object to database")
	public void EmployeeUpdate() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("basha");
		employee.setPhonenumber("8754946872");
		employee.setPassword("Basha@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(employeeService.updateEmployee(employee)).thenReturn(expected);
		Finalresponse actual = employeecontroller.updateemployee(employee);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the employee object to database")
	public void EmployeeDelete() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("babu");
		employee.setPhonenumber("9182879547");
		employee.setPassword("Babu@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(employeeService.deleteRecordById(1)).thenReturn(expected);
		Finalresponse actual = employeecontroller.deleteEmployee(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the employee object to database")
	public void EmployeeGetAll() {
		Employee employee = new Employee();
		employee.setEmployee_id(2);
		employee.setEmployee_name("naveen");
		employee.setPhonenumber("2547789665");
		employee.setPassword("Naveen@1");
		
		Employee employee1= new Employee();
		employee1.setEmployee_id(3);
		employee1.setEmployee_name("nagesh");
		employee1.setPhonenumber("8794562138");
		employee1.setPassword("Nagesh@1");
		List<Employee> list= new ArrayList<>();
		list.add(employee);
		list.add(employee1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getall");
		when(employeeService.getAllEmployee()).thenReturn(expected);
		Finalresponse actual = employeecontroller.Getemployee();
		assertThat(expected).isEqualTo(actual);
	
	
	}
	
	

}
