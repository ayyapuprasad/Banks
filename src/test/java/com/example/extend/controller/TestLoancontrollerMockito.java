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

import com.extend.bean.Finalresponse;
import com.extend.bean.Loan;
import com.extend.controller.LoanController;
import com.extendservice.impl.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestLoancontrollerMockito {
	@InjectMocks
	LoanController loancontroller;
	@Mock
	private LoanServiceImpl loanService;
	@Test
	@DisplayName("insert the loan object to database")
	public void LoanInsert() {
		Loan loan = new Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(13000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Inserted");
		when(loanService.insertLoan(loan)).thenReturn(expected);
		Finalresponse actual = loancontroller.insertLoan(loan);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the loan object to database")
	public void LoanUpdate () {
		Loan loan = new Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(14000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(loanService.updateLoan(loan)).thenReturn(expected);
		Finalresponse actual = loancontroller.updateLoan(loan);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the loan object to database")
	public void LoanDelete() {
		Loan loan = new Loan();
		loan.setBranch_id("1");
		loan.setLoan_amount(13000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(loanService.deleteLoan(1)).thenReturn(expected);
		Finalresponse actual = loancontroller.deleteLoan(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the loan object to database")
	public void LoanGetAll() {
		Loan loan =new Loan();
		loan.setBranch_id("2");
		loan.setLoan_amount(5000);
		loan.setLoan_id(2);
		loan.setCustomer_id("2");
		
		Loan loan1 = new Loan();
		loan1.setBranch_id("3");
		loan1.setLoan_amount(6000);
		loan1.setLoan_id(3);
		loan1.setCustomer_id("3");
		List<Loan> list= new ArrayList<>();
		list.add(loan);
		list.add(loan1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getall");
		when(loanService.getAllLoan()).thenReturn(expected);
		Finalresponse actual = loancontroller.getLoan();
		assertThat(expected).isEqualTo(actual);
	}
}

