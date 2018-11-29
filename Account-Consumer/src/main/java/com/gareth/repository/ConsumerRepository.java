package com.gareth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gareth.persistence.domain.PojoAccount;

@Repository
public interface ConsumerRepository extends MongoRepository<PojoAccount, Long> {

}