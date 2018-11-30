package com.gareth.repository.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gareth.AccountConsumerApplication;
import com.gareth.persistence.domain.Accounts;
import com.gareth.repository.ConsumerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccountConsumerApplication.class)
public class RepositoryTest {

	@Autowired
	private ConsumerRepository repo;

	@Test
	public void testFindAll() {
		List<Accounts> accounts = repo.findAll();
		assertEquals(accounts.size(), 0);
	}

}
