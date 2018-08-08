package com.neo.repository;

import com.neo.entity.Atm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AtmRepository extends MongoRepository<Atm, String> {

    List<Atm> findAllByUserid(String userid);
}
