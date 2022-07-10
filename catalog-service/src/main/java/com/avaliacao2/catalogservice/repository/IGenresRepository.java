package com.avaliacao2.catalogservice.repository;

import com.avaliacao2.catalogservice.model.Genres;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenresRepository extends MongoRepository<Genres, String> {

}
