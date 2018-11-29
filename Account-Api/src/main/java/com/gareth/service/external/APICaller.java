package com.gareth.service.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.domain.Prize;
import com.gareth.util.AccountProducer;

@Component
public class APICaller {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountProducer producer;

	@Value("${URL.generator.base}" + "${URL.generator.method}")
	private String accountURL;

	@Value("${URL.prize.base}" + "${URL.prize.method}")
	private String offerURL;

	public String getAccountNumber() {
		return restTemplate.getForObject(accountURL, String.class);
	}

	public Prize getPrize(String accountNumber) {
		return restTemplate.getForObject(offerURL + accountNumber, Prize.class);
	}

	public void persist(Account account) {
		producer.produce(account);
	}

}
