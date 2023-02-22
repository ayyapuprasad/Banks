package com.example.extend.repository.impl;

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
import com.extend.bean.Loan;
import com.extend.repository.LoanRepository;
import com.extendrepository.impl.LoanRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class TestLoanrepositoryMockito {
	@Mock
	private LoanRepositoryImpl loanRepository;
	@Test
	@DisplayName("insert into the loanrepository")
	public void LoanInsert() {
		Loan loan = new Loan ();
		loan.setBranch_id("1");
		loan.setLoan_amount(1000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		when(loanRepository.insertLoan(any(Loan.class))).thenReturn(loan);
		Loan actual = loanRepository.insertLoan(loan);
		assertThat(loan).isEqualTo(actual);
	}
	@Test
	@DisplayName("update into the loanrepository")
	public void LoanUpdate () {
	Loan loan = new Loan();
	loan.setBranch_id("1");
	loan.setLoan_amount(10);
	loan.setLoan_id(1);
	loan.setCustomer_id("1");
	when(loanRepository.update(any(Loan.class))).thenReturn(loan);
	Loan actual = loanRepository.update(loan);
	assertThat(loan).isEqualTo(actual);
}
	@Test
	@DisplayName("delete into the loanrepository")
	public void LoanDelete () {
		Loan loan = new Loan ();
		loan.setBranch_id("1");
		loan.setLoan_amount(1000);
		loan.setLoan_id(1);
		loan.setCustomer_id("1");
		when(loanRepository.deleteRecordById()).thenReturn(loan);
		Loan actual = loanRepository.deleteRecordById();
		assertThat(loan).isEqualTo(actual);
		}
	@Test
	@DisplayName("getall into the loanrepository")
	public void LoanGetAll () {
		Loan loan = new Loan ();
		loan.setBranch_id("2");
		loan.setLoan_amount(20);
		loan.setLoan_id(2);
		loan.setCustomer_id("2");
		
		Loan loan1 = new Loan ();
		loan1.setBranch_id("3");
		loan1.setLoan_amount(30);
		loan1.setLoan_id(3);
		loan1.setCustomer_id("3");
		List<Loan> list= new ArrayList<>();
		list.add(loan);
		list.add(loan1);
		when(loanRepository.getAllLoan()).thenReturn(list);
		List<Loan> actual = loanRepository.getAllLoan();
		assertThat(list).isEqualTo(actual);
	}
}


