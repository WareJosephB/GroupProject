package com.gareth.persistence.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class PojoAccount {

	@Id
	public ObjectId _id;
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

	@Override
	public String toString() {
		return "PojoAccount [account=" + account + ", date=" + date + "]";
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}
