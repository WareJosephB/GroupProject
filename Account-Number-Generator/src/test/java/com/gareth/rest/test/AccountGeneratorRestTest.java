package com.gareth.rest.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.gareth.rest.AccountNumberEndpoint;
import com.gareth.service.AccountNumberService;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations="classpath:src/main/resources/application.properties")
public class AccountGeneratorRestTest {

	@InjectMocks
	private AccountNumberEndpoint accountEndpoint;

	@Mock
	private AccountNumberService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void accountNumberTest() {

		when(service.generateAccountNumber()).thenReturn("A123456");

		assertEquals("A123456", accountEndpoint.accountNumber());

	}

}
