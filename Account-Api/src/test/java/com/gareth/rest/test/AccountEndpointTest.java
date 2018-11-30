package com.gareth.rest.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.domain.Prize;
import com.gareth.persistence.repository.AccountRepository;
import com.gareth.rest.AccountEndpoint;
import com.gareth.service.business.AccountService;

public class AccountEndpointTest {
	
	@InjectMocks
	private AccountEndpoint accountEndpoint;
	
	@Mock
	private AccountService service;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void createAccountTest() {
		Account account = new Account();
		account.setFirstName("firstName");
		account.setLastName("lastName");
		account.setAccountNumber("A123456");
		
		Account accountToBeAdded = new Account();
		accountToBeAdded.setFirstName("firstName");
		accountToBeAdded.setLastName("lastName");
		
		when(service.add(accountToBeAdded)).thenReturn(account);
		Account addedAccount = accountEndpoint.addAccount(accountToBeAdded);
		assertEquals(addedAccount, account);
	}
}
