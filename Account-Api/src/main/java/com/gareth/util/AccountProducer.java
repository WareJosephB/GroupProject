package com.gareth.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.domain.Accounts;

@Component
public class AccountProducer {


	private Accounts pojoAccount = new Accounts();

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(Account account) {
		pojoAccount.setAccount(account.toString());
		jmsTemplate.convertAndSend("Audit", pojoAccount);
		return "${successful.message}";
	}
}
