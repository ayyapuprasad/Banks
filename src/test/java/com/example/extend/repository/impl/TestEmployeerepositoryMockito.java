package com.example.extend.repository.impl;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Customer;
import com.extend.bean.Employee;
import com.extendrepository.impl.EmployeeRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class TestEmployeerepositoryMockito {
	@Mock
	private EmployeeRepositoryImpl employeeRepository;
	@Test
	@DisplayName("insert into the employeeRepository")
	public void EmployeeInsert() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("prasad");
		employee.setPhonenumber("7418529637");
		employee.setPassword("Prasad@1");
		when(employeeRepository.insertEmployee(any(Employee.class))).thenReturn(employee);
		Employee actual = employeeRepository.insertEmployee(employee);
		assertThat(employee).isEqualTo(actual);
	}
	@Test
	@DisplayName("update into the employeeRepository")
	public void EmployeeUpdate() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("sai");
		employee.setPhonenumber("6547891235");
		employee.setPassword("Sai@1");
		when(employeeRepository.updateEmployee(any(Employee.class))).thenReturn(employee);
		Employee actual = employeeRepository.updateEmployee(employee);
		assertThat(employee).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the employeeRepository")
	public void EmployeeDelete() {
		Employee employee = new Employee();
		employee.setEmployee_id(1);
		employee.setEmployee_name("prasad");
		employee.setPhonenumber("7418529637");
		employee.setPassword("Prasad@1");
		when(employeeRepository.deleteRecordById(1)).thenReturn(employee);
		Employee actual = employeeRepository.deleteRecordById(1);
		assertThat(employee).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall into the employeeRepository")
	public void EmployeeGetAll() {
		Employee employee = new Employee();
		employee.setEmployee_id(2);
		employee.setEmployee_name("Venkat");
		employee.setPhonenumber("9182216267");
		employee.setPassword("Venkat@1");
		
		Employee employee1 = new Employee();
		employee1.setEmployee_id(3);
		employee1.setEmployee_name("lokesh");
		employee1.setPhonenumber("1234567891");
		employee1.setPassword("Lokesh@1");
		
		List<Employee> list= new ArrayList<>();
		list.add(employee);
		list.add(employee1);
		//when(employeeRepository.getAllEmployee()).thenReturn(list);
		//List<Employee> actual = employeeRepository.getAllEmployee();
		//assertThat(list).isEqualTo(actual);
	}
}

