package com.gareth.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.gareth.persistence.domain.Accounts;
import com.gareth.service.ConsumerService;

@Component
public class AccountReceiver {

	@Autowired
	private ConsumerService service;

	@JmsListener(destination = "Audit", containerFactory = "myFactory")
	public void receiveMessage(Accounts account) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		account.set_id(ObjectId.get());
		account.setDate(timestamp);
		service.add(account);
	}

}