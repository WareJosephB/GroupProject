package com.gareth.repository.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.mockito.Mock;


import com.gareth.persistence.domain.Account;
import com.gareth.persistence.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RepositoryTest {

	@Mock
	AccountRepository accountRepo;

	@Test
	public void addAccountTest() {

		List<Account> accounts = accountRepo.findAll();
		Account account = new Account();

		accounts.add(account);

		assertEquals(accounts.size(), 1);
	}
	
	@Test
	public void addAccountIntergrationTest() {
		Account account = new Account();
		when(accountRepo.save(account)).thenReturn(account);
		assertEquals(accountRepo.save(account), account);
	}
	
	@Test
	public void removeAccountTest() {

		List<Account> accounts = accountRepo.findAll();
		Account account = new Account();

		accounts.add(account);
		accounts.remove(0);

		assertEquals(accounts.size(), 0);
	}

}
