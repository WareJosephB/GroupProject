package com.gareth.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gareth.persistence.domain.Prize;

@Component
public class PrizeType {

	@Value("${prize.base}")
	int basePrize;
	@Value("${prize.multiplier}")
	int multiplier;
	@Value("${message.win}")
	String winMessage;
	@Value("${message.lose}")
	String loseMessage;

	public Prize checkLetter(String accountNumber) {
		String letter = accountNumber.substring(0, 1);
		switch (letter) {
		case "A":
			return new Prize(winMessage + String.valueOf(basePrize), true);
		case "B":
			return new Prize(winMessage + String.valueOf(multiplier * basePrize), true);
		default:
			return new Prize(loseMessage, false);
		}

	}
}
