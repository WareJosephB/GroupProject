package com.gareth.producer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.domain.PojoAccount;

@Component
public class Producer {

	@Autowired
	private PojoAccount pojoAccount;

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(Account account) {
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		pojoAccount.setDate(date);
		pojoAccount.setAccount(account.toString());
		jmsTemplate.convertAndSend("Audit", pojoAccount);
		return "${successful.message}";
	}
}
