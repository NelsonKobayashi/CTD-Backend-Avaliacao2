package com.avaliacao2.catalogservice.repository;

import com.avaliacao2.catalogservice.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeriesRepository extends MongoRepository<Series, String> {

}
