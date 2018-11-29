package com.gareth.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private long accountId;
	private String firstName;
	private String lastName;
	private String accountNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Prize prize;

	public Account() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountNumber=" + accountNumber + ", prize=" + prize + "]";
	}

}
