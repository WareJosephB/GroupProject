package com.gareth.service.business;

import java.util.Optional;

import com.gareth.persistence.domain.Account;
import com.gareth.persistence.domain.Prize;

public interface AccountService {

	Optional<Account> get(Long id);

	Iterable<Account> getAll();

	Account add(Account account);

	void delete(Long id);

	Prize prizeCheck(String accountNumber);

}