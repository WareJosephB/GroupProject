package com.gareth.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prize {

	@Id
	@GeneratedValue
	private long prizeId;
	private String message;
	private boolean winner;

	public Prize() {
	}

	public Prize(String message, boolean winner) {
		this.message = message;
		this.winner = winner;
	}

	public String getPrize() {
		return message;
	}

	public void setPrize(String prize) {
		this.message = prize;
	}

	@Override
	public String toString() {
		return "Prize [prize=" + message + "]";
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

}
