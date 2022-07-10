package com.avaliacao2.catalogservice.repository;

import com.avaliacao2.catalogservice.model.Seasons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonsRepository extends MongoRepository<Seasons, String> {

}
