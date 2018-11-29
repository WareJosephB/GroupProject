package com.gareth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gareth.persistence.domain.Accounts;
import com.gareth.repository.ConsumerRepository;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepo;

	public void setRepo(ConsumerRepository persist) {
		this.consumerRepo = persist;
	}

	public Iterable<Accounts> getAll() {
		return consumerRepo.findAll();
	}

	public Accounts add(Accounts account) {
		return consumerRepo.save(account);
	}

	public void delete(Long id) {
		consumerRepo.deleteById(id);
	}

	public Optional<Accounts> get(Long id) {
		return consumerRepo.findById(id);
	}

}