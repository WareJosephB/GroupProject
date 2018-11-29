package com.gareth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gareth.persistence.domain.Accounts;

@Repository
public interface ConsumerRepository extends MongoRepository<Accounts, Long> {

}