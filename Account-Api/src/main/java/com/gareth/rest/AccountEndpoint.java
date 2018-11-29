package com.gareth.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gareth.persistence.domain.Prize;
import com.gareth.service.business.AccountService;
import com.gareth.persistence.domain.Account;

@CrossOrigin
@RequestMapping("${URL.base}")
@RestController
public class AccountEndpoint {

	@Autowired
	private AccountService service;

	@GetMapping("${URL.method.processOffer}")
	public Prize send(@PathVariable String accountNumber) {
		return service.prizeCheck(accountNumber);
	}

	@GetMapping("${URL.method.getAllAccounts}")
	public Iterable<Account> getAllAccounts() {
		return service.getAll();
	}

	@GetMapping("${URL.method.getAccount}")
	public Optional<Account> getAccount(@PathVariable Long ID) {
		return service.get(ID);
	}

	@DeleteMapping("${URL.method.deleteAccount}")
	public void deleteAccount(@PathVariable Long ID) {
		service.delete(ID);
	}

	@PostMapping("${URL.method.addAccount}")
	public Account addAccount(@RequestBody Account account) {
		return service.add(account);
	}

}
