package com.gareth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gareth.persistence.domain.PojoAccount;
import com.gareth.repository.ConsumerRepository;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepo;

	public void setRepo(ConsumerRepository persist) {
		this.consumerRepo = persist;
	}

	public Iterable<PojoAccount> getAll() {
		return consumerRepo.findAll();
	}

	public PojoAccount add(PojoAccount account) {
		return consumerRepo.save(account);
	}

	public void delete(Long id) {
		consumerRepo.deleteById(id);
	}

	public Optional<PojoAccount> get(Long id) {
		return consumerRepo.findById(id);
	}

}