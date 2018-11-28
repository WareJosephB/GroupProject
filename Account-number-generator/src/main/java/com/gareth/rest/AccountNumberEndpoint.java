package com.gareth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gareth.service.IAccountNumberService;

@RestController
public class AccountNumberEndpoint {

	@Autowired
	IAccountNumberService service;

	@RequestMapping("${URL.method}")
	public String accountNumber() {
		return service.generateAccountNumber();
	}
}
