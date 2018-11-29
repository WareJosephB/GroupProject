package com.gareth.persistence.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Accounts {

	@Id
	public ObjectId _id;
	private String account;
	private String date;

	public Accounts() {

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "PojoAccount [account=" + account + ", date=" + date + "]";
	}
}
