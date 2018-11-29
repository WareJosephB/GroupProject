package com.gareth.util;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.gareth.persistence.domain.PojoAccount;
import com.gareth.service.ConsumerService;

@Component
public class AccountReceiver {

	@Autowired
	private ConsumerService service;

	@JmsListener(destination = "Audit", containerFactory = "myFactory")
	public void receiveMessage(PojoAccount account) {
		account.set_id(ObjectId.get());
		service.add(account);
	}

}