package com.gareth.persistence.domain;

import org.springframework.stereotype.Component;

@Component
public class PojoAccount {

	private String account;
	private String date;

	public PojoAccount() {

	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
