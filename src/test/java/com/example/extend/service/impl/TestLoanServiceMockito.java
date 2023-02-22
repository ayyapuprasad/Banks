package com.example.extend.service.impl;

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

import com.extend.bean.Finalresponse;
import com.extend.bean.Loan;
import com.extend.repository.LoanRepository;
import com.extendservice.impl.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestLoanServiceMockito {
	//@InjectMocks
	@Mock
private	LoanServiceImpl loanService;

	//private LoanRepository loanRepository;
	@Test
	@DisplayName("insert the loan object to database")
	public void LoanInsert() {
		Loan loan = new  Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(1000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Inserted");
		when(loanService.insertLoan(loan)).thenReturn(expected);
		Finalresponse actual = loanService.insertLoan(loan);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the loan object to database ")
	public void LoanUpdate() {
		Loan loan= new Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(200);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(loanService.updateLoan(loan)).thenReturn(expected);
		Finalresponse actual = loanService.updateLoan(loan);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the loan object to database")
	public void LoanDelete() {
		Loan loan = new Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(1000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(loanService.deleteLoan(1)).thenReturn(expected);
		Finalresponse actual = loanService.deleteLoan(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the loan object to database")
	public void LoanGetAll() {
		Loan loan = new Loan();
		loan.setBranch_id("3");
		loan.setLoan_amount(50);
		loan.setLoan_id(3);
		loan.setCustomer_id("3");
		
		Loan loan2 = new Loan();
		loan2.setBranch_id("4");
		loan2.setLoan_amount(60);
		loan2.setLoan_id(4);
		loan2.setCustomer_id("4");
		List<Loan> list= new ArrayList<>();
		list.add(loan);
		list.add(loan2);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was GetAll");
		when(loanService.getAllLoan()).thenReturn(expected);
		Finalresponse actual =loanService.getAllLoan();
		assertThat(expected).isEqualTo(actual);

		}
	}



